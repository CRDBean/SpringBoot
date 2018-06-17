package com.example.demo.testDao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.FoodSystemApplication;
import com.example.demo.dao.BoardMapper;
import com.example.demo.entity.Board;
import com.example.demo.entity.BoardExample;
import com.example.demo.entity.BoardExample.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FoodSystemApplication.class) // 制定SpinrgBoot的启动类
public class BoardDao {

	@Autowired
	private BoardMapper dao;

	@Test
	public void insert() {
		Board board = new Board("三号桌");
		dao.insert(board);
	}

	@Test
	public void delete() {
		dao.deleteByPrimaryKey(2);
	}

	@Test
	public void update() {
		Board board = new Board("三号1231桌");
		board.setBid(2);
		dao.updateByPrimaryKey(board);
	}

	@Test
	public void selectOne() {
		BoardExample example=new BoardExample();
		Criteria c=example.createCriteria();
		c.andBsignEqualTo(1);
		List<Board> boards = dao.selectByExample(example);
		for (Board board : boards) {
			System.out.println(board);
		}

	}

	@Test
	public void selectAll() {
		List<Board> boards = dao.selectByExample(null);
		for (Board board : boards) {
			System.out.println(board);
		}
	}

}
