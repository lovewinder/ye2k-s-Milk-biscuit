package cn.y.ye2k.sms.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 将配置类的内容注入到SpringAOC容器
 *
 * @author caolei @date 2019/7/8 11:30
 */
@Configuration
public class SmsConfiguration {

    @Bean(name = "iAcsClient")
    public IAcsClient acsClient(@Qualifier(value = "smsProperties") SmsProperties prop) {
        DefaultProfile profile = DefaultProfile.getProfile(
                prop.getRegionID(), prop.getAccessKeyID(), prop.getAccessKeySecret());
        return new DefaultAcsClient(profile);
    }

    @Bean(name = "smsProperties")
    public SmsProperties getSmsProperties() {
        SmsProperties smsProperties = new SmsProperties();
        return smsProperties;
    }
}