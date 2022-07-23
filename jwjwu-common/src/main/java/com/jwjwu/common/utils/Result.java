package com.jwjwu.common.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 响应数据
 *
 * @author Scott
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static int SUCCESS_CODE = 0;

    /**
     * 编码：0表示成功，其他值表示失败
     */
    private int code = 0;
    /**
     * 消息内容
     */
    private String msg = "success";
    /**
     * 响应数据
     */
    private T data;

    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public static Result ok(){
        Result<Object> result = new Result<>();
        return result;
    }

    public Result<T> ok(int code,String msg){
        this.code = code;
        this.msg = msg;
        return this;
    }


    public boolean success() {
        return code == 0 ? true : false;
    }

    public Result<T> error() {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = MessageUtils.getMessage(this.code);
        return this;
    }

    public Result<T> error(int code) {
        this.code = code;
        this.msg = MessageUtils.getMessage(this.code);
        return this;
    }

    public Result<T> error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public Result<T> error(int code, String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public Result<T> error(String msg) {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
        return this;
    }

}
