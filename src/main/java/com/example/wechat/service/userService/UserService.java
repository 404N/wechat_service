package com.example.wechat.service.userService;

import com.example.wechat.entity.Users;
import com.example.wechat.vo.UsersVO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**
     * @author Tzj
     * 判断用户名是否存在
     */
    public boolean queryUserNameIsExist(String username);

    /**
     * @author Tzj
     * 根据用户名和密码查询用户是否存在
     */
    public Users queryUserExist(String username,String pwd);

    public UsersVO registerOrLogin(Users user);

    public Users saveUser(Users user);
}
