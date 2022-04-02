package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("fileUpload")
    public ModelAndView fileUpload(MultipartFile upload,ModelAndView mv) {
        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload";

        File file = new File(path);

        if (!file.exists()) {
            //创建多级路径
            file.mkdirs();
        }

        //获取文件名
        String filename = upload.getOriginalFilename();

        try {
            if (filename != null) {
                //不为空就上传
                upload.transferTo(new File(path,filename));

                mv.addObject("img", filename);

                mv.setViewName("/success.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mv;
    }
}
