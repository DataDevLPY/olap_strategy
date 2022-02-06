package cn.data.developer.strategy.api;



import java.io.Serializable;

/**
 * @author: Peiyang
 * @Date: 2022/2/4 1:56 上午
 * @Description:
 **/
public interface RichFunction extends Function, Serializable {

    abstract void invoke() throws Exception;

}
