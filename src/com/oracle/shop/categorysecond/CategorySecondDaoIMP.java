package com.oracle.shop.categorysecond;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("categorySeconddao")
public class CategorySecondDaoIMP extends HibernateDaoSupport implements CategorySecondDao {
	/**
	 * hibernate4 ¸øhibernateTemple ×¢ÈësessionFactory
	 * 
	 * @param sessionFactory
	 */
	@Resource
	public void setSessionFactoryoverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}


}
