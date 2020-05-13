package com.lifeSharing.controller.inter;

import com.lifeSharing.params.friendsManage.QueryUserDetailParamIn;
import com.lifeSharing.params.friendsManage.QueryUserDetailParamOut;
import com.lifeSharing.params.personalManage.UpdatePersonalInformationParamIn;
import com.lifeSharing.toolsUtil.MyResult;

public interface PersonalManageController {
    public QueryUserDetailParamOut queryUserDetail(QueryUserDetailParamIn in);

    public MyResult updatePersonalInformation(UpdatePersonalInformationParamIn in);
}
