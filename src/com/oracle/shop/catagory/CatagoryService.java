package com.oracle.shop.catagory;

import java.util.ArrayList;
import java.util.List;

public interface CatagoryService {

	public List<Catagory> findCatagory() throws Exception;

	/**
	 * 分页查询
	 */
	public List<Catagory> findCatagoryByPage(int current_Page, int pageSize);

	/**
	 * 统计总记录数
	 */
	public int countCatagory();

	/**
	 * 修改
	 * 
	 * @param catagory
	 */
	public void updateCategory(Catagory catagory);

	/**
	 * 
	 * @param id
	 */
	public void deleteCategory(Integer id);

	/**
	 * 添加
	 * @param catagory
	 */
	public void addCategory(Catagory catagory);

	public List<Integer> getCategoryIdList();

}
