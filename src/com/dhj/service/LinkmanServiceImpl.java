package com.dhj.service;

import org.springframework.transaction.annotation.Transactional;

import com.dhj.dao.LinkmanDao;

@Transactional
public class LinkmanServiceImpl implements LinkmanService {

	private LinkmanDao linkmanDao;
	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}
	
}
