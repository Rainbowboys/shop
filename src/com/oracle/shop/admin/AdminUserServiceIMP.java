package com.oracle.shop.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminUserServcie")
@Transactional
public class AdminUserServiceIMP implements AdminUserService{
	
	@Resource(name="adminUserDao")
	private AdminUserDao adminUserDao;

	@Override
	public AdminUser login(AdminUser adminUser) {
		// TODO Auto-generated method stub
		return adminUserDao.login(adminUser);
	}

}
