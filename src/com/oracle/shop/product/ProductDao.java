package com.oracle.shop.product;

import java.util.List;

public interface ProductDao {
	/**
	 * ��ѯ������Ʒ 10 ��
	 * 
	 * @return
	 */
	public List<Product> findHotProduct();

	/**
	 * ��ѯ 10��������Ʒ ��ʱ������
	 * 
	 */

	public List<Product> findNewProduct();

	/**
	 * ���� cid��ѯһ�������µ��ܼ�¼��
	 * 
	 * @param cid
	 * @return
	 */
	public Integer countProductByCid(Integer cid);

	/**
	 * ��ҳ��ѯ��Ʒ
	 * 
	 * @param beginPage
	 * @param pageSize
	 * @return
	 */

	public List<Product> findProductByPage(int beginPage, int pageSize,int cid);

}
