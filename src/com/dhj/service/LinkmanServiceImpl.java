package com.dhj.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.dhj.dao.LinkmanDao;
import com.dhj.domain.Linkman;
import com.dhj.domain.PageBean;

@Transactional
public class LinkmanServiceImpl implements LinkmanService {

	private LinkmanDao linkmanDao;
	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}
	/**
	 * 分页查找所有联系人
	 */
	public PageBean<Linkman> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return (PageBean<Linkman>) linkmanDao.findByPage(currPage, pageSize, criteria);
	}
	
}
