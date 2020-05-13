package com.lifeSharing.service.impl;

import com.lifeSharing.mapper.UserInformationMapper;
import com.lifeSharing.params.UploadManage.MyBackPhotoParam;
import com.lifeSharing.params.UploadManage.MyPhotoParam;
import com.lifeSharing.pojo.UserInformation;
import com.lifeSharing.pojo.UserInformationExample;
import com.lifeSharing.toolsUtil.MyResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
public class UploadService {
    @Resource
    private UserInformationMapper userInformationMapper;

    public MyResult updateMyPhoto(MyPhotoParam in){

        MyResult myResult = new MyResult();

        UserInformation userInformation = new UserInformation();
        userInformation.setPhotoUrl(in.getPhotoUrl());

        UserInformationExample userInformationExample = new UserInformationExample();
        userInformationExample.createCriteria().andUserNoEqualTo(in.getUserNo());

        int count = userInformationMapper.updateByExampleSelective(userInformation,userInformationExample);


        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("更新失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("更新成功！");
        return myResult;
    }

    public MyResult updateMyBackPhoto(MyBackPhotoParam in){
        UserInformation userInformation = new UserInformation();
        userInformation.setBackPhotoUrl(in.getBackPhotoUrl());

        UserInformationExample userInformationExample = new UserInformationExample();
        userInformationExample.createCriteria().andUserNoEqualTo(in.getUserNo());

        int count = userInformationMapper.updateByExampleSelective(userInformation,userInformationExample);

        MyResult myResult = new MyResult();
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("更新失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("更新成功！");
        return myResult;
    }
}
