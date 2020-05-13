package com.lifeSharing.params.storyManage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class QueryFriendsStoryListParamOut {
    private String storyCode;

    private String storyContext;

    private String photoUrl;

    private String userNo;

    private String userName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date publishTime;

    private boolean commentOpen;

    //评论数量
    private long commentsCount;
}
