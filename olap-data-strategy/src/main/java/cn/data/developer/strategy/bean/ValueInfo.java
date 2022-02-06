package cn.data.developer.strategy.bean;

import lombok.Data;

/**
 * @author: Peiyang
 * @Date: 2022/2/4 12:38 上午
 * @Description:
 **/

@Data
public class ValueInfo {

    /**
     * 字段名
     */
    private String value;

    /**
     * 字段类型
     */
    private String type;

    /**
     * 字段解释
     */
    private String comment;

}
