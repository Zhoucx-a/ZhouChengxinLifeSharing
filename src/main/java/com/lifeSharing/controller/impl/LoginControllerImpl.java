package com.lifeSharing.controller.impl;

import com.lifeSharing.controller.inter.LoginController;
import com.lifeSharing.params.login.LoginParamIn;
import com.lifeSharing.params.login.RegisterParamIn;
import com.lifeSharing.params.login.ResetParamIn;
import com.lifeSharing.service.inter.LoginService;
import com.lifeSharing.toolsUtil.MyResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
    public MyResult loginInUser(@RequestBody LoginParamIn in) {
        return loginService.loginInUser(in);
    }

    /*
     *  密码重置
     */

    @Override
    @PostMapping("/resetPassword")
    @ResponseBody
    public MyResult resetParamIn(@RequestBody ResetParamIn in) {
        return loginService.resetPassword(in);
    }
}
