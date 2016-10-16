package com.oracle.shop.user;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.oracle.shop.util.Contains;

@Scope("prototype")
@Controller("userAcion")
public class UserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * uuid
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * struct2 获取模型驱动
	 */
	private User user = new User();
	@Resource(name = "userservice")
	private UserService userservice;

	@Override
	public User getModel() {
		return user;
	}

	/**
	 * 跳转用户注册界面的方法
	 * 
	 * @return
	 */
	public String registerPage() {
		return "registerPage";
	}

	/**
	 * 跳转登陆页面
	 */

	public String loginPage() {
		return "loginPage";
	}

	/**
	 * 实现用户注册
	 */
	@InputConfig(resultName = "registInput")
	public String regist() {
		boolean result = userservice.regist(user);
		if (result) {
			ActionContext.getContext().put("registresult", "注册成功!请到邮箱进行激活");
		} else {
			ActionContext.getContext().put("registresult", "注册失败!");
		}
		return "registresult";
	}

	/**
	 * 实现用户登录
	 * 
	 * @throws Exception
	 */
	@InputConfig(resultName = "loginInput")
	public String login() throws Exception {
		User loginuser = userservice.login(user);
		if (loginuser != null) {
			ActionContext.getContext().getSession().put(Contains.SESSION_USER_NAME, loginuser.getUsername());
			return "loginsuccess";
		} else {
			ActionContext.getContext().put("loginresult", "用户名和密码不正确或者账户激活");
			return "loginInput";
		}
	}

	/**
	 * 激活用户
	 * 
	 * @throws Exception
	 */
	public String active() throws Exception {
		// 查询结果
		User userexsit = userservice.findUserBycode(user.getCode());
		if (userexsit != null) {
			if (userexsit.getStatus() == 1) {
				ActionContext.getContext().put("activeresult", "用户已激活");
			} else {
				userexsit.setStatus(1);
				// 更新用户信息
				userservice.updateUser(userexsit);
				ActionContext.getContext().put("activeresult", "激活成功!您可以前去登陆");
			}

		} else {
			ActionContext.getContext().put("activeresult", "激活失败！激活码有误");
		}
		return "activeresult";

	}
}
