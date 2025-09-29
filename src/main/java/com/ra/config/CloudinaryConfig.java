package com.ra.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    private static  final String CLOUD_NAME = "dbtbegrpq";
    private static  final String API_KEY = "765277277933472";
    private static  final String API_SECRET = "a7GtpQB_mJxphkNzF40HbB5MXK8";

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap("cloud_name",CLOUD_NAME,
                "api_key",API_KEY,
                "api_secret",API_SECRET));
    }
}
