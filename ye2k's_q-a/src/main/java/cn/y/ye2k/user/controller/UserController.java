package cn.y.ye2k.user.controller;

import cn.y.ye2k.pojo.User;
import cn.y.ye2k.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ye2k's look-up 内测小组
 * @date 2019-12-08
 */
@Slf4j
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 系统用户登录
     * @param userName
     * @param password
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userlogin(@RequestParam(value = "username") String userName,
                            @RequestParam(value = "password") String password,
                            @RequestParam(value = "loginVerifyCode") String loginVerifyCode,
                            HttpSession session,
                            HttpServletRequest request) {
        //校验登录时输入的验证码是否正确
        String sessionVerifyCode = (String) request.getSession().getAttribute("verifyCode");
        //忽略大小写比较
        if (!StringUtils.equalsIgnoreCase(loginVerifyCode,sessionVerifyCode)) {
            return "redirect:/login.html";
        }

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        User loginUserInfo = this.userService.userlogin(user);
        if (null != loginUserInfo) {
            session.setAttribute("users", user);
            return "/index";
        } else {
            return "redirect:/login.html";
        }
    }

    @PostMapping(value = "register")
    public String userRegister(
            User user,
            @RequestParam(value = "registerVerifyCode") String registerVerifyCode,
            @RequestParam(value = "registerEamil") String email,
            HttpSession session ) {
        //校验注册时输入的验证码
        String sessionVerifyCode = (String)session.getAttribute("verifyCode");
        if (!StringUtils.equalsIgnoreCase(registerVerifyCode,sessionVerifyCode)) {
            return "redirect:/login.html";
        }
        this.userService.userRegister(user,email);
        return null;
    }


    /**
     * 用户激活,当用户点击激活链接携带激活码,取得验证码,与数据库中比较
     * @param code
     * @return
     */
    @RequestMapping("active")
    public String userActive(@RequestParam("code") String code) {
        try {
            Boolean flag = userService.active(code);
            if (flag) {
                //如果激活成功,跳转登录页面
                return "redirect:/login.html";
            } else {
                //激活失败,跳转500页面
                return "redirect:/500.html";
            }
        } catch (Exception e) {
            log.error("[用户]-[用户激活失败]>>>"+code+"错误原因>>>"+e);
            //激活失败,跳转500页面
            return "redirect:/500.html";
        }
    }
}