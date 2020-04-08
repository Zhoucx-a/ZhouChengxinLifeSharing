package com.lifeSharing.mapper;

import com.lifeSharing.pojo.StoryInformation;
import com.lifeSharing.pojo.StoryInformationExample;
import com.lifeSharing.pojo.StoryInformationKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoryInformationMapper {
    int countByExample(StoryInformationExample example);

    int deleteByExample(StoryInformationExample example);

    int deleteByPrimaryKey(StoryInformationKey key);

    int insert(StoryInformation record);

    int insertSelective(StoryInformation record);

    List<StoryInformation> selectByExample(StoryInformationExample example);

    StoryInformation selectByPrimaryKey(StoryInformationKey key);

    int updateByExampleSelective(@Param("record") StoryInformation record, @Param("example") StoryInformationExample example);

    int updateByExample(@Param("record") StoryInformation record, @Param("example") StoryInformationExample example);

    int updateByPrimaryKeySelective(StoryInformation record);

    int updateByPrimaryKey(StoryInformation record);
}