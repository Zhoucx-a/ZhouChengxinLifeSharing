package com.lifeSharing.controller.inter;

import com.lifeSharing.params.LikeParam;
import com.lifeSharing.params.storyManage.*;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface StoryManageController {
    //好友动态查询
    public PageOut<QueryFriendsStoryList> queryFriendsStoryList(QueryFriendsStoryListParamIn in, HttpSession session);

    //个人动态查询
    public PageOut<QueryPersonalStoryListParamOut> queryPersonalStoryList(QueryPersonalStoryListParamIn in,HttpSession session);

    //删除动态
    public MyResult deleteStory(DeleteStoryParamIn in);

    //发布动态
    public MyResult publishStory(PublishStoryParamIn in);

    //修改动态
    public MyResult updateStory(UpdateStoryParamIn in);

    //查询一级评论
    public MyResult queryStoryComments(QueryStoryCommentsParamIn in);

    //查询二级评论
    public MyResult queryStoryReply(QueryStoryReplyParamIn in);

    //发表一级评论
    public MyResult publishStoryComments(PublishStoryCommentsParamIn in);

    //发表二级评论（回复一级评论）
    public MyResult publishStoryReplyOne(PublishStoryReplyOneParamIn in);

    //发表二级评论（回复二级评论）
    public MyResult publishStoryReplyTwo(PublishStoryReplyTwoParamIn in);

    //删除一级评论
    public MyResult deleteStoryComments(DeleteStoryCommentsParamIn in);

    //删除二级评论
    public MyResult deleteStoryReply(DeleteStoryReplyParamIn in);

    //点赞|取消点赞
    public MyResult like(LikeParam in);

    //查询我的赞
    public PageOut<QueryFriendsStoryList> queryMyLike(QueryFriendsStoryListParamIn in);

    //查询我的收藏
    public PageOut<QueryFriendsStoryList> queryMyCollection(QueryFriendsStoryListParamIn in);

    //查询特别关注
    public PageOut<QueryFriendsStoryList> querySpecialStory(QueryFriendsStoryListParamIn in);

    //动态模糊查询
    public PageOut<QueryFriendsStoryList> queryStoryLike(QueryFriendsStoryListParamIn in);

}
