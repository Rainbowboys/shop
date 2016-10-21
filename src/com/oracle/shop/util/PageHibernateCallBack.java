package com.oracle.shop.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

/**
 * @Title:PageHibernateCallBack
 * @Description:自定义封装的hibernate 分页查询
 * @author:Rainbow.huahang.com
 * @param <T>
 * @date:2016年10月16日 下午11:44:53
 */
public class PageHibernateCallBack<T> implements HibernateCallback<List<T>> {

	private String hql;// hql查询语句
	private Object[] params;// 参数
	private int startIndex;// 其实位置
	private int pageSize;// 每页显示个数

	public PageHibernateCallBack(String hql, Object[] params, int startIndex, int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> doInHibernate(Session session) throws HibernateException {
		Query query = session.createQuery(hql);
		// 循环设置查询参数
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}

		}
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		List<T> list = query.list();
		return list;
	}

}
