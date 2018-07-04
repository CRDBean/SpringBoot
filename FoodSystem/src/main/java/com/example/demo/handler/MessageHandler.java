package com.example.demo.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Message;
import com.example.demo.servcieImpl.MessageService;
@Controller
public class MessageHandler {
	
	
	//查询条件
	private String selectTime="";
	
	
	@Autowired
	private MessageService messageService;
	
	
	@RequestMapping("/orderListHtml.action")
	public String showorederListlHtml(Map<String,Object> map) {
		List<Message> messages=messageService.selectMessagesWithCondition(selectTime);
		
		double totalPrice=messageService.selectMoney(selectTime);
		
		map.put("selectTime", selectTime);
		map.put("messages", messages);
		map.put("totalPrice", totalPrice);
		
		return "/orderList";
	}
	
	
	@RequestMapping("/setTimeCondition.action")
	public String selectTimeCondition(String selectTime){
		//System.out.println("selectTime-------------->"+selectTime);
		this.selectTime=selectTime;
		return "redirect:/orderListHtml.action";
	}


	


	public String getSelectTime() {
		return selectTime;
	}





	public void setSelectTime(String selectTime) {
		this.selectTime = selectTime;
	}





	public MessageService getMessageService() {
		return messageService;
	}


	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	
	

	

}
