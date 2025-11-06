package com.huailizhi.controller;

import com.huailizhi.pojo.Result;
import com.huailizhi.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    /*
    * 本地上传
    * */
//    @PostMapping("/upload")
//    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
//        log.info("接收参数：{},{},{}", name, age, file);
//        //原始名称
//        String originalFilename = file.getOriginalFilename();
//
//        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
//        String newFileName = UUID.randomUUID() + extension;
//
//        //保存文件
//        file.transferTo(new File("D:\\Java learning\\java_web_code\\web-ai-project02\\tlias-web-management\\image\\" + newFileName));
//        return Result.success();
//    }

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传：{}", file.getOriginalFilename());
        //将文件交给阿里云OSS
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("文件上传OSS，url：{}", url);

        return Result.success(url);
    }


}
