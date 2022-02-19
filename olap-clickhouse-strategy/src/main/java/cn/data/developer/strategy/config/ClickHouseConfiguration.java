package cn.data.developer.strategy.config;

import cn.data.developer.strategy.bean.ConnParam;
import cn.data.developer.strategy.common.DriverConstant;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import java.util.Properties;

/**
 * @author: Peiyang
 * @Date: 2022/2/3 7:02 下午
 **/

public class ClickHouseConfiguration {

    private static Logger log = LoggerFactory.getLogger(ClickHouseConfiguration.class);
    private static String LOG_PRE = "[ ClickHouseConfiguration ]-";


    public static ClickHouseConnection getClickHouseConn(ConnParam param) {
        try{
            //配置参数
            ClickHouseProperties ckProps = new ClickHouseProperties();
            ckProps.setUser(param.getUser());
            ckProps.setPassword(param.getPassword());
            ClickHouseDataSource dataSource = new ClickHouseDataSource(param.getUrl(),ckProps);
            ClickHouseConnection connection = dataSource.getConnection();
            return connection;

        } catch (Exception e) {
            log.error(LOG_PRE + "创建clickhouse本地连接失败!{}" + e.getMessage());
            return null;
        }
    }

}
