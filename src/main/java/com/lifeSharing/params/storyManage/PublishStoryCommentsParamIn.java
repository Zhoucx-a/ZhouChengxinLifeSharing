package com.lifeSharing.params.storyManage;

import lombok.Data;

@Data
public class PublishStoryCommentsParamIn {
    private String storyCode;

    private String commentatorNo;

    private String commentatorName;

    private String commentsContext;
}
