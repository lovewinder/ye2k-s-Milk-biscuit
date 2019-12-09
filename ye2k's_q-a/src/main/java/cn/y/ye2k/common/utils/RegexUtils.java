package cn.y.ye2k.common.utils;

import cn.y.ye2k.common.enums.RegexPatterns;
import org.apache.commons.lang3.StringUtils;

/**
 * 正则工具类
 * 结合正则模板类,在后台完成数据格式的校验
 *
 * @author ye2k's look-up 内测组
 * @date 2019-12-08
 */
public class RegexUtils {
    /**
     * 是否符合手机格式
     *
     * @param phone 要校验的手机号
     * @return true:符合，false：不符合
     */
    public static boolean isPhone(String phone) {
        return matches(phone, RegexPatterns.PHONE_REGEX);
    }

    /**
     * 是否符合邮箱格式
     *
     * @param email 要校验的邮箱
     * @return true:符合，false：不符合
     */
    public static boolean isEmail(String email) {
        return matches(email, RegexPatterns.EMAIL_REGEX);
    }

    private static boolean matches(String str, String regex) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        return str.matches(regex);
    }
}
