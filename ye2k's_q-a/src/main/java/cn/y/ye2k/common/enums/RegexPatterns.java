package cn.y.ye2k.common.enums;

/**
 * 正则模板类
 * 项目后台是用的正则请都放置在此类之中,便于维护
 *
 * @author ye2k's look-up 内测组
 * @date 2019-12-08
 */
public abstract class RegexPatterns {
    /**
     * 手机号正则
     */
    public static final String PHONE_REGEX = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|8[0-9]|9[89])\\d{8}$";
    /**
     * 邮箱正则
     */
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    /**
     * 用户名正则
     */
    public static final String USERNAME_REGEX = "^\\w{4,30}$";

}
