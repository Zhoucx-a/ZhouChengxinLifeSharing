package com.lifeSharing.mapper;

import com.lifeSharing.pojo.StoryComments;
import com.lifeSharing.pojo.StoryCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoryCommentsMapper {
    int countByExample(StoryCommentsExample example);

    int deleteByExample(StoryCommentsExample example);

    int deleteByPrimaryKey(String commentsCode);

    int insert(StoryComments record);

    int insertSelective(StoryComments record);

    List<StoryComments> selectByExample(StoryCommentsExample example);

    StoryComments selectByPrimaryKey(String commentsCode);

    int updateByExampleSelective(@Param("record") StoryComments record, @Param("example") StoryCommentsExample example);

    int updateByExample(@Param("record") StoryComments record, @Param("example") StoryCommentsExample example);

    int updateByPrimaryKeySelective(StoryComments record);

    int updateByPrimaryKey(StoryComments record);
}