package com.lifeSharing.mapper;

import com.lifeSharing.pojo.StoryInformationHis;
import com.lifeSharing.pojo.StoryInformationHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoryInformationHisMapper {
    int countByExample(StoryInformationHisExample example);

    int deleteByExample(StoryInformationHisExample example);

    int deleteByPrimaryKey(String hisNo);

    int insert(StoryInformationHis record);

    int insertSelective(StoryInformationHis record);

    List<StoryInformationHis> selectByExample(StoryInformationHisExample example);

    StoryInformationHis selectByPrimaryKey(String hisNo);

    int updateByExampleSelective(@Param("record") StoryInformationHis record, @Param("example") StoryInformationHisExample example);

    int updateByExample(@Param("record") StoryInformationHis record, @Param("example") StoryInformationHisExample example);

    int updateByPrimaryKeySelective(StoryInformationHis record);

    int updateByPrimaryKey(StoryInformationHis record);
}