package com.oracle.shop.user;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface UserDao {

	/**
	 * 前台用户注册
	 */

	public boolean regist(User user);

	/**
	 * 根据离线信息查询用户
	 */
	public List<User> findUserBycriteria(DetachedCriteria criteria);

	/**
	 * 根据激活码 查询用户
	 */
	public User findUserBycode(String code) throws Exception;

	/**
	 * 更新用户信息
	 * 
	 */
	public void updateUser(User user) throws Exception;

	/**
	 * 用户登录
	 * 
	 * @param user
	 */
	public User login(User user) throws Exception;

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public User findUserByUserName(String username) throws Exception;
}
