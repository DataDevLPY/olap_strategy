package cn.data.developer.strategy.connector;

import cn.data.developer.strategy.bean.ClickHouseParam;
import cn.data.developer.strategy.api.RichFunction;
import cn.data.developer.strategy.bean.CreateParam;
import cn.data.developer.strategy.common.EmOperation;
import cn.data.developer.strategy.config.ClickHouseConfiguration;
import cn.data.developer.strategy.utils.ClickHouseUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.ClickHouseStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;


/**
 * @author: Peiyang
 * @Date: 2022/2/3 7:00 下午
 *
 **/

@Component
public class ClickHouseOperation implements RichFunction {

    private static Logger log = LoggerFactory.getLogger(ClickHouseOperation.class);
    private static final String LOG_PRE = "[ ClickHouseOperation ]-";

    private ClickHouseParam param;

    private EmOperation operation;

    @Autowired
    @Qualifier(value = "connection_ck_local")
    public ClickHouseConnection connection_ck_local;


    public ClickHouseOperation(ClickHouseParam param) {

        this.param=param;
        this.operation=EmOperation.nameOf(param.getOperation());
    }


    @Override
    public void invoke() throws Exception {
        switch(operation){
            case create:
                //创建表

                //创建配置类
                CreateParam createParam = new CreateParam();
                //调整配置Map
                Map<String, String> describe = BeanUtils.describe(param);
                //并入配置类
                BeanUtils.populate(createParam,describe);
                //获取表创建语句
                String createTableDDL = ClickHouseUtils.create(createParam);
                try{

                    System.out.println(connection_ck_local==null);
                    if (connection_ck_local == null){
                        Properties prop = new Properties();
                        prop.setProperty("user","default");
                        prop.setProperty("password","010288");
                        ClickHouseDataSource dataSource = new ClickHouseDataSource("jdbc:clickhouse://localhost:8123",prop);
                        //Connection connection = DriverManager.getConnection(url,user,password);
                        connection_ck_local = dataSource.getConnection();
                    }


                    //执行连接具柄
                    ClickHouseStatement statement = connection_ck_local.createStatement();
                    statement.execute(createTableDDL);
                } catch (Exception e){
                    log.error(LOG_PRE+"执行报错！Error！",e);
                    System.out.println(LOG_PRE+" "+e);
                }

                break;
            case insert:
                break;
            default:
                break;
        }


    }




}
