package com.example.demo.servcie;

import java.util.List;

import com.example.demo.entity.Message;

public interface IMessageServcie {

	public void addMessage(Message m);

	public List<Message> selectMessagesWithCondition(String str);

	public Double selectMoney(String str);

}
