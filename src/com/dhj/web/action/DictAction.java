package com.dhj.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.dhj.domain.Dict;
import com.dhj.service.DictService;
import com.dhj.utils.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DictAction extends ActionSupport implements ModelDriven<Dict>{

	private static final long serialVersionUID = 2692832555564165960L;
	private Dict dict = new Dict();
	@Override
	public Dict getModel() {
		return dict;
	}
	private DictService dictService;
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	
	public String findByCode(){
		List<Dict> list = dictService.findByCode(dict.getDict_type_code());
		String jsonString = FastJsonUtil.toJSONString(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.write_json(response, jsonString);
		return NONE;
	}
}
