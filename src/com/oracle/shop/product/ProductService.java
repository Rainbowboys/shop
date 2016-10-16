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

	public PageBean<Product> findProductByCid(Integer cid, Integer page);

	

}
