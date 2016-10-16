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
	 * struct2 ��ȡģ������
	 */
	private User user = new User();
	@Resource(name = "userservice")
	private UserService userservice;

	@Override
	public User getModel() {
		return user;
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
		boolean result = userservice.regist(user);
		if (result) {
			ActionContext.getContext().put("registresult", "ע��ɹ�!�뵽������м���");
		} else {
			ActionContext.getContext().put("registresult", "ע��ʧ��!");
		}
		return "registresult";
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
			ActionContext.getContext().getSession().put(Contains.SESSION_USER_NAME, loginuser.getUsername());
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
}
