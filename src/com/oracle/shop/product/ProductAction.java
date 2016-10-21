package com.oracle.shop.product;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.oracle.shop.catagory.Catagory;
import com.oracle.shop.catagory.CatagoryService;
import com.oracle.shop.util.PageBean;

/**
 * @Title:Catagory
 * @Description:һ�������ʵ����
 * @author:Rainbow.huahang.com
 * @date:2016��10��16�� ����5:01:05
 */
@Scope(value = "prototype")
@Controller(value = "productAction")
public class ProductAction extends ActionSupport implements ModelDriven<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3704695814002944899L;
	// һ������id
	@SuppressWarnings("unused")
	private Integer cid;
	@SuppressWarnings("unused")
	private Integer page;
	private Product product = new Product();
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private Integer csid;// ��������id

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}

	@Resource(name = "productService")
	private ProductService productService;
	@Resource(name = "catagoryService")
	private CatagoryService catagoryService;

	/**
	 * ����һ�������ѯ��Ʒ
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public String findProductBycid() throws Exception {
		// ��ѯ����һ������

		if (session.get("catagorylists") == null) {
			List<Catagory> catagorylists = catagoryService.findCatagory();
			session.put("catagorylists", catagorylists);
		}

		// ��ҳ��ѯ��Ʒ
		PageBean<Product> products = productService.findProductByCid(cid, page);
		ActionContext.getContext().put("pagebean", products);
		return "findProductBycid";
	}

	/**
	 * ������Ʒid ��ѯ��Ʒ����
	 * 
	 * @throws Exception
	 * 
	 */
	public String findProductByPid() throws Exception {

		if (session.get("catagorylists") == null) {
			List<Catagory> catagorylists = catagoryService.findCatagory();
			session.put("catagorylists", catagorylists);
		}

		Product productdesc = productService.findProductByPid(product.getPid());
		ActionContext.getContext().put("productdesc", productdesc);
		return "productdesc";
	}

	/**
	 * ���� ��������csid ��ѯ ��Ʒ
	 * 
	 * @throws Exception
	 */

	public String findProductBycsid() throws Exception {
		if (session.get("catagorylists") == null) {
			List<Catagory> catagorylists = catagoryService.findCatagory();
			session.put("catagorylists", catagorylists);
		}
		PageBean<Product> products=	productService.findProductBycsid(csid,page);
		ActionContext.getContext().put("pagebeanBycsid", products);
		return "productbycsid";

	}

}
