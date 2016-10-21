package com.oracle.shop.catagory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("catagoryService")
@Transactional
public class CatagoryServiceIMP implements CatagoryService {
	@Resource(name = "catagorydao")
	private CatagoryDao catagoryDao;

	@Override
	public List<Catagory> findCatagory() throws Exception {
		return catagoryDao.findCatagory();
	}

	/**
	 * ∑÷“≥≤È—Ø
	 */

	@Override
	public List<Catagory> findCatagoryByPage(int current_Page, int pageSize) {
		int beginPage=(current_Page-1)*pageSize;
		return catagoryDao.findCatagoryByPage(beginPage,pageSize);
		
	}

	@Override
	public int countCatagory() {
		// TODO Auto-generated method stub
		return catagoryDao.countCatagory();
	}

	@Override
	public void updateCategory(Catagory catagory) {
		catagoryDao.updateCategory(catagory);
	
		
	}

	@Override
	public void deleteCategory(Integer id) {
		catagoryDao.deleteCategory(id);
		
	}

	@Override
	public void addCategory(Catagory catagory) {
		catagoryDao.addCategory(catagory);
	}

	@Override
	public List<Integer> getCategoryIdList() {
		// TODO Auto-generated method stub
		return catagoryDao.getCategoryIdList();
	}

}
