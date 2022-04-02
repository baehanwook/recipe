package com.recipe.controller;

import com.recipe.common.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.recipe.common.Constants;
import com.recipe.model.RecipeDTO;
import com.recipe.service.CategoryService;
import com.recipe.service.FileService;
import com.recipe.service.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(Constants.RECIPE)
public class RecipeController {

  @Autowired
  private RecipeService recipeService;

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private FileService fileService;

  @Value("${file.upload-dir}")
  private String uploasUrl;

  /**
   * メニューリスト検索
   * 
   * @return メニュー
   * @throws Exception
   */
  @GetMapping(Constants.MENU)
  public String menu(Device device, @RequestParam(value = "categoryId", required = false) String categoryId, Model model) throws Exception {
    RecipeDTO recipeDto = new RecipeDTO();
    recipeDto.setCategoryId(categoryId);
    model.addAttribute("smallCategoryList", recipeService.getSmallCategoryList());
    model.addAttribute("categoryList", categoryService.getCategoryList());
    model.addAttribute("recipeList", recipeService.searchRecipe(recipeDto));
    return Util.deviceCheck(device, Constants.MENU_LIST);
  }

  /**
   * レシピ作成画面
   * 
   * @param model
   * @return
   * @throws Exception
   */
  @GetMapping(Constants.CREATE)
  public String createRecipe(Device device, Model model) throws Exception {
    model.addAttribute("categoryList", categoryService.getCategoryList());
    model.addAttribute("smallCategoryList", recipeService.getSmallCategoryList());
    return Util.deviceCheck(device, Constants.MENU_WRITE);
  }

  /**
   * レシピ詳細画面
   * 
   * @param id
   * @param model
   * @return
   * @throws Exception
   */
  @GetMapping(Constants.DETAIL)
  public String detailRecipe(Device device, @RequestParam("id") String id, Model model) throws Exception {
    model.addAttribute("recipe", recipeService.getDetail(id));
    return Util.deviceCheck(device, Constants.MENU_DETAIL);
  }

  /**
   * レシピ修正画面
   * 
   * @param id
   * @param model
   * @return
   * @throws Exception
   */
  @GetMapping(Constants.UPDATE)
  public String updateRecipe(Device device, @RequestParam("id") String id, Model model) throws Exception {
    model.addAttribute("categoryList", categoryService.getCategoryList());
    model.addAttribute("smallCategoryList", recipeService.getSmallCategoryList());
    model.addAttribute("recipe", recipeService.getDetail(id));
    return Util.deviceCheck(device, Constants.MENU_UPDATE);
  }

  /**
   * レシピ作成処理
   * 
   * @param file
   * @param recipeDto
   * @param model
   * @return
   * @throws Exception
   */
  @PostMapping(Constants.CREATE)
  public String createRecipe(Device device, @RequestParam("file") MultipartFile file, @ModelAttribute RecipeDTO recipeDto, Model model) throws Exception {
    String savedName = fileService.uploadFile(file.getOriginalFilename(), file.getBytes());
    recipeDto.setImageUrl(savedName);
    recipeService.create(recipeDto);
    return "redirect:" + Constants.RECIPE_MENU;
//    return "redirect:/recipe/menu";
  }

  /**
   * レシピ検索処理
   * 
   * @param recipeDto
   * @return
   * @throws Exception
   */
  @PostMapping(Constants.SEARCH)
  public String searchRecipe(Device device, @ModelAttribute RecipeDTO recipeDto, Model model) throws Exception {
    model.addAttribute("smallCategoryList", recipeService.getSmallCategoryList());
    model.addAttribute("recipeList", recipeService.searchRecipe(recipeDto));
    return Util.deviceCheck(device, Constants.MENU_LIST);
  }

  /**
   * レシピ修正処理
   * 
   * @param file
   * @param recipeDto
   * @param model
   * @return
   * @throws Exception
   */
  @PostMapping(Constants.UPDATE)
  public String updateRecipe(Device device, @RequestParam("file") MultipartFile file, @ModelAttribute RecipeDTO recipeDto, Model model) throws Exception {
    if (!file.isEmpty() && !recipeDto.getOrgFileUrl().isEmpty()) {
      fileService.deleteFile(recipeDto.getOrgFileUrl());
    }
    if (!file.isEmpty()) {
      String savedName = fileService.uploadFile(file.getOriginalFilename(), file.getBytes());
      recipeDto.setImageUrl(savedName);
    }

    recipeService.update(recipeDto);

    return "redirect:" + Constants.RECIPE_MENU;
  }

  /**
   * レシピ削除処理
   * 
   * @param id
   * @returnß
   */
  @GetMapping(Constants.DELETE)
  public String deleteRecipe(Device device, @RequestParam("id") String id) throws Exception {
    recipeService.delete(id);
    return "redirect:" + Constants.RECIPE_MENU;
  }
}
