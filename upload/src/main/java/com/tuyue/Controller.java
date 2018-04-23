package com.tuyue;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.text.SimpleDateFormat;

import java.util.Date;


/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/13.
 */
@RestController
public class Controller {
    @Value("${upload.url}")
    private String URL;

    private String saveFile(HttpServletRequest request, MultipartFile file) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中  )
//				String filePath = request.getSession().getServletContext()
//						.getRealPath("/"+name+"/") + file.getOriginalFilename();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String name = simpleDateFormat.format(new Date()) + "/";
                String filename = file.getOriginalFilename();
                String[] split = filename.split("\\.");
                name += System.currentTimeMillis() + "." + split[split.length - 1];
                String filePath = URL + name;
                // String filePath ="F:/upload/" + file.getOriginalFilename();
                System.out.println(filePath);
                File saveDir = new File(filePath);
                if (!saveDir.getParentFile().exists()) {
                    saveDir.getParentFile().mkdirs();
                }
                // 转存文件
                file.transferTo(saveDir);
                return name;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 上传图片
     *
     * @param files
     * @param request
     * @return
     */
    @RequestMapping("/filesUpload")
    public Result filesUpload(MultipartFile[] files, HttpServletRequest request) {
        String url = "";
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                String s = saveFile(request, file);
                url += s + ",";
            }
        }
        if (url.endsWith(",")) {
            url = url.substring(0, url.length() - 1);
        }
        return Result.success(url);
    }

    @RequestMapping("delfile")
    public Result delFile(String url) {
        File file1 = new File(URL + url);
        boolean exists = file1.exists();
        if (exists) {
            boolean delete = file1.delete();
            if (delete) {
                return Result.success();
            }
            return Result.error();
        } else {
            return Result.error("文件不存在");
        }
    }
}
