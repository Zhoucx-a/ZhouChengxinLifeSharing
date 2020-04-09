package com.lifeSharing.controller.impl;

import com.lifeSharing.controller.inter.LoginController;
import com.lifeSharing.params.login.CheckTelParamIn;
import com.lifeSharing.params.login.LoginParamIn;
import com.lifeSharing.params.login.RegisterParamIn;
import com.lifeSharing.params.login.ResetParamIn;
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

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

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
    public MyResult loginInUser(@RequestBody LoginParamIn in, HttpSession session) {
        MyResult myResult = loginService.loginInUser(in);
        //用户id以及用户姓名存储到session中
        if(myResult.getCode() == 0){
            session.setAttribute("userNo",in.getUserNo());
            session.setAttribute("userName",myResult.getObj());
        }
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
}
