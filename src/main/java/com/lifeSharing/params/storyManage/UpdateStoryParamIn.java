package com.lifeSharing.params.storyManage;

import lombok.Data;

@Data
public class UpdateStoryParamIn {
    private String userNo;

    private String storyCode;

    private String storyContext;

    private String photoUrl;
}
