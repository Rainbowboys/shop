package com.oracle.shop.catagory;

import java.util.List;

public interface CatagoryDao {
	/**
	 * 查询所有的一级分类
	 * @return
	 */
	public List<Catagory> findCatagory();

}
