package com.lifeSharing.controller.impl;

import com.lifeSharing.controller.inter.AdministratorStroyManageController;
import com.lifeSharing.params.administratorStoryManage.*;
import com.lifeSharing.pojo.StoryInformation;
import com.lifeSharing.service.LikeService;
import com.lifeSharing.service.inter.AdministratorStroyManageService;
import com.lifeSharing.service.inter.StoryManageService;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/administratorStoryManage")
public class AdministratorStoryManageControllerImpl implements AdministratorStroyManageController {
    @Resource
    private AdministratorStroyManageService administratorStroyManageService;

    @Resource
    private StoryManageService storyManageService;

    @Override
    @PostMapping("/queryStroyList")
    @ResponseBody
    public PageOut<QueryStoryListParamOut> queryStroyList(@RequestBody QueryStoryListParamIn in) {

        PageOut<StoryInformation> out = administratorStroyManageService.queryStoryList(in);

        List<QueryStoryListParamOut> datalist = new ArrayList<>();
        for(StoryInformation storyInformation : out.getOut()){
            QueryStoryListParamOut queryStoryListParamOut = new QueryStoryListParamOut();
            BeanUtils.copyProperties(storyInformation,queryStoryListParamOut);
            datalist.add(queryStoryListParamOut);
        }

        PageOut<QueryStoryListParamOut> pageOut = new PageOut<QueryStoryListParamOut>();
        pageOut.setTotalPage(out.getTotalPage());
        pageOut.setTotalRecord(out.getTotalRecord());
        pageOut.setOut(datalist);
        return pageOut;
    }

    @Override
    @PostMapping("/queryStoryDetail")
    @ResponseBody
    public QueryStoryDetailParamOut queryStoryDetail(@RequestBody QueryStoryDetailParamIn in) {
        StoryInformation information = administratorStroyManageService.queryStoryDetail(in);
        QueryStoryDetailParamOut out = new QueryStoryDetailParamOut();
        BeanUtils.copyProperties(information,out);
        if(information.getPhotoUrl() != null && information.getPhotoUrl().length() > 0) {
            out.setPhotoUrlList(storyManageService.getPhotoUrlList(information.getPhotoUrl()));
        }
        return out;
    }

    @Override
    @PostMapping("/deleteStory")
    @ResponseBody
    public MyResult deleteStory(@RequestBody DeleteStoryParamIn in) {
        return administratorStroyManageService.deleteStory(in);
    }

    @Override
    @PostMapping("/queryIsCheckList")
    @ResponseBody
    public PageOut<QueryStoryListParamOut> queryIsCheckList(@RequestBody QueryIsCheckListParamIn in) {
        PageOut<StoryInformation> out = administratorStroyManageService.queryIsCheckList(in);

        List<QueryStoryListParamOut> datalist = new ArrayList<>();
        for(StoryInformation storyInformation : out.getOut()){
            QueryStoryListParamOut queryStoryListParamOut = new QueryStoryListParamOut();
            BeanUtils.copyProperties(storyInformation,queryStoryListParamOut);
            datalist.add(queryStoryListParamOut);
        }

        PageOut<QueryStoryListParamOut> pageOut = new PageOut<QueryStoryListParamOut>();
        pageOut.setTotalPage(out.getTotalPage());
        pageOut.setTotalRecord(out.getTotalRecord());
        pageOut.setOut(datalist);
        return pageOut;
    }

    @Override
    @PostMapping("/queryCount")
    @ResponseBody
    public QueryCountParamOut queryCount() {
        return administratorStroyManageService.queryCount();
    }

    @Override
    @PostMapping("/updateIsCheck")
    @ResponseBody
    public MyResult updateIsCheck(@RequestBody UpdateIsCheckParamIn in) {
        return administratorStroyManageService.updateIsCheck(in);
    }


}
