package com.oracle.shop.product;

import java.util.List;

import com.oracle.shop.util.PageBean;

public interface ProductService {

	/**
	 * ��ѯ������Ʒ
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
	 * ���ݷ���id ��ѯ�������Ʒ
	 * 
	 * @param cid
	 * @param page
	 * @return
	 */
	public PageBean<Product> findProductByCid(Integer cid, Integer page);

	/**
	 * ������Ʒpid ��ѯ��Ʒ����
	 * 
	 * @param pid
	 * @return
	 */
	public Product findProductByPid(Integer pid);

	/**
	 * ������Ʒcsid ��ѯ��Ʒ
	 * @param csid
	 * @param page
	 * @return
	 */
	public PageBean<Product> findProductBycsid(Integer csid, Integer page);

}
