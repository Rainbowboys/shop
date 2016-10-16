package com.oracle.shop.catagory;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @Title:Catagory
 * @Description:一级分类的实体类
 * @author:Rainbow.huahang.com
 * @date:2016年10月16日 下午5:01:05
 */
@Scope(value="prototype")
@Controller(value="catagoryAction")
public class CatagoryAction extends ActionSupport  implements ModelDriven<Catagory>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3704695814002944899L;
	
	private Catagory catagory=new Catagory();

	@Override
	public Catagory getModel() {
		return catagory;
	}
	
	@Resource(name="catagoryService")
	private CatagoryService catagoryService;
	

}
