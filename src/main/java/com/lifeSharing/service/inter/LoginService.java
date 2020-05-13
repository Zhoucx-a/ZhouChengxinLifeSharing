package com.lifeSharing.service.inter;

import com.lifeSharing.params.login.*;
import com.lifeSharing.toolsUtil.MyResult;


public interface LoginService {
    //用户注册
    public MyResult registerUser(RegisterParamIn in);
    //用户登录
    public LoginInParamOut loginInUser(LoginParamIn in);
    //忘记密码
    public MyResult resetPassword(ResetParamIn in);
    //电话校验
    public MyResult checkTel(CheckTelParamIn in);
    //用户ID校验
    public MyResult checkUserNO(CheckUserNoParamIn in);
    //锁定用户
    public MyResult lockedUserNo(LockedUserNoParamIn in);
}
