package com.lifeSharing.service.inter;

import com.lifeSharing.params.friendsManage.QueryUserDetailParamIn;
import com.lifeSharing.params.friendsManage.QueryUserDetailParamOut;
import com.lifeSharing.params.personalManage.UpdatePersonalInformationParamIn;
import com.lifeSharing.toolsUtil.MyResult;

public interface PersonalManageService {
    //查询个人详情
    public QueryUserDetailParamOut queryPersonalDetail(QueryUserDetailParamIn in);

    //个人资料修改
    public MyResult updatePersonalInformation(UpdatePersonalInformationParamIn in);
}
