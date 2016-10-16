package com.oracle.shop.categorysecond;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.oracle.shop.catagory.Catagory;
import com.oracle.shop.product.Product;

/**
 * @Title:CategorySecond
 * @Description:��������ʵ����
 * @author:Rainbow.huahang.com
 * @date:2016��10��16�� ����5:01:05
 */
@Component("categorySecond")
public class CategorySecond {
	// ��������id
	private Integer csid;

	// ������������
	private String csname;

	// һ������
	private Catagory catagory;

	// һ�Զ� ��Ʒ ����
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
