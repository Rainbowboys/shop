package com.oracle.shop.admin;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("adminUserDao")
public class AdminUserDaoIMP extends HibernateDaoSupport implements AdminUserDao {

	@Resource
	public void setSessionFactoryoverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public AdminUser login(AdminUser adminUser) {
		List<AdminUser> list = (List<AdminUser>) this.getHibernateTemplate().find(
				"from AdminUser a where  a.username=? and a.password=?", adminUser.getUsername(),
				adminUser.getPassword());
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
