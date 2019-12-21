package cn.y.ye2k.sms.service;

import java.util.Map;

/**
 * @author caolei @date 2019/12/15 22:00
 */
public interface IShortMessageService {
    void sendSms(Map<String, String> msg);

    void sendVerifyCode(String phone);
}
