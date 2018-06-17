package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Message;
import com.example.demo.entity.MessageExample;
@Mapper
public interface MessageMapper2 {
	
	/**
	 * 根据日期查询总收入
	 * @param selectTime
	 * @return
	 */
	Double selectMoney(Map<String,Object> map);
	
	/**
	 * 根据日期查询当天的记录
	 * @param map
	 * @return
	 */
	List<Message> selectMessageByTime(Map<String,Object> map);
	
	
	
    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
 
}