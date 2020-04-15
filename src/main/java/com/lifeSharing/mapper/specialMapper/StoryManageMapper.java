package com.lifeSharing.mapper.specialMapper;

import com.lifeSharing.params.storyManage.QueryFriendsStoryListParamIn;
import com.lifeSharing.params.storyManage.QueryFriendsStoryListParamOut;
import com.lifeSharing.pojo.StoryComments;

import java.util.List;

public interface StoryManageMapper {
    //好友动态查询
    List<QueryFriendsStoryListParamOut> queryFriendsStory(QueryFriendsStoryListParamIn in);
    //好友动态条数查询
    long countFriendsStory(QueryFriendsStoryListParamIn in);
    //动态评论条数查询
    long countStoryComments(String storyCode);
    //批量删除二级评论
    int batchDeleteReply(List<StoryComments> commentsList);

}
