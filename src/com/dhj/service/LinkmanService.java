package com.dhj.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.dhj.domain.Linkman;
import com.dhj.domain.PageBean;

public interface LinkmanService {

	PageBean<Linkman> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria);

}
