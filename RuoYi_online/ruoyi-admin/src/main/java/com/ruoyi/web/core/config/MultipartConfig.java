package com.ruoyi.web.core.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@Configuration
public class MultipartConfig {


    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        File tmpFile = new File("tmp");
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        factory.setLocation(tmpFile.getAbsolutePath());
        return factory.createMultipartConfig();
    }

}