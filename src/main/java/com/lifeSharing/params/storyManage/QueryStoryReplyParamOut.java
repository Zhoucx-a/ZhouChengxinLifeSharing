package com.lifeSharing.params.storyManage;

import lombok.Data;

@Data
public class QueryStoryReplyParamOut {
    private String replyCode;

    private String replyToId;

    private String replyContext;

    private String replierNo;   //回复人

    private String replierName;

    private String replyType;

    private String toId;

    private String toName;

    private boolean replyOpen;
}
