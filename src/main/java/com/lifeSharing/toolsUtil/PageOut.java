package com.lifeSharing.toolsUtil;

import lombok.Data;

import java.util.List;

@Data
public class PageOut<T>{
    private long totalRecord;    //总记录数

    private long totalPage;    //总页数

    private List<T> out;   //存放分页后的数据
}
