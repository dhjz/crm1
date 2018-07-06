package com.dhj.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dhj.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

}
