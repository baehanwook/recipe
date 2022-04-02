package com.recipe.controller;

import com.recipe.common.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
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
  public String category(Device device, Model model) throws Exception {
    model.addAttribute("categoryList", categoryService.getCategoryList());
    return Util.deviceCheck(device, Constants.CATEGORY_LIST);
  }

  /**
   * カテゴリー修正画面
   * 
   * @param model
   * @return
   * @throws Exception
   */
  @GetMapping(Constants.CATEGORY + Constants.DETAIL)
  public String categoryDetail(Device device, @RequestParam("id") String id, Model model) throws Exception {
    model.addAttribute("category", categoryService.getCategory(id));
    model.addAttribute("categoryList", categoryService.getCategoryList());
    return Util.deviceCheck(device, Constants.CATEGORY_DETAIL);
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
  public String updateCategory(Device device, @ModelAttribute CategoryDto categoryDto, Model model) throws Exception {
    model.addAttribute("categoryList", categoryService.getCategoryList());
    categoryService.updateCategory(categoryDto);
    return "redirect:" + Constants.CATEGORY_MAIN;
  }

  /**
   * カテゴリー作成画面
   * 
   * @param model
   * @return
   * @throws Exception
   */
  @GetMapping(Constants.CATEGORY + Constants.CREATE)
  public String createCategory(Device device, Model model) throws Exception {
    model.addAttribute("categoryList", categoryService.getCategoryList());
    return Util.deviceCheck(device, Constants.CATEGORY_CREATE);
  }

  /**
   * カテゴリー作成
   *
   * @param model
   * @return
   * @throws Exception
   */
  @PostMapping(Constants.CATEGORY + Constants.CREATE)
  public String createCategory(Device device, @ModelAttribute CategoryDto categoryDto, Model model) throws Exception {
    model.addAttribute("categoryList", categoryService.getCategoryList());
    return "redirect:" + Constants.CATEGORY_MAIN;
  }
}
