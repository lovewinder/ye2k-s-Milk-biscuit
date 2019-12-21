package cn.y.ye2k.sms.listener;


import cn.y.ye2k.sms.config.SmsProperties;
import cn.y.ye2k.sms.utils.SmsHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 短信服务对于消息中间件的监听器
 *
 * @author caolei @date 2019/7/8 11:37
 */
@Slf4j
@Component
public class SmsListener {

    @Autowired
    private SmsProperties prop;

    @Autowired
    private SmsHelper smsHelper;

    public void listenVerifyCode(Map<String, String> msg) {

    }
}