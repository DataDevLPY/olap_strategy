package cn.data.developer.strategy.connector;

import cn.data.developer.strategy.bean.ClickHouseParam;
import cn.data.developer.strategy.api.RichFunction;
import cn.data.developer.strategy.bean.ConnParam;
import cn.data.developer.strategy.bean.CreateParam;
import cn.data.developer.strategy.common.EmOperation;
import cn.data.developer.strategy.config.ClickHouseConfiguration;
import cn.data.developer.strategy.utils.ClickHouseUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.ClickHouseStatement;

import java.util.Map;
import java.util.Properties;


/**
 * @author: Peiyang
 * @Date: 2022/2/3 7:00 下午
 *
 **/


public class ClickHouseOperation implements RichFunction {

    private static Logger log = LoggerFactory.getLogger(ClickHouseOperation.class);
    private static final String LOG_PRE = "[ ClickHouseOperation ]-";

    private ClickHouseParam param;

    private EmOperation operation;

    private ClickHouseConnection connection;



    public ClickHouseOperation(ClickHouseParam param) {
        this.param=param;
        this.operation=EmOperation.nameOf(param.getOperation());

        try {
            ConnParam connParam = new ConnParam();
            Map<String, String> describe = BeanUtils.describe(param);
            BeanUtils.populate(connParam,describe);
            this.connection = ClickHouseConfiguration.getClickHouseConn(connParam);
        } catch (Exception e){
            log.error(LOG_PRE + "connParam参数接收报错！" + e.getMessage());
        }

        invoke();
    }



    @Override
    public void invoke() {

        switch(operation){
            case create:
                //创建配置类
                CreateParam createParam = new CreateParam();
                try {
                    Map<String, String> describe = BeanUtils.describe(param);
                    BeanUtils.populate(createParam,describe);
                } catch (Exception e){
                    log.error(LOG_PRE + "createParam参数接收报错！" + e.getMessage());
                }
                //获取表创建语句
                String createTableDDL = ClickHouseUtils.create(createParam);

                //通过连接具柄执行
                try {
                    ClickHouseStatement statement = connection.createStatement();
                    statement.execute(createTableDDL);
                } catch (Exception e){
                    log.error(LOG_PRE+"执行报错！Error！" + e.getMessage());
                }
                break;
            case insert:
                break;
            default:
                break;
        }


    }




}
