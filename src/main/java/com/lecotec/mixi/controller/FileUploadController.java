package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/api/fileUpload")
@Api(tags = "文件上传接口")
public class FileUploadController {

    @Autowired
    private Environment env;

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + "/" + fileName);
        out.write(file);
        out.flush();
        out.close();
    }


    @PostMapping
    @ApiOperation("文件上传接口")
    public ResponseObject fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf('.'));
        String newFileName = fileName.substring(0, fileName.lastIndexOf('.') - 1) +
                String.valueOf(System.currentTimeMillis()) + suffix;

        String contextpath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

        uploadFile(file.getBytes(), env.getProperty("upload.dir"), newFileName);
        return new SuccessResponse(/*env.getProperty("upload.server")*/ contextpath + "/" + newFileName);
    }
}
