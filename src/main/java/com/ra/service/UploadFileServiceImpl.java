package com.ra.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
@Service
public class UploadFileServiceImpl implements UploadFileService {
    @Autowired
    private Cloudinary cloudinary;

    public String uploadFile(MultipartFile file){
        if (file == null || file.isEmpty()) {
            return "";
        }
        // lay ten anh
        String fileName = file.getOriginalFilename();

        // demo.jpg
        if(fileName != null && fileName.contains(".")){
            fileName = fileName.substring(0,fileName.lastIndexOf("."));
        }
        // up anh voi ten la ten anh
        Map cloudinaryParams = ObjectUtils.asMap("public_id",fileName);
        Map cloudinaryResult = null;

        try {
            cloudinaryResult = cloudinary.uploader().upload(file.getBytes(),cloudinaryParams);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cloudinaryResult.get("url").toString();
    }
}
