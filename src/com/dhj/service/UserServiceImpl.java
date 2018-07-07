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
	/**
	 * 保存客户
	 */
	@Override
	public void save(User user) {
		String pwd = user.getUser_password();
		user.setUser_password(MD5Utils.md5(pwd));
		user.setUser_state("1");
		userDao.save(user);
	}
	/**
	 * 根据登录名检验用户是否存在
	 */
	@Override
	public User checkCode(String user_code) {
		return userDao.checkCode(user_code);
	}
	/**
	 * 登录用户
	 */
	@Override
	public User login(User user) {
		String pwd = user.getUser_password();
		user.setUser_password(MD5Utils.md5(pwd));
		return userDao.login(user);
	}
	
}
