package com.lifeSharing.params.administratorAccountManage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class QueryAccountDetailParamOut {
    private String userNo;

    private String userName;

    private String sex;

    private String tel;

    private String loginType;

    private String loginStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registerTime;

    private String description;

    private Date birth;

    private String address;

    private String remark;
}
