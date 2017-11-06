package com.uway.springboot.boot.controller;



import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by uwayxs on 2017/11/3.
 */
@Controller
public class FileController {
    @RequestMapping("/file")
    public String file(){
        return "uploadFile";
    }

    /**
     * 单文件上传
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file")MultipartFile file){
        String path = "d://" + file.getOriginalFilename();
        try (BufferedOutputStream out =
                     new BufferedOutputStream(
                             new FileOutputStream(
                                     new File(path)))){
            out.write(file.getBytes());
            out.flush();
            return "success!";
        }catch (Exception e){
            return "filed";
        }
    }

    /**
     * 多文件上传可以借助了MultipartHttpServletRequest和MultipartFile
     * @param request
     * @return
     */
    @RequestMapping("/batch/upload")
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request){
        List<MultipartFile> files =
                ((MultipartHttpServletRequest)request).getFiles("files");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0 ;  i < files.size() ; i++){
            file = files.get(i);
            if(!file.isEmpty()){
                try (BufferedOutputStream out =
                             new BufferedOutputStream(
                                     new FileOutputStream(
                                             new File("d://"+file.getOriginalFilename())))){
                    out.write(file.getBytes());
                    out.flush();
                }catch (Exception e){
                    return "failed";
                }
            }else {
                return "failed";
            }
        }
        return "success";
    }
}
