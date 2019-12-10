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
}
