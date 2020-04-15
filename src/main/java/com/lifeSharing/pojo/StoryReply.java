package com.lifeSharing.pojo;

public class StoryReply {
    private String replyCode;

    private String commentsCode;

    private String replyToId;

    private String replyContext;

    private String replierNo;

    private String replierName;

    private String replyType;

    private String toId;

    private String toName;

    public String getReplyCode() {
        return replyCode;
    }

    public void setReplyCode(String replyCode) {
        this.replyCode = replyCode == null ? null : replyCode.trim();
    }

    public String getCommentsCode() {
        return commentsCode;
    }

    public void setCommentsCode(String commentsCode) {
        this.commentsCode = commentsCode == null ? null : commentsCode.trim();
    }

    public String getReplyToId() {
        return replyToId;
    }

    public void setReplyToId(String replyToId) {
        this.replyToId = replyToId == null ? null : replyToId.trim();
    }

    public String getReplyContext() {
        return replyContext;
    }

    public void setReplyContext(String replyContext) {
        this.replyContext = replyContext == null ? null : replyContext.trim();
    }

    public String getReplierNo() {
        return replierNo;
    }

    public void setReplierNo(String replierNo) {
        this.replierNo = replierNo == null ? null : replierNo.trim();
    }

    public String getReplierName() {
        return replierName;
    }

    public void setReplierName(String replierName) {
        this.replierName = replierName == null ? null : replierName.trim();
    }

    public String getReplyType() {
        return replyType;
    }

    public void setReplyType(String replyType) {
        this.replyType = replyType == null ? null : replyType.trim();
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId == null ? null : toId.trim();
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName == null ? null : toName.trim();
    }
}