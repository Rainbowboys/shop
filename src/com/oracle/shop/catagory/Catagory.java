package com.oracle.shop.catagory;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.oracle.shop.categorysecond.CategorySecond;

/**
 * @Title:Catagory
 * @Description:һ�������ʵ����
 * @author:Rainbow.huahang.com
 * @date:2016��10��16�� ����5:01:05
 */
@Component("catagory")
public class Catagory {
	// ����id
	private Integer cid;
	// һ�����������
	private String cname;

	// �������� һ�Զ�Ĺ�ϵ

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
