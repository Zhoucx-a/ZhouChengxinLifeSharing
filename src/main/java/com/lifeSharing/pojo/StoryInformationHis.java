package com.lifeSharing.pojo;

import java.util.Date;

public class StoryInformationHis {
    private String hisNo;

    private String storyCode;

    private String userNo;

    private String storyContext;

    private Date publishTime;

    private Integer isCheck;

    private String operNo;

    private String operName;

    private String operType;

    private Date operTime;

    private String photoUrl;

    public String getHisNo() {
        return hisNo;
    }

    public void setHisNo(String hisNo) {
        this.hisNo = hisNo == null ? null : hisNo.trim();
    }

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

    public String getOperNo() {
        return operNo;
    }

    public void setOperNo(String operNo) {
        this.operNo = operNo == null ? null : operNo.trim();
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }
}