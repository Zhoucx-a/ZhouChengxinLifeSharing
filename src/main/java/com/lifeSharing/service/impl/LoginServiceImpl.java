package com.lifeSharing.service.impl;

import com.lifeSharing.mapper.UserInformationMapper;
import com.lifeSharing.params.login.CheckTelParamIn;
import com.lifeSharing.params.login.LoginParamIn;
import com.lifeSharing.params.login.RegisterParamIn;
import com.lifeSharing.params.login.ResetParamIn;
import com.lifeSharing.pojo.UserInformation;
import com.lifeSharing.pojo.UserInformationExample;
import com.lifeSharing.service.inter.LoginService;
import com.lifeSharing.toolsUtil.MyException;
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

    /*
     *用户注册
     */
    @Override
    public MyResult registerUser(RegisterParamIn in) {
        UserInformation newUser = new UserInformation();
        BeanUtils.copyProperties(in,newUser);
        newUser.setLoginStatus("1");
        newUser.setLoginType("1");
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
    public MyResult loginInUser(LoginParamIn in) {
        MyResult myResult = new MyResult();
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
        //判断密码是否正确
        UserInformation userInformation = userInformationMapper.selectByPrimaryKey(in.getUserNo());
        String password = userInformation.getPassword();
        if(!password.equals(in.getPassword())){
            myResult.setCode(2);
            myResult.setMsg("密码不正确！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("登陆成功！");
        myResult.setObj(userInformation.getUserName());
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
}
