package com.dhj.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dhj.domain.Dict;

public class DictDaoImpl extends HibernateDaoSupport implements DictDao {

	/**
	 * 根据类别代码查询类别
	 */
	@Override
	public List<Dict> findByCode(String dict_type_code) {
		// TODO Auto-generated method stub
		return (List<Dict>) this.getHibernateTemplate().find("from Dict where dict_type_code = ?", dict_type_code);
	}
	
}
