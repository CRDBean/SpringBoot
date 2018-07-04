package com.example.demo.servcieImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.UserExample;
import com.example.demo.entity.UserExample.Criteria;
import com.example.demo.servcie.IUserService;

@Service
public class UserService implements IUserService{
	
	
	@Autowired
	private UserMapper userDao;
	
	
	public User selectUser(String username,String password){
		UserExample example=new UserExample();
		Criteria c=example.createCriteria();
		c.andUsernameEqualTo(username);
		c.andPasswordEqualTo(password);
		List<User> users=new ArrayList<User>();
		users=userDao.selectByExample(example);
		if(users.size()>0){
			return users.get(0);
		}else{
			return null;
		}
		
	}

}
