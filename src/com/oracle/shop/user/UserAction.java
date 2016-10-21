package com.oracle.shop.user;

import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
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

	// 后台验证码
	private String captcha;

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
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
		String checkcode = ServletActionContext.getRequest().getSession().getAttribute("checkcode").toString();
		if (captcha != null && captcha.equals(checkcode)) {

			boolean result = userservice.regist(user);
			if (result) {
				ActionContext.getContext().put("registresult", "注册成功!请到邮箱进行激活");
			} else {
				ActionContext.getContext().put("registresult", "注册失败!");
			}
			return "registresult";
		} else {
			this.addActionError("验证码错误");
			return "registInput";
		}
	}

	/**
	 * 用户名检测
	 * 
	 * @throws Exception
	 */
	public void registcheck() throws Exception {
		User userexsit = userservice.findUserByUserName(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		// 提示信息
		String msg = "";
		if (userexsit != null) {
			// 用户已存在
			msg = "该用户已经存在";
			writer.write(JSON.toJSONString(msg));
		} else {
			writer.write(JSON.toJSONString(msg));
		}
		writer.close();
		writer.flush();
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
			ActionContext.getContext().getSession().put(Contains.SESSION_USER_NAME, loginuser);
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

	/**
	 * 用户注销
	 */

	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get(Contains.SESSION_USER_NAME) != null) {
			session.remove(Contains.SESSION_USER_NAME);
		}
		return "quitSuccess";

	}
}
