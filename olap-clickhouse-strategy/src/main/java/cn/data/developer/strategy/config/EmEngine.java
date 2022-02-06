package cn.data.developer.strategy.config;

/**
 * @author: Peiyang
 * @Date: 2022/2/4 9:28 下午
 * @Description:
 **/
public enum EmEngine {

    mergeTree,
    replacingMergeTree,
    aggregateMergeTree,
    log,
    memory;

    public static EmEngine nameOf(String name){

        if (null == name){
            throw new IllegalArgumentException("请填写正确ClickHouse表引擎");
        }

        for (EmEngine engine : EmEngine.values()) {
            if (engine.name().equalsIgnoreCase(name)){
                return engine;
            }
        }

        throw new IllegalArgumentException("请填写正确ClickHouse表引擎");
    }
}
