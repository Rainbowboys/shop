package com.oracle.shop.util;

import java.util.List;

/**
 * @Title:PageBean
 * @Description:��ҳ��ʾ
 * @author:Rainbow.huahang.com
 * @date:2016��10��16�� ����10:50:08
 */
public class PageBean<T> {

	private Integer limit;// ÿҳ��ʾ����
	private Integer current_page;// ��ǰҳ
	private Integer totalCount;// �ܼ�¼��
	private Integer totalPage;// ��ҳ��
	private List<T> list;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(Integer current_page) {
		this.current_page = current_page;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
