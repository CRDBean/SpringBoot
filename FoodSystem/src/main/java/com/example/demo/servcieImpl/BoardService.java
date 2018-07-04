package com.example.demo.servcieImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardFoodMapper;
import com.example.demo.dao.BoardMapper;
import com.example.demo.dao.FoodMapper;
import com.example.demo.dao.MessageMapper;
import com.example.demo.entity.Board;
import com.example.demo.entity.Food;
import com.example.demo.entity.Message;
import com.example.demo.servcie.IBoardService;

@Service
public class BoardService implements IBoardService{

	@Autowired
	private BoardMapper BoardDao;

	@Autowired
	private BoardFoodMapper boardFoodDao;

	@Autowired
	private FoodMapper foodDao;

	@Autowired
	private MessageMapper messageDao;

	public void addBoardFood(int bid, List<Integer> lists) {

		Integer temp = null;

		Map<String, Object> map = new HashMap<>();
		map.put("bid", bid);
		for (Integer integer : lists) {
			map.put("fid", integer);
			// 查询bid餐桌fid的数量
			temp = boardFoodDao.selectBoardHasFoodNumber(map);

			// 如果上面的数存在，就加一
			if (temp != null) {
				boardFoodDao.addBoardHasFoodNumber(map);
			} else {
				// 如果不存在，就插入
				boardFoodDao.insertBoardFoodOne(map);

			}
			
			//某一个菜品被点击了
			foodDao.updateFoodClickNumber(integer);
			
		}

	}

	public void payBoardById(int id) {
		// 修改Board的状态
		Board board = BoardDao.selectByPrimaryKey(id);
		board.setBsign(0);
		BoardDao.updateByPrimaryKey(board);

		// 计算总价格
		List<Map<String, Integer>> lists = boardFoodDao.selectBoardHasAllFood(id);
		// System.out.println(lists);
		List<Food> foods = new ArrayList<>();
		int fid = 0;
		String str = "";
		Food food = new Food();
		for (Map<String, Integer> map : lists) {
			fid = map.get("fid");
			food = foodDao.selectByPrimaryKey(fid);
			food.setNumber(map.get("number"));
			foods.add(food);
			str += (food.getFname() + "*" + food.getNumber() + " , ");

		}
		double totalPrice = 0;// 总价格
		for (Food f : foods) {
			// System.out.println(f.getPrice()+"------"+f.getNumber());
			totalPrice += (f.getPrice() * f.getNumber());
		}

		boardFoodDao.deleteBoardHasFood(id);

		// 将记录添加的到Mesage数据库中
		Message m = new Message();
		m.setBname(board.getBname());
		m.setMessage(str);
		m.setMoney(totalPrice);
		m.setTime(new Date());

		messageDao.insert(m);

	}

	public Board selectBoardById(int id) {
		return BoardDao.selectByPrimaryKey(id);
	}

	public List<Board> selectBoardAlls() {
		return BoardDao.selectByExample(null);
	}

	public void addBoard(String name) {
		Board board = new Board(name);
		BoardDao.insert(board);
	}

	public void updateBoard(Board b) {
		BoardDao.updateByPrimaryKey(b);
	}

}
