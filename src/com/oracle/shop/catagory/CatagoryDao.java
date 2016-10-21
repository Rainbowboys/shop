package com.oracle.shop.catagory;

import java.util.List;

public interface CatagoryDao {
	/**
	 * ��ѯ���е�һ������
	 * 
	 * @return
	 */
	public List<Catagory> findCatagory();

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param beginPage
	 * @param pageSize
	 * @return
	 */
	public List<Catagory> findCatagoryByPage(int beginPage, int pageSize);

	/**
	 * ͳ�Ƽ�¼
	 * 
	 * @return
	 */
	public int countCatagory();

	/**
	 * �޸�һ������
	 * 
	 * @param catagory
	 */
	public void updateCategory(Catagory catagory);

	/**
	 * ɾ��
	 * 
	 * @param id
	 */
	public void deleteCategory(Integer id);

	/**
	 * ���� cid ��ѯ
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
