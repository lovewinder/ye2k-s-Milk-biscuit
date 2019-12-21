package cn.y.ye2k.user.service;

import cn.y.ye2k.pojo.User;
/**
 * @author ye2k's look-up 内测小组
 * @date 2019-12-08
 */
public interface IUserService {
    User userlogin(User user);
    void userRegister(User user,String email);
    /**
     * 根据激活码激活账户
     * @param code
     * @return
     */
    Boolean active(String code);
}
