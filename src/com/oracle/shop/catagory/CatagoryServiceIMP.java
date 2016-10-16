package com.oracle.shop.catagory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("catagoryService")
@Transactional
public class CatagoryServiceIMP implements CatagoryService{
	@Resource(name="catagorydao")
	private CatagoryDao catagoryDao;

	@Override
	public List<Catagory> findCatagory() throws Exception {
		return catagoryDao.findCatagory();
	}
	
	

}
