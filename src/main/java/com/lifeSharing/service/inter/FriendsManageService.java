package com.lifeSharing.service.inter;

import com.lifeSharing.params.friendsManage.*;
import com.lifeSharing.pojo.UserConnection;
import com.lifeSharing.pojo.UserInformation;
import com.lifeSharing.toolsUtil.MyResult;

import java.util.List;

public interface FriendsManageService {
    //好友列表查询
    public List<UserConnection> queryFriendsList(QueryFriendsListParamIn in);

    //删除好友
    public MyResult deleteFriend(DeleteFriendParamIn in);

    //添加好友
    public MyResult addFriend(AddFriendParamIn in);

    //好友搜索
    public List<QueryFriendByNameParamOut> queryFriendByName(QueryFriendByNameParamIn in);

    //修改备注
    public MyResult updateRemark(UpdateRemarkParamIn in);

    //特别关心|取消特别关心
    public MyResult isSpecialFocus(IsSpecialFocusParamIn in);

    //好友详情资料查询
    public QueryUserDetailParamOut queryUserDetail(QueryUserDetailParamIn in);

    //粉丝列表查询
    public List<QueryFansListParamOut> queryFansList(QueryFriendsListParamIn in);

    //查询是否关注该用户
    public MyResult queryIsFocus(QueryIsFocusParamIn in);

}
