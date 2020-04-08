package com.lifeSharing.mapper;

import com.lifeSharing.pojo.UserStory;
import com.lifeSharing.pojo.UserStoryExample;
import com.lifeSharing.pojo.UserStoryKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserStoryMapper {
    int countByExample(UserStoryExample example);

    int deleteByExample(UserStoryExample example);

    int deleteByPrimaryKey(UserStoryKey key);

    int insert(UserStory record);

    int insertSelective(UserStory record);

    List<UserStory> selectByExample(UserStoryExample example);

    UserStory selectByPrimaryKey(UserStoryKey key);

    int updateByExampleSelective(@Param("record") UserStory record, @Param("example") UserStoryExample example);

    int updateByExample(@Param("record") UserStory record, @Param("example") UserStoryExample example);

    int updateByPrimaryKeySelective(UserStory record);

    int updateByPrimaryKey(UserStory record);
}