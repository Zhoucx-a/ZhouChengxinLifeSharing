package com.lifeSharing.service.inter;

import com.lifeSharing.params.login.CheckTelParamIn;
import com.lifeSharing.params.login.LoginParamIn;
import com.lifeSharing.params.login.RegisterParamIn;
import com.lifeSharing.params.login.ResetParamIn;
import com.lifeSharing.toolsUtil.MyResult;

public interface LoginService {
    public MyResult registerUser(RegisterParamIn in);

    public MyResult loginInUser(LoginParamIn in);

    public MyResult resetPassword(ResetParamIn in);

    public MyResult checkTel(CheckTelParamIn in);
}
