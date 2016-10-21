package com.oracle.shop.categorysecond;

import java.util.List;

public interface CategorySecondDao {
	/**
	 * ��ҳ��ѯ
	 * 
	 * @param beginPage
	 * @param endPage
	 * @return
	 */
	List<CategorySecond> findCatagorySecondByPage(Integer beginPage, Integer endPage);

	/**
	 * �ܼ�¼��
	 * 
	 * @return
	 */
	int countCatagorySecond();

	void savecategorySecond(CategorySecond categorySecond);

	void updatecategorySecond(CategorySecond categorySecond);

	CategorySecond findcategorySecond(Integer id);

	void deletecategorySecond(CategorySecond categorySecond);

}
