package cn.y.ye2k.common.advice;

import cn.y.ye2k.common.exceptions.Ye2kException;
import lombok.Getter;
import org.joda.time.DateTime;

/**
 * 封装异常处理结果,使得响应给前端的格式更加规范
 * *@Getter lombok为类提供get方法,界面更清爽
 *
 * @author ye2k's look-up 内测组
 * @date 2019-12-08
 */
@Getter
public class ExceptionResult {
    /**
     * Http状态码
     */
    private int status;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 异常发生时间
     */
    private String timestamp;

    /**
     * 构造方法,从异常信息对象提取信息封装
     *
     * @param e
     */
    public ExceptionResult(Ye2kException e) {
        this.status = e.getStatus();
        this.message = e.getMessage();
        this.timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
    }
}