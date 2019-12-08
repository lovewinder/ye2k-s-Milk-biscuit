package cn.y.ye2k.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回结果封装实体
 *
 * @author ye2k's look-up 内测小组
 * @date 2019-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo implements Serializable {
    /**
     * 后端返回结果正常为true，发生异常返回false
     */
    private Boolean flag;
    /**
     * 后端返回结果数据对象
     */
    private Object data;
    /**
     * 发生异常的错误消息
     */
    private String errorMsg;

    /**
     * 有参构造方法
     * @param flag
     * @param errorMsg
     */
    public ResultInfo(boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }

}
