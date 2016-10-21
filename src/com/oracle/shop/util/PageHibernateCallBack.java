package com.oracle.shop.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

/**
 * @Title:PageHibernateCallBack
 * @Description:�Զ����װ��hibernate ��ҳ��ѯ
 * @author:Rainbow.huahang.com
 * @param <T>
 * @date:2016��10��16�� ����11:44:53
 */
public class PageHibernateCallBack<T> implements HibernateCallback<List<T>> {

	private String hql;// hql��ѯ���
	private Object[] params;// ����
	private int startIndex;// ��ʵλ��
	private int pageSize;// ÿҳ��ʾ����

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
		// ѭ�����ò�ѯ����
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
