package com.dhj.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.dhj.domain.Customer;
import com.dhj.domain.Linkman;
import com.dhj.domain.PageBean;
import com.dhj.service.LinkmanService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkmanAction extends BaseAction implements ModelDriven<Linkman>{

	private static final long serialVersionUID = 1570876933995351321L;
	private Linkman linkman = new Linkman();
	@Override
	public Linkman getModel() {
		// TODO Auto-generated method stub
		return linkman;
	}
	private LinkmanService linkmanService;
	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}
	
	public String findByPage(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class); 
		String lkm_name = linkman.getLkm_name();
		if (lkm_name != null && !lkm_name.trim().isEmpty()) {
			criteria.add(Restrictions.like("lkm_name", "%"+lkm_name+"%"));
		}
		Customer customer = linkman.getCustomer();
		if (customer != null && customer.getCust_id() != null) {
			criteria.add(Restrictions.eq("customer.cust_id", customer.getCust_id()));
		}
		PageBean<Linkman> page = linkmanService.findByPage(this.getCurrPage(),this.getPageSize(),criteria);
		this.setVs("page", page);
		return "page";
	}
	

}
