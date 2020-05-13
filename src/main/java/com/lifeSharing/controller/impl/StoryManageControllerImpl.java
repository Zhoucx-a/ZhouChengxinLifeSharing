package com.lifeSharing.controller.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lifeSharing.controller.inter.StoryManageController;
import com.lifeSharing.params.CollectionParam;
import com.lifeSharing.params.LikeParam;
import com.lifeSharing.params.storyManage.*;
import com.lifeSharing.pojo.StoryComments;
import com.lifeSharing.pojo.StoryInformation;
import com.lifeSharing.pojo.StoryReply;
import com.lifeSharing.service.CollectionService;
import com.lifeSharing.service.LikeService;
import com.lifeSharing.service.inter.StoryManageService;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;
import org.springframework.beans.BeanUtils;
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

    @Resource
    private LikeService likeService;

    @Resource
    private CollectionService collectionService;


    @Override
    @PostMapping("/queryFriendsStoryList")
    @ResponseBody
    public PageOut<QueryFriendsStoryList> queryFriendsStoryList(@RequestBody QueryFriendsStoryListParamIn in, HttpSession session) {
        PageOut<QueryFriendsStoryListParamOut> out = storyManageService.queryFriendsStoryList(in);
        List<QueryFriendsStoryListParamOut> list = out.getOut();
        List<QueryFriendsStoryList> outList = new ArrayList<>();
        //封装点赞数量以及点赞状态
        for(QueryFriendsStoryListParamOut queryFriendsStoryListParamOut : list){
            QueryFriendsStoryList newOut = new QueryFriendsStoryList();
            LikeParam likeParam = new LikeParam();
            //出参封装
            BeanUtils.copyProperties(queryFriendsStoryListParamOut,newOut);
            //封装点赞信息
            likeParam.setEntityId(queryFriendsStoryListParamOut.getStoryCode());
            likeParam.setEntityType("1");
            likeParam.setUserId(in.getUserNo());
            newOut.setLikeCount((int)likeService.findEntityLikeCount(likeParam));
            newOut.setLikeStatus(likeService.findEntityLikeStatus(likeParam));
            //封装收藏信息
            CollectionParam collectionParam = new CollectionParam();
            collectionParam.setEntityType("2");
            collectionParam.setEntityId(queryFriendsStoryListParamOut.getStoryCode());
            collectionParam.setUserId(in.getUserNo());
            newOut.setCollectionCount((int)collectionService.findEntityCollectionCount(collectionParam));
            newOut.setCollectionStatus(collectionService.findEntityCollectionStatus(collectionParam));
            //封装图片的URL
            if(queryFriendsStoryListParamOut.getPhotoUrl() != null && queryFriendsStoryListParamOut.getPhotoUrl().length() > 0){
                 newOut.setPhotoUrlList(storyManageService.getPhotoUrlList(queryFriendsStoryListParamOut.getPhotoUrl()));
            }
            //封装动态发起人的头像
            String url = storyManageService.queryMyPhotoUrl(newOut.getUserNo()).getPhotoUrl();
            if (url != null && url.length() > 0){
                newOut.setMyPhotoUrl(url);
            }
            outList.add(newOut);
        }
        PageOut<QueryFriendsStoryList> outData = new PageOut<QueryFriendsStoryList>();
        outData.setOut(outList);
        outData.setTotalPage(out.getTotalPage());
        outData.setTotalRecord(out.getTotalRecord());
        return outData;
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
            QueryPersonalStoryListParamOut out = new QueryPersonalStoryListParamOut();
            out.setCommentsCount(storyManageService.countStoryComments(storyInformation.getStoryCode()));
            out.setUserNo(storyInformation.getUserNo());
            out.setUserName(storyManageService.queryUserName(storyInformation.getUserNo()));
            out.setStoryContext(storyInformation.getStoryContext());
            out.setStoryCode(storyInformation.getStoryCode());
            out.setPublishTime(storyInformation.getPublishTime());
            out.setCommentOpen(false);
            //封装点赞信息
            LikeParam like = new LikeParam();
            like.setEntityId(storyInformation.getStoryCode());
            like.setEntityType("1");
            like.setUserId(storyInformation.getUserNo());
            out.setLikeCount((int)likeService.findEntityLikeCount(like));
            out.setLikeStatus(likeService.findEntityLikeStatus(like));
            //封装收藏信息
            CollectionParam collection = new CollectionParam();
            collection.setEntityId(storyInformation.getStoryCode());
            collection.setEntityType("2");
            collection.setUserId(in.getUserNo());
            out.setCollectionCount((int)collectionService.findEntityCollectionCount(collection));
            out.setCollectionStatus(collectionService.findEntityCollectionStatus(collection));
            //封装图片URL
            if(storyInformation.getPhotoUrl() != null && storyInformation.getPhotoUrl().length() > 0){
                out.setPhotoUrl(storyManageService.getPhotoUrlList(storyInformation.getPhotoUrl()));
            }
            //封装动态发起人的头像
            String url = storyManageService.queryMyPhotoUrl(out.getUserNo()).getPhotoUrl();
            if (url != null && url.length() > 0){
                out.setMyPhotoUrl(url);
            }
            outList.add(out);
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
    @PostMapping("/queryStoryComments")
    @ResponseBody
    public MyResult queryStoryComments(@RequestBody QueryStoryCommentsParamIn in) {
        List<StoryComments> storyCommentsList = storyManageService.queryStoryComments(in);
        //出参封装
        List<QueryStoryCommentsParamOut> commentsParamOuts = new ArrayList<>();

        for(StoryComments storyComments : storyCommentsList){
            QueryStoryCommentsParamOut queryStoryCommentsParamOut = new QueryStoryCommentsParamOut();
            QueryStoryReplyParamIn queryStoryReplyParamIn = new QueryStoryReplyParamIn();

            queryStoryCommentsParamOut.setCommentatorNo(storyComments.getCommentatorNo());
            queryStoryCommentsParamOut.setCommentatorName(storyComments.getCommentatorName());
            queryStoryCommentsParamOut.setCommentsCode(storyComments.getCommentsCode());
            queryStoryCommentsParamOut.setCommentsContext(storyComments.getCommentsContext());
            //封装一集评论人头像信息
            String url = storyManageService.queryMyPhotoUrl(queryStoryCommentsParamOut.getCommentatorNo()).getPhotoUrl();
            if (url != null && url.length() > 0){
                queryStoryCommentsParamOut.setMyPhotoUrl(url);
            }
            //封装二级评论list
            queryStoryReplyParamIn.setCommentsCode(storyComments.getCommentsCode());
            queryStoryCommentsParamOut.setReplyList((List)this.queryStoryReply(queryStoryReplyParamIn).getObj());
            queryStoryCommentsParamOut.setReplyOpen(false);
            commentsParamOuts.add(queryStoryCommentsParamOut);
        }

        MyResult myResult = new MyResult();
        myResult.setObj(commentsParamOuts);
        return myResult;
    }

    @Override
    @PostMapping("/queryStoryReply")
    @ResponseBody
    public MyResult queryStoryReply(@RequestBody QueryStoryReplyParamIn in) {
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
            queryStoryReplyParamOut.setReplyOpen(false);

            replyParamOuts.add(queryStoryReplyParamOut);
        }

        MyResult myResult = new MyResult();
        myResult.setObj(replyParamOuts);
        return myResult;
    }

    @Override
    @PostMapping("/publishStoryComments")
    @ResponseBody
    public MyResult publishStoryComments(@RequestBody PublishStoryCommentsParamIn in) {
        return storyManageService.publishStoryComments(in);
    }

    @Override
    @PostMapping("/publishStoryReplyOne")
    @ResponseBody
    public MyResult publishStoryReplyOne(@RequestBody PublishStoryReplyOneParamIn in) {
        return storyManageService.publishStoryReplyOne(in);
    }

    @Override
    @PostMapping("/publishStoryReplyTwo")
    @ResponseBody
    public MyResult publishStoryReplyTwo(@RequestBody PublishStoryReplyTwoParamIn in) {
        return storyManageService.publishStoryReplyTwo(in);
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

    @Override
    @PostMapping("/like")
    @ResponseBody
    public MyResult like(@RequestBody LikeParam in) {
        MyResult myResult = new MyResult();
        //点赞
        long a = likeService.like(in);
        if(a > 0){
            myResult.setCode(0);
            myResult.setMsg("操作成功！");
            return myResult;
        }
        myResult.setCode(1);
        myResult.setMsg("操作失败！");
        return myResult;
    }

    @Override
    @PostMapping("/queryMyLike")
    @ResponseBody
    public PageOut<QueryFriendsStoryList> queryMyLike(@RequestBody QueryFriendsStoryListParamIn in) {
        LikeParam likeParam = new LikeParam();
        likeParam.setUserId(in.getUserNo());
        likeParam.setEntityType("1");
        likeParam.setPageNum(in.getPageNum());
        likeParam.setPageSize(in.getPageSize());

        PageOut<QueryFriendsStoryListParamOut> pageOut = likeService.findLikeList(likeParam);

        List<QueryFriendsStoryListParamOut> list = pageOut.getOut();

        List<QueryFriendsStoryList> dataList = new ArrayList<>();
        for(QueryFriendsStoryListParamOut story : list){
            QueryFriendsStoryList out = new QueryFriendsStoryList();
            BeanUtils.copyProperties(story,out);
            //封装点赞信息
            LikeParam like = new LikeParam();
            like.setEntityId(story.getStoryCode());
            like.setEntityType("1");
            like.setUserId(in.getUserNo());
            out.setLikeCount((int)likeService.findEntityLikeCount(like));
            out.setLikeStatus(likeService.findEntityLikeStatus(like));
            //封装收藏信息
            CollectionParam collection = new CollectionParam();
            collection.setEntityId(story.getStoryCode());
            collection.setEntityType("2");
            collection.setUserId(in.getUserNo());
            out.setCollectionCount((int)collectionService.findEntityCollectionCount(collection));
            out.setCollectionStatus(collectionService.findEntityCollectionStatus(collection));
            //封装图片的URL
            if(story.getPhotoUrl() != null && story.getPhotoUrl().length() > 0){
                out.setPhotoUrlList(storyManageService.getPhotoUrlList(story.getPhotoUrl()));
            }
            //封装动态发起人的头像
            String url = storyManageService.queryMyPhotoUrl(out.getUserNo()).getPhotoUrl();
            if (url != null && url.length() > 0){
                out.setMyPhotoUrl(url);
            }
            dataList.add(out);
        }
        PageOut<QueryFriendsStoryList> out = new PageOut<QueryFriendsStoryList>();
        out.setOut(dataList);
        out.setTotalRecord(pageOut.getTotalRecord());
        out.setTotalPage(pageOut.getTotalPage());
        return out;
    }

    @Override
    @PostMapping("/queryMyCollection")
    @ResponseBody
    public PageOut<QueryFriendsStoryList> queryMyCollection(@RequestBody QueryFriendsStoryListParamIn in) {
        CollectionParam collectionParam = new CollectionParam();
        collectionParam.setEntityType("2");
        collectionParam.setUserId(in.getUserNo());
        collectionParam.setPageNum(in.getPageNum());
        collectionParam.setPageSize(in.getPageSize());

        PageOut<QueryFriendsStoryListParamOut> pageOut = collectionService.findCollectionList(collectionParam);

        List<QueryFriendsStoryListParamOut> list = pageOut.getOut();

        List<QueryFriendsStoryList> dataList = new ArrayList<>();
        for(QueryFriendsStoryListParamOut story : list){
            QueryFriendsStoryList out = new QueryFriendsStoryList();

            BeanUtils.copyProperties(story,out);
            //封装点赞信息
            LikeParam like = new LikeParam();
            like.setEntityId(story.getStoryCode());
            like.setEntityType("1");
            like.setUserId(in.getUserNo());
            out.setLikeCount((int)likeService.findEntityLikeCount(like));
            out.setLikeStatus(likeService.findEntityLikeStatus(like));
            //封装收藏信息
            CollectionParam collection = new CollectionParam();
            collection.setEntityId(story.getStoryCode());
            collection.setEntityType("2");
            collection.setUserId(in.getUserNo());
            out.setCollectionCount((int)collectionService.findEntityCollectionCount(collection));
            out.setCollectionStatus(collectionService.findEntityCollectionStatus(collection));
            //封装图片的URL
            if(story.getPhotoUrl() != null && story.getPhotoUrl().length() > 0){
                out.setPhotoUrlList(storyManageService.getPhotoUrlList(story.getPhotoUrl()));
            }
            //封装动态发起人的头像
            String url = storyManageService.queryMyPhotoUrl(out.getUserNo()).getPhotoUrl();
            if (url != null && url.length() > 0){
                out.setMyPhotoUrl(url);
            }
            dataList.add(out);
        }

        PageOut<QueryFriendsStoryList> out = new PageOut<QueryFriendsStoryList>();
        out.setOut(dataList);
        out.setTotalRecord(pageOut.getTotalRecord());
        out.setTotalPage(pageOut.getTotalRecord());
        return out;
    }

    @Override
    @PostMapping("/querySpecialStory")
    @ResponseBody
    public PageOut<QueryFriendsStoryList> querySpecialStory(@RequestBody QueryFriendsStoryListParamIn in) {
        PageOut<QueryFriendsStoryListParamOut> out = storyManageService.querySpecialStory(in);
        List<QueryFriendsStoryListParamOut> list = out.getOut();
        List<QueryFriendsStoryList> outList = new ArrayList<>();
        //封装点赞数量以及点赞状态
        for(QueryFriendsStoryListParamOut queryFriendsStoryListParamOut : list){
            QueryFriendsStoryList newOut = new QueryFriendsStoryList();
            LikeParam likeParam = new LikeParam();
            //出参封装
            BeanUtils.copyProperties(queryFriendsStoryListParamOut,newOut);
            //封装点赞信息
            likeParam.setEntityId(queryFriendsStoryListParamOut.getStoryCode());
            likeParam.setEntityType("1");
            likeParam.setUserId(in.getUserNo());
            newOut.setLikeCount((int)likeService.findEntityLikeCount(likeParam));
            newOut.setLikeStatus(likeService.findEntityLikeStatus(likeParam));
            //封装收藏信息
            CollectionParam collectionParam = new CollectionParam();
            collectionParam.setEntityType("2");
            collectionParam.setEntityId(queryFriendsStoryListParamOut.getStoryCode());
            collectionParam.setUserId(in.getUserNo());
            newOut.setCollectionCount((int)collectionService.findEntityCollectionCount(collectionParam));
            newOut.setCollectionStatus(collectionService.findEntityCollectionStatus(collectionParam));
            //封装图片的URL
            if(queryFriendsStoryListParamOut.getPhotoUrl() != null && queryFriendsStoryListParamOut.getPhotoUrl().length() > 0){
                newOut.setPhotoUrlList(storyManageService.getPhotoUrlList(queryFriendsStoryListParamOut.getPhotoUrl()));
            }
            //封装动态发起人的头像
            String url = storyManageService.queryMyPhotoUrl(newOut.getUserNo()).getPhotoUrl();
            if (url != null && url.length() > 0){
                newOut.setMyPhotoUrl(url);
            }
            outList.add(newOut);
        }
        PageOut<QueryFriendsStoryList> outData = new PageOut<QueryFriendsStoryList>();
        outData.setOut(outList);
        outData.setTotalPage(out.getTotalPage());
        outData.setTotalRecord(out.getTotalRecord());
        return outData;
    }

    @Override
    @PostMapping("/queryStoryLike")
    @ResponseBody
    public PageOut<QueryFriendsStoryList> queryStoryLike(@RequestBody QueryFriendsStoryListParamIn in) {
        PageOut<QueryFriendsStoryListParamOut> out = storyManageService.queryStoryLike(in);
        List<QueryFriendsStoryListParamOut> list = out.getOut();
        List<QueryFriendsStoryList> outList = new ArrayList<>();
        //封装点赞数量以及点赞状态
        for(QueryFriendsStoryListParamOut queryFriendsStoryListParamOut : list){
            QueryFriendsStoryList newOut = new QueryFriendsStoryList();
            LikeParam likeParam = new LikeParam();
            //出参封装
            BeanUtils.copyProperties(queryFriendsStoryListParamOut,newOut);
            //封装点赞信息
            likeParam.setEntityId(queryFriendsStoryListParamOut.getStoryCode());
            likeParam.setEntityType("1");
            likeParam.setUserId(in.getUserNo());
            newOut.setLikeCount((int)likeService.findEntityLikeCount(likeParam));
            newOut.setLikeStatus(likeService.findEntityLikeStatus(likeParam));
            //封装收藏信息
            CollectionParam collectionParam = new CollectionParam();
            collectionParam.setEntityType("2");
            collectionParam.setEntityId(queryFriendsStoryListParamOut.getStoryCode());
            collectionParam.setUserId(in.getUserNo());
            newOut.setCollectionCount((int)collectionService.findEntityCollectionCount(collectionParam));
            newOut.setCollectionStatus(collectionService.findEntityCollectionStatus(collectionParam));
            //封装图片的URL
            if(queryFriendsStoryListParamOut.getPhotoUrl() != null && queryFriendsStoryListParamOut.getPhotoUrl().length() > 0){
                newOut.setPhotoUrlList(storyManageService.getPhotoUrlList(queryFriendsStoryListParamOut.getPhotoUrl()));
            }
            String url = storyManageService.queryMyPhotoUrl(newOut.getUserNo()).getPhotoUrl();
            if (url != null && url.length() > 0){
                newOut.setMyPhotoUrl(url);
            }
            outList.add(newOut);
        }
        PageOut<QueryFriendsStoryList> outData = new PageOut<QueryFriendsStoryList>();
        outData.setOut(outList);
        outData.setTotalPage(out.getTotalPage());
        outData.setTotalRecord(out.getTotalRecord());
        return outData;
    }
}
