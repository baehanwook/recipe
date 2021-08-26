package com.recipe.service;

import java.util.List;
import com.recipe.model.CategoryDto;

public interface CategoryService {

  /**
   * カテゴリー一覧取得
   * 
   * @return
   * @throws Exception
   */
  public List<CategoryDto> getCategoryList() throws Exception;

  /**
   * カテゴリー取得
   * 
   * @return
   * @throws Exception
   */
  public CategoryDto getCategory(String id) throws Exception;

  /**
   * カテゴリー更新
   * 
   * @param categoryDto
   * @throws Exception
   */
  public void updateCategory(CategoryDto categoryDto) throws Exception;
}
