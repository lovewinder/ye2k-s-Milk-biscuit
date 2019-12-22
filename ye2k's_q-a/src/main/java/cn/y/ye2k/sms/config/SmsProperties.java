package cn.y.ye2k.sms.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * 作用：
 * 用于加载.properties文件中的配置。例如我们配置数据源时，可以把连接数据库的信息写到properties配置文件中，就可以使用此注解指定properties配置文件的位置。
 * 属性：
 * value[]：用于指定properties文件位置。如果是在类路径下，需要写上classpath:
 * @author caolei @date 2019/7/8 11:26
 */
@Data
//@PropertySource(value = "classpath:sms.properties",encoding = "UTF-8")
public class SmsProperties {
    /**
     * 账号
     */
    @Value(value = "${sms.accessKeyID}")
    private String accessKeyID;
    /**
     * 密钥
     */
    @Value(value = "${sms.accessKeySecret}")
    private String accessKeySecret;
    /**
     * 短信签名
     */
    @Value(value = "${sms.signName}")
    private String signName;
    /**
     * 短信模板
     */
    @Value(value = "${sms.verifyCodeTemplate}")
    private String verifyCodeTemplate;
    /**
     * 发送短信请求的域名
     */
    @Value("${sms.domain}")
    private String domain;
    /**
     * API版本
     */
    @Value(value = "${sms.version}")
    private String version;
    /**
     * API类型
     */
    @Value(value = "${sms.action}")
    private String action;
    /**
     * 区域
     */
    @Value(value = "${sms.regionID}")
    private String regionID;
}
