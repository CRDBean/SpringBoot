package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Message;
@Mapper
public interface MessageMapper {
	
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
	
	
	
    
    int insert(Message record);

    
    
 
}