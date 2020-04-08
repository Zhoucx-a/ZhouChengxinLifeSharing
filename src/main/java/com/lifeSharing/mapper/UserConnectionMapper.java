package com.lifeSharing.mapper;

import com.lifeSharing.pojo.UserConnection;
import com.lifeSharing.pojo.UserConnectionExample;
import com.lifeSharing.pojo.UserConnectionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserConnectionMapper {
    int countByExample(UserConnectionExample example);

    int deleteByExample(UserConnectionExample example);

    int deleteByPrimaryKey(UserConnectionKey key);

    int insert(UserConnection record);

    int insertSelective(UserConnection record);

    List<UserConnection> selectByExample(UserConnectionExample example);

    UserConnection selectByPrimaryKey(UserConnectionKey key);

    int updateByExampleSelective(@Param("record") UserConnection record, @Param("example") UserConnectionExample example);

    int updateByExample(@Param("record") UserConnection record, @Param("example") UserConnectionExample example);

    int updateByPrimaryKeySelective(UserConnection record);

    int updateByPrimaryKey(UserConnection record);
}