package com.lifeSharing.controller.impl;

import com.alibaba.druid.util.StringUtils;
import com.lifeSharing.controller.inter.LoginController;
import com.lifeSharing.params.login.*;
import com.lifeSharing.service.inter.LoginService;
import com.lifeSharing.toolsUtil.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginControllerImpl implements LoginController {
    @Resource
    private LoginService loginService;

    /*
     *  用户注册
     */
    @Override
    @PostMapping("/registerUser")
    @ResponseBody
    public MyResult registerUser(@RequestBody RegisterParamIn in) {
        return loginService.registerUser(in);
    }

    /*
     *  用户登录
     */
    @Override
    @PostMapping("/loginInUser")
    @ResponseBody
    public LoginInParamOut loginInUser(@RequestBody LoginParamIn in, HttpSession session) {
        LoginInParamOut myResult = new LoginInParamOut();
        //判断验证码是否一致
        String validateCode = session.getAttribute("RANDOMKEY").toString();
        if (!StringUtils.isEmpty(validateCode)){
            if (!validateCode.equals(in.getValidateCode())) {
                myResult.setCode(3);
                myResult.setMsg("验证码不正确！");
                return myResult;
            }
            LoginInParamOut myResult1 = loginService.loginInUser(in);
            //用户id以及用户姓名存储到session中
            if(myResult1.getCode() == 0){
                session.setAttribute("userNo",myResult1.getUserNo());
                session.setAttribute("userName",myResult1.getUserName());
                session.setAttribute("loginType",myResult1.getLoginType());
            }
            return myResult1;
        }
        myResult.setCode(4);
        myResult.setMsg("输入的验证码为空！");
        return myResult;

    }

    /*
     *  密码重置
     */
    @Override
    @PostMapping("/resetPassword")
    @ResponseBody
    public MyResult resetPassword(@RequestBody ResetParamIn in) {
        return loginService.resetPassword(in);
    }

    /*
     *  电话校验
     */
    @Override
    @PostMapping("/checkTel")
    @ResponseBody
    public MyResult checkTel(@RequestBody CheckTelParamIn in) {
        return loginService.checkTel(in);
    }


    /*
     *  用户ID校验
     */
    @Override
    @PostMapping("/checkUserNo")
    @ResponseBody
    public MyResult checkUserNo(@RequestBody CheckUserNoParamIn in) {
        return loginService.checkUserNO(in);
    }
}
