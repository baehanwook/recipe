package com.recipe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.recipe.common.Constants;
import com.recipe.model.RecipeDTO;
import com.recipe.model.RecipeSearchResult;
import com.recipe.service.mapper.RecipeMapper;

@RestController
@RequestMapping(Constants.RECIPE)
public class RecipeController {

  @Autowired
  private RecipeMapper mapper;

  // @Autowired
  // private RecipeDTO recipeDto;

  // @Autowired
  // private ModelAndView modelAndView;

  @PostMapping(Constants.CREATE)
  public void createRecipe(@RequestBody RecipeDTO recipeDto) throws Exception {
    mapper.create(recipeDto);
  }

  @PostMapping(Constants.SEARCH)
  public List<RecipeSearchResult> searchRecipe(@RequestBody RecipeDTO recipeDto) throws Exception {
    return mapper.search(recipeDto);
  }

  // @GetMapping(value = "")
  // @ResponseBody
  // public ModelAndView samplFindAll() throws Exception {
  //
  // ModelAndView modelAndView = new ModelAndView();
  //
  // List<MemberTestVO> list = mapper.selectTestMemberList();
  //
  // list.stream().forEach(x -> System.out.println(x.getName()));;
  //
  // modelAndView.setViewName("/home.html");
  //
  // return modelAndView;
  // }

}
