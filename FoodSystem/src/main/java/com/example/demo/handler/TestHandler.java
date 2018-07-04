package com.example.demo.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Food;
import com.example.demo.entity.FoodType;
import com.example.demo.servcieImpl.FoodServcie;
import com.example.demo.servcieImpl.FoodTypeService;

@Controller
public class TestHandler {

	@Autowired
	private FoodServcie foodService;

	@Autowired
	private FoodTypeService foodTypeService;
	
	
	/**
	 * 测试testFor.html页面已加载就for循环
	 * @return
	 */
	@RequestMapping(value="/testFor.action")
	public String testFor(){
		return "/testFor";
	}
	
	

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/test.action")
	@ResponseBody
	public List<Map<String, Object>> method1() {

		// 返回的结果的是List
		List<Map<String, Object>> result = new ArrayList<>();

		List<FoodType> foodTypes = foodTypeService.selectFoodTypes();

		

		List<Food> foods = new ArrayList<>();

		for (FoodType foodType : foodTypes) {
			List<String> listFoodName = new ArrayList<>();
			List<Integer> listFoodClickNumber = new ArrayList<>();

			foods = foodService.selectFoodByCondition(foodType.getTypename());

			for (Food food : foods) {
				listFoodName.add(food.getFname());
				listFoodClickNumber.add(food.getClickNumber());
			}
			Map<String, Object> tempMap = new HashMap<>();
			tempMap.put("typeName", foodType.getTypename());
			tempMap.put("listFoodName", listFoodName);
			tempMap.put("listFoodClickNumber", listFoodClickNumber);
			result.add(tempMap);
			//System.out.println("temp:" + tempMap);

			
			//System.out.println("result:" + result);

		}
		//System.out.println(result);

		return result;
	}
	
	
	/**
	 * 跳转到iconMany.html页面
	 * @return
	 */
	@RequestMapping("/iconMany.action")
	public String method11(){
		return "/iconMany";
	}



}
