package com.lifeSharing.service.inter;

import com.lifeSharing.params.administratorAccountManage.*;
import com.lifeSharing.pojo.UserInformation;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;

public interface AdministratorAccountManageService {
    //账号列表查询
    public PageOut<UserInformation> queryAccountList(QueryAccountListParamIn in);

    //账号锁定|解锁
    public MyResult isLocked(IsLockedParamIn in);

    //账号明细
    public UserInformation queryAccountDetail(QueryAccountDetailParamIn in);

    //账号删除
    public MyResult deleteAccount(DeleteAccountParamIn in);
}
