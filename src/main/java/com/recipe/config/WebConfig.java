package com.recipe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Value("${file.upload-dir}")
  private String uploadImagesPath;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // registry.addResourceHandler("/Users/hanwookbae/fileUpload/**")
    // .addResourceLocations("file:/Users/hanwookbae/fileUpload/");
    registry.addResourceHandler(uploadImagesPath + "**")
        .addResourceLocations("file:" + uploadImagesPath);
  }
}
