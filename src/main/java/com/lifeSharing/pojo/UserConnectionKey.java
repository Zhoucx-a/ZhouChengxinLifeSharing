package com.lifeSharing.pojo;

public class UserConnectionKey {
    private String userNo;

    private String focusNo;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getFocusNo() {
        return focusNo;
    }

    public void setFocusNo(String focusNo) {
        this.focusNo = focusNo == null ? null : focusNo.trim();
    }
}