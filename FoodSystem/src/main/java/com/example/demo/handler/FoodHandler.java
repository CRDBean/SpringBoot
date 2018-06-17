package com.example.demo.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Food;
import com.example.demo.entity.FoodType;
import com.example.demo.entity.Page;
import com.example.demo.servcie.FoodServcie;
import com.example.demo.servcie.FoodTypeService;

@Controller
public class FoodHandler {

	@Autowired
	private FoodServcie foodService;

	@Autowired
	private FoodTypeService foodTypeService;

	// 查询关键字
	private String selectKeyWord = "";

	// 当前第几页Page
	private Integer currectPage = 1;
	
	
	/**
	 * iconHtml进去发送Ajax请求，就是这个请求
	 * @return
	 */
	@RequestMapping("/iconHtmlCore.action")
	@ResponseBody
	public Map<String,Object> iconHtmlCore(){
		System.out.println("Ajax。。。。。。。。。。。。。。。");
		List<Food> foods=foodService.selectAllFood();
		List<String> listName=new ArrayList<String>();
		List<Integer> listClickNumber=new ArrayList<Integer>();
		for (Food food : foods) {
			listName.add(food.getFname());
			listClickNumber.add(food.getClickNumber());	
		}
		
		Map<String,Object> map=new HashMap<>();
		map.put("listName", listName);
		map.put("listClickNumber", listClickNumber);
		
		return map;
	}
	
	
	
	
	
	@RequestMapping("/iconHtml.action")
	public String showIconHtml(){
		//List<Food> foods=foodService.selectAllFood();
		
		
		//弄格式
		//data:["Android","IOS","PC","Ohter"]
		//data:[500,200,360,100]
		/*
		String strName="[";
		String strNumber="[";
		for (Food food : foods) {
			strName+=("\""+food.getFname()+"\" , ");
			strNumber+=(""+food.getClickNumber()+" , ");
		}
		strName=strName.substring(0, strName.length()-2);
		strNumber=strNumber.substring(0, strNumber.length()-2);
		strName+="]";
		strNumber+="]";
		map.put("strName", strName);
		map.put("strNumber", strNumber);
		*/
		return "/icon";
	}
	

	@RequestMapping("/foodCondition.action")
	public String selectCondition(String selectKeyWord) {

		// System.out.println("selectKeyWord:"+selectKeyWord);

		this.selectKeyWord = selectKeyWord;

		return "redirect:/foodListHtml.action";
	}

	/*
	 * 设置Page的currentPage
	 */
	@RequestMapping("/setCurrectPage.action")
	public String PageCurrectPageNumber(int currectPage) {
		if (currectPage == 1) {
			this.currectPage = 1;
		} else if (currectPage == 2) {
			this.currectPage = this.currectPage - 1;
		} else if (currectPage == 3) {
			this.currectPage = this.currectPage + 1;
		} else if (currectPage == 4) {
			this.currectPage = Integer.MAX_VALUE;
		}
		return "redirect:/foodListHtml.action";
	}

	// 跳转的foodList。html页面
	@RequestMapping("/foodListHtml.action")
	public String showFoodListHtml(Map<String, Object> map) {
		List<Food> foods = foodService.selectFoodByCondition(selectKeyWord);
		 Page page=new Page(foods);
         page.setCurrentPage(this.currectPage);
         this.currectPage=page.getCurrentPage();
		//map.put("foods", foods);
         map.put("page", page);
		map.put("selectKeyWord", selectKeyWord);
		return "/foodList";
	}

	@RequestMapping("/saveFood.action")
	public String saveFood(Food f, MultipartFile file) throws IOException {

		if (!file.isEmpty()) {

			// 打印文件的名称
			// System.out.println("FileName:" + file.getOriginalFilename());
			// 确定上传文件的位置
			// String path =
			// "E:/stsWorkSpace/SpringBoot_Test/src/main/resources/upload";
			String path = "E:/stsWorkSpace/picture/foodsystem";
			File newFile = new File(path, file.getOriginalFilename());
			// 如果不存在，创建一哥副本
			if (!newFile.exists()) {
				newFile.createNewFile();

			}

			// 将io上传到副本中
			file.transferTo(newFile);
			f.setPicture(file.getOriginalFilename());

		}
		// System.out.println("----------->" + f);
		foodService.addFood(f);
		
		//将查询条件致为空
		this.currectPage=Integer.MAX_VALUE;
		this.selectKeyWord = "";
		return "redirect:/foodListHtml.action";
	}

	@RequestMapping("/saveFoodHtml.action")
	public String showSaveFoodlHtml(Map<String, Object> map) {
		List<FoodType> foodTypes = foodTypeService.selectFoodTypes();
		map.put("foodTypes", foodTypes);

		return "/saveFood";
	}

	// 前台传过来的ID，删除都又重定向到foodListHtml.action
	@RequestMapping("/deleteFoodById.action")
	public String deleteFood(String id) {
		int sid = Integer.parseInt(id);
		foodService.deleteFood(sid);
		return "redirect:/foodListHtml.action";
	}

	@RequestMapping("/updateFoodHtml.action")
	public String showUpdateFoodlHtml(String id, Map<String, Object> map) {
		int sid = Integer.parseInt(id);
		Food f = foodService.selectFoodById(sid);
		System.out.println(f);
		map.put("food", f);

		List<FoodType> foodTypes = foodTypeService.selectFoodTypes();
		map.put("foodTypes", foodTypes);

		return "/updateFood";
	}

	@RequestMapping("/updateFood.action")
	public String updateFood(Food f, MultipartFile file) throws IOException {

		System.out.println(f);

		if (!file.isEmpty()) {

			// 打印文件的名称
			// System.out.println("FileName:" + file.getOriginalFilename());
			// 确定上传文件的位置
			// String path =
			// "E:/stsWorkSpace/SpringBoot_Test/src/main/resources/upload";
			String path = "E:/stsWorkSpace/picture/foodsystem";
			File newFile = null;

			// 删除原来的图片
			if (!("".equals(f.getPicture()) || f.getPicture() == null)) {
				newFile = new File(path, f.getPicture());
				newFile.delete();

			}

			// 上传新的图片
			newFile = new File(path, file.getOriginalFilename());
			// 如果不存在，创建一哥副本
			if (!newFile.exists()) {
				newFile.createNewFile();

			}

			// 将io上传到副本中
			file.transferTo(newFile);
			f.setPicture(file.getOriginalFilename());

		}

		// System.out.println(f);

		foodService.updateFood(f);

		return "redirect:/foodListHtml.action";
	}

}
