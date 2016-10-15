package com.oracle.shop.index;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Scope(value="prototype")
@Controller("indexAction")
public class IndexAction extends ActionSupport {

	/**
	 * uuid
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 通过Indexaction 跳转到index.jsp
	 * 
	 */

	@Override
	public String execute() throws Exception {
		return "index";
	}

}
