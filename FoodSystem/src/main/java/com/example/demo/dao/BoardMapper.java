package com.example.demo.dao;

import com.example.demo.entity.Board;
import com.example.demo.entity.BoardExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BoardMapper {
    int countByExample(BoardExample example);

    int deleteByExample(BoardExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Board record);

    int insertSelective(Board record);

    List<Board> selectByExample(BoardExample example);

    Board selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Board record, @Param("example") BoardExample example);

    int updateByExample(@Param("record") Board record, @Param("example") BoardExample example);

    int updateByPrimaryKeySelective(Board record);

    int updateByPrimaryKey(Board record);
}