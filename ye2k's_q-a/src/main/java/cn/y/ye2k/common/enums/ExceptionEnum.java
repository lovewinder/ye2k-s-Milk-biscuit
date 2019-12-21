package cn.y.ye2k.common.enums;

import lombok.Getter;

/**
 * 异常枚举类型,用于封装异常转态码和异常信息
 * 枚举本身是一种常值,一般用保存常值
 *
 * @author ye2k's look-up 内测组
 * @date 2019-12-08
 */
@Getter
public enum ExceptionEnum {
    //第一个参数http状态码.第二个参数提示信息
    PRICE_CANNOT_BE_NULL(400, "请求参数错误！"),
    DATA_TRANSFER_ERROR(500, "服务器宕机!"),
    CATEGORY_NOT_FOND(204, "数据未找到"), SEND_MESSAGE_ERROR(500,"短信发送失败");

    /**
     * 封装http状态码
     */
    private int status;
    /**
     * 封装提示信息
     */
    private String message;

    /**
     * 枚举类构造信息
     *
     * @param status  封装http状态码
     * @param message 封装提示信息
     */
    ExceptionEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
