package com.oracle.shop.catagory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.oracle.shop.util.GridJSON;

/**
 * @Title:Catagory
 * @Description:一级分类的实体类
 * @author:Rainbow.huahang.com
 * @date:2016年10月16日 下午5:01:05
 */
@Scope(value = "prototype")
@Controller(value = "catagoryAction")
public class CatagoryAction extends ActionSupport implements ModelDriven<Catagory> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3704695814002944899L;

	private Catagory catagory = new Catagory();

	private Integer rows;
	private Integer page;
	private Boolean _search;
	private String oper;
	private String id;

	public void setId(String id) {
		this.id = id;
		if (!id.equals("_empty")) {

			this.catagory.setCid(Integer.parseInt(id));
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

	@Override
	public Catagory getModel() {
		return catagory;
	}

	@Resource(name = "catagoryService")
	private CatagoryService catagoryService;

	public String findCategoryPage() {
		return "categoryPage";

	}

	/**
	 * 分页查询
	 * 
	 * @throws Exception
	 */
	public void findAllCategory() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		List<Catagory> catagorylist = catagoryService.findCatagoryByPage(page, rows);
		// List<Catagory> catagorylist = catagoryService.findCatagory();
		// 总记录数
		int records = catagoryService.countCatagory();
		;
		// 总页数
		int total = (records - 1) / rows + 1;
		GridJSON gridJSON = new GridJSON(page, total, records, catagorylist);
		PrintWriter pw = response.getWriter();
		pw.write(JSON.toJSONString(gridJSON));
		pw.flush();
		pw.close();
	}

	/**
	 * 修改一级状态
	 */

	public void editCategory() {
		if (oper.equals("del")) {
			catagoryService.deleteCategory(Integer.parseInt(id));
		} else if (oper.equals("edit")) {
			catagoryService.updateCategory(catagory);
		} else if (oper.equals("add")) {
			catagoryService.addCategory(catagory);
		}
	}

	/**
	 * 获取一级分类的id
	 * 
	 * @throws IOException
	 */
	public void getCategoryList() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		List<Integer> list =catagoryService.getCategoryIdList();
		StringBuffer sb = new StringBuffer();
		sb.append("<select>");
		for (Integer integer : list) {
			sb.append("<option value=" + integer + ">" + integer + "</option>");
		}
		sb.append("</select>");

		PrintWriter pw = response.getWriter();
		pw.write(sb.toString());
		pw.flush();
		pw.close();
	}
}
