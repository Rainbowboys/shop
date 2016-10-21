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

	/**
	 * 根据分类id 查询分类的商品
	 * 
	 * @param cid
	 * @param page
	 * @return
	 */
	public PageBean<Product> findProductByCid(Integer cid, Integer page);

	/**
	 * 根据商品pid 查询商品详情
	 * 
	 * @param pid
	 * @return
	 */
	public Product findProductByPid(Integer pid);

	/**
	 * 根据商品csid 查询商品
	 * @param csid
	 * @param page
	 * @return
	 */
	public PageBean<Product> findProductBycsid(Integer csid, Integer page);

}
