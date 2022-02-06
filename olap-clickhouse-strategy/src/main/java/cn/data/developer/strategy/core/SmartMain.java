package cn.data.developer.strategy.core;

import cn.data.developer.strategy.bean.ClickHouseParam;
import cn.data.developer.strategy.connector.ClickHouseOperation;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author: Peiyang
 * @Date: 2022/2/3 9:37 下午
 * @Desciption: 核心启动类
 **/
public class SmartMain {

    private static Logger log = LoggerFactory.getLogger(SmartMain.class);
    private static final String LOG_PRE = "[ SmartMain ]-";

    public static void main(String[] args) {

        String ss = "{\"url\":\"jdbc:clickhouse://localhost:8123/default\",\"user\":\"default\",\"password\":\"010288\",\"cluster\":\"\",\"database\":\"f03\",\"tableName\":\"hive_log5\",\"engine\":\"Log\",\"values\":\"id;String;编码,name;String;姓名\",\"operation\":\"create\",\"orderBy\":\"\",\"primaryBy\":\"\",\"ttl\":\"\"}";

        try{
            ClickHouseParam clickHouseParam = new ClickHouseParam();
            JSONObject configs = JSON.parseObject(ss,JSONObject.class);
            BeanUtils.populate(clickHouseParam,configs);

            try{
                ClickHouseOperation clickHouseOperation = new ClickHouseOperation(clickHouseParam);
                clickHouseOperation.invoke();
            } catch (Exception e){
                log.error(LOG_PRE + "ClickHouse操作ERROR ！{}",e);
            }
        } catch (Exception e){
            log.error(LOG_PRE + "配置解析报错 ERROR ！{}",e);
        }






    }

}
