package com.lifeSharing.toolsUtil;

import lombok.Data;

import java.util.List;

@Data
public class MyResult {
    private int code;
    private String msg;
    private List<?> list;
    private Object obj;
}
