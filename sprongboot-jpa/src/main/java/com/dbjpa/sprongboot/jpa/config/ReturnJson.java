package com.dbjpa.sprongboot.jpa.config;

public class ReturnJson<T> {
    private Integer code;
    private String message;
    private T data;

    private ReturnJson(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }
    private ReturnJson(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    /**
     * 支持自定义的code和message
     */
    public static ReturnJson json(Integer code, String message) {
        return new ReturnJson(code, message);
    }
    public static <T> ReturnJson json(Integer code, String message, T data) {
        return new ReturnJson<>(code, message, data);
    }
    /**
     * 通用成功
     */
    public static ReturnJson success() {
        return ReturnJson.json(ReturnEnum.SUCCESS.getCode(), ReturnEnum.SUCCESS.getMessage());
    }
    public static <T> ReturnJson success(T data) {
        return ReturnJson.json(ReturnEnum.SUCCESS.getCode()
                , ReturnEnum.SUCCESS.getMessage(), data);
    }
    /**
     * 带分页信息的通用成功
     */
    public static <T> ReturnJson pageSuccess(Long totalRecords, Integer currentPage, Integer pageSize, T data) {
        return ReturnJson.success(new PageInfo<>(totalRecords, currentPage, pageSize, data));
    }
    /**
     * 通用失败
     */
    public static ReturnJson fail() {
        return ReturnJson.json(ReturnEnum.FAIL.getCode(), ReturnEnum.FAIL.getMessage());
    }
}
