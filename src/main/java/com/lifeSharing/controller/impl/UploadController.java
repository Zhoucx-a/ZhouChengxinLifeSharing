package com.lifeSharing.controller.impl;

import com.lifeSharing.toolsUtil.MyResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class UploadController {
    //单文件上传
    @PostMapping("/upFile")
    @ResponseBody
    public MyResult upFile(MultipartFile file, HttpServletRequest request) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date());

        // uploads文件夹位置
        String rootPath = request.getSession().getServletContext().getRealPath("resource/uploads/");
        // 原始名称
        String originalFileName = file.getOriginalFilename();
        // 新文件名(sliver+当前时间)
        String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
        // 创建年月文件夹
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH)+1));
        // 新文件
        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
        // 判断目标文件所在目录是否存在
        if( !newFile.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        // 将内存中的数据写入磁盘
        file.transferTo(newFile);
        // 完整的url
        String fileUrl = rootPath + "/" + date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH)+1) + "/" + newFileName;
        //返回url
        MyResult myResult = new MyResult();
        myResult.setObj(fileUrl);
        return myResult;
    }

    //文件删除
    @PostMapping("/deleteFile")
    @ResponseBody
    public MyResult deleteFile(@RequestBody Map map){
        MyResult myResult = new MyResult();
        String s = map.get("FilePath").toString();
        File file = new File(s);
        if(file.exists()){
            boolean b = file.delete();
            if(b){
                myResult.setCode(0);
                myResult.setMsg("删除成功！");
                return myResult;
            }
            myResult.setCode(1);
            myResult.setMsg("删除失败！");
            return myResult;
        }else{
            myResult.setCode(2);
            myResult.setMsg("文件不存在！");
            return myResult;
        }
    }
}
