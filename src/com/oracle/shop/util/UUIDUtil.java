package com.oracle.shop.util;

import java.util.UUID;

/**
 * @Title:UUIDUtil
 * @Description:获取随机激活码的工具类
 * @author:Rainbow.huahang.com
 * @date:2016年10月15日 下午5:15:18
 */
public class UUIDUtil {

	public static String getUUID() {
		String result = UUID.randomUUID().toString().replace("-", "");
		return result;
	}

	public static void main(String[] args) {
	
		System.out.println(getUUID());

	}
}
