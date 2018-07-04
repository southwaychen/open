package com.open.api.entity.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tony on 2016-11-03.
 */
public class ResponseWrapper<T> implements Serializable {

    private String code;
    private String msg;
    private T data;

    public ResponseWrapper() {
        this.code = ResponseCode.RET_SUCCESS.getCode();
        this.msg = ResponseCode.RET_SUCCESS.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setData(String key,Object value){
        if (data == null){
            this.data = (T) new HashMap<String,Object>();
            ((Map) this.data).put(key,value);
        }else if(this.data instanceof Map){
            ((Map) this.data).put(key,value);
        }
    }
}
