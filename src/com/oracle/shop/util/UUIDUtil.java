package com.oracle.shop.util;

import java.util.UUID;

/**
 * @Title:UUIDUtil
 * @Description:��ȡ���������Ĺ�����
 * @author:Rainbow.huahang.com
 * @date:2016��10��15�� ����5:15:18
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
