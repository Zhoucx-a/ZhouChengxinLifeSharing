package com.lifeSharing.pojo;

public class UserStoryKey {
    private String userNo;

    private String storyCode;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getStoryCode() {
        return storyCode;
    }

    public void setStoryCode(String storyCode) {
        this.storyCode = storyCode == null ? null : storyCode.trim();
    }
}