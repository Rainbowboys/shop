package com.oracle.shop.catagory;

import java.util.ArrayList;
import java.util.List;

public interface CatagoryService {

	public List<Catagory> findCatagory() throws Exception;

	/**
	 * ��ҳ��ѯ
	 */
	public List<Catagory> findCatagoryByPage(int current_Page, int pageSize);

	/**
	 * ͳ���ܼ�¼��
	 */
	public int countCatagory();

	/**
	 * �޸�
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
	 * ���
	 * @param catagory
	 */
	public void addCategory(Catagory catagory);

	public List<Integer> getCategoryIdList();

}
