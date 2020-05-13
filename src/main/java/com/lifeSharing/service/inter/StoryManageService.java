package com.lifeSharing.service.inter;

import com.lifeSharing.params.storyManage.*;
import com.lifeSharing.pojo.StoryComments;
import com.lifeSharing.pojo.StoryInformation;
import com.lifeSharing.pojo.StoryReply;
import com.lifeSharing.pojo.UserInformation;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;

import java.util.List;

public interface StoryManageService {
    //好友动态列表查询
    public PageOut<QueryFriendsStoryListParamOut> queryFriendsStoryList(QueryFriendsStoryListParamIn in);

    //个人动态列表查询
    public PageOut<StoryInformation> queryPersonalStoryList(QueryPersonalStoryListParamIn in);

    //删除动态
    public MyResult deleteStory(DeleteStoryParamIn in);

    //发布动态
    public MyResult publishStory(PublishStoryParamIn in);

    //修改动态
    public MyResult updateStory(UpdateStoryParamIn in);

    //查询一级评论
    public List<StoryComments> queryStoryComments(QueryStoryCommentsParamIn in);

    //根据评论编码查询二级评论
    public List<StoryReply> queryStoryReply(QueryStoryReplyParamIn in);

    //发表一级评论
    public MyResult publishStoryComments(PublishStoryCommentsParamIn in);

    //发表二级评论(回复一级评论)
    public MyResult publishStoryReplyOne(PublishStoryReplyOneParamIn in);

    //发表二级评论（回复二级评论）
    public MyResult publishStoryReplyTwo(PublishStoryReplyTwoParamIn in);

    //删除一级评论
    public MyResult deleteStoryComments(DeleteStoryCommentsParamIn in);

    //删除二级评论
    public MyResult deleteStoryReply(DeleteStoryReplyParamIn in);

    //查询特别关注
    public PageOut<QueryFriendsStoryListParamOut> querySpecialStory(QueryFriendsStoryListParamIn in);

    //动态模糊查询
    public PageOut<QueryFriendsStoryListParamOut> queryStoryLike(QueryFriendsStoryListParamIn in);

    //查询用户头像
    public UserInformation queryMyPhotoUrl(String userNo);


    //拆分图片URL
    public List<String> getPhotoUrlList(String photoUrl);

    //查询动态评论数量
    public long countStoryComments(String userNo);

    //查询用户姓名
    public String queryUserName(String userNo);
}
