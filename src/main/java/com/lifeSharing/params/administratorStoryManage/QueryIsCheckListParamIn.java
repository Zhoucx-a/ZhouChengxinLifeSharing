package com.lifeSharing.params.administratorStoryManage;

import lombok.Data;

@Data
public class QueryIsCheckListParamIn {
    private int isCheck;

    private int pageNum;    //当前的页数

    private int pageSize;   //每页显示数量

    private int offset;     //limit第一个数据
}
