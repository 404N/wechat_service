package com.example.wechat.dao;

import com.example.wechat.core.CustomerMapper;
import com.example.wechat.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper extends CustomerMapper<Users> {
    public Users selectUsersByUsernameAndPwd(String username,String password);
}