package cn.y.ye2k.common.utils;

import java.util.UUID;

/**
 * 产生UUID随机字符串工具类
 *
 * @author ye2k's look-up 内测组
 * @date 2019-12
 */
public final class UuidUtil {
    private UuidUtil() {
    }

    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
