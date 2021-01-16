package com.recipe.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@ConfigurationProperties(prefix = "file")
@Data
public class FileUploadProperties {
  private String uploadDir;

}
