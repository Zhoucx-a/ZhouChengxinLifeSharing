package com.lifeSharing.service.impl;

import com.lifeSharing.mapper.StoryInformationMapper;
import com.lifeSharing.mapper.UserConnectionMapper;
import com.lifeSharing.mapper.UserInformationMapper;
import com.lifeSharing.params.friendsManage.*;
import com.lifeSharing.pojo.*;
import com.lifeSharing.service.inter.FriendsManageService;
import com.lifeSharing.toolsUtil.MyResult;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class FriendsManageServiceImpl implements FriendsManageService {
    @Resource
    private UserInformationMapper userInformationMapper;

    @Resource
    private UserConnectionMapper userConnectionMapper;

    @Resource
    private StoryInformationMapper storyInformationMapper;

    //好友列表查询
    @Override
    public List<UserConnection> queryFriendsList(QueryFriendsListParamIn in) {
        UserConnectionExample userConnectionExample = new UserConnectionExample();
        userConnectionExample.createCriteria().andUserNoEqualTo(in.getUserNo());
        return userConnectionMapper.selectByExample(userConnectionExample);
    }

    //删除好友
    @Override
    public MyResult deleteFriend(DeleteFriendParamIn in) {
        UserConnectionKey userConnectionKey = new UserConnectionKey();
        userConnectionKey.setFocusNo(in.getFocusNo());
        userConnectionKey.setUserNo(in.getUserNo());
        int count = userConnectionMapper.deleteByPrimaryKey(userConnectionKey);
        MyResult myResult = new MyResult();
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("删除失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("删除成功！");
        return myResult;
    }

    //添加好友
    @Override
    public MyResult addFriend(AddFriendParamIn in) {
        UserConnection userConnection = new UserConnection();
        BeanUtils.copyProperties(in,userConnection);
        userConnection.setFocusTime(new Date());
        userConnection.setIsSpecialFocus("N");

        int count = userConnectionMapper.insert(userConnection);
        MyResult myResult = new MyResult();
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("添加失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("添加成功！");
        return myResult;
    }

    //搜索好友
    @Override
    public List<QueryFriendByNameParamOut> queryFriendByName(QueryFriendByNameParamIn in) {
        UserInformationExample userInformationExample = new UserInformationExample();
        userInformationExample.createCriteria().andUserNameLike("%"+in.getUserName()+"%");
        List<UserInformation> userInformationList = userInformationMapper.selectByExample(userInformationExample);

        List<QueryFriendByNameParamOut> queryFriendByNameParamOutList = new ArrayList<>();
        for(UserInformation userInformation : userInformationList){
            QueryFriendByNameParamOut queryFriendByNameParamOut = new QueryFriendByNameParamOut();
            BeanUtils.copyProperties(userInformation,queryFriendByNameParamOut);
            Map<String,Integer> map = this.countFriendSum(userInformation.getUserNo());
            queryFriendByNameParamOut.setFocusNoSum(map.get("focusNoSum"));
            queryFriendByNameParamOut.setFansSum(map.get("fansSum"));
            queryFriendByNameParamOut.setStorySum(map.get("storySum"));
            //查询当前用户是否关注
            UserConnectionExample userConnectionExample = new UserConnectionExample();
            userConnectionExample.createCriteria().andUserNoEqualTo(in.getUserNo()).andFocusNoEqualTo(userInformation.getUserNo());
            int count = userConnectionMapper.countByExample(userConnectionExample);
            if(count == 0){
                queryFriendByNameParamOut.setIsFocus(0);
            }else{
                queryFriendByNameParamOut.setIsFocus(1);
            }
            //封装头像信息
            String url = userInformationMapper.selectByPrimaryKey(userInformation.getUserNo()).getPhotoUrl();
            if(url != null && url.length() > 0){
                queryFriendByNameParamOut.setMyPhotoUrl(url);
            }

            queryFriendByNameParamOutList.add(queryFriendByNameParamOut);

        }

        return queryFriendByNameParamOutList;
    }

    //更新好友备注
    @Override
    public MyResult updateRemark(UpdateRemarkParamIn in) {
        UserConnection userConnection = new UserConnection();
        userConnection.setRemark(in.getRemark());

        UserConnectionExample userConnectionExample = new UserConnectionExample();
        userConnectionExample.createCriteria().andFocusNoEqualTo(in.getFocusNo()).andUserNoEqualTo(in.getUserNo());

        int count = userConnectionMapper.updateByExampleSelective(userConnection,userConnectionExample);
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

    //特别关注|取消特别关注
    @Override
    public MyResult isSpecialFocus(IsSpecialFocusParamIn in) {
        UserConnectionKey userConnectionKey = new UserConnectionKey();
        userConnectionKey.setFocusNo(in.getFocusNo());
        userConnectionKey.setUserNo(in.getUserNo());
        String isSpecialFocus = userConnectionMapper.selectByPrimaryKey(userConnectionKey).getIsSpecialFocus();
        //特别关注
        if(isSpecialFocus.equals("N")){
            UserConnectionExample userConnectionExample = new UserConnectionExample();
            userConnectionExample.createCriteria().andUserNoEqualTo(in.getUserNo()).andFocusNoEqualTo(in.getFocusNo());

            UserConnection userConnection = new UserConnection();
            userConnection.setIsSpecialFocus("Y");

            int count = userConnectionMapper.updateByExampleSelective(userConnection,userConnectionExample);
            MyResult myResult = new MyResult();
            if(count == 0){
                myResult.setCode(1);
                myResult.setMsg("操作失败！");
                return myResult;
            }
            myResult.setCode(0);
            myResult.setMsg("操作成功！");
            return myResult;
        }
        //取消特别关注
        UserConnectionExample userConnectionExample = new UserConnectionExample();
        userConnectionExample.createCriteria().andUserNoEqualTo(in.getUserNo()).andFocusNoEqualTo(in.getFocusNo());

        UserConnection userConnection = new UserConnection();
        userConnection.setIsSpecialFocus("N");

        int count = userConnectionMapper.updateByExample(userConnection,userConnectionExample);
        MyResult myResult = new MyResult();
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("操作失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("操作成功！");
        return myResult;
    }

    //查询好友详情
    @Override
    public QueryUserDetailParamOut queryUserDetail(QueryUserDetailParamIn in) {
        UserInformation userInformation = userInformationMapper.selectByPrimaryKey(in.getFocusNo());
        QueryUserDetailParamOut queryUserDetailParamOut = new QueryUserDetailParamOut();
        BeanUtils.copyProperties(userInformation,queryUserDetailParamOut);
        if(!in.getFocusNo().equals(in.getUserNo())){
            queryUserDetailParamOut.setRemark(this.queryFriendsRemark(in).getRemark());
        }
        Map<String,Integer> map = this.countFriendSum(in.getFocusNo());
        queryUserDetailParamOut.setFansSum(map.get("fansSum"));
        queryUserDetailParamOut.setFocusNoSum(map.get("focusNoSum"));
        queryUserDetailParamOut.setStorySum(map.get("storySum"));
        System.out.println(queryUserDetailParamOut);
        return queryUserDetailParamOut;
    }

    //查询粉丝列表
    @Override
    public List<QueryFansListParamOut> queryFansList(QueryFriendsListParamIn in) {
        UserConnectionExample userConnectionExample = new UserConnectionExample();
        userConnectionExample.createCriteria().andFocusNoEqualTo(in.getUserNo());
        List<UserConnection> list = userConnectionMapper.selectByExample(userConnectionExample);

        List<QueryFansListParamOut> outList = new ArrayList<>();
        for(UserConnection userConnection : list){
            QueryFansListParamOut out = new QueryFansListParamOut();
            UserInformation userInformation = userInformationMapper.selectByPrimaryKey(userConnection.getUserNo());
            out.setFansNo(userConnection.getUserNo());
            out.setFansName(userInformation.getUserName());
            out.setDescription(userInformation.getDescription());
            out.setPhotoUrl(userInformation.getPhotoUrl());
            //粉丝列表中封装是否对该粉丝关注|特别关注|关注后的备注
            UserConnectionKey userConnectionKey = new UserConnectionKey();
            userConnectionKey.setUserNo(in.getUserNo());
            userConnectionKey.setFocusNo(userConnection.getUserNo());

            UserConnection userConnection1 = userConnectionMapper.selectByPrimaryKey(userConnectionKey);
            if(userConnection1 != null){
                out.setIsFocus(1);
                out.setIsSpecialFocus(userConnection1.getIsSpecialFocus());
                out.setRemark(userConnection1.getRemark());
            }else{
                out.setIsFocus(0);
                out.setIsSpecialFocus(null);
                out.setRemark(null);
            }
            outList.add(out);
        }
        return outList;
    }

    //查询是否关注该用户
    @Override
    public MyResult queryIsFocus(QueryIsFocusParamIn in) {
        UserConnectionExample userConnectionExample = new UserConnectionExample();
        userConnectionExample.createCriteria().andUserNoEqualTo(in.getUserNo()).andFocusNoEqualTo(in.getFocusNo());

        int count = userConnectionMapper.countByExample(userConnectionExample);

        MyResult myResult = new MyResult();
        if(count > 0){
            myResult.setCode(1);
            myResult.setMsg("已关注该用户！");
            return myResult;
        }else{
            myResult.setCode(0);
            myResult.setMsg("未关注该用户！");
            return myResult;
        }
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

    //查询好友备注
    private UserConnection queryFriendsRemark(QueryUserDetailParamIn in){
        UserConnectionKey userConnectionKey = new UserConnectionKey();
        userConnectionKey.setUserNo(in.getUserNo());
        userConnectionKey.setFocusNo(in.getFocusNo());
        return userConnectionMapper.selectByPrimaryKey(userConnectionKey);
    }


}
