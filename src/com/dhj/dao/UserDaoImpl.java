package com.dhj.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dhj.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	/**
	 * 根据登录名检验用户是否存在
	 */
	@Override
	public User checkCode(String user_code) {
		List<User> users = (List<User>) this.getHibernateTemplate().find("from User where user_code = ?", user_code);
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}

	/**
	 * 登录用户
	 */
	@Override
	public User login(User user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_code", user.getUser_code()));
		criteria.add(Restrictions.eq("user_password", user.getUser_password()));
		criteria.add(Restrictions.eq("user_state", "1"));
		List<User> users = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}

}
