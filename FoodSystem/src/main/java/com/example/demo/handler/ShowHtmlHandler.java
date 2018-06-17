package com.example.demo.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHtmlHandler {

	@RequestMapping("/topHtml.action")
	public String showTopHtml() {
		return "/top";
	}

	@RequestMapping("/leftHtml.action")
	public String showLetfHtml() {
		return "/left";
	}

	@RequestMapping("/rightHtml.action")
	public String showRightHtml() {
		return "/right";
	}

	@RequestMapping("/bottomHtml.action")
	public String showBottomHtml() {
		return "/bottom";
	}

	
	

	
	
	
	
	
  
	

	
	
	
	
	
   


	

	

	
	

}
