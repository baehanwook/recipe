package com.recipe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.recipe.common.Constants;
import com.recipe.model.RecipeDTO;
import com.recipe.model.RecipeSearchResult;
import com.recipe.service.FileService;
import com.recipe.service.RecipeService;
import com.recipe.service.mapper.RecipeMapper;

@Controller
@RequestMapping(Constants.RECIPE)
public class RecipeController {

  @Autowired
  private RecipeService recipeService;

  @Autowired
  private RecipeMapper mapper;

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
  public String menu(RecipeDTO recipeDTO, Model model) throws Exception {
    model.addAttribute("recipeList", recipeService.search(recipeDTO));
    return "/menu/menu";
  }

  /**
   * レシピ作成画面
   * 
   * @param model
   * @return
   * @throws Exception
   */
  @GetMapping(Constants.CREATE)
  public String createRecipe(Model model) throws Exception {
    model.addAttribute("categoryList", recipeService.getCategory());
    model.addAttribute("smallCategoryList", recipeService.getSmallCategory());
    return "/menu/write";
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
  public String detailRecipe(@RequestParam("id") String id, Model model) throws Exception {
    model.addAttribute("recipe", recipeService.getDetail(id));
    return "/menu/detail";
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
  public String updateRecipe(@RequestParam("id") String id, Model model) throws Exception {
    model.addAttribute("categoryList", recipeService.getCategory());
    model.addAttribute("smallCategoryList", recipeService.getSmallCategory());
    model.addAttribute("recipe", recipeService.getDetail(id));
    return "/menu/update";
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
  public String createRecipe(@RequestParam("file") MultipartFile file,
      @ModelAttribute RecipeDTO recipeDto, Model model) throws Exception {
    String savedName = fileService.uploadFile(file.getOriginalFilename(), file.getBytes());
    recipeDto.setImageUrl(savedName);
    recipeService.create(recipeDto);
    return "redirect:/recipe/menu";
  }

  /**
   * レシピ検索処理
   * 
   * @param recipeDto
   * @return
   * @throws Exception
   */
  @PostMapping(Constants.SEARCH)
  public List<RecipeSearchResult> searchRecipe(@RequestBody RecipeDTO recipeDto) throws Exception {
    return mapper.search(recipeDto);
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
  public String updateRecipe(@RequestParam("file") MultipartFile file,
      @ModelAttribute RecipeDTO recipeDto, Model model) throws Exception {
    if (!file.isEmpty() && !recipeDto.getOrgFileUrl().isEmpty()) {
      fileService.deleteFile(recipeDto.getOrgFileUrl());
    }
    if (!file.isEmpty()) {
      String savedName = fileService.uploadFile(file.getOriginalFilename(), file.getBytes());
      recipeDto.setImageUrl(savedName);
    }

    recipeService.update(recipeDto);

    return "redirect:/recipe/menu";
  }

  /**
   * レシピ削除処理
   * 
   * @param id
   * @return
   */
  @GetMapping(Constants.DELETE)
  public String deleteRecipe(String id) throws Exception {
    recipeService.delete(id);
    return "redirect:/recipe/menu";
  }

  @GetMapping("/test")
  public String test() throws Exception {
    System.out.println(uploasUrl);
    return "/menu/menu";
  }

}
