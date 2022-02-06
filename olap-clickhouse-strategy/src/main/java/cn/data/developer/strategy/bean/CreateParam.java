package cn.data.developer.strategy.bean;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author: Peiyang
 * @Date: 2022/2/3 10:29 下午
 * @Description:
 **/

@Data
public class CreateParam {

    /**
     * 集群
     */
    private String cluster;

    /**
     * 数据库
     */
    private String database;

    /**
     * 表
     */
    private String tableName;

    /**
     * 表引擎
     */
    private String engine;


    private String values;

    private String orderBy;

    private String primaryBy;

    private String ttl;


    @Override
    public String toString() {
        return "CreateParam{" +
                "cluster='" + cluster + '\'' +
                ", database='" + database + '\'' +
                ", tableName='" + tableName + '\'' +
                ", engine='" + engine + '\'' +
                ", values='" + values + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", primaryBy='" + primaryBy + '\'' +
                ", ttl='" + ttl + '\'' +
                '}';
    }
}
