package cn.y.ye2k.user.controller;

import cn.y.ye2k.pojo.User;
import cn.y.ye2k.user.service.UserService;
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
	@Resource
	private UserService userServiceImpl;
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(@RequestParam(value = "username") String username,
						@RequestParam(value = "password") String password,
						HttpSession session){
		if("admin@lookup.com".equals(username)&&"123".equals(password)){
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			session.setAttribute("users", user);
			return "redirect:/index";
		}else{
			return "redirect:/login.html";
		}
	}
}