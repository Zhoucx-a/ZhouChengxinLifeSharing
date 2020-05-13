package com.lifeSharing.params;

import lombok.Data;

@Data
public class LikeParam {
    private String userId; //点赞人ID

    private String entityType; //固定为1

    private String entityId; //动态id

    private int pageNum;    //当前的页数

    private int pageSize;   //每页显示数量

    private int offset;     //limit第一个数据
}
