package com.lifeSharing.service.impl;

import com.github.pagehelper.PageHelper;
import com.lifeSharing.mapper.*;
import com.lifeSharing.mapper.specialMapper.StoryManageMapper;
import com.lifeSharing.params.storyManage.*;
import com.lifeSharing.pojo.*;
import com.lifeSharing.service.inter.StoryManageService;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class StoryManageServiceImpl implements StoryManageService {
    @Resource
    private StoryManageMapper storyManageMapper;

    @Resource
    private StoryInformationMapper storyInformationMapper;

    @Resource
    private UserInformationMapper userInformationMapper;

    @Resource
    private StoryInformationHisMapper storyInformationHisMapper;

    @Resource
    private StoryCommentsMapper storyCommentsMapper;

    @Resource
    private StoryReplyMapper storyReplyMapper;

    @Resource
    private UserStoryMapper userStoryMapper;


    //好友动态列表查询
    @Override
    public PageOut<QueryFriendsStoryListParamOut> queryFriendsStoryList(QueryFriendsStoryListParamIn in) {
        //计算limit第一个数值
        in.setOffset((in.getPageNum() - 1) * in.getPageSize());
        //查询分页后的数据
        List<QueryFriendsStoryListParamOut> dataList = storyManageMapper.queryFriendsStory(in);
        //评论数量拼接
        List<QueryFriendsStoryListParamOut> list = new ArrayList<>();
        for(QueryFriendsStoryListParamOut storyList : dataList){
            storyList.setCommentsCount(this.countStoryComments(storyList.getStoryCode()));
            storyList.setCommentOpen(false);
            list.add(storyList);
        }
        //计算总条数
        long count = storyManageMapper.countFriendsStory(in);
        //出参封装
        PageOut<QueryFriendsStoryListParamOut> pageOut = new PageOut<>();
        pageOut.setOut(dataList);
        pageOut.setTotalPage(count/in.getPageSize());
        pageOut.setTotalRecord(count);
        return pageOut;
    }

    //个人动态列表查询
    @Override
    public PageOut<StoryInformation> queryPersonalStoryList(QueryPersonalStoryListParamIn in) {
        //分页条件拼接
        //计算limit第一个数值
        in.setOffset((in.getPageNum() - 1) * in.getPageSize());
        PageHelper.startPage(in.getOffset(),in.getPageSize());
        //条件拼接
        StoryInformationExample storyInformationExample = new StoryInformationExample();
        storyInformationExample.createCriteria().andUserNoEqualTo(in.getUserNo());
        //查询数量
        long count = storyInformationMapper.countByExample(storyInformationExample);
        //查询动态
        List<StoryInformation> dataList = storyInformationMapper.selectByExample(storyInformationExample);

        PageOut<StoryInformation> pageOut = new PageOut<StoryInformation>();
        pageOut.setOut(dataList);
        pageOut.setTotalPage(count/in.getPageSize());
        pageOut.setTotalRecord(count);
        return pageOut;
    }

    //删除动态
    @Override
    public MyResult deleteStory(DeleteStoryParamIn in) {
        //查询该动态的所有一级评论
        StoryCommentsExample storyCommentsExample = new StoryCommentsExample();
        storyCommentsExample.createCriteria().andStoryCodeEqualTo(in.getStoryCode());
        List<StoryComments> storyCommentsList = storyCommentsMapper.selectByExample(storyCommentsExample);
        //删除该动态的所有一级评论
        storyCommentsMapper.deleteByExample(storyCommentsExample);
        if(!storyCommentsList.isEmpty()){
            //根据所有的一级评论删除一级评论所对应的二级评论
            storyManageMapper.batchDeleteReply(storyCommentsList);
        }
        //删除该动态的所有收藏、点赞记录
        UserStoryExample userStoryExample = new UserStoryExample();
        userStoryExample.createCriteria().andStoryCodeEqualTo(in.getStoryCode());
        userStoryMapper.deleteByExample(userStoryExample);
        //查询删除的该条记录的基本信息（入历史表）
        StoryInformationKey storyInformationKey = new StoryInformationKey();
        storyInformationKey.setStoryCode(in.getStoryCode());
        storyInformationKey.setUserNo(in.getUserNo());
        StoryInformation storyInformation = storyInformationMapper.selectByPrimaryKey(storyInformationKey);
        //封装入历史表信息
        StoryInformationHis storyInformationHis = new StoryInformationHis();
        BeanUtils.copyProperties(storyInformation,storyInformationHis);
        storyInformationHis.setHisNo(UUID.randomUUID().toString());
        storyInformationHis.setOperNo(in.getUserNo());
        storyInformationHis.setOperName(this.queryUserName(in.getUserNo()));
        storyInformationHis.setOperTime(new Date());
        storyInformationHis.setOperType("D");
        //入历史表
        storyInformationHisMapper.insert(storyInformationHis);
        //删除该动态
        int count = storyInformationMapper.deleteByPrimaryKey(storyInformationKey);
        if(count == 0){
            MyResult myResult = new MyResult();
            myResult.setCode(1);
            myResult.setMsg("删除失败！");
            return myResult;
        }
        MyResult myResult = new MyResult();
        myResult.setCode(0);
        myResult.setMsg("删除成功！");
        return myResult;
    }

    //发布动态
    @Override
    public MyResult publishStory(PublishStoryParamIn in) {
        //入正表
        StoryInformation storyInformation = new StoryInformation();
        BeanUtils.copyProperties(in,storyInformation);
        storyInformation.setStoryCode(UUID.randomUUID().toString());
        storyInformation.setLikeCount(0);
        storyInformation.setPublishTime(new Date());

        storyInformationMapper.insert(storyInformation);

        //入历史表
        StoryInformationHis storyInformationHis = new StoryInformationHis();
        BeanUtils.copyProperties(storyInformation,storyInformationHis);
        storyInformationHis.setHisNo(UUID.randomUUID().toString());
        storyInformationHis.setOperNo(in.getUserNo());
        storyInformationHis.setOperName(this.queryUserName(in.getUserNo()));
        storyInformationHis.setOperTime(new Date());
        storyInformationHis.setOperType("I");

        int count = storyInformationHisMapper.insert(storyInformationHis);

        if(count == 0){
            MyResult myResult = new MyResult();
            myResult.setCode(1);
            myResult.setMsg("发布失败！");
            return myResult;
        }
        MyResult myResult = new MyResult();
        myResult.setCode(0);
        myResult.setMsg("发布成功！");
        return myResult;
    }

    //修改动态
    @Override
    public MyResult updateStory(UpdateStoryParamIn in) {
        //入正表
        StoryInformation storyInformation = new StoryInformation();
        storyInformation.setStoryContext(in.getStoryContext());
        storyInformation.setPhotoUrl(in.getPhotoUrl());

        StoryInformationExample storyInformationExample = new StoryInformationExample();
        storyInformationExample.createCriteria().andUserNoEqualTo(in.getUserNo()).andStoryCodeEqualTo(in.getStoryCode());

        int count = storyInformationMapper.updateByExampleSelective(storyInformation,storyInformationExample);

        //根据角色ID、动态编码查询出该条动态的所有信息
        StoryInformationKey storyInformationKey = new StoryInformationKey();
        storyInformationKey.setUserNo(in.getUserNo());
        storyInformationKey.setStoryCode(in.getStoryCode());

        StoryInformation story = storyInformationMapper.selectByPrimaryKey(storyInformationKey);

        //入历史表
        StoryInformationHis storyInformationHis = new StoryInformationHis();
        BeanUtils.copyProperties(story,storyInformationHis);
        storyInformationHis.setHisNo(UUID.randomUUID().toString());
        storyInformationHis.setOperNo(in.getUserNo());
        storyInformationHis.setOperName(this.queryUserName(in.getUserNo()));
        storyInformationHis.setOperTime(new Date());
        storyInformationHis.setOperType("U");

        storyInformationHisMapper.insert(storyInformationHis);
        MyResult myResult = new MyResult();
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("更新失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("更新成功！");
        return myResult;
    }

    //收藏|是否收藏
    @Override
    public MyResult isColleciton(IsCollectionParamIn in) {
        MyResult myResult = new MyResult();
        //查询是否存在该用户是否拥有该动态
        UserStoryExample userStoryExample = new UserStoryExample();
        userStoryExample.createCriteria().andStoryCodeEqualTo(in.getStoryCode()).andUserNoEqualTo(in.getUserNo());

        int count = userStoryMapper.countByExample(userStoryExample);
        //表中无该动态
        if(count == 0){
            UserStory userStory = new UserStory();
            BeanUtils.copyProperties(in,userStory);
            userStory.setIsCollection("Y");
            userStory.setCollectionTime(new Date());
            int count1 = userStoryMapper.insert(userStory);
            if(count1 == 0){
                myResult.setCode(1);
                myResult.setMsg("收藏失败！");
                return myResult;
            }
            myResult.setCode(0);
            myResult.setMsg("收藏成功！");
            return myResult;
        }
        //表中存在该动态
        else{
            int code =  this.checkIsLikeOrIsCollection(in.getUserNo(),in.getStoryCode());
            if(code == 0||code == 2){       //脏数据或者只点赞，进行收藏
                UserStory userStory = new UserStory();
                userStory.setIsCollection("Y");
                userStory.setCollectionTime(new Date());
                int count2 = userStoryMapper.updateByExample(userStory,userStoryExample);
                if(count2 == 0){
                    myResult.setCode(1);
                    myResult.setMsg("收藏失败！");
                    return myResult;
                }
                myResult.setCode(0);
                myResult.setMsg("收藏成功！");
                return myResult;
            }
            else{                           //点赞+收藏或者只收藏，取消收藏
                UserStory userStory = new UserStory();
                userStory.setIsCollection("");
                userStory.setCollectionTime(null);
                int count2 = userStoryMapper.updateByExample(userStory,userStoryExample);
                if(count2 == 0){
                    myResult.setCode(1);
                    myResult.setMsg("取消收藏失败！");
                    return myResult;
                }
                myResult.setCode(0);
                myResult.setMsg("取消收藏成功！");
                return myResult;
            }
        }
    }

    //查询一级评论
    @Override
    public List<StoryComments> queryStoryComments(QueryStoryCommentsParamIn in) {
        StoryCommentsExample storyCommentsExample = new StoryCommentsExample();
        storyCommentsExample.createCriteria().andStoryCodeEqualTo(in.getStoryCode());
        return storyCommentsMapper.selectByExample(storyCommentsExample);

    }

    //根据评论编码查询二级评论
    @Override
    public List<StoryReply> queryStoryReply(QueryStoryReplyParamIn in) {
        StoryReplyExample storyReplyExample = new StoryReplyExample();
        storyReplyExample.createCriteria().andCommentsCodeEqualTo(in.getCommentsCode());
        return storyReplyMapper.selectByExample(storyReplyExample);
    }

    //发表一级评论
    @Override
    public MyResult publishStoryComments(PublishStoryCommentsParamIn in) {
        StoryComments storyComments = new StoryComments();
        BeanUtils.copyProperties(in,storyComments);
        storyComments.setCommentsCode(UUID.randomUUID().toString());

        int count = storyCommentsMapper.insert(storyComments);
        MyResult myResult = new MyResult();
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("发表失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("发表成功！");
        return myResult;
    }

    //发表二级评论
    @Override
    public MyResult publishStoryReply(PublishStoryReplyParamIn in) {
        StoryReply storyReply = new StoryReply();
        BeanUtils.copyProperties(in,storyReply);
        storyReply.setReplyCode(UUID.randomUUID().toString());
        if(in.getReplyToId().equals(in.getCommentsCode())){
            storyReply.setReplyType("1");
        }
        storyReply.setReplyType("2");
        int count = storyReplyMapper.insert(storyReply);
        MyResult myResult = new MyResult();
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("发表失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("发表成功！");
        return myResult;
    }

    //删除一级评论
    @Override
    public MyResult deleteStoryComments(DeleteStoryCommentsParamIn in) {
        MyResult myResult = new MyResult();
        //将对应的二级评论删除
        StoryReplyExample storyReplyExample = new StoryReplyExample();
        storyReplyExample.createCriteria().andCommentsCodeEqualTo(in.getCommentsCode());
        storyReplyMapper.deleteByExample(storyReplyExample);
        //将对应的一级评论删除
        int count = storyCommentsMapper.deleteByPrimaryKey(in.getCommentsCode());
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("删除失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("删除成功！");
        return myResult;
    }

    //删除二级评论
    @Override
    public MyResult deleteStoryReply(DeleteStoryReplyParamIn in) {
        MyResult myResult = new MyResult();
        //将对应的二级评论删除
        int count = storyReplyMapper.deleteByPrimaryKey(in.getReplyCode());
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("删除失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("删除成功！");
        return myResult;
    }

    //点赞|是否点赞
    @Override
    public MyResult isLike(IsLikeParamIn in) {
        MyResult myResult = new MyResult();
        //查询是否存在该用户是否拥有该动态
        UserStoryExample userStoryExample = new UserStoryExample();
        userStoryExample.createCriteria().andStoryCodeEqualTo(in.getStoryCode()).andUserNoEqualTo(in.getUserNo());

        int count = userStoryMapper.countByExample(userStoryExample);
        //表中无该动态
        if(count == 0){
            UserStory userStory = new UserStory();
            BeanUtils.copyProperties(in,userStory);
            userStory.setIsLike("Y");
            userStory.setLikeTime(new Date());
            int count1 = userStoryMapper.insert(userStory);
            if(count1 == 0){
                myResult.setCode(1);
                myResult.setMsg("点赞失败！");
                return myResult;
            }
            //将该动态的点赞数量+1
            StoryInformationExample storyInformationExample = new StoryInformationExample();
            storyInformationExample.createCriteria().andStoryCodeEqualTo(in.getStoryCode());

            StoryInformation storyInformation = new StoryInformation();
            storyInformation.setLikeCount(in.getLikeCount()+1);

            storyInformationMapper.updateByExample(storyInformation,storyInformationExample);
            //入历史表
            StoryInformationKey storyInformationKey = new StoryInformationKey();
            storyInformationKey.setStoryCode(in.getStoryCode());
            storyInformationKey.setUserNo(in.getUserNo());

            StoryInformation storyInformation1 = storyInformationMapper.selectByPrimaryKey(storyInformationKey);

            StoryInformationHis storyInformationHis = new StoryInformationHis();
            BeanUtils.copyProperties(storyInformation1,storyInformationHis);
            storyInformationHis.setOperType("U");
            storyInformationHis.setOperNo(in.getUserNo());
            storyInformationHis.setOperName(userInformationMapper.selectByPrimaryKey(in.getUserNo()).getUserName());
            storyInformationHis.setOperTime(new Date());
            storyInformationHis.setHisNo(UUID.randomUUID().toString());

            storyInformationHisMapper.insert(storyInformationHis);
            myResult.setCode(0);
            myResult.setMsg("点赞成功！");
            return myResult;
        }
        //表中存在该动态
        else{
            int code =  this.checkIsLikeOrIsCollection(in.getUserNo(),in.getStoryCode());
            if(code == 0||code == 3){       //脏数据或者只收藏，进行点赞
                UserStory userStory = new UserStory();
                userStory.setIsLike("Y");
                userStory.setLikeTime(new Date());
                int count2 = userStoryMapper.updateByExample(userStory,userStoryExample);
                if(count2 == 0){
                    myResult.setCode(1);
                    myResult.setMsg("点赞失败！");
                    return myResult;
                }
                myResult.setCode(0);
                myResult.setMsg("点赞成功！");
                return myResult;
            }
            else{                           //点赞+收藏或者只收藏，取消点赞
                UserStory userStory = new UserStory();
                userStory.setIsLike("");
                userStory.setLikeTime(null);
                int count2 = userStoryMapper.updateByExample(userStory,userStoryExample);
                if(count2 == 0){
                    myResult.setCode(1);
                    myResult.setMsg("取消点赞失败！");
                    return myResult;
                }
                myResult.setCode(0);
                myResult.setMsg("取消点赞成功！");
                return myResult;
            }
        }
    }


    //查询评论数
    @Override
    public long countStoryComments(String storyCode) {
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

    //查询用户姓名
    @Override
    public String queryUserName(String userNo) {
        String userName = userInformationMapper.selectByPrimaryKey(userNo).getUserName();
        return userName;
    }

    //判断是否点赞|收藏（返回值分0、1、2、3————0代表脏数据、1代表同时点赞收藏、2代表只点赞、3代表只收藏）
    private int checkIsLikeOrIsCollection(String userNo,String storyCode){
        UserStoryKey userStoryKey = new UserStoryKey();
        userStoryKey.setStoryCode(userNo);
        userStoryKey.setUserNo(storyCode);

        UserStory userStory = userStoryMapper.selectByPrimaryKey(userStoryKey);
        String isCollection = userStory.getIsCollection();
        String isLike = userStory.getIsLike();
        if(!"Y".equals(isCollection)&&!"Y".equals(isLike)){
            return 0;
        }
        else if("Y".equals(isCollection)&&"Y".equals(isLike)){
            return 1;
        }
        else if ("Y".equals(isCollection)){
            return 2;
        }else {
            return 3;
        }
    }
}
