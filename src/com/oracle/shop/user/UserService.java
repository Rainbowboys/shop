package com.oracle.shop.user;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * @Title:UserService
 * @Description:�û�ҵ���ӿ�
 * @author:Rainbow.huahang.com
 * @date:2016��10��15�� ����5:08:56
 */
public interface UserService {
	/**
	 * ҵ��㴦��ע���û�
	 * 
	 * @param user
	 */
	public boolean regist(User user);

	/**
	 * ҵ��� ����������Ϣ��ѯ�û�
	 */
	public List<User> findUserBycriteria(DetachedCriteria criteria);

	/**
	 * ���ݼ����� ��ѯ�û� ҵ���ӿ�
	 */
	public User findUserBycode(String code) throws Exception;

	/**
	 * �����û���Ϣ ҵ���ӿ�
	 * 
	 */
	public void updateUser(User user) throws Exception;

	/**
	 * �û���¼
	 * @param user
	 */
	public User login(User user) throws Exception;

}
