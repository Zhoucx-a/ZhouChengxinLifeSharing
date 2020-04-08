package com.lifeSharing.pojo;

public class StoryComments {
    private String commentsCode;

    private String storyCode;

    private String commentatorNo;

    private String commentatorName;

    private String commentsContext;

    public String getCommentsCode() {
        return commentsCode;
    }

    public void setCommentsCode(String commentsCode) {
        this.commentsCode = commentsCode == null ? null : commentsCode.trim();
    }

    public String getStoryCode() {
        return storyCode;
    }

    public void setStoryCode(String storyCode) {
        this.storyCode = storyCode == null ? null : storyCode.trim();
    }

    public String getCommentatorNo() {
        return commentatorNo;
    }

    public void setCommentatorNo(String commentatorNo) {
        this.commentatorNo = commentatorNo == null ? null : commentatorNo.trim();
    }

    public String getCommentatorName() {
        return commentatorName;
    }

    public void setCommentatorName(String commentatorName) {
        this.commentatorName = commentatorName == null ? null : commentatorName.trim();
    }

    public String getCommentsContext() {
        return commentsContext;
    }

    public void setCommentsContext(String commentsContext) {
        this.commentsContext = commentsContext == null ? null : commentsContext.trim();
    }
}