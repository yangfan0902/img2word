package dao;

import org.apache.ibatis.annotations.Param;

import bean.User;

public interface UserDao {
	User findUserById(int i);

	User findUser(@Param("name")String name, @Param("password")String password);

	void saveUser(@Param("name")String name, @Param("password")String password);
}
