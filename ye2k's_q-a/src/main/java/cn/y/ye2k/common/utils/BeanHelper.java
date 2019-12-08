package cn.y.ye2k.common.utils;


import cn.y.ye2k.common.enums.ExceptionEnum;
import cn.y.ye2k.common.exceptions.Ye2kException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * copyProperties工具类
 * 可以方便的进行Bean数据的拷贝
 *
 * @author ye2k's look-up 内测组
 * @date 2019-12-08
 */
@Slf4j
public class BeanHelper {

    public static <T> T copyProperties(Object source, Class<T> target) {
        try {
            T t = target.newInstance();
            BeanUtils.copyProperties(source, t);
            return t;
        } catch (Exception e) {
            log.error("【数据转换】数据转换出错，目标对象{}构造函数异常", target.getName(), e);
            throw new Ye2kException(ExceptionEnum.DATA_TRANSFER_ERROR);
        }
    }

    public static <T> List<T> copyWithCollection(List<?> sourceList, Class<T> target) {
        try {
            return sourceList.stream().map(s -> copyProperties(s, target)).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("【数据转换】数据转换出错，目标对象{}构造函数异常", target.getName(), e);
            throw new Ye2kException(ExceptionEnum.DATA_TRANSFER_ERROR);
        }
    }

    public static <T> Set<T> copyWithCollection(Set<?> sourceList, Class<T> target) {
        try {
            return sourceList.stream().map(s -> copyProperties(s, target)).collect(Collectors.toSet());
        } catch (Exception e) {
            log.error("【数据转换】数据转换出错，目标对象{}构造函数异常", target.getName(), e);
            throw new Ye2kException(ExceptionEnum.DATA_TRANSFER_ERROR);
        }
    }
}
