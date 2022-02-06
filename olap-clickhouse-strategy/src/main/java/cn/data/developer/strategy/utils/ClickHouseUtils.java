package cn.data.developer.strategy.utils;

import cn.data.developer.strategy.bean.CreateParam;
import cn.data.developer.strategy.bean.InsertParam;
import cn.data.developer.strategy.bean.ValueInfo;
import cn.data.developer.strategy.common.SignalConstant;
import cn.data.developer.strategy.config.EmEngine;
import cn.data.developer.strategy.config.ValueParsingConfig;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author: Peiyang
 * @Date: 2022/2/3 8:39 下午
 **/
public class ClickHouseUtils {

    private static Logger log = LoggerFactory.getLogger(ClickHouseUtils.class);
    private static final String LOG_PRE = "[ ClickHouseUtils ]-";

    /**
     * 数据插入
     * @param insertParam
     * @return
     */
    public String insert(InsertParam insertParam){

        StringBuilder insert = new StringBuilder();
        //insertParam.getValues()



        return insert.toString();
    }

    /**
     * 数据删除
     * @param json
     * @return
     */
    public String delete(JSONObject json){

        StringBuilder delete = new StringBuilder();


        return delete.toString();
    }

    /**
     * 数据查询
     * @param json
     * @return
     */
    public String select(JSONObject json){

        StringBuilder select = new StringBuilder();


        return select.toString();
    }

    /**
     * 表创建
     * @param
     * @return
     */
    public static String create(CreateParam param){
        StringBuilder create = new StringBuilder();
        create.append("CREATE TABLE ");
        create.append(param.getDatabase()).append(SignalConstant.DOT).append(param.getTableName());
        create.append(SignalConstant.SPACE).append(SignalConstant.LEFT_BRACKET).append(SignalConstant.SPACE);
        for(ValueInfo valueInfo : ValueParsingConfig.getValueInfos(param.getValues())){
            create.append(valueInfo.getValue()).append(SignalConstant.SPACE);
            create.append(valueInfo.getType()).append(SignalConstant.SPACE);
            create.append("COMMENT ").append(SignalConstant.SINGLE_QUOTATION).append(valueInfo.getComment()).append(SignalConstant.SINGLE_QUOTATION).append(SignalConstant.COMMA);
        }
        create = new StringBuilder(create.substring(0, create.length() - 1));
        create.append(SignalConstant.SPACE).append(SignalConstant.RIGHT_BRACKET).append(SignalConstant.SPACE);

        if ( EmEngine.log.equals(EmEngine.nameOf(param.getEngine()))) {
            create.append(EngineUtils.getLog());
        } else if (EmEngine.mergeTree.equals(EmEngine.nameOf(param.getEngine()))) {
            create.append(EngineUtils.getMergeTree());
        } else if (EmEngine.replacingMergeTree.equals(EmEngine.nameOf(param.getEngine()))) {
            create.append(EngineUtils.getReplacingMergeTree());
        } else if (EmEngine.aggregateMergeTree.equals(EmEngine.nameOf(param.getEngine()))) {
            create.append(EngineUtils.getAggregateMergeTree());
        }
        if (!param.getOrderBy().isEmpty()){
            create.append("ORDER BY ").append(param.getOrderBy());
        }

        if (!param.getPrimaryBy().isEmpty()){
            create.append(SignalConstant.COMMA).append("PRIMARY KEY ").append(param.getPrimaryBy());
        }

//        if (!param.getTtl().isEmpty()){
//            create.append(SignalConstant.COMMA).append("TTL").append(param.getTtl());
//        }
        create.append(SignalConstant.SEMICOLON);

        log.error(LOG_PRE + "操作语句："+create);
        System.out.println(LOG_PRE + "操作语句："+create);
        return create.toString();
    }

    /**
     * 用户赋权
     * @param json
     * @return
     */
    public String grant(JSONObject json){

        StringBuilder grant = new StringBuilder();


        return grant.toString();
    }


    public static void main(String[] args) {
        CreateParam param = new CreateParam();
        param.setDatabase("f03");
        param.setEngine("log");
        param.setPrimaryBy("id");
        param.setTableName("hive_local");
        param.setOrderBy("id");
        param.setValues("id;String;编码,name;String;姓名");


        System.out.println(create(param));
    }



}
