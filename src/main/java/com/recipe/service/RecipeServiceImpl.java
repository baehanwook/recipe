package com.recipe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recipe.model.RecipeDTO;
import com.recipe.model.RecipeSearchResult;
import com.recipe.model.SmallCategoryDto;
import com.recipe.service.mapper.RecipeMapper;

@Service
public class RecipeServiceImpl implements RecipeService {

  @Autowired
  private RecipeMapper recipeMapper;

  @Override
  public void create(RecipeDTO recipeDto) throws Exception {
    recipeMapper.create(recipeDto);
  }

  @Override
  public void update(RecipeDTO recipeDto) throws Exception {
    recipeMapper.updateRecipe(recipeDto);
  }

  @Override
  public List<SmallCategoryDto> getSmallCategoryList() throws Exception {
    return recipeMapper.getSmallCategoryList();
  }

  @Override
  public List<RecipeSearchResult> searchRecipe(RecipeDTO recipeDto) throws Exception {
    return recipeMapper.search(recipeDto);
  }

  @Override
  public RecipeSearchResult getDetail(String id) throws Exception {
    return recipeMapper.getDetail(id);
  }

  @Override
  public void delete(String id) throws Exception {
    recipeMapper.deleteRecipe(id);
  }
}
