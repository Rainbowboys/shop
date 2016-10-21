package com.oracle.shop.categorysecond;

import java.util.List;

public interface CategorySecondDao {
	/**
	 * 分页查询
	 * 
	 * @param beginPage
	 * @param endPage
	 * @return
	 */
	List<CategorySecond> findCatagorySecondByPage(Integer beginPage, Integer endPage);

	/**
	 * 总记录数
	 * 
	 * @return
	 */
	int countCatagorySecond();

	void savecategorySecond(CategorySecond categorySecond);

	void updatecategorySecond(CategorySecond categorySecond);

	CategorySecond findcategorySecond(Integer id);

	void deletecategorySecond(CategorySecond categorySecond);

}
