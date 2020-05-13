package com.lifeSharing.params.friendsManage;

import lombok.Data;

@Data
public class QueryFansListParamOut {
    private String fansNo;

    private String fansName;

    private String remark;

    private String isSpecialFocus;

    private int isFocus;

    private String description;

    private String photoUrl;
}
