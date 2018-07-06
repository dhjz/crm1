package com.dhj.web.action;

import com.dhj.domain.User;
import com.dhj.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private static final long serialVersionUID = -7536901963972430826L;
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String regist(){
		userService.save(user);
		return NONE;
	}
	
	public String checkCode(){
		
		return NONE;
		
	}
}
