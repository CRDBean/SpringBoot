package com.example.demo.servcie;



import java.util.List;

import com.example.demo.entity.Food;

public interface IBoardFoodService {

	
	//查询一个餐桌的价格
	public Double selectBoardMoney(int id);

	// 查询某一个餐桌所拥有的食物(食物的ID，食物的数量)
	public List<Food> selectBoardHasAllFood(int id);

	// 删除餐桌的记录
	public void deleteBoardHasFood(int id);

	/**
	 * 删除餐桌的一行记录 给某一个桌的某一种菜在加一份
	 * 
	 * @param map
	 *            bid fid
	 */
	public void deleteBoardHasFoodOne(int bid, int fid);

	/**
	 * 查询某一个餐桌的某一个食物的数量 给某一个桌的某一种菜在加一份
	 * 
	 * @param map
	 *            bid fid
	 */
	public Integer selectBoardHasFoodNumber(int bid, int fid);

	/**
	 * 给某一个桌的某一种菜在加一份
	 * 
	 * @param map
	 *            bid fid
	 */
	public void addBoardHasFoodNumber(int bid, int fid);

	/**
	 * 给某一个桌的某一种菜在减去一份
	 * 
	 * @param map
	 *            bid fid
	 */
	public void subBoardHasFoodNumber(int bid, int fid);

}
