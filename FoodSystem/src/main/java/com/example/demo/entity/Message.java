package com.example.demo.entity;

import java.util.Date;

public class Message {
    private Integer id;

    private String bname;

    private String message;

    private Double money;

    private Date time;
    
    
    

    public Message() {
		
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", bname=" + bname + ", message=" + message + ", money=" + money + ", time=" + time
				+ "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}