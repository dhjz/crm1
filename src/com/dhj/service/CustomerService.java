package com.dhj.service;

import org.hibernate.criterion.DetachedCriteria;

import com.dhj.domain.Customer;
import com.dhj.domain.PageBean;

public interface CustomerService {

	void add(Customer customer);

	PageBean<Customer> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria);

}
