package com.lifeSharing.pojo;

import java.util.Date;

public class StoryInformation extends StoryInformationKey {
    private String storyContext;

    private Date publishTime;

    private Integer likeCount;

    private String photoUrl;

    public String getStoryContext() {
        return storyContext;
    }

    public void setStoryContext(String storyContext) {
        this.storyContext = storyContext == null ? null : storyContext.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }
}