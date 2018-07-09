package com.dhj.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = -7012687741758088254L;
	
	//属性驱动接受参数 默认值是1
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		if (currPage == null) {
			currPage =1;
		}
		this.currPage = currPage;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	private Integer pageSize = 3;
	public void setPageSize(Integer pageSize) {
		if (pageSize == null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setVs(String key,Object obj){
		ActionContext.getContext().getValueStack().set(key, obj);
	}
	public void pushVs(Object obj){
		ActionContext.getContext().getValueStack().push(obj);
	}
	
}
