package com.oracle.shop.user;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Title:UserDaoIMP
 * @Description:userdao 模板实现类
 * @author:Rainbow.huahang.com
 * @date:2016年10月15日 下午5:03:01
 */
@Repository("userdao")
public class UserDaoIMP extends HibernateDaoSupport implements UserDao {
	/**
	 * hibernate4 给hibernateTemple 注入sessionFactory
	 * 
	 * @param sessionFactory
	 */
	@Resource
	public void setSessionFactoryoverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public boolean regist(User user) {
		Serializable id = this.getHibernateTemplate().save(user);

		if (id != null) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUserBycriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	/**
	 * 根据激活码 查询用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public User findUserBycode(String code) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("code", code));
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;

	}

	/**
	 * 更新用户信息
	 */
	@Override
	public void updateUser(User user) throws Exception {
		this.getHibernateTemplate().update(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User login(User user) throws Exception {
		List<User> list = (List<User>) this.getHibernateTemplate().find(
				"from User where username=? and password=? and status=?", user.getUsername(), user.getPassword(), 1);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public User findUserByUserName(String username) throws Exception {
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where username=?", username);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
