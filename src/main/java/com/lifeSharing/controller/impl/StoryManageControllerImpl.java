package com.lifeSharing.controller.impl;

import com.lifeSharing.controller.inter.StoryManageController;
import com.lifeSharing.params.storyManage.*;
import com.lifeSharing.pojo.StoryComments;
import com.lifeSharing.pojo.StoryInformation;
import com.lifeSharing.pojo.StoryReply;
import com.lifeSharing.service.inter.StoryManageService;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/storyManage")
public class StoryManageControllerImpl implements StoryManageController {
    @Resource
    private StoryManageService storyManageService;


    @Override
    @PostMapping("/queryFriendsStoryList")
    @ResponseBody
    public PageOut<QueryFriendsStoryListParamOut> queryFriendsStoryList(@RequestBody QueryFriendsStoryListParamIn in, HttpSession session) {
        return storyManageService.queryFriendsStoryList(in);
    }

    @Override
    @PostMapping("/queryPersonalStoryList")
    @ResponseBody
    public PageOut<QueryPersonalStoryListParamOut> queryPersonalStoryList(@RequestBody QueryPersonalStoryListParamIn in, HttpSession session) {
        PageOut<StoryInformation> data = storyManageService.queryPersonalStoryList(in);
        List<StoryInformation> list = data.getOut();
        //出参封装
        List<QueryPersonalStoryListParamOut> outList = new ArrayList<>();
        for(StoryInformation storyInformation : list){
            QueryPersonalStoryListParamOut queryPersonalStoryListParamOut = new QueryPersonalStoryListParamOut();
            queryPersonalStoryListParamOut.setCommentsCount(storyManageService.countStoryComments(storyInformation.getStoryCode()));
            queryPersonalStoryListParamOut.setUserNo(storyInformation.getUserNo());
            queryPersonalStoryListParamOut.setUserName(storyManageService.queryUserName(storyInformation.getUserNo()));
            queryPersonalStoryListParamOut.setStoryContext(storyInformation.getStoryContext());
            queryPersonalStoryListParamOut.setStoryCode(storyInformation.getStoryCode());
            queryPersonalStoryListParamOut.setPhotoUrl(storyInformation.getPhotoUrl());
            queryPersonalStoryListParamOut.setLikeCount(storyInformation.getLikeCount());
            queryPersonalStoryListParamOut.setCommentOpen(false);
            outList.add(queryPersonalStoryListParamOut);
        }
        PageOut<QueryPersonalStoryListParamOut> pageOut = new PageOut<QueryPersonalStoryListParamOut>();
        pageOut.setOut(outList);
        pageOut.setTotalRecord(data.getTotalRecord());
        pageOut.setTotalPage(data.getTotalPage());
        return pageOut;
    }

    @Override
    @PostMapping("/deleteStory")
    @ResponseBody
    public MyResult deleteStory(@RequestBody DeleteStoryParamIn in) {
        return storyManageService.deleteStory(in);
    }

    @Override
    @PostMapping("/publishStory")
    @ResponseBody
    public MyResult publishStory(@RequestBody PublishStoryParamIn in) {
        return storyManageService.publishStory(in);
    }

    @Override
    @PostMapping("/updateStory")
    @ResponseBody
    public MyResult updateStory(@RequestBody UpdateStoryParamIn in) {
        return storyManageService.updateStory(in);
    }

    @Override
    @PostMapping("/isColleciton")
    @ResponseBody
    public MyResult isColleciton(@RequestBody IsCollectionParamIn in) {
        return storyManageService.isColleciton(in);
    }

    @Override
    @PostMapping("/isLike")
    @ResponseBody
    public MyResult isLike(@RequestBody IsLikeParamIn in) {
        return storyManageService.isLike(in);
    }

    @Override
    @PostMapping("/queryStoryComments")
    @ResponseBody
    public List<QueryStoryCommentsParamOut> queryStoryComments(@RequestBody QueryStoryCommentsParamIn in) {
        List<StoryComments> storyCommentsList = storyManageService.queryStoryComments(in);
        //出参封装
        List<QueryStoryCommentsParamOut> commentsParamOuts = new ArrayList<>();
        QueryStoryCommentsParamOut queryStoryCommentsParamOut = new QueryStoryCommentsParamOut();
        QueryStoryReplyParamIn queryStoryReplyParamIn = new QueryStoryReplyParamIn();
        for(StoryComments storyComments : storyCommentsList){
            queryStoryCommentsParamOut.setCommentatorNo(storyComments.getCommentatorNo());
            queryStoryCommentsParamOut.setCommentatorName(storyComments.getCommentatorName());
            queryStoryCommentsParamOut.setCommentsCode(storyComments.getCommentsCode());
            queryStoryCommentsParamOut.setCommentsContext(storyComments.getCommentsContext());
            //封装二级评论list
            queryStoryReplyParamIn.setCommentsCode(storyComments.getCommentsCode());
            queryStoryCommentsParamOut.setReplyList(storyManageService.queryStoryReply(queryStoryReplyParamIn));
            queryStoryCommentsParamOut.setReplyOpen(false);
            commentsParamOuts.add(queryStoryCommentsParamOut);
        }
        return commentsParamOuts;
    }

    @Override
    @PostMapping("/queryStoryReply")
    @ResponseBody
    public List<QueryStoryReplyParamOut> queryStoryReply(@RequestBody QueryStoryReplyParamIn in) {
        List<StoryReply> storyReplyList = storyManageService.queryStoryReply(in);
        //出参封装
        List<QueryStoryReplyParamOut> replyParamOuts = new ArrayList<>();
        for(StoryReply storyReply : storyReplyList){
            QueryStoryReplyParamOut queryStoryReplyParamOut = new QueryStoryReplyParamOut();
            queryStoryReplyParamOut.setReplyCode(storyReply.getReplyCode());
            queryStoryReplyParamOut.setReplierName(storyReply.getReplierName());
            queryStoryReplyParamOut.setReplierNo(storyReply.getReplierNo());
            queryStoryReplyParamOut.setReplyContext(storyReply.getReplyContext());
            queryStoryReplyParamOut.setReplyToId(storyReply.getReplyToId());
            queryStoryReplyParamOut.setReplyType(storyReply.getReplyType());
            queryStoryReplyParamOut.setToId(storyReply.getToId());
            queryStoryReplyParamOut.setToName(storyReply.getToName());
            replyParamOuts.add(queryStoryReplyParamOut);
        }
        return replyParamOuts;
    }

    @Override
    @PostMapping("/publishStoryComments")
    @ResponseBody
    public MyResult publishStoryComments(@RequestBody PublishStoryCommentsParamIn in) {
        return storyManageService.publishStoryComments(in);
    }

    @Override
    @PostMapping("/publishStoryReply")
    @ResponseBody
    public MyResult publishStoryReply(@RequestBody PublishStoryReplyParamIn in) {
        return storyManageService.publishStoryReply(in);
    }

    @Override
    @PostMapping("/deleteStoryComments")
    @ResponseBody
    public MyResult deleteStoryComments(@RequestBody DeleteStoryCommentsParamIn in) {
        return storyManageService.deleteStoryComments(in);
    }

    @Override
    @PostMapping("/deleteStoryReply")
    @ResponseBody
    public MyResult deleteStoryReply(@RequestBody DeleteStoryReplyParamIn in) {
        return storyManageService.deleteStoryReply(in);
    }
}
