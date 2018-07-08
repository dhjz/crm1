package com.dhj.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dhj.domain.Customer;
import com.dhj.domain.PageBean;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	/**
	 * 添加客户
	 */
	@Override
	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	/**
	 * 分页查询客户
	 */
	@Override
	public PageBean<Customer> findByPage(Integer currPage, Integer pageSize, DetachedCriteria criteria) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		//查询总条数 select count(*) from
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if (list != null && list.size()>0) {
			int totleCount = list.get(0).intValue();
			pageBean.setTotleCount(totleCount);
		}
		//查询分页数据  limit？，？ 先清空criteria,就变成select *
		criteria.setProjection(null);
		List<Customer> beanList = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, (currPage-1)*pageSize, pageSize);
		pageBean.setBeanList(beanList);
		return pageBean;
	}

	/**
	 * 根据id查询客户
	 */
	@Override
	public Customer findById(Long cust_id) {
		return this.getHibernateTemplate().get(Customer.class, cust_id);
	}

	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

}
