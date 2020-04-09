package com.lifeSharing.controller.inter;

import com.lifeSharing.params.login.CheckTelParamIn;
import com.lifeSharing.params.login.LoginParamIn;
import com.lifeSharing.params.login.RegisterParamIn;
import com.lifeSharing.params.login.ResetParamIn;
import com.lifeSharing.toolsUtil.MyResult;

import javax.servlet.http.HttpSession;

public interface LoginController {

    public MyResult registerUser(RegisterParamIn in);

    public MyResult loginInUser(LoginParamIn in, HttpSession session);

    public MyResult resetPassword(ResetParamIn in);

    public MyResult checkTel(CheckTelParamIn in);
}
