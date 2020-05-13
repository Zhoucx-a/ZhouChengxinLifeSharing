package com.lifeSharing.pojo;

import java.util.Date;

public class StoryInformation extends StoryInformationKey {
    private String storyContext;

    private Date publishTime;

    private Integer isCheck;

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

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }
}