package com.lifeSharing.params.storyManage;

import lombok.Data;

@Data
public class QueryPersonalStoryListParamIn {
    private String userNo;

    private int pageNum;    //当前的页数

    private int pageSize;   //每页显示数量

    private int offset;     //limit第一个数据
}
