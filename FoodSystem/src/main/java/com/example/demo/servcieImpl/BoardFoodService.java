package com.example.demo.servcieImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardFoodMapper;
import com.example.demo.dao.FoodMapper;
import com.example.demo.entity.Food;
import com.example.demo.servcie.IBoardFoodService;

@Service
public class BoardFoodService implements IBoardFoodService {

	@Autowired
	private BoardFoodMapper boardFoodDao;

	@Autowired
	private FoodMapper foodDao;

	@Override
	public Double selectBoardMoney(int id) {
		List<Map<String, Integer>> lists = boardFoodDao.selectBoardHasAllFood(id);
		// System.out.println(lists);
		List<Food> foods = new ArrayList<>();
		int fid = 0;
		Food food = new Food();
		for (Map<String, Integer> map : lists) {
			fid = map.get("fid");
			food = foodDao.selectByPrimaryKey(fid);
			food.setNumber(map.get("number"));
			foods.add(food);

		}

		double totalPrice = 0;
		for (Food f : foods) {
			// System.out.println(f.getPrice()+"------"+f.getNumber());
			totalPrice += (f.getPrice() * f.getNumber());
		}
		return totalPrice;
	}

	// 查询某一个餐桌所拥有的食物(食物的ID，食物的数量)
	@Override
	public List<Food> selectBoardHasAllFood(int id) {
		List<Map<String, Integer>> lists = boardFoodDao.selectBoardHasAllFood(id);
		// System.out.println(lists);
		List<Food> foods = new ArrayList<>();
		int fid = 0;
		Food food = new Food();
		for (Map<String, Integer> map : lists) {
			fid = map.get("fid");
			food = foodDao.selectByPrimaryKey(fid);
			food.setNumber(map.get("number"));
			foods.add(food);

		}
		return foods;
	}

	// 删除餐桌的记录
	@Override
	public void deleteBoardHasFood(int id) {
		boardFoodDao.deleteBoardHasFood(id);
	}

	/**
	 * 删除餐桌的一行记录 给某一个桌的某一种菜在加一份
	 * 
	 * @param map
	 *            bid fid
	 */
	@Override
	public void deleteBoardHasFoodOne(int bid, int fid) {
		Map<String, Object> map = new HashMap<>();
		map.put("bid", bid);
		map.put("fid", fid);
		boardFoodDao.deleteBoardHasFoodOne(map);
	}

	/**
	 * 查询某一个餐桌的某一个食物的数量 给某一个桌的某一种菜在加一份
	 * 
	 * @param map
	 *            bid fid
	 */
	@Override
	public Integer selectBoardHasFoodNumber(int bid, int fid) {
		Map<String, Object> map = new HashMap<>();
		map.put("bid", bid);
		map.put("fid", fid);
		return boardFoodDao.selectBoardHasFoodNumber(map);
	}

	/**
	 * 给某一个桌的某一种菜在加一份
	 * 
	 * @param map
	 *            bid fid
	 */
	@Override
	public void addBoardHasFoodNumber(int bid, int fid) {
		Map<String, Object> map = new HashMap<>();
		map.put("bid", bid);
		map.put("fid", fid);
		boardFoodDao.addBoardHasFoodNumber(map);
	}

	/**
	 * 给某一个桌的某一种菜在减去一份
	 * 
	 * @param map
	 *            bid fid
	 */
	@Override
	public void subBoardHasFoodNumber(int bid, int fid) {
		Map<String, Object> map = new HashMap<>();
		map.put("bid", bid);
		map.put("fid", fid);
		boardFoodDao.subBoardHasFoodNumber(map);
	}

}
