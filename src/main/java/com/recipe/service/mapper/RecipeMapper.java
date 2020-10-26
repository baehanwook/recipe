package com.recipe.service.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.recipe.model.RecipeDTO;
import com.recipe.model.RecipeSearchResult;

@Mapper
public interface RecipeMapper {

  public void create(RecipeDTO recipeDto) throws Exception;

  public List<RecipeSearchResult> search(RecipeDTO recipeDto) throws Exception;

  public List<RecipeDTO> read(RecipeDTO recipeDto) throws Exception;
}
