package cn.y.ye2k.common.exceptions;

import cn.y.ye2k.common.enums.ExceptionEnum;
import lombok.Getter;

/**
 * 自定义异常来处理异常信息
 * 继承运行时异常
 *
 * @author ye2k's look-up 内测组
 * @date 2019-12-08
 */
@Getter
public class Ye2kException extends RuntimeException {
    /**
     * http状态码
     */
    private int status;

    /**
     * 构造方法,接受枚举类型信息 自定义枚举类型
     *
     * @param em 枚举常量
     */
    public Ye2kException(ExceptionEnum em) {
        //从枚举中获取提示语
        super(em.getMessage());
        //从枚举中获取状态码
        this.status = em.getStatus();
    }

    public Ye2kException(ExceptionEnum em, Throwable cause) {
        super(em.getMessage(), cause);
        this.status = em.getStatus();
    }
}
