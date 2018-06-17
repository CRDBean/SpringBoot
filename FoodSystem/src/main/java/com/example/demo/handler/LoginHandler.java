package com.example.demo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.User;
import com.example.demo.servcie.UserService;

@Controller
public class LoginHandler {

	@Autowired
	private UserService userService;

	@RequestMapping("/loginCheck.action")
	@ResponseBody
	public String loginCheck(String username, String password,HttpServletRequest request) {
		
		User user = userService.selectUser(username, password);
		
		if (user == null) {
			return "0";
		} else {
			request.getSession().setAttribute("user", user);
			return "1";
		}
	}

	@RequestMapping("/login.action")
	public String login() {
		System.out.println("login action...");
		return "/loginSuccess";

	}

	@RequestMapping("/logout.action")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("loginout action...");
		return "redirect:http://localhost:8080/";

	}

}
