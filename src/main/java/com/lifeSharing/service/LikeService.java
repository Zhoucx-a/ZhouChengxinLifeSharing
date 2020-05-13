package com.lifeSharing.service;

import com.lifeSharing.mapper.StoryCommentsMapper;
import com.lifeSharing.mapper.StoryInformationMapper;
import com.lifeSharing.mapper.StoryReplyMapper;
import com.lifeSharing.mapper.specialMapper.StoryManageMapper;
import com.lifeSharing.params.LikeParam;
import com.lifeSharing.params.friendsManage.QueryFriendsListParamIn;
import com.lifeSharing.params.storyManage.QueryFriendsStoryListParamIn;
import com.lifeSharing.params.storyManage.QueryFriendsStoryListParamOut;
import com.lifeSharing.pojo.*;
import com.lifeSharing.toolsUtil.PageOut;
import com.lifeSharing.toolsUtil.RedisKeyUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class LikeService {
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StoryManageMapper storyManageMapper;

    @Resource
    private StoryCommentsMapper storyCommentsMapper;

    @Resource
    private StoryReplyMapper storyReplyMapper;

    //点赞
    public long like(LikeParam in){
        String entityLikeKey = RedisKeyUtil.getEntityLikeKey(in.getEntityType(), in.getEntityId());
        boolean isMember = redisTemplate.opsForSet().isMember(entityLikeKey,in.getUserId());
        if(isMember){
            long s = redisTemplate.opsForSet().remove(entityLikeKey,in.getUserId());
            return s;
        }else {
            long s = redisTemplate.opsForSet().add(entityLikeKey,in.getUserId());
            return s;
        }
    }

    //查询某实体点赞的数量
    public long findEntityLikeCount(LikeParam in){
        String entityLikeKey = RedisKeyUtil.getEntityLikeKey(in.getEntityType(),in.getEntityId());
        return redisTemplate.opsForSet().size(entityLikeKey);
    }

    //查询某人对某实体的点赞状态
    public int findEntityLikeStatus(LikeParam in){
        String entityLikeKey = RedisKeyUtil.getEntityLikeKey(in.getEntityType(), in.getEntityId());
        int i = redisTemplate.opsForSet().isMember(entityLikeKey, in.getUserId()) ? 1 : 0;
        return i;
    }

    //查询某人点赞过的实体列表
    public PageOut<QueryFriendsStoryListParamOut> findLikeList(LikeParam in){
        QueryFriendsStoryListParamIn queryFriendsStoryListParamIn = new QueryFriendsStoryListParamIn();
        queryFriendsStoryListParamIn.setUserNo(in.getUserId());
        queryFriendsStoryListParamIn.setPageNum(in.getPageNum());
        queryFriendsStoryListParamIn.setPageSize(in.getPageSize());
        queryFriendsStoryListParamIn.setOffset((in.getPageNum() - 1) * in.getPageSize());

        List<QueryFriendsStoryListParamOut> list = storyManageMapper.queryFriendsStory(queryFriendsStoryListParamIn);

        //评论数量拼接
        List<QueryFriendsStoryListParamOut> list1 = new ArrayList<>();
        for(QueryFriendsStoryListParamOut storyList : list){
            storyList.setCommentsCount(this.countStoryComments(storyList.getStoryCode()));
            storyList.setCommentOpen(false);
            list1.add(storyList);
        }

        List<QueryFriendsStoryListParamOut> dataList = new ArrayList<>();
        for(QueryFriendsStoryListParamOut story : list1){
            //查询点赞状态
            String entityLikeKey = RedisKeyUtil.getEntityLikeKey("1", story.getStoryCode());
            int i = redisTemplate.opsForSet().isMember(entityLikeKey, in.getUserId()) ? 1 : 0;
            //筛选点过赞的动态信息
            if(i == 1){
                dataList.add(story);
            }
        }

        //出参封装
        PageOut<QueryFriendsStoryListParamOut> pageOut = new PageOut<QueryFriendsStoryListParamOut>();
        pageOut.setOut(dataList);
        pageOut.setTotalPage(dataList.size()/in.getPageSize());
        pageOut.setTotalRecord(dataList.size());

        return pageOut;
    }




    //封装评论数量
    private long countStoryComments(String storyCode) {
        //一级评论数量
        StoryCommentsExample storyCommentsExample = new StoryCommentsExample();
        storyCommentsExample.createCriteria().andStoryCodeEqualTo(storyCode);
        long count1 = storyCommentsMapper.countByExample(storyCommentsExample);
        //二级评论数量
        long count2 = 0;
        List<StoryComments> list = storyCommentsMapper.selectByExample(storyCommentsExample);
        StoryReplyExample storyReplyExample = new StoryReplyExample();
        for(StoryComments storyComments : list){
            storyReplyExample.createCriteria().andCommentsCodeEqualTo(storyComments.getCommentsCode());
            count2 += storyReplyMapper.countByExample(storyReplyExample);
            storyReplyExample.clear();
        }
        long count = count1 + count2;
        return count;
    }
}
