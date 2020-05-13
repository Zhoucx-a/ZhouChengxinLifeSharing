package com.lifeSharing.params.storyManage;

import lombok.Data;

import java.util.List;

@Data
public class QueryStoryCommentsParamOut {
    private String commentsCode;    //一级评论编码

    private String commentatorNo;   //一级评论人

    private String commentatorName;

    private String commentsContext;

    private boolean replyOpen;

    private List replyList;     //二级评论列表

    private String myPhotoUrl;
}
