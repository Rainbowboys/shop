package com.oracle.shop.admin;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.oracle.shop.util.Contains;

@Scope(value = "prototype")
@Controller("adminUserAction")
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8791609399773772427L;
	@Resource(name = "adminUserServcie")
	private AdminUserService adminUserService;
	private AdminUser adminUser = new AdminUser();

	@Override
	public AdminUser getModel() {
		return adminUser;
	}

	/**
	 * 后台用户登录
	 */
	public String login() {
		AdminUser existUser = adminUserService.login(adminUser);
		//登陆失败
		if(existUser==null){
			ActionContext.getContext().getValueStack().set("loginError", "用户名密码错误");
			return "loginFaild";
		}else{
			//成功
			 ServletActionContext.getRequest().getSession().setAttribute(Contains.SESSION_ADMIN_NAME,existUser );
			return "loginSuccess";
		}
		

	}
}
