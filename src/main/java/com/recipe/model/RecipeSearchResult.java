package com.recipe.model;

import lombok.Data;

@Data
public class RecipeSearchResult {
  String id;
  String categoryId;
  String categoryName;
  String smallCategoryId;
  String smallCategoryName;
  String title;
  String content;
  String imageUrl;
  String updateYear;
  String updateMonth;
  String updateDay;
}
