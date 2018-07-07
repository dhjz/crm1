package com.dhj.web.action;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.dhj.domain.Customer;
import com.dhj.domain.PageBean;
import com.dhj.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class CustomerActon extends ActionSupport implements ModelDriven<Customer>{

	private static final long serialVersionUID = -1358979309100005380L;
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public String add(){
		customerService.add(customer);
		return NONE;
	}
	
	//属性驱动接受参数 默认值是1
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		if (currPage == null) {
			currPage =1;
		}
		this.currPage = currPage;
	}
	private Integer pageSize = 3;
	public void setPageSize(Integer pageSize) {
		if (pageSize == null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}

	/**
	 * 分页查询客户
	 * @return
	 */
	public String findByPage(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		
		PageBean<Customer> pageBean = customerService.findByPage(currPage,pageSize,criteria);
		//压栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("pageBean", pageBean);
		return "page";
	}
	

}
