package com.dhj.service;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.dhj.dao.SaleVisitDao;
import com.dhj.domain.PageBean;
import com.dhj.domain.SaleVisit;

@Transactional
public class SaleVisitServiceImpl implements SaleVisitService {
	
	@Resource(name="saleVisitDao")
	private SaleVisitDao saleVisitDao;

	@Override
	public PageBean<SaleVisit> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria) {
		return saleVisitDao.findByPage(currPage, pageSize, criteria);
	}
}
