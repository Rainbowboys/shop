package com.oracle.shop.categorysecond;

import java.util.List;

import com.oracle.shop.util.GridBean;

public interface CategorySecondService {

	List<GridBean>  findCatagorySecondByPage(Integer page, Integer rows);

	int countCatagorySecond();

	void savecategorySecond(CategorySecond categorySecond, Integer caid);

	void updatecategorySecond(CategorySecond categorySecond, Integer caid);

	void deletecategorySecond(Integer id);


}
