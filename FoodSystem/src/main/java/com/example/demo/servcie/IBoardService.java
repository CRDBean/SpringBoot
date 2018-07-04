package com.example.demo.servcie;

import java.util.List;

import com.example.demo.entity.Board;

public interface IBoardService {
	
	
	
		public void addBoardFood(int bid, List<Integer> lists) ;


		public void payBoardById(int id) ;
		

		

		public Board selectBoardById(int id) ;
		

		public List<Board> selectBoardAlls() ;

		public void addBoard(String name) ;
		

		public void updateBoard(Board b) ;

	

	

}
