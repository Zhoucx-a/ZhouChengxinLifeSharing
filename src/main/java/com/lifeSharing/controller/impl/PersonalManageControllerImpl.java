package com.lifeSharing.controller.impl;

import com.lifeSharing.controller.inter.PersonalManageController;
import com.lifeSharing.params.friendsManage.QueryUserDetailParamIn;
import com.lifeSharing.params.friendsManage.QueryUserDetailParamOut;
import com.lifeSharing.params.personalManage.UpdatePersonalInformationParamIn;
import com.lifeSharing.service.inter.PersonalManageService;
import com.lifeSharing.toolsUtil.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Slf4j
@Controller
@RequestMapping("/personalManage")
public class PersonalManageControllerImpl implements PersonalManageController {
    @Resource
    private PersonalManageService personalManageService;

    @Override
    @PostMapping("/queryUserDetail")
    @ResponseBody
    public QueryUserDetailParamOut queryUserDetail(@RequestBody QueryUserDetailParamIn in) {
        return personalManageService.queryPersonalDetail(in);
    }

    @Override
    @PostMapping("/updatePersonalInformation")
    @ResponseBody
    public MyResult updatePersonalInformation(@RequestBody UpdatePersonalInformationParamIn in) {
        return personalManageService.updatePersonalInformation(in);
    }
}
