package com.dhj.service;

import org.hibernate.criterion.DetachedCriteria;

import com.dhj.domain.PageBean;
import com.dhj.domain.SaleVisit;

public interface SaleVisitService {

	PageBean<SaleVisit> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria);

}
