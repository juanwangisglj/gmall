package com.guazi.common.constant;

/**
 * @author glj
 * @date 2022/1/27 7:08 下午
 */
public enum ResultCode {

    Success("true",20000),
    Error("false",20001);

    private String msg;
    private Integer code;

    private ResultCode(){}

    ResultCode(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
