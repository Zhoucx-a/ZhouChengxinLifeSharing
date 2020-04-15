package com.lifeSharing.params.storyManage;

import lombok.Data;

@Data
public class QueryPersonalStoryListParamOut {
    private String storyCode;

    private String storyContext;

    private Integer likeCount;

    private String photoUrl;

    private String userNo;

    private String userName;

    private boolean commentOpen;

    //评论数量
    private long commentsCount;
}
