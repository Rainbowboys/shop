package com.oracle.shop.categorysecond;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.oracle.shop.catagory.Catagory;
import com.oracle.shop.product.Product;

/**
 * @Title:CategorySecond
 * @Description:二级分类实体类
 * @author:Rainbow.huahang.com
 * @date:2016年10月16日 下午5:01:05
 */
@Component("categorySecond")
public class CategorySecond {
	// 二级分类id
	private Integer csid;

	// 二级分类名称
	private String csname;

	// 一级分类
	private Catagory catagory;

	// 一对多 商品 关联
	private Set<Product> products=new HashSet<Product>();

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
