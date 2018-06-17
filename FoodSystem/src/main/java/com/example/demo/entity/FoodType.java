package com.example.demo.entity;

public class FoodType {
    private Integer id;

    private String typename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

	@Override
	public String toString() {
		return "FoodType [id=" + id + ", typename=" + typename + "]";
	}

	public FoodType(String typename) {
		
		this.typename = typename;
	}

	public FoodType() {
		
	}
    
    
	
	
}