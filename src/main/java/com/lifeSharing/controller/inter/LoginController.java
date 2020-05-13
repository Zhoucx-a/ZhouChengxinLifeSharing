package com.lifeSharing.controller.inter;

import com.lifeSharing.params.login.*;
import com.lifeSharing.toolsUtil.MyResult;

import javax.servlet.http.HttpSession;

public interface LoginController {

    public MyResult registerUser(RegisterParamIn in);

    public LoginInParamOut loginInUser(LoginParamIn in, HttpSession session);

    public MyResult resetPassword(ResetParamIn in);

    public MyResult checkTel(CheckTelParamIn in);

    public MyResult checkUserNo(CheckUserNoParamIn in);

    public MyResult lockedUserNo(LockedUserNoParamIn in);
}
