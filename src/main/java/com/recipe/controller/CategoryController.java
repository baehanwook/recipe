package com.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.recipe.common.Constants;
import com.recipe.model.CategoryDto;
import com.recipe.service.CategoryService;

@Controller
@RequestMapping(Constants.RECIPE)
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  /**
   * カテゴリー一覧
   * 
   * @param model
   * @return
   * @throws Exception
   */
  @GetMapping(Constants.CATEGORY)
  public String category(Model model) throws Exception {
    model.addAttribute("categoryList", categoryService.getCategoryList());
    return "/category/category";
  }

  /**
   * カテゴリー修正画面
   * 
   * @param model
   * @return
   * @throws Exception
   */
  @GetMapping(Constants.CATEGORY + Constants.DETAIL)
  public String categoryDetail(@RequestParam("id") String id, Model model) throws Exception {
    model.addAttribute("category", categoryService.getCategory(id));
    model.addAttribute("categoryList", categoryService.getCategoryList());
    return "category/categoryDetail";
  }

  /**
   * カテゴリー修正
   * 
   * @param categoryDto
   * @param model
   * @return
   * @throws Exception
   */
  @PostMapping(Constants.CATEGORY + Constants.UPDATE)
  public String updateCategory(@ModelAttribute CategoryDto categoryDto, Model model) throws Exception {
    model.addAttribute("categoryList", categoryService.getCategoryList());
    categoryService.updateCategory(categoryDto);
    return "redirect:/recipe/category";
  }

  /**
   * カテゴリー作成画面
   * 
   * @param model
   * @return
   * @throws Exception
   */
  @GetMapping(Constants.CATEGORY + Constants.CREATE)
  public String createCategory(Model model) throws Exception {
    model.addAttribute("categoryList", categoryService.getCategoryList());
    return "category/categoryCreate";
  }
}
