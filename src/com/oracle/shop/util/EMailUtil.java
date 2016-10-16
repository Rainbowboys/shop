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
 * @Description�������ʼ��Ĺ�����
 * @author:Rainbow.huahang.com
 * @date:2016��10��15�� ����8:46:41
 */
public class EMailUtil {
	/**
	 * �����ʼ�
	 * 
	 * @throws MessagingException
	 */
	public static void sendEmail(String to, String code) {

		Properties props = new Properties();
		props.setProperty("mail.smtp", "localhost");
		// 1.����session���� �������������
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com", "123456");
			}
		});
		// 2.�����ʼ���Ϣ
		Message message = new MimeMessage(session);
		// ������
		try {
			message.setFrom(new InternetAddress("service@shop.com"));
			// �ռ���
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			// ��������
			message.setSubject("��������Shop�����̳ǵļ����ʼ�");
			// �����ʼ�����
			message.setContent(
					"<h1>����Shop�����̳ǵļ����ʼ� ������ӽ��м���</h1><h3><a href='http://172.16.2.66/shop/user_active.action?code="
							+ code + "'>http://172.16.2.66:8080/shop/user_active.action?code=" + code + "</a></h3>",
					"text/html; charset=UTF-8");
			// �����ʼ�
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
