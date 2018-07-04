package com.example.demo.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Board;
import com.example.demo.entity.Food;
import com.example.demo.servcieImpl.BoardFoodService;
import com.example.demo.servcieImpl.BoardService;
import com.example.demo.servcieImpl.FoodServcie;

@Controller
public class BoardHandler {

	@Autowired
	private BoardService boardService;

	@Autowired
	private BoardFoodService boardFoodService;

	@Autowired
	private FoodServcie foodService;

	@RequestMapping("/addFood.action")
	public String addFood(String id, HttpServletRequest request) {
		int sid = Integer.parseInt(id);// 餐桌的Id
		System.out.println(id);

		String[] strs = request.getParameterValues("action");// 食物的Id

		List<Integer> integers = new ArrayList<>();
		for (String string : strs) {
			System.out.println(string);
			integers.add(Integer.parseInt(string));
		}
		if (integers.size() > 0) {
			boardService.addBoardFood(sid, integers);
		}
		return "redirect:/orderDetailHtml.action?id=" + sid;

	}

	// 跳转到添加菜的html addFoodHtml.action
	@RequestMapping("/addFoodHtml.action")
	public String showAddFoodListHtml(String id, Map<String, Object> map) {
		List<Food> foods = foodService.selectAllFood();
		System.out.println(id);
		map.put("id", id);
		map.put("foods", foods);

		return "/addFood";
	}

	@RequestMapping("/payBoard.action")
	public String payBoard(String id) {
		int bid = Integer.parseInt(id);
		System.out.println("结账--------->" + id);
		boardService.payBoardById(bid);

		return "redirect:/boardListHtml.action";

	}

	@RequestMapping("/advanceBoard.action")
	public String advanceButton(String id) {
		int bid = Integer.parseInt(id);
		Board board = boardService.selectBoardById(bid);
		board.setBsign(1);
		board.setBtime(new Date());
		boardService.updateBoard(board);
		System.out.println(id);
		return "redirect:/boardListHtml.action";
	}

	@RequestMapping("/boardListHtml.action")
	public String showBoardListHtml(Map<String, Object> map) {
		List<Board> boards = boardService.selectBoardAlls();
		map.put("boards", boards);
		return "/boardList";
	}

	@RequestMapping("/saveBoardHtml.action")
	public String showSaveBoardlHtml() {
		return "/saveBoard";
	}

	@RequestMapping("/addBoard.action")
	public String addBoard(String name) {
		boardService.addBoard(name);
		return "redirect:/boardListHtml.action";
	}

	@RequestMapping("/orderDetailHtml.action")
	public String showorederDetailHtml(String id, Map<String, Object> map) {
		int bid = Integer.parseInt(id);
		List<Food> foods = boardFoodService.selectBoardHasAllFood(bid);
		double totalPrice = 0;
		totalPrice = boardFoodService.selectBoardMoney(bid);
		/*
		 * for (Food food : foods) {
		 * System.out.println(food.getPrice()+"------"+food.getNumber());
		 * totalPrice+=(food.getPrice()*food.getNumber()); }
		 */

		map.put("foods", foods);
		map.put("totalPrice", totalPrice);
		map.put("id", bid);

		return "/orderDetail";
	}

}
