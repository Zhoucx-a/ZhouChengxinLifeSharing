package com.lifeSharing.controller;

import com.lifeSharing.params.CollectionParam;
import com.lifeSharing.params.LikeParam;
import com.lifeSharing.service.CollectionService;
import com.lifeSharing.toolsUtil.MyResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CollectionController {
    @Resource
    private CollectionService collectionService;

    @PostMapping("/collection")
    @ResponseBody
    public MyResult collection(@RequestBody CollectionParam in){
        MyResult myResult = new MyResult();
        //点赞
        collectionService.collection(in);
        //数量
        long collectionCount = collectionService.findEntityCollectionCount(in);
        //状态
        int collectionStatus =collectionService.findEntityCollectionStatus(in);

        Map<String,Object> map = new HashMap<>();
        map.put("collectionCount",collectionCount);
        map.put("collectionStatus",collectionStatus);

        myResult.setObj(map);

        return myResult;
    }
}
