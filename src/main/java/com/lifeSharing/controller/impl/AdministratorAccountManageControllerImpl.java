package com.lifeSharing.controller.impl;

import com.lifeSharing.controller.inter.AdministratorAccountManageController;
import com.lifeSharing.params.administratorAccountManage.*;
import com.lifeSharing.pojo.UserInformation;
import com.lifeSharing.service.inter.AdministratorAccountManageService;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/administratorAccountManage")
public class AdministratorAccountManageControllerImpl implements AdministratorAccountManageController {
    @Resource
    private AdministratorAccountManageService administratorAccountManageService;

    @Override
    @PostMapping("/queryAccountList")
    @ResponseBody
    public PageOut<QueryAccountListParamOut> queryAccountList(@RequestBody QueryAccountListParamIn in) {
        PageOut<UserInformation> pageOut = administratorAccountManageService.queryAccountList(in);
        List<QueryAccountListParamOut> list = new ArrayList<>();
        for(UserInformation userInformation : pageOut.getOut()){
            QueryAccountListParamOut queryAccountListParamOut = new QueryAccountListParamOut();
            BeanUtils.copyProperties(userInformation,queryAccountListParamOut);
            list.add(queryAccountListParamOut);
        }
        PageOut<QueryAccountListParamOut> out = new PageOut<QueryAccountListParamOut>();
        out.setOut(list);
        out.setTotalPage(pageOut.getTotalPage());
        out.setTotalRecord(pageOut.getTotalRecord());
        return out;
    }

    @Override
    @PostMapping("/isLocked")
    @ResponseBody
    public MyResult isLocked(@RequestBody IsLockedParamIn in) {
        return administratorAccountManageService.isLocked(in);
    }

    @Override
    @PostMapping("/queryAccountDetail")
    @ResponseBody
    public QueryAccountDetailParamOut queryAccountDetail(@RequestBody QueryAccountDetailParamIn in) {
        UserInformation userInformation = administratorAccountManageService.queryAccountDetail(in);
        QueryAccountDetailParamOut queryAccountDetailParamOut = new QueryAccountDetailParamOut();
        BeanUtils.copyProperties(userInformation,queryAccountDetailParamOut);
        return queryAccountDetailParamOut;
    }

    @Override
    @PostMapping("/deleteAccount")
    @ResponseBody
    public MyResult deleteAccount(@RequestBody DeleteAccountParamIn in) {
        return administratorAccountManageService.deleteAccount(in);
    }
}
