package com.oracle.shop.product;

import java.util.List;

import com.oracle.shop.util.PageBean;

public interface ProductService {
	/**
	 * 查询热门商品
	 * 
	 * @return
	 */
	public List<Product> findHotProduct();

	/**
	 * 查询 10件最新商品 按时间排序
	 * 
	 */

	public List<Product> findNewProduct();

	public PageBean<Product> findProductByCid(Integer cid, Integer page);

	

}
