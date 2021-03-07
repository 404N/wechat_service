package com.example.wechat.dao;

import com.example.wechat.core.CustomerMapper;
import com.example.wechat.entity.MyFriends;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyFriendsMapper extends CustomerMapper<MyFriends> {
}