package com.recipe.service;

import java.util.List;
import com.recipe.model.RecipeDTO;
import com.recipe.model.RecipeSearchResult;
import com.recipe.model.SmallCategoryDto;

public interface RecipeService {

  /**
   * レシピ作成
   * 
   * @param recipeDto
   * @throws Exception
   */
  public void create(RecipeDTO recipeDto) throws Exception;

  /**
   * レシピ修正
   * 
   * @param recipeDto
   * @throws Exception
   */
  public void update(RecipeDTO recipeDto) throws Exception;

  /**
   * 小カテゴリー取得
   * 
   * @return
   * @throws Exception
   */
  public List<SmallCategoryDto> getSmallCategoryList() throws Exception;

  /**
   * レシピ検索
   * 
   * @param recipeDto
   * @return
   * @throws Exception
   */
  public List<RecipeSearchResult> searchRecipe(RecipeDTO recipeDto) throws Exception;

  /**
   * レシピ詳細の取得
   * 
   * @param id
   * @return
   * @throws Exception
   */
  public RecipeSearchResult getDetail(String id) throws Exception;

  /**
   * レシピ削除
   * 
   * @param id
   * @throws Exception
   */
  public void delete(String id) throws Exception;

}
