package com.example.demo.handler;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.FoodType;
import com.example.demo.servcie.FoodTypeService;

@Controller
public class FoodTypeHandler {
	
	@Autowired
	private FoodTypeService foodTypeService;
	
	@RequestMapping("/addFoodType.action")
	public String addFoodType(FoodType ft){
		System.out.println("addFoodType---------->"+ft);
		foodTypeService.addFoodType(ft);
		return "redirect:/cuisineListHtml.action";
	}

	// 前台传过来的ID，删除都又重定向到foodListHtml.action
	@RequestMapping("/deleteFoodTypeById.action")
	public String deleteFood(String id) {
         System.out.println("deleteFoodType------------>"+id);
         foodTypeService.deleteFoodType(Integer.parseInt(id));
		return "redirect:/cuisineListHtml.action";
	}
	
	@RequestMapping("/updateFoodType.action")
	public String updateFoodType(String id,String typename){
		System.out.println("updateFoodType------->"+id+":"+typename);
		FoodType ft=new FoodType();
		ft.setId(Integer.parseInt(id));
		ft.setTypename(typename);
		foodTypeService.updateFoodType(ft);
		return "redirect:/cuisineListHtml.action";
	}

	@RequestMapping("/updateCuisineHtml.action")
	public String showUpdateCuisineHtml(String id,Map<String,Object> map) {
		FoodType ft=foodTypeService.selectFoodTypeById(Integer.parseInt(id));
		map.put("foodType", ft);
		return "/updateCuisine";
	}

	@RequestMapping("/cuisineListHtml.action")
	public String showCuisineListHtml(Map<String,Object> map) {
		List<FoodType> foodTypes=foodTypeService.selectFoodTypes();
		map.put("foodTypes", foodTypes);
		return "/cuisineList";
	}

	@RequestMapping("/saveCuisineHtml.action")
	public String showSaveCuisinelHtml() {
		return "/saveCuisine";
	}
	
	

}
