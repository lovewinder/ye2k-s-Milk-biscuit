package cn.y.ye2k.user.service.impl;

import javax.annotation.Resource;

import cn.y.ye2k.common.utils.MailUtil;
import cn.y.ye2k.common.utils.Md5Util;
import cn.y.ye2k.common.utils.UuidUtil;
import cn.y.ye2k.pojo.User;
import cn.y.ye2k.user.mapper.UserMapper;
import cn.y.ye2k.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ye2k's look-up 内测小组
 * @date 2019-12-08
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userMapper;
	@Override
	public User userlogin(User user) {
		return userMapper.selUserByNameAndPwd(user);
	}

	@Override
	public void userRegister(User user,String email) {
		//查询用户名,判断是否已注册
       User findUser=userMapper.findUserByEmail(email);
       if (findUser!=null){
       	return;
	   }
		//设置激活码和密码
		String activeCode=UuidUtil.getUuid();
		String encodeByMd5=null;
		try {
			encodeByMd5 = Md5Util.encodeByMd5(user.getPassword());
		} catch (Exception e) {
			log.error("[用户]-[用户注册时加密密码异常]>>>"+user.getPassword()+"错误原因>>>"+e);
		}
		user.setPassword(encodeByMd5);
        userMapper.insertUser(user);
		//注册成功就发送邮箱激活链接
		MailUtil.sendMail(user.getEmail(),"<h2>尊敬的用户:"+user.getUsername()+",您已经成功注册,请点击本链接激活账户!如非本人操作,请勿忽视此邮件!</h2><a href='http://localhost:8080/user/active?code="+user.getCode()+"'>点击激活></a>");
	}

	@Override
	public Boolean active(@RequestParam("code")String code) {
//        int flag=userMapper.active(code);
		//使用通用Mapper改造
		//使用激活码查询需要激活的账户
		User u = new User();
		u.setCode(code);
		User selUser = userMapper.selectOne(u);
		//查找到用户后对激活状态进行修改
		selUser.setStatus("Y");
		int flag = userMapper.updateByPrimaryKeySelective(selUser);

		if (flag==1){
			return true;
		}
		return false;
	}

}
