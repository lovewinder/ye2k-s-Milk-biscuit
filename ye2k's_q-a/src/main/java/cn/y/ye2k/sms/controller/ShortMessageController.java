package cn.y.ye2k.sms.controller;

import cn.y.ye2k.sms.service.IShortMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author caolei @date 2019/12/15 21:59
 */
@Controller
public class ShortMessageController {

    @Autowired
    private IShortMessageService shortMessageService;

    /**
     * 通过手机号获取短信验证码
     *
     * @param phone 手机号
     * @return 无法值, 状态码204
     */
    @PostMapping("code")
    public ResponseEntity<Void> sendVerifyCode(
            @RequestParam("phone") String phone) {
        this.shortMessageService.sendVerifyCode(phone);
        //获取验证码无返回值
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
