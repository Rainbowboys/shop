package com.oracle.shop.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.shop.util.PageBean;

@Service("productService")
@Transactional
public class ProductServiceIMP implements ProductService {
	@Resource(name = "productdao")
	private ProductDao productDao;

	@Override
	public List<Product> findHotProduct() {

		return productDao.findHotProduct();
	}

	@Override
	public List<Product> findNewProduct() {
		return productDao.findNewProduct();
	}

	@Override
	public PageBean<Product> findProductByCid(Integer cid, Integer page) {
		int pageSize = 12;
		int totalPage = 0;
		PageBean<Product> pageBean = new PageBean<>();
		pageBean.setCurrent_page(page);
		pageBean.setLimit(pageSize);
		// ×Ü¼ÇÂ¼Êý
		Integer totalCount = productDao.countProductByCid(cid);
		pageBean.setTotalCount(totalCount);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int beginPage = (page - 1) * pageSize;
		List<Product> products = productDao.findProductByPage(beginPage, pageSize, cid);
		pageBean.setList(products);
		return pageBean;
	}

}
