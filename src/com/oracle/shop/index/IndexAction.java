package com.oracle.shop.index;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.shop.catagory.Catagory;
import com.oracle.shop.catagory.CatagoryService;
import com.oracle.shop.product.Product;
import com.oracle.shop.product.ProductService;

@Scope(value = "prototype")
@Controller("indexAction")
public class IndexAction extends ActionSupport {

	/**
	 * uuid
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ͨ��Indexaction ��ת��index.jsp
	 * 
	 */

	@Resource(name = "catagoryService")
	private CatagoryService catagoryService;
	@Resource(name = "productService")
	private ProductService productService;

	@Override
	public String execute() throws Exception {
		List<Catagory> catagorylist = catagoryService.findCatagory();
		ActionContext.getContext().getSession().put("catagorylist", catagorylist);

		// ��ѯ������Ʒ
		List<Product> hotProduct = productService.findHotProduct();
		ActionContext.getContext().put("hotProduct", hotProduct);

		// ��ѯ������Ʒ
		List<Product> newProduct = productService.findNewProduct();
		ActionContext.getContext().put("newProduct", newProduct);

		return "index";
	}

}
