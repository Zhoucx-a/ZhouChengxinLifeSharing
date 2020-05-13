package com.lifeSharing.params.storyManage;

import lombok.Data;

@Data
public class PublishStoryReplyOneParamIn {
    private String commentsCode;

    private String replyContext;

    private String replierNo;

    private String replierName;

    private String toId;

    private String toName;
}
