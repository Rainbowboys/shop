package com.oracle.shop.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oracle.shop.catagory.Catagory;
import com.oracle.shop.catagory.CatagoryService;
import com.oracle.shop.categorysecond.CategorySecond;
import com.oracle.shop.categorysecond.CategorySecondService;
import com.oracle.shop.product.Product;
import com.oracle.shop.product.ProductDao;
import com.oracle.shop.product.ProductService;
import com.oracle.shop.util.PageBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext-bean.xml",
		"classpath:spring/applicationContext-hibernate.xml", "classpath:spring/applicationContext-transation.xml" })
public class TestProduct {

	@Resource(name = "productService")
	private ProductService productService;
	@Resource(name = "catagoryService")
	private CatagoryService catagoryService;
	@Resource(name="productdao")
	private ProductDao productdao;
	@Resource(name="categorySecondService")
	private CategorySecondService categorySecondService;

	@Test
	public void testGetCategory() throws Exception {
		List<Catagory> list = catagoryService.findCatagory();
		for (Catagory catagory : list) {
			for (CategorySecond categorySecond : catagory.getCategorySecond()) {
				for (Product product : categorySecond.getProducts()) {
					System.out.println(product.getPname());
				}
			}
		}
	}

	@Test
	public void tesCountProductByCid() {
		productService.findProductByCid(1, 1);
	}

	@Test
	public void testGetProductByPage() {
		@SuppressWarnings("unused")
		PageBean<Product> pageBean = productService.findProductByCid(1, 1);
		System.out.println("ok");

	}
	@Test
	public void testGetProductByPid() {
		@SuppressWarnings("unused")
	 	Product product= productService.findProductByPid(1);
		System.out.println(product);
		
	}
	@Test
	public void testGetCountByCsid() {
		@SuppressWarnings("unused")
		Integer count = productdao.countProductByCsid(1);
		System.out.println(count);
		
	}
	@Test
	public void testGetPageBeanByCsid() {
		@SuppressWarnings("unused")
		PageBean<Product> pageBean= productService.findProductBycsid(1, 1);
		System.out.println(pageBean);
	}
	
	@Test
	public void testDelete(){
		categorySecondService.deletecategorySecond(40);
		
	}

}
