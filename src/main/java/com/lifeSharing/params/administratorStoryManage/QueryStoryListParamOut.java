package com.lifeSharing.params.administratorStoryManage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class QueryStoryListParamOut {
    private String storyCode;

    private String userNo;

    private String storyContext;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date publishTime;

    private Integer isCheck;
}
