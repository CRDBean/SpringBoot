package com.example.demo.servcie;

import java.util.List;

import com.example.demo.entity.FoodType;

public interface IFoodTypeService {

	public FoodType selectFoodTypeById(int id);

	public FoodType selectFoodTypeByName(String name);

	public List<FoodType> selectFoodTypes();

	public void addFoodType(FoodType ft);

	public void deleteFoodType(int id);

	public void updateFoodType(FoodType ft);

}
