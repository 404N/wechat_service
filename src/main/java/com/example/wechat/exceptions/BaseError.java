package com.example.wechat.exceptions;

public interface BaseError {
    /** 错误码*/
    String getResultCode();

    /** 错误描述*/
    String getResultMsg();
}
