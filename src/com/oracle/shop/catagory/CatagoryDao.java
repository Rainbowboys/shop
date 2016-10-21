package com.oracle.shop.catagory;

import java.util.List;

public interface CatagoryDao {
	/**
	 * 查询所有的一级分类
	 * 
	 * @return
	 */
	public List<Catagory> findCatagory();

	/**
	 * 分页查询
	 * 
	 * @param beginPage
	 * @param pageSize
	 * @return
	 */
	public List<Catagory> findCatagoryByPage(int beginPage, int pageSize);

	/**
	 * 统计记录
	 * 
	 * @return
	 */
	public int countCatagory();

	/**
	 * 修改一级分类
	 * 
	 * @param catagory
	 */
	public void updateCategory(Catagory catagory);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteCategory(Integer id);

	/**
	 * 根据 cid 查询
	 *
	 */
	public Catagory findCatagoryByCid(Integer cid);

	/**
	 * 
	 * @param catagory
	 */
	public void addCategory(Catagory catagory);

	public List<Integer> getCategoryIdList();

}
