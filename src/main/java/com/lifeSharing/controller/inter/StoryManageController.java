package com.lifeSharing.controller.inter;

import com.lifeSharing.params.storyManage.*;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface StoryManageController {
    //
    public PageOut<QueryFriendsStoryListParamOut> queryFriendsStoryList(QueryFriendsStoryListParamIn in, HttpSession session);
    //
    public PageOut<QueryPersonalStoryListParamOut> queryPersonalStoryList(QueryPersonalStoryListParamIn in,HttpSession session);
    //
    public MyResult deleteStory(DeleteStoryParamIn in);
    //
    public MyResult publishStory(PublishStoryParamIn in);
    //
    public MyResult updateStory(UpdateStoryParamIn in);
    //收藏|取消收藏
    public MyResult isColleciton(IsCollectionParamIn in);
    //点赞|取消点赞
    public MyResult isLike(IsLikeParamIn in);
    //
    public List<QueryStoryCommentsParamOut> queryStoryComments(QueryStoryCommentsParamIn in);
    //
    public List<QueryStoryReplyParamOut> queryStoryReply(QueryStoryReplyParamIn in);
    //
    public MyResult publishStoryComments(PublishStoryCommentsParamIn in);
    //
    public MyResult publishStoryReply(PublishStoryReplyParamIn in);
    //
    public MyResult deleteStoryComments(DeleteStoryCommentsParamIn in);
    //
    public MyResult deleteStoryReply(DeleteStoryReplyParamIn in);

}
