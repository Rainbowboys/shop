package com.oracle.shop.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oracle.shop.user.User;
import com.oracle.shop.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext-bean.xml",
		"classpath:spring/applicationContext-hibernate.xml", "classpath:spring/applicationContext-transation.xml" })
public class TestUser {

	@Resource(name = "userservice")
	private UserService service;

	@Test
	public void testadd() {
		User user = new User();
		user.setUsername("xiaozhang");
		service.regist(user);
	}

	@Test
	public void testDetachedCriteria() {

		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("phone", "15632695088"));
		List<User> list = service.findUserBycriteria(criteria);
		System.out.println(list.size());

	}
}
