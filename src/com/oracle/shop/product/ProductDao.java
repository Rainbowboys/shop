package com.oracle.shop.product;

import java.util.List;

public interface ProductDao {
	/**
	 * 查询热门商品 10 件
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
	 * 根据 cid查询一级分类下的总记录数
	 * 
	 * @param cid
	 * @return
	 */
	public Integer countProductByCid(Integer cid);

	/**
	 * 分页查询商品
	 * 
	 * @param beginPage
	 * @param pageSize
	 * @return
	 */

	public List<Product> findProductByPage(int beginPage, int pageSize, int cid);

	/**
	 * 根据商品pid 查询商品详情
	 * 
	 * @param pid
	 * @return
	 */
	public Product findProductByPid(Integer pid);

	/**
	 * 根据csid 查询商品数量
	 * 
	 * @param csid
	 * @return
	 */
	public Integer countProductByCsid(Integer csid);

	/**
	 * 根据csid 查询商品
	 * @param beginPage
	 * @param pageSize
	 * @param csid
	 * @return
	 */
	public List<Product> findProductByPageAndCsId(int beginPage, int pageSize, Integer csid);

}
