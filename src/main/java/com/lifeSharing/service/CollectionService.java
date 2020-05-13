package com.lifeSharing.service;

import com.github.pagehelper.PageHelper;
import com.lifeSharing.mapper.StoryCommentsMapper;
import com.lifeSharing.mapper.StoryReplyMapper;
import com.lifeSharing.mapper.specialMapper.StoryManageMapper;
import com.lifeSharing.params.CollectionParam;
import com.lifeSharing.params.storyManage.QueryFriendsStoryListParamIn;
import com.lifeSharing.params.storyManage.QueryFriendsStoryListParamOut;
import com.lifeSharing.pojo.StoryComments;
import com.lifeSharing.pojo.StoryCommentsExample;
import com.lifeSharing.pojo.StoryReplyExample;
import com.lifeSharing.toolsUtil.PageOut;
import com.lifeSharing.toolsUtil.RedisKeyUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService {
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StoryManageMapper storyManageMapper;

    @Resource
    private StoryCommentsMapper storyCommentsMapper;

    @Resource
    private StoryReplyMapper storyReplyMapper;

    //收藏
    public long collection(CollectionParam in){
        String entityCollectionKey = RedisKeyUtil.getEntityLikeKey(in.getEntityType(), in.getEntityId());
        boolean isMember = redisTemplate.opsForSet().isMember(entityCollectionKey,in.getUserId());
        if(isMember){
            long s = redisTemplate.opsForSet().remove(entityCollectionKey,in.getUserId());
            return s;
        }else {
            long s = redisTemplate.opsForSet().add(entityCollectionKey,in.getUserId());
            return s;
        }
    }

    //查询某实体收藏的数量
    public long findEntityCollectionCount(CollectionParam in){
        String entityCollectionKey = RedisKeyUtil.getEntityLikeKey(in.getEntityType(),in.getEntityId());
        return redisTemplate.opsForSet().size(entityCollectionKey);
    }

    //查询某人对某实体的收藏状态
    public int findEntityCollectionStatus(CollectionParam in){
        String entityCollectionKey = RedisKeyUtil.getEntityLikeKey(in.getEntityType(), in.getEntityId());
        int i = redisTemplate.opsForSet().isMember(entityCollectionKey, in.getUserId()) ? 1 : 0;
        return i;
    }

    //查询某人收藏过的实体列表
    public PageOut<QueryFriendsStoryListParamOut> findCollectionList(CollectionParam in){
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
            //查询收藏状态
            String entityLikeKey = RedisKeyUtil.getEntityLikeKey("2", story.getStoryCode());
            int i = redisTemplate.opsForSet().isMember(entityLikeKey, in.getUserId()) ? 1 : 0;
            //筛选收藏过的动态信息
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
