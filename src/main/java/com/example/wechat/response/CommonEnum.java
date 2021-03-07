package com.example.wechat.response;

import com.example.wechat.exceptions.BaseError;

public enum CommonEnum implements BaseError {
    // 数据操作错误定义
    SUCCESS("200", "成功!"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    ACCOUNT_WRONG("401","账号或密码错误!"),
    ACCOUNT_EXIST("403","该邮箱已被注册!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!"),
    USER_NAME_OR_PASSWORD_EMPTY("503","账号或密码不能为空")
    ;

    /** 错误码 */
    private String resultCode;

    /** 错误描述 */
    private String resultMsg;

    CommonEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }

}