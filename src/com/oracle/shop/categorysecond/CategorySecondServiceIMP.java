package com.oracle.shop.categorysecond;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.shop.catagory.Catagory;
import com.oracle.shop.catagory.CatagoryDao;
import com.oracle.shop.util.GridBean;

@Service("categorySecondService")
@Transactional
public class CategorySecondServiceIMP implements CategorySecondService{
	@Resource(name="categorySeconddao")
	private CategorySecondDao categorySecondDao;
	@Resource(name="catagorydao")
	private CatagoryDao catagorydao;

	@Override
	public List<GridBean> findCatagorySecondByPage(Integer page, Integer rows) {
		Integer beginPage=(page-1)*rows;
		Integer endPage=beginPage+rows;
		List<CategorySecond>	catagorySecondlist=categorySecondDao.findCatagorySecondByPage(beginPage,endPage);
		List<GridBean> list = new ArrayList<>();
		GridBean gridBean = null;
		for (CategorySecond categorySecond : catagorySecondlist) {
			gridBean = new GridBean();
			gridBean.setId(categorySecond.getCsid());
			gridBean.setCsname(categorySecond.getCsname());
			gridBean.setCaid(categorySecond.getCatagory().getCid());
			list.add(gridBean);
		}
		return list ;
	}

	@Override
	public int countCatagorySecond() {
		// TODO Auto-generated method stub
		return categorySecondDao.countCatagorySecond();
	}

	@Override
	public void savecategorySecond(CategorySecond categorySecond, Integer caid) {
		Catagory catagory = catagorydao.findCatagoryByCid(caid);
		categorySecond.setCatagory(catagory);
		categorySecondDao.savecategorySecond(categorySecond);
		
	 
		
	}

	@Override
	public void updatecategorySecond(CategorySecond categorySecond, Integer caid) {
		Catagory catagory = catagorydao.findCatagoryByCid(caid);
		categorySecond.setCatagory(catagory);
		categorySecondDao.updatecategorySecond(categorySecond);
		
	}

	@Override
	public void deletecategorySecond(Integer id) {
		CategorySecond categorySecond = categorySecondDao.findcategorySecond(id);
		categorySecondDao.deletecategorySecond(categorySecond);
		 
		
	}

	

}
