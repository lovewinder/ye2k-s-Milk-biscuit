package cn.y.ye2k.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Json工具类
 *
 * @author ye2k's look-up 内测组
 * @date 2019-12-08
 */
public class JsonUtils {


    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    /**
     * 将对象装换成json
     *
     * @param obj 原始java对象
     * @return String 返回一个json数据
     */
    public static String toString(Object obj) {
        /*传入一个Obj对象,先判断对象是否为null,如是null返回null*/
        if (obj == null) {
            return null;
        }
        /*判断传入的Obj是否是String类型,如是直接将其转换成String返回*/
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            //使用jackson中的方法将对象装成json数据返回,捕获异常
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            //捕获异常后打印错误日志
            logger.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    /**
     * 静态方法:将json反序列成对象
     *
     * @param json   json数据
     * @param tClass 要被序列化成的对象
     * @param <T>    要反序列对象的类型
     * @return 反序列出的对象
     */
    public static <T> T toBean(String json, Class<T> tClass) {
        try {
            //使用jackson中的方法将json数据反序列成对象,需要传入被序列化json数据和要被序列化成什么样的类型
            return MAPPER.readValue(json, tClass);
        } catch (IOException e) {
            //出现异常捕获并打印错误日志
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    /**
     * 静态方法:把一个json反序列化为List类型，需要指定集合中元素类型，包含两个参数：
     *
     * @param json   要反序列化的json字符串
     * @param eClass 集合类型
     * @param <E>    集合中元素类型
     * @return 反序列化出的集合对象数据
     */
    public static <E> List<E> toList(String json, Class<E> eClass) {
        try {
            return MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    /**
     * 静态方法: 把一个json反序列化为Map类型，需要指定集合中key和value类型，包含三个参数：
     *
     * @param json   要反序列化的json字符串
     * @param kClass 集合中key的类型
     * @param vClass 集合中value的类型
     * @param <K>    集合中key的类型
     * @param <V>    集合中value的类型
     * @return son反序列化为Map对象
     */
    public static <K, V> Map<K, V> toMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return MAPPER.readValue(json, MAPPER.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    /**
     * 静态方法:把json字符串反序列化，当反序列化的结果比较复杂时，通过这个方法转换，参数：
     *
     * @param json 要反序列化的json字符串
     * @param type 在传参时，需要传递TypeReference的匿名内部类，把要返回的类型写在TypeReference的泛型中，则返回的就是泛型中类型
     * @param <T>  对象的类型
     * @return 反序列化成的对象
     */
    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return MAPPER.readValue(json, type);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }
}
