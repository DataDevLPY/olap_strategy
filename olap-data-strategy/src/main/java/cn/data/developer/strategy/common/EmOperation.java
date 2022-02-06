package cn.data.developer.strategy.common;

/**
 * @author: Peiyang
 * @Date: 2022/2/3 9:30 下午
 **/
public enum EmOperation {

    insert,
    select,
    delete,
    drop,
    grant,
    create;

    public static EmOperation nameOf(String name){

        if (null == name){
            throw new IllegalArgumentException("请填写正确数据库操作");
        }

        for (EmOperation operation : EmOperation.values()) {
            if (operation.name().equalsIgnoreCase(name)){
                return operation;
            }
        }

        throw new IllegalArgumentException("请填写正确数据库操作");
    }


}
