package com.recipe.model;

import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class FileDTO {

  private Long size;

  private String fileType;

  private String fileName;

  private String filePath;

  private MultipartFile file;
}
