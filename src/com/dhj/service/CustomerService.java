package com.dhj.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.dhj.domain.Customer;
import com.dhj.domain.PageBean;

public interface CustomerService {

	void add(Customer customer);

	PageBean<Customer> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria);

	Customer findById(Long cust_id);

	void delete(Customer customer);

	void update(Customer customer);

	List<Customer> findAll();

}
