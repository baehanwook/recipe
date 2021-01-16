package com.recipe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recipe.model.CategoryDto;
import com.recipe.model.RecipeDTO;
import com.recipe.model.RecipeSearchResult;
import com.recipe.model.SmallCategoryDto;
import com.recipe.service.mapper.RecipeMapper;

@Service
public class RecipeServiceImpl implements RecipeService {

  @Autowired
  private RecipeMapper mapper;

  @Override
  public void create(RecipeDTO recipeDto) throws Exception {
    mapper.create(recipeDto);
  }

  @Override
  public void update(RecipeDTO recipeDto) throws Exception {
    mapper.updateRecipe(recipeDto);
  }

  @Override
  public List<RecipeSearchResult> search(RecipeDTO recipeDto) throws Exception {
    return mapper.search(recipeDto);
  }

  @Override
  public List<CategoryDto> getCategory() throws Exception {
    return mapper.getCategory();
  }

  @Override
  public List<SmallCategoryDto> getSmallCategory() throws Exception {
    return mapper.getSmallCategory();
  }

  @Override
  public RecipeSearchResult getDetail(String id) throws Exception {
    return mapper.getDetail(id);
  }

  @Override
  public void delete(String id) throws Exception {
    mapper.deleteRecipe(id);
  }
}
