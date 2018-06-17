package com.example.demo.entity;
//食物类
public class Food {
    private Integer fid;

    private String fname;

    private Integer ftype;
    
    private FoodType foodType;

    private Double price;

    private Double mprice;

    private String message;
    
    private Integer number;
    
    private String picture;
    
    private Integer clickNumber;
    
    

    
    
    public Integer getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(Integer clickNumber) {
		this.clickNumber = clickNumber;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    
    
    public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getFtype() {
        return ftype;
    }

    public void setFtype(Integer ftype) {
        this.ftype = ftype;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMprice() {
        return mprice;
    }

    public void setMprice(Double mprice) {
        this.mprice = mprice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

	

	
	




	@Override
	public String toString() {
		return "Food [fid=" + fid + ", fname=" + fname + ", ftype=" + ftype + ", foodType=" + foodType + ", price="
				+ price + ", mprice=" + mprice + ", message=" + message + ", number=" + number + ", picture=" + picture
				+ ", clickNumber=" + clickNumber + "]";
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	public Food() {
		
	}

	public Food(String fname, Integer ftype, Double price, Double mprice, String message) {
		
		this.fname = fname;
		this.ftype = ftype;
		this.price = price;
		this.mprice = mprice;
		this.message = message;
	}
    
}