package com.dhj.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.dhj.domain.Customer;
import com.dhj.domain.Dict;
import com.dhj.domain.PageBean;
import com.dhj.service.CustomerService;
import com.dhj.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class CustomerActon extends ActionSupport implements ModelDriven<Customer>{

	private static final long serialVersionUID = -1358979309100005380L;
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public String initAdd(){
		return "initAdd";
	}
	
	/**
	 * 定义三个属性，struts注入文件
	 * private File upload;
	 * private String uploadFileName;
	 * private String uploadContentType;
	 * 
	 */
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String add() throws IOException{
		//判断是否上传了文件
		if (uploadFileName != null) {
			String uuidname = UploadUtils.getUUIDName(uploadFileName);
			// D:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\upload
			String path = "E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\upload\\";
			File file = new File(path+uuidname);
			FileUtils.copyFile(upload, file);
			customer.setFilepath(path+uuidname);
		}
		
		
		customerService.add(customer);
		return "add";
	}
	
	//属性驱动接受参数 默认值是1
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		if (currPage == null) {
			currPage =1;
		}
		this.currPage = currPage;
	}
	private Integer pageSize = 3;
	public void setPageSize(Integer pageSize) {
		if (pageSize == null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}

	/**
	 * 分页查询客户
	 * @return
	 */
	public String findByPage(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		String cust_name = customer.getCust_name();
		if (cust_name != null && !cust_name.trim().isEmpty()) {
			criteria.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		}
		Dict level = customer.getLevel();
		if (level != null && !level.getDict_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("level.dict_id", level.getDict_id()));
		}
		Dict source = customer.getSource();
		if (source != null && !source.getDict_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("source.dict_id", source.getDict_id()));
		}
		PageBean<Customer> pageBean = customerService.findByPage(currPage,pageSize,criteria);
		//压栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("pageBean", pageBean);
		return "page";
	}
	
	public String delete(){
		//先获取用户，得到路径
		customer = customerService.findById(customer.getCust_id());
		String filepath = customer.getFilepath();
		customerService.delete(customer);
		File file = new File(filepath);
		if (file.exists()) {
			file.delete();
		}
		return "delelte";
	}
	public String initUpdate(){
		customer = customerService.findById(customer.getCust_id());
		return "initUpdate";
	}
	
	public String update() throws IOException{
		//upload 是否为空，不为空，filepath是否有数据，有就删除，没有就上传文件更新到数据库，空就直接更新customer
		if (uploadFileName != null) {
			//上传了新的文件
			String oldpath = customer.getFilepath();
			if (oldpath != null && !oldpath.trim().isEmpty()) {
				File f = new File(oldpath);
				if (f.exists()) {
					f.delete();
				}
			}
			String uuidname = UploadUtils.getUUIDName(uploadFileName);
			String path = "E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\upload\\";
			File file = new File(path+uuidname);
			FileUtils.copyFile(upload, file);
			customer.setFilepath(path+uuidname);
		}
		customerService.update(customer);
		
		return "update";
	}
	

}
