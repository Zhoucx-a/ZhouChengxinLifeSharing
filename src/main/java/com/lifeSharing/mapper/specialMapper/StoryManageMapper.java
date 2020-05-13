package com.lifeSharing.mapper.specialMapper;

import com.lifeSharing.params.storyManage.QueryFriendsStoryListParamIn;
import com.lifeSharing.params.storyManage.QueryFriendsStoryListParamOut;
import com.lifeSharing.params.storyManage.QueryPersonalStoryListParamIn;
import com.lifeSharing.pojo.StoryComments;

import java.util.List;
import java.util.Map;

public interface StoryManageMapper {
    //好友动态查询
    List<QueryFriendsStoryListParamOut> queryFriendsStory(QueryFriendsStoryListParamIn in);
    //个人动态条数查询
    Integer countPersonalStory(String userNo);
    //好友动态条数查询
    Integer countFriendsStory(QueryFriendsStoryListParamIn in);
    //动态评论条数查询
    Integer countStoryComments(String storyCode);
    //批量删除二级评论
    int batchDeleteReply(List<StoryComments> commentsList);
    //查询特别关心好友列表
    List<QueryFriendsStoryListParamOut> querySpecialStory(QueryFriendsStoryListParamIn in);
    //查询特别关心的动态数量
    Integer countSpecialStory(QueryFriendsStoryListParamIn in);
    //动态模糊查询
    List<QueryFriendsStoryListParamOut> queryStoryLike(QueryFriendsStoryListParamIn in);
    //好友动态模糊查询数量
    Integer countStoryLike(QueryFriendsStoryListParamIn in);

}
