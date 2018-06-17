package com.example.demo.dao;

import com.example.demo.entity.Food;
import com.example.demo.entity.FoodExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FoodMapper {
	
	void updateFoodClickNumber(int fid);
	
    int countByExample(FoodExample example);

    int deleteByExample(FoodExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Food record);

    int insertSelective(Food record);

    List<Food> selectByExample(FoodExample example);

    Food selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByExample(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
}