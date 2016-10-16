package com.oracle.shop.user;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * @Title:UserService
 * @Description:用户业务层接口
 * @author:Rainbow.huahang.com
 * @date:2016年10月15日 下午5:08:56
 */
public interface UserService {
	/**
	 * 业务层处理注册用户
	 * 
	 * @param user
	 */
	public boolean regist(User user);

	/**
	 * 业务层 根据离线信息查询用户
	 */
	public List<User> findUserBycriteria(DetachedCriteria criteria);

	/**
	 * 根据激活码 查询用户 业务层接口
	 */
	public User findUserBycode(String code) throws Exception;

	/**
	 * 更新用户信息 业务层接口
	 * 
	 */
	public void updateUser(User user) throws Exception;

	/**
	 * 用户登录
	 * @param user
	 */
	public User login(User user) throws Exception;

}
