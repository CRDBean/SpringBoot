package com.example.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice 
/**
 * 全局异常捕捉类，出现异常后跳转打error.html
 * @author 柴火
 *
 */
public class AllExceptionController {
	
	 @ExceptionHandler(value=Exception.class)  
	   
	    public String exception(Exception e){  
	        //return "处理错误！";  
		 return "/error";
	    } 

}
