package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Board {
	private Integer bid;

	private String bname;

	private Integer bsign;

	private Date btime;
	
	private List<Food> foods=new ArrayList<>();
	
	

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname == null ? null : bname.trim();
	}

	public Integer getBsign() {
		return bsign;
	}

	public void setBsign(Integer bsign) {
		this.bsign = bsign;
	}

	public Date getBtime() {
		return btime;
	}

	public void setBtime(Date btime) {
		this.btime = btime;
	}

	public Board() {
	}
	
	

	public Board(String bname) {
		
		this.bname = bname;
		this.bsign=0;
		
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", bname=" + bname + ", bsign=" + bsign + ", btime=" + btime + "]";
	}

}