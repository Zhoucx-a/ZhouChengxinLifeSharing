package com.lifeSharing.service.impl;

import com.lifeSharing.mapper.StoryInformationMapper;
import com.lifeSharing.mapper.UserConnectionMapper;
import com.lifeSharing.mapper.UserInformationMapper;
import com.lifeSharing.params.friendsManage.QueryUserDetailParamIn;
import com.lifeSharing.params.friendsManage.QueryUserDetailParamOut;
import com.lifeSharing.params.personalManage.UpdatePersonalInformationParamIn;
import com.lifeSharing.pojo.*;
import com.lifeSharing.service.inter.PersonalManageService;
import com.lifeSharing.toolsUtil.MyResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersonalManageServiceImpl implements PersonalManageService {
    @Resource
    private UserConnectionMapper userConnectionMapper;

    @Resource
    private StoryInformationMapper storyInformationMapper;

    @Resource
    private UserInformationMapper userInformationMapper;

    //查询个人资料
    @Override
    public QueryUserDetailParamOut queryPersonalDetail(QueryUserDetailParamIn in) {
        UserInformation userInformation = userInformationMapper.selectByPrimaryKey(in.getUserNo());
        QueryUserDetailParamOut queryUserDetailParamOut = new QueryUserDetailParamOut();

        BeanUtils.copyProperties(userInformation,queryUserDetailParamOut);
        Map<String,Integer> map = this.countFriendSum(in.getUserNo());

        queryUserDetailParamOut.setFansSum(map.get("fansSum"));
        queryUserDetailParamOut.setFocusNoSum(map.get("focusNoSum"));
        queryUserDetailParamOut.setStorySum(map.get("storySum"));

        return queryUserDetailParamOut;
    }

    //个人资料修改
    @Override
    public MyResult updatePersonalInformation(UpdatePersonalInformationParamIn in) {
        UserInformation userInformation = new UserInformation();
        BeanUtils.copyProperties(in,userInformation);

        UserInformationExample userInformationExample = new UserInformationExample();
        userInformationExample.createCriteria().andUserNoEqualTo(in.getUserNo());

        int count = userInformationMapper.updateByExample(userInformation,userInformationExample);
        MyResult myResult = new MyResult();
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("修改失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("修改成功！");
        return myResult;
    }

    //查询好友粉丝数等
    private Map countFriendSum(String userNo){
        Map<String,Integer> map = new HashMap<String,Integer>();
        //查询关注数量
        UserConnectionExample userConnectionExample = new UserConnectionExample();
        userConnectionExample.createCriteria().andUserNoEqualTo(userNo);
        int focusNoSum = userConnectionMapper.countByExample(userConnectionExample);
        map.put("focusNoSum",focusNoSum);

        //查询粉丝数量
        userConnectionExample.clear();
        userConnectionExample.createCriteria().andFocusNoEqualTo(userNo);
        int fansSum = userConnectionMapper.countByExample(userConnectionExample);
        map.put("fansSum",fansSum);

        //查询动态数量
        StoryInformationExample storyInformationExample = new StoryInformationExample();
        storyInformationExample.createCriteria().andUserNoEqualTo(userNo);
        int storySum = storyInformationMapper.countByExample(storyInformationExample);
        map.put("storySum",storySum);

        return map;
    }
}
