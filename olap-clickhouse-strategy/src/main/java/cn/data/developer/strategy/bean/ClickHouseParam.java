package cn.data.developer.strategy.bean;

import cn.data.developer.strategy.common.EmOperation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: Peiyang
 * @Date: 2022/2/3 8:29 下午
 * @Description: ClickHouse配置类
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClickHouseParam implements Serializable {

    /**
     * 连接地址
     */
    private String url;

    /**
     * 用户
     */
    private String user;

    /**
     * 密码
     */
    private String password;

    /**
     * 集群
     */
    private String cluster;

    /**
     * 数据库
     */
    private String database;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表引擎
     */
    private String engine;

    /**
     * 字段组
     */
    private String values;

    /**
     * 操作
     */
    private String operation;

    /**
     * 主键
     */
    private String primaryBy;

    /**
     * 排序
     */
    private String orderBy;

    /**
     * SQL语句
     */
    private String sql;


}
