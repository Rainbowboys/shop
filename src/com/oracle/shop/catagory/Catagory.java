package com.oracle.shop.catagory;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.oracle.shop.categorysecond.CategorySecond;

/**
 * @Title:Catagory
 * @Description:一级分类的实体类
 * @author:Rainbow.huahang.com
 * @date:2016年10月16日 下午5:01:05
 */
@Component("catagory")
public class Catagory {
	// 分类id
	private Integer cid;
	// 一级分类的名称
	private String cname;

	// 二级分类 一对多的关系

	private Set<CategorySecond> categorySecond=new HashSet<CategorySecond>();

	public Set<CategorySecond> getCategorySecond() {
		return categorySecond;
	}

	public void setCategorySecond(Set<CategorySecond> categorySecond) {
		this.categorySecond = categorySecond;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}
