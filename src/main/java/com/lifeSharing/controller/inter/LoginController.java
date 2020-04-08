package com.lifeSharing.controller.inter;

import com.lifeSharing.params.login.LoginParamIn;
import com.lifeSharing.params.login.RegisterParamIn;
import com.lifeSharing.params.login.ResetParamIn;
import com.lifeSharing.toolsUtil.MyResult;

public interface LoginController {

    public MyResult registerUser(RegisterParamIn in);

    public MyResult loginInUser(LoginParamIn in);

    public MyResult resetParamIn(ResetParamIn in);
}
