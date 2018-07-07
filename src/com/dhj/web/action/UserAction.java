package com.dhj.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

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
	
	/**
	 * 注册用户
	 * @return
	 */
	public String regist(){
		userService.save(user);
		return LOGIN;
	}
	
	/**
	 * 根据用户名检测用户是否存在
	 * @return
	 */
	public String checkCode(){
		User u = userService.checkCode(user.getUser_code());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter writer = response.getWriter();
			if(u != null){
				writer.print("yes");
			}else {
				writer.print("no");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return NONE;
		
	}
	
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		User existUser =userService.login(user);
		if(existUser == null){
			return LOGIN;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginOK";
		}
	}
	/**
	 * 用户退出
	 * @return
	 */
	public String exit(){
		ServletActionContext.getRequest().getSession().removeAttribute("existUser");;
		return LOGIN;
	}
}
