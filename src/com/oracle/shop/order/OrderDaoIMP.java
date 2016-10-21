package com.oracle.shop.order;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.oracle.shop.user.User;

@Repository("orderDaoIMP")
public class OrderDaoIMP extends HibernateDaoSupport implements OrderDao {
	@Resource
	public void setSessionFactoryoverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public Integer saveOrder(Order order) {
		Integer oid = (Integer) this.getHibernateTemplate().save(order);
		return oid;
	}

	@Override
	public Order findOrderByOid(Integer oid) {

		return this.getHibernateTemplate().get(Order.class, oid);
	}

	@Override
	public void updateOrder(Order currentOrder) {
		this.getHibernateTemplate().update(currentOrder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findOrderByUser(User userexsit) {
		List<Order> list = (List<Order>) this.getHibernateTemplate().find("from Order o where o.user.uid=?",
				userexsit.getUid());
		return list;
	}

	@Override
	public void removeOrder(Integer oid) {
		Order deleteorder = findOrderByOid(oid);
		if (deleteorder != null) {
			this.getHibernateTemplate().delete(deleteorder);
		}
	}

}
