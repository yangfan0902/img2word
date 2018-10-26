package service;

import bean.User;

public interface UserService {
	
	User findUser(String name,String password);

	void saveUser(String name, String password);
}
