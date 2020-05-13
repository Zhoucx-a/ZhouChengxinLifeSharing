package com.lifeSharing.params.friendsManage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class QueryUserDetailParamOut {
    private String userNo;

    private String userName;

    private String sex;

    private String tel;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birth;

    private String address;

    private String remark; //备注

    private String photoUrl;

    private String backPhotoUrl;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date registerTime;

    private int focusNoSum;

    private int fansSum;

    private int storySum;
}
