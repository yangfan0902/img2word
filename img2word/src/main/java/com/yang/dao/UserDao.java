package com.yang.dao;

import org.springframework.stereotype.Repository;

import pojo.User;
@Repository
public interface UserDao {
	public void update(User user);
	public User getUserById(int id);
	public void deleteUser(int id);
}
