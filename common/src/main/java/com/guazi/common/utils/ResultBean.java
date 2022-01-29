package com.guazi.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.guazi.common.constant.CommonCode;
import com.guazi.common.constant.CommonMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author xf
 * @Date 2022/1/29 5:22 下午
 **/
@Data
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = -2792556188993845048L;

    private static final JSONObject EMPTY_OBJECT = new JSONObject();

    private int statusCode;

    private String message;

    private T data;

    public ResultBean() {
    }

    public ResultBean(final Integer code, final String message, final T data) {

        this.statusCode = code;
        this.message = message;
        this.data = data;
    }

    public ResultBean(final Integer code, final String message) {

        this.statusCode = code;
        this.message = message;
        this.data = (T) EMPTY_OBJECT;
    }

    public ResultBean(final Integer code) {

        this.statusCode = code;
        this.message = CommonMessage.SUCCESS;
        this.data = (T) EMPTY_OBJECT;
    }

    public ResultBean(final String message) {
        this.statusCode = CommonCode.SUCCESS;
        this.message = message;
        this.data = (T) EMPTY_OBJECT;
    }

    /**
     * return success.
     *
     * @return {@linkplain ResultBean}
     */
    public static <K> ResultBean<K> success() {
        return success(CommonMessage.SUCCESS, (K) EMPTY_OBJECT);
    }

    /**
     * return success.
     *
     * @param msg msg
     * @return {@linkplain ResultBean}
     */
    public static <K> ResultBean<K> success(final String msg) {
        return new ResultBean<>(msg);
    }

    /**
     * return success.
     *
     * @param data this is result data.
     * @return {@linkplain ResultBean}
     */
    public static <K> ResultBean<K> success(final K data) {
        return success(CommonMessage.SUCCESS, data);
    }

    /**
     * return success.
     *
     * @param msg  this ext msg.
     * @param data this is result data.
     * @return {@linkplain ResultBean}
     */
    public static <K> ResultBean<K> success(final String msg, final K data) {
        return get(CommonCode.SUCCESS, msg, data);
    }

    /**
     * return error .
     *
     * @param msg error msg
     * @return {@linkplain ResultBean}
     */
    public static <K> ResultBean<K> error(final String msg) {
        return error(CommonCode.ERROR, msg);
    }

    /**
     * return error .
     *
     * @param code error code
     * @param msg  error msg
     * @return {@linkplain ResultBean}
     */
    public static <K> ResultBean<K> error(final int code, final String msg) {
        return new ResultBean<>(code, msg);
    }

    /**
     * return error .
     *
     * @param code error code
     * @param msg  error msg
     * @param data error data
     * @return {@linkplain ResultBean}
     */
    public static <K> ResultBean<K> error(final int code, final String msg, final K data) {
        return get(code, msg, data);
    }


    private static <K> ResultBean<K> get(final int code, final String msg, final K data) {
        return new ResultBean<>(code, msg, data);
    }
}
