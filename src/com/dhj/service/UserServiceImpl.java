package com.dhj.service;

import org.springframework.transaction.annotation.Transactional;

import com.dhj.dao.UserDao;
import com.dhj.domain.User;
import com.dhj.utils.MD5Utils;

@Transactional
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void save(User user) {
		String pwd = user.getUser_password();
		user.setUser_password(MD5Utils.md5(pwd));
		user.setUser_state("1");
		userDao.save(user);
	}
	
}
