package com.example.wechat.dao;

import com.example.wechat.core.CustomerMapper;
import com.example.wechat.entity.ChatMsg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMsgMapper extends CustomerMapper<ChatMsg> {
}