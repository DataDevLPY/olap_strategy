package cn.data.developer.strategy.config;

import cn.data.developer.strategy.bean.ValueInfo;
import cn.data.developer.strategy.common.SignalConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Peiyang
 * @Date: 2022/2/4 12:26 上午
 * @Description:
 **/

public class ValueParsingConfig {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private static final String LOG_PRE = "[ ValueParsingConfig ]-";

    /**
     * value解析
     * @param values
     * @return
     */
    public static List<ValueInfo> getValueInfos(String values){
        List<ValueInfo> valueInfos = new ArrayList<>();
        //解析输入字段信息
        List<String> valueList = Arrays.asList(values.split(SignalConstant.COMMA));
        for (String info:valueList) {
            //调整类型
            ValueInfo valueInfo = new ValueInfo();
            valueInfo.setValue(info.split(SignalConstant.SEMICOLON)[0]);
            valueInfo.setType(info.split(SignalConstant.SEMICOLON)[1]);
            valueInfo.setComment(info.split(SignalConstant.SEMICOLON)[2]);
            //字段信息添加
            valueInfos.add(valueInfo);
        }
        return valueInfos;
    }

}
