package com.dhj.web.action;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;

import com.dhj.domain.PageBean;
import com.dhj.domain.SaleVisit;
import com.dhj.service.SaleVisitService;
import com.opensymphony.xwork2.ModelDriven;

public class SaleVisitAction extends BaseAction implements ModelDriven<SaleVisit>{

	private SaleVisit saleVisit = new SaleVisit();
	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}
	@Resource(name="saleVisitService")
	private SaleVisitService saleVisitService;
	
	public String findByPage(){
		DetachedCriteria criteria = DetachedCriteria.forClass(SaleVisit.class);
		PageBean<SaleVisit> page = saleVisitService.findByPage(this.getCurrPage(),this.getPageSize(),criteria);
		this.setVs("page", page);
		return "page";
	}
}
