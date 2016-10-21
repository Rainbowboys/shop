package com.oracle.shop.categorysecond;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.oracle.shop.catagory.Catagory;
import com.oracle.shop.util.GridBean;
import com.oracle.shop.util.GridJSON;

/**
 * @Title:Catagory
 * @Description:一级分类的实体类
 * @author:Rainbow.huahang.com
 * @date:2016年10月16日 下午5:01:05
 */
@Scope(value = "prototype")
@Controller(value = "categorySecondAction")
public class CategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3704695814002944899L;
	@Resource(name = "categorySecond")
	private CategorySecond categorySecond;;

	@Override
	public CategorySecond getModel() {
		return categorySecond;
	}

	@Resource(name = "categorySecondService")
	private CategorySecondService categorySecondService;
	private Integer rows;
	private Integer page;
	private Boolean _search;
	private String oper;
	private String id;
	private Integer caid;

	public void setCaid(Integer caid) {
		this.caid = caid;
	}

	public void setId(String id) {
		this.id = id;
		if (!id.equals("_empty")) {
			this.categorySecond.setCsid(Integer.parseInt(id));
		}

	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void set_search(Boolean _search) {
		this._search = _search;
	}

	/**
	 * 跳转Action
	 */

	public String categorySecondPage() {
		return "categorysecondPage";
	}

	/**
	 * 查询分页
	 * 
	 * @throws IOException
	 */

	public void findCategorySecondByPage() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		List<GridBean> list = categorySecondService.findCatagorySecondByPage(page, rows);

		// 总记录数
		int records = categorySecondService.countCatagorySecond();

		// 总页数
		int total = (records - 1) / rows + 1;
		GridJSON gridJSON = new GridJSON(page, total, records, list);
		PrintWriter pw = response.getWriter();
		pw.write(JSON.toJSONString(gridJSON));
		pw.flush();
		pw.close();
	}

	public void operCategorySecond() {
		if ("add".equals(oper)) {
			// 添加二级分类
			categorySecondService.savecategorySecond(categorySecond, caid);
		} else if ("edit".equals(oper)) {
			categorySecondService.updatecategorySecond(categorySecond, caid);
		} else if ("del".equals(oper)) {
			categorySecondService.deletecategorySecond(Integer.parseInt(id));

		}

	}
}
