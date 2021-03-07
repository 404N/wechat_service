package com.example.wechat.dao;

import com.example.wechat.core.CustomerMapper;
import com.example.wechat.entity.FriendsRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FriendsRequestMapper extends CustomerMapper<FriendsRequest> {
}