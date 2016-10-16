package com.oracle.shop.product;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.oracle.shop.util.PageHibernateCallBack;

@Repository("productdao")
public class ProductDaoIMP extends HibernateDaoSupport implements ProductDao {
	/**
	 * hibernate4 给hibernateTemple 注入sessionFactory
	 * 
	 * @param sessionFactory
	 */
	@Resource
	public void setSessionFactoryoverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 查询热门的10个商品
	 */
	@Override
	public List<Product> findHotProduct() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("is_hot", 1));
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findNewProduct() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer countProductByCid(Integer cid) {
		String hql = "select count(*) from Product p,CategorySecond cs where p.categorySecond=cs and cs.catagory.cid=?";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, cid);
		return list.get(0).intValue();
	}

	@Override
	public List<Product> findProductByPage(int beginPage, int pageSize, int cid) {
		String hql = "select p from Product p,CategorySecond cs where p.categorySecond=cs and cs.catagory.cid=? ";
		List<Product> list = this.getHibernateTemplate()
				.execute(new PageHibernateCallBack<>(hql, new Object[] { cid }, beginPage, pageSize));

		return list;
	}

}
