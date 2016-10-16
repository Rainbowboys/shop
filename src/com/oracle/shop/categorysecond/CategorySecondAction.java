package com.oracle.shop.categorysecond;

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
@Controller(value="categorySecondAction")
public class CategorySecondAction extends ActionSupport  implements ModelDriven<CategorySecond>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3704695814002944899L;
	@Resource(name="categorySecond")
	private CategorySecond categorySecond;;

	@Override
	public CategorySecond getModel() {
		return categorySecond;
	}
	
	@Resource(name="categorySecondService")
	private CategorySecondService categorySecondService;
	

}
