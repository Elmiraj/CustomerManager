package com.biz.std.util.Exception;

/**
 * BusinessException class
 * @author junzhang
 * @date 2018-12-25
 */

public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 2399482671638328601L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
