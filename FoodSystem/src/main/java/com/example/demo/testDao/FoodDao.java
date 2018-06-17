package com.example.demo.testDao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.FoodSystemApplication;
import com.example.demo.dao.FoodMapper;
import com.example.demo.entity.Food;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FoodSystemApplication.class) // 制定SpinrgBoot的启动类
public class FoodDao {

	@Autowired
	private FoodMapper dao;

	

	

	@Test
	public void insert() {
		Food f = new Food("菜花", 1, 1.0, 1.1, "很棒");
		dao.insert(f);
	}

	@Test
	public void delete() {
		dao.deleteByPrimaryKey(5);
	}

	@Test
	public void update() {
		Food f = new Food("菜213花", 1, 1.0, 1.1, "很棒");
		f.setFid(5);
		dao.updateByPrimaryKey(f);
	}

	@Test
	public void selectOne() {
		Food f = dao.selectByPrimaryKey(1);
		System.out.println(f);

	}

	@Test
	public void selectAll() {
		List<Food> f = dao.selectByExample(null);
		for (Food food : f) {
			System.out.println(food);
		}

	}

}
