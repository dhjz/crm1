package com.dhj.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.dhj.dao.CustomerDao;
import com.dhj.domain.Customer;
import com.dhj.domain.PageBean;

@Transactional
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	/**
	 * 添加客户
	 */
	@Override
	public void add(Customer customer) {
		customerDao.add(customer);
	}
	/**
	 * 分页查询客户
	 */
	@Override
	public PageBean<Customer> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria) {
		return customerDao.findByPage(currPage, pageSize, criteria);
	}
	/**
	 * 根据id查询客户
	 */
	@Override
	public Customer findById(Long cust_id) {
		return customerDao.findById(cust_id);
	}
	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}
	
}
