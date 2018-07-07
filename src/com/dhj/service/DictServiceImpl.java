package com.dhj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dhj.dao.DictDao;
import com.dhj.domain.Dict;

@Transactional
public class DictServiceImpl implements DictService {
	private DictDao dictDao;

	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	/**
	 * 根据类别代码查询
	 */
	@Override
	public List<Dict> findByCode(String dict_type_code) {
		return dictDao.findByCode(dict_type_code);
	}
	
}
