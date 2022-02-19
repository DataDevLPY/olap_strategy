package cn.data.developer.strategy.utils;

import cn.data.developer.strategy.common.SignalConstant;
import cn.data.developer.strategy.config.EmEngine;


/**
 * @author: Peiyang
 * @Date: 2022/2/4 9:21 上午
 * @Description:
 **/
public class EngineUtils {

    public static StringBuilder engine = new StringBuilder();

    /**
     * Log引擎
     */
    public static String getLog(){
        engine.append("engine").append(SignalConstant.EQUAL).append(EmEngine.Log);
        engine.append(SignalConstant.SPACE);
        return engine.toString();
    }

    /**
     * Memory引擎
     */
    public String getMemory(){

        return "";
    }

    /**
     * MergeTree引擎
     */
    public static String getMergeTree(){
        engine.append("engine").append(SignalConstant.EQUAL).append(EmEngine.MergeTree);
        engine.append(SignalConstant.LEFT_BRACKET).append(SignalConstant.RIGHT_BRACKET);
        engine.append(SignalConstant.SPACE);
        return engine.toString();
    }

    /**
     *
     */
    public static String getMergeTree(Boolean isReplicated){

        return "";
    }


    /**
     * ReplacingMergeTree引擎
     */
    public static String getReplacingMergeTree(){
        engine.append("engine").append(SignalConstant.EQUAL).append(EmEngine.ReplacingMergeTree);
        engine.append(SignalConstant.LEFT_BRACKET).append(SignalConstant.RIGHT_BRACKET);
        engine.append(SignalConstant.SPACE);
        return engine.toString();
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


    public static void main(String[] args) {
        System.out.println(getReplacingMergeTree());
    }
}
