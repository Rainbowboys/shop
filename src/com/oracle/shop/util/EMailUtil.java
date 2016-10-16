package com.oracle.shop.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * @Title:EMailUtil
 * @Description：发送邮件的工具类
 * @author:Rainbow.huahang.com
 * @date:2016年10月15日 下午8:46:41
 */
public class EMailUtil {
	/**
	 * 发送邮件
	 * 
	 * @throws MessagingException
	 */
	public static void sendEmail(String to, String code) {

		Properties props = new Properties();
		props.setProperty("mail.smtp", "localhost");
		// 1.创建session连接 连接邮箱服务器
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com", "123456");
			}
		});
		// 2.创建邮件信息
		Message message = new MimeMessage(session);
		// 发件人
		try {
			message.setFrom(new InternetAddress("service@shop.com"));
			// 收件人
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			// 设置主题
			message.setSubject("这是来自Shop电子商城的激活邮件");
			// 设置邮件内容
			message.setContent(
					"<h1>来自Shop电子商城的激活邮件 点击链接进行激活</h1><h3><a href='http://172.16.2.66/shop/user_active.action?code="
							+ code + "'>http://172.16.2.66:8080/shop/user_active.action?code=" + code + "</a></h3>",
					"text/html; charset=UTF-8");
			// 发送邮件
			Transport.send(message);

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
