package com.lifeSharing.toolsUtil;

import lombok.Data;

@Data
public class PageIn<T>{
    private int pageNum;    //当前的页数

    private int pageSize;   //每页显示数量

    private int offset;     //limit第一个数据

    private T in;     //查询条件
}
