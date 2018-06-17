package com.example.demo.servcie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MessageMapper;
import com.example.demo.entity.Message;

@Service
public class MessageService {

	@Autowired
	private MessageMapper dao;

	public void addMessage(Message m) {
		dao.insert(m);
	}

	public List<Message> selectMessagesWithCondition(String str) {
		List<Message> messages = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("selectTime", str);
		messages = dao.selectMessageByTime(map);
		//如果有数据
		if (messages != null && messages.size() >= 1) {
			Collections.reverse(messages);
		}else{
			//如果没数据
			messages = new ArrayList<>();
		}

		return messages;
	}

	public Double selectMoney(String str) {
		Map<String, Object> map = new HashMap<>();
		map.put("selectTime", str);
		Double result=dao.selectMoney(map);
		if(result==null){
			result=0.0;
		}
		return result;
	}

}
