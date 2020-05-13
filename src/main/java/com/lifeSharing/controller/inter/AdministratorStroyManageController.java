package com.lifeSharing.controller.inter;

import com.lifeSharing.params.administratorStoryManage.*;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;

public interface AdministratorStroyManageController {
    //动态列表查询
    public PageOut<QueryStoryListParamOut> queryStroyList(QueryStoryListParamIn in);

    //动态详情查询
    public QueryStoryDetailParamOut queryStoryDetail(QueryStoryDetailParamIn in);

    //动态删除
    public MyResult deleteStory(DeleteStoryParamIn in);

    //查询审核|未审核动态
    public PageOut<QueryStoryListParamOut> queryIsCheckList(QueryIsCheckListParamIn in);

    //查询各个状态的数量
    public QueryCountParamOut queryCount();

    //更新审核|未审核状态
    public MyResult updateIsCheck(UpdateIsCheckParamIn in);
}
