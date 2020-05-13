package com.lifeSharing.params.administratorStoryManage;

import lombok.Data;

@Data
public class UpdateIsCheckParamIn {
    private String storyCode;

    private String userNo;

    private int isCheck;

    private String operNo;

    private String operName;
}
