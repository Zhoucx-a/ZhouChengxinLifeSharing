package com.lifeSharing.pojo;

import java.util.Date;

public class UserConnection extends UserConnectionKey {
    private String focusName;

    private String isSpecialFocus;

    private Date focusTime;

    private String remark;

    public String getFocusName() {
        return focusName;
    }

    public void setFocusName(String focusName) {
        this.focusName = focusName == null ? null : focusName.trim();
    }

    public String getIsSpecialFocus() {
        return isSpecialFocus;
    }

    public void setIsSpecialFocus(String isSpecialFocus) {
        this.isSpecialFocus = isSpecialFocus == null ? null : isSpecialFocus.trim();
    }

    public Date getFocusTime() {
        return focusTime;
    }

    public void setFocusTime(Date focusTime) {
        this.focusTime = focusTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}