package com.lifeSharing.params.administratorStoryManage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class QueryStoryDetailParamOut {
    private String storyCode;

    private String userNo;

    private String storyContext;

    private String photoUrl;

    private List<String> photoUrlList;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date publishTime;
}
