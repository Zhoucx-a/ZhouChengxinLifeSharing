package com.lifeSharing.params.administratorAccountManage;

import lombok.Data;

@Data
public class QueryAccountListParamIn {
    private String loginType;   //登录类型（管理员|普通用户）

    private String loginStatus;     //登录状态（正常|锁定）

    private String userNo;      //用户ID

    private Integer pageNum;    //当前的页数

    private Integer pageSize;   //每页显示数量

    private Integer offset;     //limit第一个数据
}
