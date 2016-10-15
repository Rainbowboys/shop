package com.oracle.shop.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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

	@Override
	public User getModel() {
		return user;
	}

	/**
	 * ��ת�û�ע�����ķ���
	 * @return
	 */
	public String registerPage() {
		return "registerPage";

	}

}
