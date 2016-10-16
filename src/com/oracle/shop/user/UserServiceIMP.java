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
	 * 业务层 处理注册用户 首先生成随机验证码 发送激活邮件 状态码改变 完成最终的用户信息保存的业务
	 */
	@Override
	public boolean regist(User user) {
		// 用户为激活0 激活1
		user.setStatus(0);
		// 生成随机激活码
		String code = UUIDUtil.getUUID() + UUIDUtil.getUUID() + UUIDUtil.getUUID() + UUIDUtil.getUUID()
				+ UUIDUtil.getUUID() + UUIDUtil.getUUID();
		user.setCode(code);
		// 发送邮件
		EMailUtil.sendEmail(user.getEmail(), code);

		// 保存用户
		return userdao.regist(user);

	}

	@Override
	public List<User> findUserBycriteria(DetachedCriteria criteria) {
		// 返回查询信息
		return userdao.findUserBycriteria(criteria);
	}

	/**
	 * 根据激活码 查询用户
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
	 * 业务层 登录实现
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
