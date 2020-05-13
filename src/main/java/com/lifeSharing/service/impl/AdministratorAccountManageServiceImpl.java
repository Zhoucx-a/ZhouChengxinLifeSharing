package com.lifeSharing.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lifeSharing.mapper.UserInformationMapper;
import com.lifeSharing.params.administratorAccountManage.DeleteAccountParamIn;
import com.lifeSharing.params.administratorAccountManage.IsLockedParamIn;
import com.lifeSharing.params.administratorAccountManage.QueryAccountDetailParamIn;
import com.lifeSharing.params.administratorAccountManage.QueryAccountListParamIn;
import com.lifeSharing.pojo.UserInformation;
import com.lifeSharing.pojo.UserInformationExample;
import com.lifeSharing.service.inter.AdministratorAccountManageService;
import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.PageOut;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AdministratorAccountManageServiceImpl implements AdministratorAccountManageService {
    @Resource
    private UserInformationMapper userInformationMapper;

    //账号列表查询
    @Override
    public PageOut<UserInformation> queryAccountList(QueryAccountListParamIn in) {
        in.setOffset((in.getPageNum() - 1) * in.getPageSize());
        PageHelper.startPage(in.getOffset(),in.getPageSize());

        UserInformationExample userInformationExample = new UserInformationExample();
        UserInformationExample.Criteria criteria = userInformationExample.createCriteria();

        if(in.getLoginStatus() != null && in.getLoginStatus().length() > 0){
            criteria.andLoginStatusEqualTo(in.getLoginStatus());
        }
        if(in.getLoginType() != null && in.getLoginType().length() > 0){
            criteria.andLoginTypeEqualTo(in.getLoginType());
        }
        if(in.getUserNo() != null && in.getUserNo().length() > 0){
            criteria.andUserNoLike("%"+in.getUserNo()+"%");
        }

        List<UserInformation> userInformationList = userInformationMapper.selectByExample(userInformationExample);
        //取分页信息
        PageInfo<UserInformation> pageInfo = new PageInfo<UserInformation>(userInformationList);
        //创建返回结果对象
        PageOut<UserInformation> pageOut = new PageOut<UserInformation>();
        pageOut.setOut(userInformationList);
        pageOut.setTotalRecord(pageInfo.getTotal());
        pageOut.setTotalPage(pageInfo. getTotal()/in.getPageSize());
        return pageOut;
    }

    //锁定|解锁
    @Override
    public MyResult isLocked(IsLockedParamIn in) {
        String loginStatus = userInformationMapper.selectByPrimaryKey(in.getUserNo()).getLoginStatus();
        UserInformationExample userInformationExample = new UserInformationExample();
        userInformationExample.createCriteria().andUserNoEqualTo(in.getUserNo());
        MyResult myResult = new MyResult();
        UserInformation userInformation = new UserInformation();
        //锁定
        if(loginStatus.equals("1")){
            userInformation.setLoginStatus("2");
            int count = userInformationMapper.updateByExampleSelective(userInformation,userInformationExample);
            if(count == 0){
                myResult.setCode(1);
                myResult.setMsg("锁定失败！");
                return myResult;
            }
            myResult.setCode(0);
            myResult.setMsg("锁定成功！");
            return myResult;
        }
        //解锁
        userInformation.setLoginStatus("1");
        int count = userInformationMapper.updateByExampleSelective(userInformation,userInformationExample);
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("解锁失败！");
            return myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("解锁成功！");
        return myResult;
    }

    //账号详情查询
    @Override
    public UserInformation queryAccountDetail(QueryAccountDetailParamIn in) {
        return userInformationMapper.selectByPrimaryKey(in.getUserNo());
    }

    //删除账号
    @Override
    public MyResult deleteAccount(DeleteAccountParamIn in) {
        int count = userInformationMapper.deleteByPrimaryKey(in.getUserNo());
        MyResult myResult = new MyResult();
        if(count == 0){
            myResult.setCode(1);
            myResult.setMsg("删除失败！");
            return  myResult;
        }
        myResult.setCode(0);
        myResult.setMsg("删除成功！");
        return  myResult;
    }
}
