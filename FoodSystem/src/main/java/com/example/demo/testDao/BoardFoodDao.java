package com.example.demo.testDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.FoodSystemApplication;
import com.example.demo.dao.BoardFoodMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FoodSystemApplication.class) // 制定SpinrgBoot的启动类
public class BoardFoodDao {

	@Autowired
	private BoardFoodMapper dao;
	
	@Test
	public void insertBoardFoodOne(){
		Map<String,Object> map=new HashMap<>();
		map.put("bid", 10);
		map.put("fid", 10);
		dao.insertBoardFoodOne(map);
	}
	

	@Test
	public void selectBoardHasAllFood() {
		List<Map<String,Integer>> lists=dao.selectBoardHasAllFood(1);
		System.out.println(lists);
	}

	@Test
	public void deleteBoardHasFood() {
	      dao.deleteBoardHasFood(5);
	}

	@Test
	public void deleteBoardHasFoodOne() {
		Map<String,Object> map=new HashMap<>();
		map.put("bid", 1);
		map.put("fid", 1);
		dao.deleteBoardHasFoodOne(map);
		
	}

	@Test
	public void selectBoardHasFoodNumber() {
		
		Map<String,Object> map=new HashMap<>();
		map.put("bid", 1);
		map.put("fid", 2);
		Integer result=dao.selectBoardHasFoodNumber(map);
		System.out.println(result);
	}

	@Test
	public void addBoardHasFoodNumber() {
		Map<String,Object> map=new HashMap<>();
		map.put("bid", 1);
		map.put("fid", 2);
		dao.addBoardHasFoodNumber(map);
	}
	@Test
	public void subBoardHasFoodNumber() {
		Map<String,Object> map=new HashMap<>();
		map.put("bid", 1);
		map.put("fid", 2);
		dao.subBoardHasFoodNumber(map);
	}

}
