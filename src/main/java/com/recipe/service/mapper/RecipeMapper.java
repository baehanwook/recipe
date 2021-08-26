package com.recipe.service.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.recipe.model.CategoryDto;
import com.recipe.model.RecipeDTO;
import com.recipe.model.RecipeSearchResult;
import com.recipe.model.SmallCategoryDto;

@Mapper
public interface RecipeMapper {

  public void create(RecipeDTO recipeDto) throws Exception;

  public List<RecipeSearchResult> search(RecipeDTO recipeDto) throws Exception;

  public List<RecipeDTO> read(RecipeDTO recipeDto) throws Exception;

  public List<SmallCategoryDto> getSmallCategoryList() throws Exception;

  public RecipeSearchResult getDetail(String id) throws Exception;

  public void updateRecipe(RecipeDTO recipeDto) throws Exception;

  public void deleteRecipe(String id) throws Exception;
}
