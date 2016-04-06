package com.flinkinfo.demo.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 上传文件控制类
 */
@Controller
public class UploadFileContorller
{
    /**
     * 上传文件页面
     *
     * @return
     */
    @RequestMapping("/uploadFileIndex")
    public String uploadFileIndex()
    {
        return "uploadfile_index";
    }


    /**
     * 上传文件
     *
     * @return
     */
    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap modelMap)
    {
        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists())
        {
            targetFile.mkdirs();
        }

        //保存
        try
        {
            file.transferTo(targetFile);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        modelMap.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);
        return "uploadFile_result";
    }
}
