package com.oracle.shop.user;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface UserDao {

	/**
	 * ǰ̨�û�ע��
	 */

	public boolean regist(User user);

	/**
	 * ����������Ϣ��ѯ�û�
	 */
	public List<User> findUserBycriteria(DetachedCriteria criteria);

	/**
	 * ���ݼ����� ��ѯ�û�
	 */
	public User findUserBycode(String code) throws Exception;

	/**
	 * �����û���Ϣ
	 * 
	 */
	public void updateUser(User user) throws Exception;

	/**
	 * �û���¼
	 * 
	 * @param user
	 */
	public User login(User user) throws Exception;

	/**
	 * �����û��������û�
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public User findUserByUserName(String username) throws Exception;
}
