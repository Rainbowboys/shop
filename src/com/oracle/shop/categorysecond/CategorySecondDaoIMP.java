package com.oracle.shop.categorysecond;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<CategorySecond> findCatagorySecondByPage(Integer beginPage, Integer endPage) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CategorySecond.class);
		List<CategorySecond> list = (List<CategorySecond>) this.getHibernateTemplate().findByCriteria(criteria,
				beginPage, endPage);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int countCatagorySecond() {

		List<Long> list = (List<Long>) this.getHibernateTemplate().find("select count(*) from CategorySecond");
		return list.get(0).intValue();
	}

	@Override
	public void savecategorySecond(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}

	@Override
	public void updatecategorySecond(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CategorySecond findcategorySecond(Integer id) {
		List<CategorySecond> list = (List<CategorySecond>) this.getHibernateTemplate()
				.find("from CategorySecond cs where cs.csid=?", id);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void deletecategorySecond(CategorySecond categorySecond) {
		categorySecond.getProducts().clear();
		categorySecond.setProducts(null);
		this.getHibernateTemplate().delete(categorySecond);
	}

}
