package com.lifeSharing.params.personalManage;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UpdatePersonalInformationParamIn {
    private String userNo;

    private String userName;

    private String sex;

    private String password;

    private String tel;

    private String description;

    private Date birth;

    private String address;
}
