package cn.data.developer.strategy.bean;

import lombok.Data;

/**
 * @author: Peiyang
 * @Date: 2022/2/3 10:27 下午
 * @Description:
 **/

@Data
public class InsertParam {

    /**
     * 数据库
     */
    private String database;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 字段组
     */
    private String values;


}
