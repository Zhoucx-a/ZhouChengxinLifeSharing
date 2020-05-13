package com.lifeSharing.params.storyManage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class QueryFriendsStoryList {
    private String storyCode;

    private String storyContext;

    private int likeCount;

    private int likeStatus;

    private int collectionCount;

    private int collectionStatus;

    private List<String> photoUrlList;

    private String userNo;

    private String userName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date publishTime;

    private boolean commentOpen;

    //评论数量
    private long commentsCount;

    private String myPhotoUrl;


}
