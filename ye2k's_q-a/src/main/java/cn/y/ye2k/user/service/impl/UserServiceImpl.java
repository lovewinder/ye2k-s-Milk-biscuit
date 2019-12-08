package cn.y.ye2k.user.service.impl;

import javax.annotation.Resource;

import cn.y.ye2k.pojo.User;
import cn.y.ye2k.user.mapper.UserMapper;
import cn.y.ye2k.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author ye2k's look-up 内测小组
 * @date 2019-12-08
 */

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Override
	public User login(User user) {
		return userMapper.selUserByNameAndPwd(user);
	}

}
