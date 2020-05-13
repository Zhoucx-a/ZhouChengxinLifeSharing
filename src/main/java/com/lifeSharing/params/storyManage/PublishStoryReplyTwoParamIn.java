package com.lifeSharing.params.storyManage;

import lombok.Data;

@Data
public class PublishStoryReplyTwoParamIn {
    private String commentsCode;

    private String replyToId;

    private String replyContext;

    private String replierNo;

    private String replierName;

    private String toId;

    private String toName;
}
