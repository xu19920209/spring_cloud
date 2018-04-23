package com.tuyue;

/**
 * 请求返回对象
 * Created by Administrator on 2017/5/25.
 */
public class Result<T> {
    private Integer code;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(Integer code, String msg, Object data) {
        if(data==null){
            data=new Result();
        }
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result() {
    }

    public static Result success(Integer code, String msg, Object data) {
        return new Result(code,msg,data);
    }
    public static Result error(Integer code, String msg, Object data) {
        return new Result(code,msg,data);
    }
    public static Result error(Integer code, String msg) {
        return new Result(code,msg);
    }
    public static Result success(Integer code, String msg) {
        return new Result(code,msg);
    }
    public static Result success() {
        return new Result(1,"SUCCESS");
    }
    public static Result success(Object data) {
        return new Result(1,"SUCCESS",data);
    }
    public static Result error(String msg) {
        return new Result(2,msg);
    }
    public static Result error() {
        return new Result(2,"error");
    }
}