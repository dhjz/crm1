package com.dhj.domain;

import java.util.List;

public class PageBean<T> {
	
	//当前页  传值
	private int currPage;
	//总条数  查询
	private int totleCount;
	//总页数
	private int totlePage;
	//每页数量  设置
	private int pageSize;
	//每页数据 查询
	private List<T> beanList;
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotleCount() {
		return totleCount;
	}
	public void setTotleCount(int totleCount) {
		this.totleCount = totleCount;
	}
	/**
	 * 通过计算得到总页数
	 * @return
	 */
	public int getTotlePage() {
		if (totleCount % pageSize == 0) {
			return totleCount/pageSize;
		}else{
			return totleCount/pageSize+1;
		}
	}
	/*public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}*/
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
}
