package com.lifeSharing.params.administratorAccountManage;

import lombok.Data;

import java.util.Date;

@Data
public class QueryAccountListParamOut {
    private String userNo;

    private String userName;

    private String loginStatus;

    private String loginType;

    private String sex;

    private Date birth;
}
