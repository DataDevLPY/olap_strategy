package cn.data.developer.strategy.utils;

import cn.data.developer.strategy.common.SignalConstant;
import cn.data.developer.strategy.config.EmEngine;


/**
 * @author: Peiyang
 * @Date: 2022/2/4 9:21 上午
 * @Description:
 **/
public class EngineUtils {


    public static String getLog(){
        StringBuilder engine = new StringBuilder();
        engine.append("engine").append(SignalConstant.EQUAL).append("Log");
        engine.append(SignalConstant.SPACE);
        return engine.toString();
    }

    public String getMemory(){

        return "";
    }

    public static String getMergeTree(){




        return "";
    }

    public static String getMergeTree(Boolean isReplicated){

        return "";
    }

    public static String getReplacingMergeTree(){

        return "";
    }

    public static String getReplacingMergeTree(Boolean isReplicated){

        return "";
    }

    public static String getAggregateMergeTree(){

        return "";
    }

    public static String getAggregateMergeTree(Boolean isReplicated){

        return "";
    }



}
