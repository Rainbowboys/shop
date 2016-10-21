package com.oracle.shop.catagory;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Catagory> findCatagoryByPage(int beginPage, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Catagory.class);
		List<Catagory> list = (List<Catagory>) this.getHibernateTemplate().findByCriteria(criteria, beginPage,
				beginPage + pageSize);
		return list;
	}

	@Override
	public int countCatagory() {
		List<Long> count = (List<Long>) this.getHibernateTemplate().find("select count(*) from Catagory");
		return count.get(0).intValue();
	}

	@Override
	public void updateCategory(Catagory catagory) {
		this.getHibernateTemplate().update(catagory);
	}

	@Override
	public void deleteCategory(Integer id) {
		Catagory catagory = findCatagoryByCid(id);
		if (catagory != null) {
			this.getHibernateTemplate().delete(catagory);
		}
	}

	@Override
	public Catagory findCatagoryByCid(Integer cid) {
		Catagory catagory = this.getHibernateTemplate().get(Catagory.class, cid);
		return catagory;
	}

	@Override
	public void addCategory(Catagory catagory) {
		this.getHibernateTemplate().save(catagory);

	}

	@Override
	public List<Integer> getCategoryIdList() {
		// TODO Auto-generated method stub
		return (List<Integer>) this.getHibernateTemplate().find("select c.cid from Catagory c");
	}

}
