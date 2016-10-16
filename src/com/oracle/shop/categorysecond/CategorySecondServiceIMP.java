package com.oracle.shop.categorysecond;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("categorySecondService")
@Transactional
public class CategorySecondServiceIMP implements CategorySecondService{
	@Resource(name="categorySeconddao")
	private CategorySecondDao categorySecondDao;

	

}
