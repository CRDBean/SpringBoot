package com.example.demo.servcie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FoodTypeMapper;
import com.example.demo.entity.FoodType;
import com.example.demo.entity.FoodTypeExample;
import com.example.demo.entity.FoodTypeExample.Criteria;

@Service
public class FoodTypeService {

	@Autowired
	private FoodTypeMapper foodTypeDao;

	public FoodType selectFoodTypeById(int id) {
		return foodTypeDao.selectByPrimaryKey(id);
	}

	public FoodType selectFoodTypeByName(String name) {
		FoodTypeExample example = new FoodTypeExample();
		Criteria c = example.createCriteria();
		c.andTypenameEqualTo(name);
		List<FoodType> foodTypes = new ArrayList<>();
		foodTypes = foodTypeDao.selectByExample(example);
		if (foodTypes != null && foodTypes.size() > 0) {
			return foodTypes.get(0);
		} else {
			return null;
		}

	}

	public List<FoodType> selectFoodTypes() {
		return foodTypeDao.selectByExample(null);
	}
	
	public void addFoodType(FoodType ft){
		foodTypeDao.insert(ft);
	}
	
	
	public void deleteFoodType(int id){
		foodTypeDao.deleteByPrimaryKey(id);
	}
	public void updateFoodType(FoodType ft){
		foodTypeDao.updateByPrimaryKey(ft);
	}

}
