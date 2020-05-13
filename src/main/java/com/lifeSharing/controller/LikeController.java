package com.lifeSharing.controller;

import com.lifeSharing.params.LikeParam;
import com.lifeSharing.service.LikeService;
import com.lifeSharing.toolsUtil.MyResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LikeController {
    @Resource
    private LikeService likeService;

    @PostMapping("/like")
    @ResponseBody
    public MyResult like(@RequestBody LikeParam in){
        MyResult myResult = new MyResult();
        //点赞
        likeService.like(in);
        //数量
        long likeCount = likeService.findEntityLikeCount(in);
        //状态
        int likeStatus =likeService.findEntityLikeStatus(in);

        Map<String,Object> map = new HashMap<>();
        map.put("likeCount",likeCount);
        map.put("likeStatus",likeStatus);

        myResult.setObj(map);

        return myResult;
    }
}
