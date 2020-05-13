package com.lifeSharing.service.inter;

import com.lifeSharing.params.administratorStoryManage.*;
import com.lifeSharing.pojo.StoryInformation;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;

public interface AdministratorStroyManageService {
    //动态列表查询
    public PageOut<StoryInformation> queryStoryList(QueryStoryListParamIn in);

    //动态删除
    public MyResult deleteStory(DeleteStoryParamIn in);

    //动态详情查询
    public StoryInformation queryStoryDetail(QueryStoryDetailParamIn in);

    //查询审核|未审核动态列表
    public PageOut<StoryInformation> queryIsCheckList(QueryIsCheckListParamIn in);

    //动态各个状态的数量
    public QueryCountParamOut queryCount();

    //更改审核|未审核状态
    public MyResult updateIsCheck(UpdateIsCheckParamIn in);
}
