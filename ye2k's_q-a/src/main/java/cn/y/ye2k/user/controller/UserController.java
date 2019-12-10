package cn.y.ye2k.user.controller;

import cn.y.ye2k.pojo.User;
import cn.y.ye2k.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author ye2k's look-up 内测小组
 * @date 2019-12-08
 */

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(@RequestParam(value = "username") String userName,
						@RequestParam(value = "password") String password,
						HttpSession session){
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		User loginUserInfo = this.userService.login(user);
		if(null!=loginUserInfo){
			session.setAttribute("users", user);
			return "redirect:/index";
		}else{
			return "redirect:/login.html";
		}
	}
}