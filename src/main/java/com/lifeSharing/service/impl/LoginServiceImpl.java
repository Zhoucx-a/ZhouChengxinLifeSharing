package com.lifeSharing.service.impl;

import com.lifeSharing.mapper.UserConnectionMapper;
import com.lifeSharing.mapper.UserInformationMapper;
import com.lifeSharing.params.login.*;
import com.lifeSharing.pojo.UserConnection;
import com.lifeSharing.pojo.UserInformation;
import com.lifeSharing.pojo.UserInformationExample;
import com.lifeSharing.service.inter.LoginService;
import com.lifeSharing.toolsUtil.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserInformationMapper userInformationMapper;

    @Resource
    private UserConnectionMapper userConnectionMapper;
    /*
     *用户注册
     */
    @Override
    public MyResult registerUser(RegisterParamIn in) {
        UserInformation newUser = new UserInformation();
        BeanUtils.copyProperties(in,newUser);
        newUser.setLoginStatus("1");    //正常账号
        newUser.setLoginType("2");  //普通用户
        newUser.setRegisterTime(new Date());
        userInformationMapper.insert(newUser);

        MyResult myResult = new MyResult();
        myResult.setCode(0);
        myResult.setMsg("注册成功！");
        return myResult;
    }

    /*
     *用户登录
     */
    @Override
    public LoginInParamOut loginInUser(LoginParamIn in) {
        LoginInParamOut myResult = new LoginInParamOut();
        //条件拼接
        UserInformationExample userInformationExample = new UserInformationExample();
        userInformationExample.createCriteria().andUserNoEqualTo(in.getUserNo());
        int count = userInformationMapper.countByExample(userInformationExample);
        //判断用户名是否存在
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("用户不存在！");
            return myResult;
        }
        //判断该用户是否锁定
        UserInformation userInformation = userInformationMapper.selectByPrimaryKey(in.getUserNo());
        String loginStatus = userInformation.getLoginStatus();
        if("2".equals(loginStatus)){
            myResult.setCode(3);
            myResult.setMsg("该用户账号被锁定，请联系管理员进行操作！");
            return myResult;
        }

        //判断密码是否正确
        String password = userInformation.getPassword();
        if(!password.equals(in.getPassword())){
            myResult.setCode(2);
            myResult.setMsg("密码不正确！");
            return myResult;
        }
        String loginType = userInformation.getLoginType();
        //判断角色
        if("1".equals(loginType)){
            myResult.setCode(0);
            myResult.setMsg("管理员登陆成功！");
            myResult.setLoginType(userInformation.getLoginType());
            myResult.setUserNo(userInformation.getUserNo());
            myResult.setUserName(userInformation.getUserName());
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("用户登陆成功！");
        myResult.setLoginType(userInformation.getLoginType());
        myResult.setUserNo(userInformation.getUserNo());
        myResult.setUserName(userInformation.getUserName());
        return myResult;
    }

    /*
     *密码重置
     */
    @Override
    public MyResult resetPassword(ResetParamIn in) {
        MyResult myResult = new MyResult();
        //条件拼接
        UserInformationExample userInformationExample = new UserInformationExample();
        userInformationExample.createCriteria().andUserNoEqualTo(in.getUserNo());
        //重置密码
        UserInformation userInformation = new UserInformation();
        userInformation.setPassword(in.getPassword());
        int count = userInformationMapper.updateByExampleSelective(userInformation,userInformationExample);
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("重置密码失败！");
            return myResult;
        }else{
            myResult.setCode(0);
            myResult.setMsg("重置密码成功！");
            return myResult;
        }
    }

    /*
     *电话校验
     */

    @Override
    public MyResult checkTel(CheckTelParamIn in) {
        MyResult myResult = new MyResult();
        String tel =  userInformationMapper.selectByPrimaryKey(in.getUserNo()).getTel();
        //电话比较
        if(!tel.equals(in.getTel())){
            myResult.setCode(1);
            myResult.setMsg("校验未通过！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("校验通过！");
        return myResult;
    }

    /*
     *用户ID校验
     */

    @Override
    public MyResult checkUserNO(CheckUserNoParamIn in) {
        MyResult myResult = new MyResult();
        //条件拼接
        UserInformationExample userInformationExample = new UserInformationExample();
        userInformationExample.createCriteria().andUserNoEqualTo(in.getUserNo());
        //查询该用户是否存在
        long count = userInformationMapper.countByExample(userInformationExample);
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("该用户不存在！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("该用户存在！");
        return myResult;
    }

    /*
     *锁定用户
     */

    @Override
    public MyResult lockedUserNo(LockedUserNoParamIn in) {
        UserInformation userInformation = new UserInformation();
        userInformation.setLoginStatus("2");

        UserInformationExample userInformationExample = new UserInformationExample();
        userInformationExample.createCriteria().andUserNoEqualTo(in.getUserNo());

        int count = userInformationMapper.updateByExampleSelective(userInformation,userInformationExample);

        MyResult myResult = new MyResult();

        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("锁定失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("锁定成功！");
        return myResult;
    }
}
