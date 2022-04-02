package com.recipe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recipe.model.CategoryDto;
import com.recipe.service.mapper.CategoryMapper;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryMapper categoryMapper;

  @Override
  public List<CategoryDto> getCategoryList() throws Exception {
    return categoryMapper.getCategoryList();
  }

  @Override
  public CategoryDto getCategory(String id) throws Exception {
    return categoryMapper.getCategory(id);
  }

  @Override
  public void updateCategory(CategoryDto categoryDto) throws Exception {
    categoryMapper.updateCategory(categoryDto);
  }

  @Override
  public void createCategory(CategoryDto categoryDto) throws Exception {
    categoryMapper.createCategory(categoryDto);
  }
}
