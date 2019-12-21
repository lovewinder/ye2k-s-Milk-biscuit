package cn.y.ye2k.user.mapper;

import cn.y.ye2k.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author ye2k's look-up 内测小组
 * @date 2019-12-08
 */
public interface UserMapper {
	@Select("SELECT * FROM TAB_USER WHERE USER_NAME=#{userName} AND PASSWORD=#{password}")
	User selUserByNameAndPwd(User users);

	/**
	 * 根据用户名查询用户信息
	 * @param username 用户名
	 * @return
	 */
	User findUserByUsername(String username);

	/**
	 * 更据手机号查询用户信息
	 * @param telephone 手机号
	 * @return 封装好的user javabean对象
	 */
	User findUserByPhoneNumer(String telephone);

	/**
	 * 更据邮箱查询用户信息
	 * @param email 邮箱
	 * @return 封装好的user javabean对象
	 */
	User findUserByEmail(String email);

	/**
	 *
	 * @param user
	 */
	void insertUser(User user);
}
