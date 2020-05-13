package com.lifeSharing.params.administratorStoryManage;

import lombok.Data;

@Data
public class QueryStoryListParamIn {
    private String userNo;

    private String storyContext;

    private Integer isCheck;

    private int pageNum;    //当前的页数

    private int pageSize;   //每页显示数量

    private int offset;     //limit第一个数据
}
