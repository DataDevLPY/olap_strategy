package cn.data.developer.strategy.config;

import cn.data.developer.strategy.common.DriverConstant;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author: Peiyang
 * @Date: 2022/2/3 7:02 下午
 **/

@Configuration
public class ClickHouseConfiguration {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private static String LOG_PRE = "[ ClickHouseConfiguration ]-";




    @Bean(name="connection_ck_local")
    public ClickHouseConnection connection_ck_local() {
        try{
            //驱动
            Class.forName(DriverConstant.ClickHouse_Driver);

            //配置参数
            Properties prop = new Properties();
            //String url = json.getString("url");
            //String user = json.getString("user");
            //String password = json.getString("password");
            String url = "jdbc:clickhouse://localhost:8123";
            String user = "default";
            String password = "010288";
            prop.setProperty("user",user);
            prop.setProperty("password",password);

            //clickhouse数据源引入
            ClickHouseDataSource dataSource = new ClickHouseDataSource(url,prop);
            ClickHouseConnection connection = dataSource.getConnection();
            return connection;

        } catch (Exception e) {
            log.error(LOG_PRE + "创建clickhouse本地连接失败!{}",e);
            return null;
        }
    }

}
