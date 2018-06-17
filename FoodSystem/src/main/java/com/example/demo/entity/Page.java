package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;



//页面对象

public class Page {

	private List<Food> foods = new ArrayList<Food>();

	private int pageSize = 5; // 每页显示多少条记录

	private int currentPage; // 当前第几页数据

	private int totalRecord; // 一共多少条记录

	private int totalPage; // 一共多少页记录

	private List<Food> dataList = new ArrayList<Food>(); // 要显示的数据

	public Page(List<Food> foodss) {
		if (foodss == null || foodss.size() == 0) {
			currentPage = 1;
			totalPage = 1;
			totalRecord = 0;
		} else {
			this.foods = foodss;
			this.currentPage = 1;
			this.totalRecord = foodss.size();
			this.totalPage = (this.totalRecord % this.pageSize == 0) ? (this.totalRecord / this.pageSize)
					: (this.totalRecord / this.pageSize + 1);
			if (this.totalRecord < this.pageSize) {
				dataList = foodss;
			} else {
				dataList = foods.subList(0, pageSize);
			}
		}

	}

	@Override
	public String toString() {
		System.out.println("foods:" + foods);
		System.out.println("totalRecord:" + totalRecord);
		System.out.println("pageSize:" + pageSize);
		System.out.println("currentPage:" + currentPage);
		System.out.println("totalPage:" + totalPage);
		System.out.println("dataList:" + dataList);
		return "";
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @return the totalRecord
	 */
	public int getTotalRecord() {
		return totalRecord;
	}

	/**
	 * @param totalRecord
	 *            the totalRecord to set
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage
	 *            the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the dataList
	 */
	public List<Food> getDataList() {
		return dataList;
	}

	/**
	 * @param dataList
	 *            the dataList to set
	 */
	public void setDataList(List<Food> dataList) {
		this.dataList = dataList;
	}

	public void setCurrentPage(int currentPage) {

		if (currentPage <= 0) {
			currentPage = 1;
		} else if (currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		} else {
			this.currentPage = currentPage;
		}

		int first = (this.currentPage - 1) * this.pageSize;

		int last = 0;
		if (first + this.pageSize > this.totalRecord) {
			last = this.totalRecord;
		} else {
			last = first + this.pageSize;
		}
		dataList = foods.subList(first, last);
	}

	public boolean hasLastPage() {
		return this.currentPage > 1;
	}

	public boolean hasNextPage() {
		return this.currentPage < this.totalPage;
	}

}
