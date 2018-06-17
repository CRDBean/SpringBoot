package com.example.demo.dao;

import com.example.demo.entity.FoodType;
import com.example.demo.entity.FoodTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FoodTypeMapper {
    int countByExample(FoodTypeExample example);

    int deleteByExample(FoodTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FoodType record);

    int insertSelective(FoodType record);

    List<FoodType> selectByExample(FoodTypeExample example);

    FoodType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FoodType record, @Param("example") FoodTypeExample example);

    int updateByExample(@Param("record") FoodType record, @Param("example") FoodTypeExample example);

    int updateByPrimaryKeySelective(FoodType record);

    int updateByPrimaryKey(FoodType record);
}