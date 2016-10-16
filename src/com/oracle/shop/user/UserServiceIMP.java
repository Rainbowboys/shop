package com.oracle.shop.user;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.shop.util.EMailUtil;
import com.oracle.shop.util.UUIDUtil;

@Service("userservice")
@Transactional
public class UserServiceIMP implements UserService {
	@Resource(name = "userdao")
	private UserDao userdao;

	/**
	 * ҵ��� ����ע���û� �������������֤�� ���ͼ����ʼ� ״̬��ı� ������յ��û���Ϣ�����ҵ��
	 */
	@Override
	public boolean regist(User user) {
		// �û�Ϊ����0 ����1
		user.setStatus(0);
		// �������������
		String code = UUIDUtil.getUUID() + UUIDUtil.getUUID() + UUIDUtil.getUUID() + UUIDUtil.getUUID()
				+ UUIDUtil.getUUID() + UUIDUtil.getUUID();
		user.setCode(code);
		// �����ʼ�
		EMailUtil.sendEmail(user.getEmail(), code);

		// �����û�
		return userdao.regist(user);

	}

	@Override
	public List<User> findUserBycriteria(DetachedCriteria criteria) {
		// ���ز�ѯ��Ϣ
		return userdao.findUserBycriteria(criteria);
	}

	/**
	 * ���ݼ����� ��ѯ�û�
	 */
	@Override
	public User findUserBycode(String code) throws Exception {

		return userdao.findUserBycode(code);
	}

	@Override
	public void updateUser(User user) throws Exception {

		userdao.updateUser(user);
	}

	/**
	 * ҵ��� ��¼ʵ��
	 * 
	 * @throws Exception
	 */

	@Override
	public User login(User user) throws Exception {
		return userdao.login(user);

	}

	@Override
	public User findUserByUserName(String username) throws Exception {
	
		return userdao.findUserByUserName(username);
	}

}
