package com.recipe.model;

import lombok.Data;

@Data
public class SmallCategoryDto {
  private int id;
  private int categoryId;
  private String name;
  private String nameJp;
}
