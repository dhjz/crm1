package com.dhj.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dhj.domain.PageBean;
@SuppressWarnings("all")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	private Class clazz;
	public  BaseDaoImpl(){
		Class c = this.getClass();
		Type type = c.getSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType ptype = (ParameterizedType) type;
			Type[] types = ptype.getActualTypeArguments();
			this.clazz = (Class) types[0];
		}
	}
	/**
	 * 添加
	 */
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	/**
	 * 删除
	 */
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	/**
	 * 修改
	 */
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	/**
	 * 根据主键查询
	 */
	public T findById(Long id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	/**
	 * 根据主键查询
	 */
	public T findById(String id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	/**
	 * 查询所有
	 */
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+clazz.getSimpleName());
	}

	/**
	 * 分页查询
	 */
	public PageBean<T> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria) {
		PageBean<T> page = new PageBean<T>();
		page.setCurrPage(currPage);
		page.setPageSize(pageSize);
		//查询总数；
		criteria.setProjection(Projections.rowCount());
		List<Number> num = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if (num !=null && num.size()>0) {
			int totleCount = num.get(0).intValue();
			page.setTotleCount(totleCount);
		}
		criteria.setProjection(null);
		List<T> beanList = (List<T>) this.getHibernateTemplate().findByCriteria(criteria, (currPage-1)*pageSize, pageSize);
		page.setBeanList(beanList);
		return page;
	}

}
