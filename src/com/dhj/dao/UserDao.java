package com.dhj.dao;

import com.dhj.domain.User;

public interface UserDao {

	void save(User user);

	User checkCode(String user_code);

	User login(User user);

}
