package cn.y.ye2k.sms.service.impl;

import cn.y.ye2k.common.enums.ExceptionEnum;
import cn.y.ye2k.common.exceptions.Ye2kException;
import cn.y.ye2k.common.utils.JsonUtils;
import cn.y.ye2k.common.utils.NumberUtils;
import cn.y.ye2k.common.utils.RegexUtils;
import cn.y.ye2k.sms.config.SmsProperties;
import cn.y.ye2k.sms.service.IShortMessageService;
import cn.y.ye2k.sms.utils.SmsHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author caolei @date 2019/12/15 22:06
 */
@Slf4j
@Service(value = "shortMessageService")
public class ShortMessageServiceImpl implements IShortMessageService {
    private final static String KEY_PREFIX = "ye2k:sms:shortMessage:phone";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SmsHelper smsHelper;

    @Resource(name = "smsProperties")
    private SmsProperties smsProperties;


    @Override
    public void sendVerifyCode(String phone) {
        //参数校验
        if (!RegexUtils.isPhone(phone)) {
            throw new Ye2kException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
        }
        HashMap<String, String> msg = new HashMap<>();
        msg.put("phone", phone);
        String code = NumberUtils.generateCode(6);
        //存入Redis缓存
        redisTemplate.opsForValue().set(KEY_PREFIX + phone, code, 5, TimeUnit.MINUTES);
        msg.put("code", code);

        this.sendSms(msg);
    }


    @Override
    public void sendSms(Map<String, String> msg) {
        if (msg == null) {
            return;
        }
        // 移除手机数据，剩下的是短信参数
        String phone = msg.remove("phone");
        if (StringUtils.isBlank(phone)) {
            return;
        }
        try {
            smsHelper.sendMessage(phone, smsProperties.getSignName(), smsProperties.getVerifyCodeTemplate(), JsonUtils.toString(msg));
        } catch (Ye2kException e) {
            // 短信验证码失败后不重发，所以需要捕获异常。
            log.error("【SMS服务】短信验证码发送失败", e);
        }
    }
}
