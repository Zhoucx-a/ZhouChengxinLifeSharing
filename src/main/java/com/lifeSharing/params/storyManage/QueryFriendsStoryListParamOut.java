package com.lifeSharing.params.storyManage;

import lombok.Data;

import java.util.Date;

@Data
public class QueryFriendsStoryListParamOut {
    private String storyCode;

    private String storyContext;

    private Integer likeCount;

    private String photoUrl;

    private String userNo;

    private String userName;

    private String isLike;

    private String isCollection;

    private Date publishTime;

    private boolean commentOpen;

    //评论数量
    private long commentsCount;
}
