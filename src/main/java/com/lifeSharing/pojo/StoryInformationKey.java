package com.lifeSharing.pojo;

public class StoryInformationKey {
    private String storyCode;

    private String userNo;

    public String getStoryCode() {
        return storyCode;
    }

    public void setStoryCode(String storyCode) {
        this.storyCode = storyCode == null ? null : storyCode.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }
}