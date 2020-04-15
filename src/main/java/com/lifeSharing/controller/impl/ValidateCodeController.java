package com.lifeSharing.controller.impl;

import com.lifeSharing.toolsUtil.MyResult;
import com.lifeSharing.toolsUtil.ValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ValidateCodeController {
    // 生成验证码图片
    @PostMapping(value = "/getCaptchaImage")
    @ResponseBody
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/png");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Expire", "0");
            response.setHeader("Pragma", "no-cache");
            ValidateCode validateCode = new ValidateCode();
            // 直接返回图片
            validateCode.getRandomCodeImage(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // 生成验证码,返回的是 base64
    @PostMapping("/getCaptchaBase64")
    @ResponseBody
    public Object getCaptchaBase64(HttpServletRequest request, HttpServletResponse response) {
        Map result = new HashMap();
        MyResult myResult = new MyResult();
        try {
            response.setContentType("image/png");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Expire", "0");
            response.setHeader("Pragma", "no-cache");

            ValidateCode validateCode = new ValidateCode();
            // 返回base64
            String base64String = validateCode.getRandomCodeBase64(request, response);
            result.put("url", "data:image/png;base64," + base64String);
            result.put("message", "created successfull");
            myResult.setObj(result);
        } catch (Exception e) {
            System.out.println(e);
        }
        return myResult;
    }
}
