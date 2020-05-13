package com.lifeSharing.params.friendsManage;

import lombok.Data;

@Data
public class QueryFriendByNameParamIn {
    private String userNo;  //当前登录人

    private String userName;  //搜索的好友名字
}
