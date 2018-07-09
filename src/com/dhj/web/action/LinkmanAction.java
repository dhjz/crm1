package com.dhj.web.action;

import com.dhj.domain.Linkman;
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
	

}
