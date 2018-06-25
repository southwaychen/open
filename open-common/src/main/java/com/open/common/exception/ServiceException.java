package com.open.common.exception;

/**
 * Created by Tony on 6/10/2018.
 */
public class ServiceException extends RuntimeException {

    static final long serialVersionUID = 1L;
    private String code;

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ServiceException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public ServiceException(Throwable cause) {
        this(null, cause);
    }

    public ServiceException(String code, String msg) {
        this(code, msg, null);
    }
}
