package cn.y.ye2k.common.exceptions;

/**
 * 密码错误异常
 */
public class PasswordErrorException extends Exception {
    public PasswordErrorException(){

    }
    public PasswordErrorException(String errorMsg){
        super(errorMsg);
    }
}
