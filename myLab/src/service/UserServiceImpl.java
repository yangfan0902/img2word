package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.User;
import dao.ItemDao;
import dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findUser(String name, String password) {
		
		return userDao.findUser(name, password);
	}

	@Override
	public void saveUser(String name, String password) {
		userDao.saveUser(name,password);
		
	}
	
	

}
