package com.dhj.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.dhj.domain.PageBean;

public interface BaseDao<T> {

	public void add(T t);
	
	public void delete(T t);
	
	public void update(T t);
	
	public T findById(Long id);
	
	public T findById(String id);
	
	public List<T> findAll();
	
	public PageBean<T> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria);
}
