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
	 * struct2 ��ȡģ������
	 */
	private User user = new User();
	@Resource(name = "userservice")
	private UserService userservice;

	@Override
	public User getModel() {
		return user;
	}

	// ��̨��֤��
	private String captcha;

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	/**
	 * ��ת�û�ע�����ķ���
	 * 
	 * @return
	 */
	public String registerPage() {
		return "registerPage";
	}

	/**
	 * ��ת��½ҳ��
	 */

	public String loginPage() {
		return "loginPage";
	}

	/**
	 * ʵ���û�ע��
	 */
	@InputConfig(resultName = "registInput")
	public String regist() {
		String checkcode = ServletActionContext.getRequest().getSession().getAttribute("checkcode").toString();
		if (captcha != null && captcha.equals(checkcode)) {

			boolean result = userservice.regist(user);
			if (result) {
				ActionContext.getContext().put("registresult", "ע��ɹ�!�뵽������м���");
			} else {
				ActionContext.getContext().put("registresult", "ע��ʧ��!");
			}
			return "registresult";
		} else {
			this.addActionError("��֤�����");
			return "registInput";
		}
	}

	/**
	 * �û������
	 * 
	 * @throws Exception
	 */
	public void registcheck() throws Exception {
		User userexsit = userservice.findUserByUserName(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		// ��ʾ��Ϣ
		String msg = "";
		if (userexsit != null) {
			// �û��Ѵ���
			msg = "���û��Ѿ�����";
			writer.write(JSON.toJSONString(msg));
		} else {
			writer.write(JSON.toJSONString(msg));
		}
		writer.close();
		writer.flush();
	}

	/**
	 * ʵ���û���¼
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
			ActionContext.getContext().put("loginresult", "�û��������벻��ȷ�����˻�����");
			return "loginInput";
		}
	}

	/**
	 * �����û�
	 * 
	 * @throws Exception
	 */
	public String active() throws Exception {
		// ��ѯ���
		User userexsit = userservice.findUserBycode(user.getCode());
		if (userexsit != null) {
			if (userexsit.getStatus() == 1) {
				ActionContext.getContext().put("activeresult", "�û��Ѽ���");
			} else {
				userexsit.setStatus(1);
				// �����û���Ϣ
				userservice.updateUser(userexsit);
				ActionContext.getContext().put("activeresult", "����ɹ�!������ǰȥ��½");
			}

		} else {
			ActionContext.getContext().put("activeresult", "����ʧ�ܣ�����������");
		}
		return "activeresult";
	}

	/**
	 * �û�ע��
	 */

	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get(Contains.SESSION_USER_NAME) != null) {
			session.remove(Contains.SESSION_USER_NAME);
		}
		return "quitSuccess";

	}
}
