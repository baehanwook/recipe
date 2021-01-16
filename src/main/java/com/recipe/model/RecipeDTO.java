package com.recipe.model;

import lombok.Data;

@Data
public class RecipeDTO {
  String id;
  String categoryId;
  String smallCategoryId;
  String title;
  String content;
  String imageUrl;
  String orgFileUrl;
  // MultipartFile file;
}
