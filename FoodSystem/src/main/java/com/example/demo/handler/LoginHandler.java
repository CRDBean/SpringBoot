package com.example.demo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.servcieImpl.UserService;

@Controller
public class LoginHandler {

	@Autowired
	private UserService userService;

	/*
	 * @RequestMapping("/loginCheck.action")
	 * 
	 * @ResponseBody public String loginCheck(String username, String
	 * password,HttpServletRequest request) {
	 * 
	 * User user = userService.selectUser(username, password);
	 * 
	 * if (user == null) { return "0"; } else {
	 * request.getSession().setAttribute("user", user); return "1"; } }
	 */

	@RequestMapping("/login.action")
	public String login(String username, String password, HttpServletRequest request) {
		System.out.println("login action...");
		User user = userService.selectUser(username, password);

		if (user == null) {
			request.setAttribute("error", "用户名名或者密码错误！！！");
			request.getSession().setAttribute("loginError", "用户名名或者密码错误！！！");
			return "/index";
		} else {
			request.getSession().setAttribute("user", user);
			request.getSession().removeAttribute("loginError");
			return "/loginSuccess";
		}

	}

	@RequestMapping("/index.action")
	public String index() {
		System.out.println("loginHtml action...");
		return "/index";

	}

	@RequestMapping("/logout.action")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("loginout action...");
		return "/index";

	}

}
