package com.lifeSharing.mapper;

import com.lifeSharing.pojo.StoryReply;
import com.lifeSharing.pojo.StoryReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoryReplyMapper {
    int countByExample(StoryReplyExample example);

    int deleteByExample(StoryReplyExample example);

    int deleteByPrimaryKey(String replyCode);

    int insert(StoryReply record);

    int insertSelective(StoryReply record);

    List<StoryReply> selectByExample(StoryReplyExample example);

    StoryReply selectByPrimaryKey(String replyCode);

    int updateByExampleSelective(@Param("record") StoryReply record, @Param("example") StoryReplyExample example);

    int updateByExample(@Param("record") StoryReply record, @Param("example") StoryReplyExample example);

    int updateByPrimaryKeySelective(StoryReply record);

    int updateByPrimaryKey(StoryReply record);
}