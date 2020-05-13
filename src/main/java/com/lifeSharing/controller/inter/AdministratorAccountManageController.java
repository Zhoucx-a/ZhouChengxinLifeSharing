package com.lifeSharing.controller.inter;

import com.lifeSharing.params.administratorAccountManage.*;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;


public interface AdministratorAccountManageController {
    //账号列表查询
    public PageOut<QueryAccountListParamOut> queryAccountList(QueryAccountListParamIn in);

    //账号锁定|解锁
    public MyResult isLocked(IsLockedParamIn in);

    //账号明细
    public QueryAccountDetailParamOut queryAccountDetail(QueryAccountDetailParamIn in);

    //账号删除
    public MyResult deleteAccount(DeleteAccountParamIn in);
}
