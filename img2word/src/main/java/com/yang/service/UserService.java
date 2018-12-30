package com.yang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.dao.UserDao;

import pojo.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public User selectUser(int id){
		return userDao.getUserById(id);
	}
	
}
