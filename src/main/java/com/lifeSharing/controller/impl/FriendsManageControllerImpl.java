package com.lifeSharing.controller.impl;

import com.lifeSharing.controller.inter.FriendsManageController;
import com.lifeSharing.params.friendsManage.*;
import com.lifeSharing.pojo.UserConnection;
import com.lifeSharing.service.inter.FriendsManageService;
import com.lifeSharing.toolsUtil.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/friendsManage")
public class FriendsManageControllerImpl implements FriendsManageController {
    @Resource
    private FriendsManageService friendsManageService;

    @Override
    @PostMapping("/queryFriendsList")
    @ResponseBody
    public MyResult queryFriendsList(@RequestBody QueryFriendsListParamIn in) {
        List<UserConnection> userConnectionList = friendsManageService.queryFriendsList(in);

        List<QueryFriendsListParamOut> list = new ArrayList<>();
        for(UserConnection userConnection : userConnectionList){
            QueryFriendsListParamOut out = new QueryFriendsListParamOut();
            BeanUtils.copyProperties(userConnection,out);
            //封装个性签名以及头像的URL

            QueryUserDetailParamIn in1 = new QueryUserDetailParamIn();
            in1.setUserNo(in.getUserNo());
            in1.setFocusNo(out.getFocusNo());

            QueryUserDetailParamOut outData = friendsManageService.queryUserDetail(in1);
            out.setDescription(outData.getDescription());
            out.setPhotoUrl(outData.getPhotoUrl());
            list.add(out);
        }

        MyResult myResult = new MyResult();
        myResult.setObj(list);
        return myResult;
    }

    @Override
    @PostMapping("/deleteFriend")
    @ResponseBody
    public MyResult deleteFriend(@RequestBody DeleteFriendParamIn in) {
        return friendsManageService.deleteFriend(in);
    }

    @Override
    @PostMapping("/addFriend")
    @ResponseBody
    public MyResult addFriend(@RequestBody AddFriendParamIn in) {
        return friendsManageService.addFriend(in);
    }

    @Override
    @PostMapping("/queryFriendByName")
    @ResponseBody
    public MyResult queryFriendByName(@RequestBody QueryFriendByNameParamIn in) {
        List<QueryFriendByNameParamOut> list = friendsManageService.queryFriendByName(in);

        MyResult myResult = new MyResult();
        myResult.setObj(list);
        return myResult;
    }

    @Override
    @PostMapping("/updateRemark")
    @ResponseBody
    public MyResult updateRemark(@RequestBody UpdateRemarkParamIn in) {
        return friendsManageService.updateRemark(in);
    }

    @Override
    @PostMapping("/isSpecialFocus")
    @ResponseBody
    public MyResult isSpecialFocus(@RequestBody IsSpecialFocusParamIn in) {
        return friendsManageService.isSpecialFocus(in);
    }

    @Override
    @PostMapping("/queryUserDetail")
    @ResponseBody
    public QueryUserDetailParamOut queryUserDetail(@RequestBody QueryUserDetailParamIn in) {
        return friendsManageService.queryUserDetail(in);
    }

    @Override
    @PostMapping("/queryFansList")
    @ResponseBody
    public MyResult queryFansList(@RequestBody QueryFriendsListParamIn in) {
        List<QueryFansListParamOut> userConnectionList = friendsManageService.queryFansList(in);
        MyResult myResult = new MyResult();
        myResult.setObj(userConnectionList);
        return myResult;
    }

    @Override
    @PostMapping("/queryIsFocus")
    @ResponseBody
    public MyResult queryIsFocus(@RequestBody QueryIsFocusParamIn in) {
        return friendsManageService.queryIsFocus(in);
    }
}
