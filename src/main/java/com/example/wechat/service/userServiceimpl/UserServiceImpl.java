package com.example.wechat.service.userServiceimpl;

import com.example.wechat.dao.UsersMapper;
import com.example.wechat.entity.Users;
import com.example.wechat.exceptions.BaseException;
import com.example.wechat.response.CommonEnum;
import com.example.wechat.service.userService.UserService;
import com.example.wechat.utils.MD5Util;
import com.example.wechat.utils.StringUtil;
import com.example.wechat.utils.UuidUtil;
import com.example.wechat.vo.UsersVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Tzj
 * @Date 2021/3/6 16:23
 */
@Service
public class UserServiceImpl implements UserService {

    final private UsersMapper usersMapper;

    public UserServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public boolean queryUserNameIsExist(String username) {
        Users users = new Users();
        users.setUsername(username);
        Users result = usersMapper.selectOne(users);
        return result != null;
    }

    @Override
    public Users queryUserExist(String username, String pwd) {
        Users users = usersMapper.selectUsersByUsernameAndPwd(username, pwd);
        return users;
    }

    public UsersVO registerOrLogin(Users user) {
        if (StringUtil.isNullOrEmpty(user.getUsername()) || StringUtil.isNullOrEmpty(user.getPassword())) {
            throw new BaseException(CommonEnum.USER_NAME_OR_PASSWORD_EMPTY);
        }
        Users users=new Users();
        if (queryUserNameIsExist(user.getUsername())) {
            //登录
             users = queryUserExist(user.getUsername(), MD5Util.getMD5_32_lower(user.getPassword()));
            if (users == null) {
                throw new BaseException(CommonEnum.ACCOUNT_WRONG);
            }
        } else {
            //注册
            users = new Users();
            users.setNickname(user.getUsername());
            users.setFaceImage("");
            users.setFaceImageBig("");
            users.setPassword(MD5Util.getMD5_32_lower(user.getPassword()));
            users=saveUser(users);
        }
        UsersVO usersVO=new UsersVO();
        BeanUtils.copyProperties(users,usersVO);
        return usersVO;
    }

    @Override
    public Users saveUser(Users user) {
        user.setId(UuidUtil.getUUID());
        user.setQrcode("");
        usersMapper.insert(user);
        return user;
    }
}
