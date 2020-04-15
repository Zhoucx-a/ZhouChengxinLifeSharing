package com.lifeSharing.params.login;

import lombok.Data;

@Data
public class LoginInParamOut {
    private int code;

    private String msg;

    private String loginType;

    private String userNo;

    private String userName;
}
