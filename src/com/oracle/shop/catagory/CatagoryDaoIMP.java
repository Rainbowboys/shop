package com.oracle.shop.catagory;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("catagorydao")
public class CatagoryDaoIMP extends HibernateDaoSupport implements CatagoryDao {
	/**
	 * hibernate4 ¸øhibernateTemple ×¢ÈësessionFactory
	 * 
	 * @param sessionFactory
	 */
	@Resource
	public void setSessionFactoryoverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Catagory> findCatagory() {
		
		return (List<Catagory>) this.getHibernateTemplate().find("from Catagory");
	}

}
