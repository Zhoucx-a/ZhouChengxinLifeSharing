package com.lifeSharing.params.storyManage;

import lombok.Data;

import java.util.Date;

@Data
public class PublishStoryParamIn {
    private String userNo;

    private String storyContext;

    private String photoUrl;
}
