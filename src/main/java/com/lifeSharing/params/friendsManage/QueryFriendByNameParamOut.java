package com.lifeSharing.params.friendsManage;

import lombok.Data;

@Data
public class QueryFriendByNameParamOut {
    private String userNo;

    private String userName;

    private String sex;

    private String description;

    private String address;

    private int focusNoSum;

    private int fansSum;

    private int storySum;

    private int isFocus;    //0代表未关注| 1代表关注

    private String myPhotoUrl;
}
