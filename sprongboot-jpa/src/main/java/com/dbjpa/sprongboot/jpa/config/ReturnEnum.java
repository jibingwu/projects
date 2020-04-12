package com.dbjpa.sprongboot.jpa.config;

public enum ReturnEnum {
    /**
     * 通用成功
     **/
    SUCCESS(200, "success"),
    /**
     * 通用失败
     **/
    FAIL(400, "fail"),
    /**
     * 权限访问错误
     **/
    AUTH_ERROR(401, "auth error"),
    /**
     * 账密登录失败
     **/
    LOGIN_ERROR(402, "login deny");

    private Integer code;
    private String message;

    ReturnEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public Integer getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }
}
