package com.wrh.sublet.common.core.exception;

/**
 * @author wrh
 * @date 2021/10/13
 */
public class BizException extends RuntimeException {

    private int code = -1;

    public BizException(String message) {
        super(message);
    }

    public BizException(int code,String message){
        super(message);
        this.code = code;
    }

    public BizException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
