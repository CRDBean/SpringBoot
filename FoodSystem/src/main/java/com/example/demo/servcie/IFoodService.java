package com.example.demo.servcie;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Food;

public interface IFoodService {

	public void addFood(Food f,MultipartFile file) throws Exception;

	public List<Food> selectFoodByCondition(String str);

	public List<Food> selectAllFood();

	public void deleteFood(int id);

	public Food selectFoodById(int id);

	public void updateFood(Food f);

}
