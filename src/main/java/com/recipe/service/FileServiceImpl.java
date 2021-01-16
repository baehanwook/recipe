package com.recipe.service;

import java.io.File;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import com.recipe.common.Constants;

@Service
public class FileServiceImpl implements FileService {

  @Value("${file.upload-dir}")
  private String uploadPath;

  @Override
  public String uploadFile(String originalName, byte[] fileData) throws Exception {
    UUID uid = UUID.randomUUID();
    String savedName = uid.toString() + "_" + originalName;
    File target = new File(uploadPath, savedName);
    FileCopyUtils.copy(fileData, target);

    return "/upload" + Constants.SLASH + savedName;
  }

  @Override
  public void deleteFile(String fileUrl) throws Exception {
    String path = uploadPath + fileUrl;
    File file = new File(path);

    if (file.exists() == true) {

      file.delete();

    }
  }

}
