package com.lifeSharing.params.friendsManage;

import lombok.Data;

@Data
public class QueryUserDetailParamIn {
    private String userNo;  //当前登录人

    private String focusNo; //查询的人
}
