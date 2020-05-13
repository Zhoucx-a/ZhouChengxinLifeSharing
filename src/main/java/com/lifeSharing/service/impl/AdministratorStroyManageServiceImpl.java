package com.lifeSharing.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lifeSharing.mapper.*;
import com.lifeSharing.mapper.specialMapper.StoryManageMapper;
import com.lifeSharing.params.administratorStoryManage.*;
import com.lifeSharing.pojo.*;
import com.lifeSharing.service.inter.AdministratorStroyManageService;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AdministratorStroyManageServiceImpl implements AdministratorStroyManageService {
    @Resource
    private StoryInformationMapper storyInformationMapper;

    @Resource
    private StoryCommentsMapper storyCommentsMapper;

    @Resource
    private StoryInformationHisMapper storyInformationHisMapper;

    @Resource
    private StoryManageMapper storyManageMapper;

    @Resource
    private UserStoryMapper userStoryMapper;

    @Resource
    private UserInformationMapper userInformationMapper;

    //查询动态列表
    @Override
    public PageOut<StoryInformation> queryStoryList(QueryStoryListParamIn in) {
        //分页条件
        in.setOffset((in.getPageNum() - 1) * in.getPageSize());
        PageHelper.startPage(in.getOffset(),in.getPageSize());
        //条件拼接
        StoryInformationExample storyInformationExample = new StoryInformationExample();
        StoryInformationExample.Criteria criteria = storyInformationExample.createCriteria();
        if(in.getUserNo() != null && in.getUserNo().length() > 0){
            criteria.andUserNoLike("%"+in.getUserNo()+"%");
        }
        if(in.getStoryContext() != null && in.getStoryContext().length() > 0){
            criteria.andStoryContextLike("%"+in.getStoryContext()+"%");
        }
        List<StoryInformation> list = storyInformationMapper.selectByExample(storyInformationExample);
        //取分页信息
        PageInfo<StoryInformation> pageInfo = new PageInfo<StoryInformation>(list);
        //创建返回结果对象
        PageOut<StoryInformation> pageOut = new PageOut<StoryInformation>();
        pageOut.setOut(list);
        pageOut.setTotalRecord(pageInfo.getTotal());
        pageOut.setTotalPage(pageInfo.getPageNum());
        return pageOut;
    }

    //删除动态
    @Override
    public MyResult deleteStory(DeleteStoryParamIn in) {
        //查询该动态下的一级评论编码
        StoryCommentsExample storyCommentsExample = new StoryCommentsExample();
        storyCommentsExample.createCriteria().andStoryCodeEqualTo(in.getStoryCode());
        List<StoryComments> storyCommentsList = storyCommentsMapper.selectByExample(storyCommentsExample);

        if(!storyCommentsList.isEmpty()){
            //根据所有的一级评论删除一级评论所对应的二级评论
            storyManageMapper.batchDeleteReply(storyCommentsList);
        }
        //删除该动态的所有一级评论
        storyCommentsMapper.deleteByExample(storyCommentsExample);
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

    //查询动态详情
    @Override
    public StoryInformation queryStoryDetail(QueryStoryDetailParamIn in) {
        StoryInformationKey storyInformationKey = new StoryInformationKey();
        storyInformationKey.setUserNo(in.getUserNo());
        storyInformationKey.setStoryCode(in.getStoryCode());
        return storyInformationMapper.selectByPrimaryKey(storyInformationKey);
    }

    //审核|未审核动态列表查询
    @Override
    public PageOut<StoryInformation> queryIsCheckList(QueryIsCheckListParamIn in) {
        //分页条件
        in.setOffset((in.getPageNum() - 1) * in.getPageSize());
        PageHelper.startPage(in.getOffset(),in.getPageSize());
        //条件拼接
        StoryInformationExample storyInformationExample = new StoryInformationExample();
        storyInformationExample.createCriteria().andIsCheckEqualTo(in.getIsCheck());
        List<StoryInformation> list = storyInformationMapper.selectByExample(storyInformationExample);
        //取分页信息
        PageInfo<StoryInformation> pageInfo = new PageInfo<StoryInformation>(list);
        //创建返回结果对象
        PageOut<StoryInformation> pageOut = new PageOut<StoryInformation>();
        pageOut.setOut(list);
        pageOut.setTotalRecord(pageInfo.getTotal());
        pageOut.setTotalPage(pageInfo.getPageNum());
        return pageOut;
    }

    //动态各个状态的数量
    @Override
    public QueryCountParamOut queryCount() {
        StoryInformationExample storyInformationExample = new StoryInformationExample();
        //查询所有动态
        int allNums = storyInformationMapper.countByExample(storyInformationExample);
        //查询审核动态
        storyInformationExample.clear();
        storyInformationExample.createCriteria().andIsCheckEqualTo(1);
        int checkNums = storyInformationMapper.countByExample(storyInformationExample);
        //查询未审核动态
        storyInformationExample.clear();
        storyInformationExample.createCriteria().andIsCheckEqualTo(0);
        int isCheckNums = storyInformationMapper.countByExample(storyInformationExample);
        //动态数量封装
        QueryCountParamOut queryCountParamOut = new QueryCountParamOut();
        queryCountParamOut.setAllNums(allNums);
        queryCountParamOut.setCheckNums(checkNums);
        queryCountParamOut.setIsCheckNums(isCheckNums);
        return queryCountParamOut;
    }

    //更改审核|未审核状态
    @Override
    public MyResult updateIsCheck(UpdateIsCheckParamIn in) {
        //入正表
        StoryInformation storyInformation = new StoryInformation();
        storyInformation.setIsCheck(in.getIsCheck());

        StoryInformationExample storyInformationExample = new StoryInformationExample();
        storyInformationExample.createCriteria().andStoryCodeEqualTo(in.getStoryCode());

        int count = storyInformationMapper.updateByExampleSelective(storyInformation,storyInformationExample);
        //入历史表
        StoryInformationKey storyInformationKey = new StoryInformationKey();

        storyInformationKey.setStoryCode(in.getStoryCode());
        storyInformationKey.setUserNo(in.getUserNo());

        StoryInformation information = storyInformationMapper.selectByPrimaryKey(storyInformationKey);

        StoryInformationHis storyInformationHis = new StoryInformationHis();
        BeanUtils.copyProperties(information,storyInformationHis);
        storyInformationHis.setHisNo(UUID.randomUUID().toString());
        storyInformationHis.setOperType("U");
        storyInformationHis.setOperNo(in.getOperNo());
        storyInformationHis.setOperName(in.getOperName());
        storyInformationHis.setOperTime(new Date());

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




    //查询用户姓名
    private String queryUserName(String userNo) {
        String userName = userInformationMapper.selectByPrimaryKey(userNo).getUserName();
        return userName;
    }
}
