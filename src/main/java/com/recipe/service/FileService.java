package com.recipe.service;

public interface FileService {

  public String uploadFile(String originalName, byte[] fileData) throws Exception;

  public void deleteFile(String fileUrl) throws Exception;

}
