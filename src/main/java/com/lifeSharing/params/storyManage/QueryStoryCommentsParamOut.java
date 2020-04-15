package com.lifeSharing.params.storyManage;

import lombok.Data;

import java.util.List;

@Data
public class QueryStoryCommentsParamOut {
    private String commentsCode;

    private String commentatorNo;

    private String commentatorName;

    private String commentsContext;

    private boolean replyOpen;

    private List replyList;
}
