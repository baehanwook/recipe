package com.recipe.service.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.recipe.model.CategoryDto;

@Mapper
public interface CategoryMapper {

  public List<CategoryDto> getCategoryList() throws Exception;

  public CategoryDto getCategory(String id) throws Exception;

  public void updateCategory(CategoryDto categoryDto) throws Exception;

}
