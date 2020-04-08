package com.lifeSharing.toolsUtil;

import lombok.Data;

/*
 * 自定义异常
*/

@Data
public class MyException extends RuntimeException {
    private int code;
    private String message;

    public MyException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
