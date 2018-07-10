package com.dhj.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.dhj.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceptor extends MethodFilterInterceptor{

	private static final long serialVersionUID = -206989216698548992L;

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if (user == null) {
			return "login";
		}
		return arg0.invoke();
	}

}
