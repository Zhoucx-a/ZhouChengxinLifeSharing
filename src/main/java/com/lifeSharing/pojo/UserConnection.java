package com.lifeSharing.pojo;

import java.util.Date;

public class UserConnection extends UserConnectionKey {
    private String foucsName;

    private String isSpecialFocus;

    private Date foucsTime;

    private String remark;

    public String getFoucsName() {
        return foucsName;
    }

    public void setFoucsName(String foucsName) {
        this.foucsName = foucsName == null ? null : foucsName.trim();
    }

    public String getIsSpecialFocus() {
        return isSpecialFocus;
    }

    public void setIsSpecialFocus(String isSpecialFocus) {
        this.isSpecialFocus = isSpecialFocus == null ? null : isSpecialFocus.trim();
    }

    public Date getFoucsTime() {
        return foucsTime;
    }

    public void setFoucsTime(Date foucsTime) {
        this.foucsTime = foucsTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}