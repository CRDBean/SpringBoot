package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardFoodMapper {
	
	/**
	 * 插入一条记录bid   fid
	 * @param map
	 */
	public void insertBoardFoodOne(Map<String,Object> map);
	
	
	//查询某一个餐桌所拥有的食物(食物的ID，食物的数量)
	public List<Map<String,Integer>> selectBoardHasAllFood(int id);
	
	//删除餐桌的记录
	public void deleteBoardHasFood(int id);
	
	
	/**删除餐桌的一行记录
	 * 给某一个桌的某一种菜在加一份
	 * @param map   bid   fid 
	 */
	public void deleteBoardHasFoodOne(Map<String,Object> map);
	
	
	
	/**查询某一个餐桌的某一个食物的数量
	 * 给某一个桌的某一种菜在加一份
	 * @param map   bid   fid 
	 */
	public Integer selectBoardHasFoodNumber(Map<String,Object> map);
	
	
	
	/**
	 * 给某一个桌的某一种菜在加一份
	 * @param map   bid   fid 
	 */
	public void addBoardHasFoodNumber(Map<String,Object> map);
	
	/**
	 * 给某一个桌的某一种菜在减去一份
	 * @param map   bid   fid 
	 */
	public void subBoardHasFoodNumber(Map<String,Object> map);
	
	

}
