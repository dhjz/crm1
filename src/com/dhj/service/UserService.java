package com.dhj.service;

import com.dhj.domain.User;

public interface UserService {

	void save(User user);

	User checkCode(String user_code);

	User login(User user);

}
