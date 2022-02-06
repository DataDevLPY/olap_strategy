import cn.data.developer.strategy.bean.ClickHouseParam;
import cn.data.developer.strategy.bean.CreateParam;
import cn.data.developer.strategy.utils.ToMapUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author: Peiyang
 * @Date: 2022/2/5 8:32 下午
 * @Description:
 **/
public class Test {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
//        String ss = "{\"url\":\"\",\"user\":\"\",\"password\":\"\",\"cluster\":\"\",\"database\":\"f03\",\"tableName\":\"hive_log\",\"engine\":\"log\",\"values\":\"id;String;编码,name;String;姓名\",\"operation\":\"create\",\"orderBy\":\"id\",\"primaryBy\":\"id\",\"ttl\":\"\"}";
//
//
//        ClickHouseParam clickHouseParam = new ClickHouseParam();
//        JSONObject configs = JSON.parseObject(ss,JSONObject.class);
//        BeanUtils.populate(clickHouseParam,configs);
//
//
//        System.out.println(clickHouseParam.getOperation());
        CreateParam createParam = new CreateParam();
        createParam.setValues("id;String;编码,name;String;姓名");


        //Map<String,String> map = ToMapUtils.paramToMap(createParam);
        //System.out.println(map);

        Map<String,String> map = BeanUtils.describe(createParam);
        System.out.println(map);
    }
}
