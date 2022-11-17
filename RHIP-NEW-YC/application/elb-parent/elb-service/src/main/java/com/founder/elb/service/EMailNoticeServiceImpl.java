/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.elb.service;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;
import org.springframework.stereotype.Service;

import com.founder.elb.entity.Notice;
import com.founder.elb.entity.SiteConfig;
import com.founder.fasf.service.AbstractService;

@Service("eMailNoticeService")
public class EMailNoticeServiceImpl extends AbstractService implements
		IEMailNoticeService

{
	/**
	 * 发送邮件以及通过文件路径发送邮件附件
	 * 
	 * @param Notice
	 * @return void
	 */
	public void sendEmailByFilePath(Notice notice) throws Exception {
		boolean sessionDebug = false;
		InternetAddress[] address = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {

			SiteConfig config = new SiteConfig(); // 配置信息
			String mailServer = config.getSendEmailSmtp(); // 服务器地址
			String mailAuth = config.getMailSmtpAuth(); // 验证
			String mailAddress = config.getSendEmailAddress(); // 邮箱
			String mailUser = config.getSendEmailAddress(); // 用户名
			String mailPassword = config.getSendEmailPassword(); // 密码
			String mailSmtpPort = config.getMailSmtpPort(); // 端口

			Properties props = System.getProperties();
			props.put("mail.smtp.host", mailServer);
			props.put("mail.smtp.auth", mailAuth);

			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);

			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(mailAddress));
			if (notice.getToAddress() != null
					&& !"".equals(notice.getToAddress())) {
				address = InternetAddress.parse(notice.getToAddress(), false);
				for (InternetAddress addr : address) {
					if (this.isEmail(addr.getAddress()) == false) {
						log.info(sdf.format(new Date() + notice.getScene()
								+ addr.getAddress() + "地址格式不正确。"));
					}
				}
				msg.setRecipients(Message.RecipientType.TO, address);
			}
			if (notice.getCcAddress() != null
					&& !"".equals(notice.getCcAddress())) {
				address = InternetAddress.parse(notice.getCcAddress(), false);
				for (InternetAddress addr : address) {
					if (this.isEmail(addr.getAddress()) == false) {
						log.info(sdf.format(new Date() + notice.getScene()
								+ addr.getAddress() + "地址格式不正确。"));
					}
				}
				msg.setRecipients(Message.RecipientType.CC, address);
			}
			if (notice.getBccAddress() != null
					&& !"".equals(notice.getBccAddress())) {
				address = InternetAddress.parse(notice.getBccAddress(), false);
				for (InternetAddress addr : address) {
					if (this.isEmail(addr.getAddress()) == false) {
						log.info(sdf.format(new Date() + notice.getScene()
								+ addr.getAddress() + "地址格式不正确。"));
					}
				}
				msg.setRecipients(Message.RecipientType.BCC, address);
			}

			String message = notice.getContent();
			msg.setSubject(notice.getTitle());
			msg.setSentDate(new Date());

			msg.setText(message);
			Multipart mm = new MimeMultipart();
			BodyPart mdp = new MimeBodyPart(); // 新建一个存放信件内容的BodyPart对象
			mdp.setContent(message, "text/html;charset=UTF-8");
			mm.addBodyPart(mdp); // 将含有信件内容的BodyPart加入到MimeMultipart对象中

			String[] fname = notice.getAttachFilePath();

			File f = null;

			for (String name : fname) {
				f = new File(name);
				if (f.exists() == false) {
					log.error(sdf.format(new Date() + notice.getScene() + name
							+ "附件文件不存在。"));
					continue;
				}

				mdp = new MimeBodyPart();
				FileDataSource fds = new FileDataSource(name);
				DataHandler dh = new DataHandler(fds);
				int i = name.lastIndexOf(File.separatorChar);
				String attachName = name.substring(i + 1); // 提取文件名
				mdp.setFileName(attachName); // 可以和原文件名不一致
				mdp.setDataHandler(dh);
				mdp.setFileName(MimeUtility
						.encodeWord(attachName, "UTF-8", "Q"));
				mdp.setHeader("content-id", attachName);
				mm.addBodyPart(mdp);
			}

			msg.setContent(mm);
			msg.saveChanges();

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(mailServer, Integer.parseInt(mailSmtpPort),
					mailUser, mailPassword);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();

		} catch (MessagingException e) {
			e.printStackTrace();
			log.error(sdf.format(new Date() + notice.getScene()
					+ "异常错误，邮件发送失败。"));
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(sdf.format(new Date() + notice.getScene()
					+ "异常错误，邮件发送失败。"));
			throw e;
		}
	}

	/**
	 * 发送邮件以及通过byte[]流或base64编码字符串发送邮件附件
	 * 
	 * @param Notice
	 * @return void
	 */
	@SuppressWarnings("restriction")
	public void sendEmailByFlow(Notice notice) throws Exception {
		boolean sessionDebug = false;
		InternetAddress[] address = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {

			SiteConfig config = new SiteConfig(); // 配置信息
			String mailServer = config.getSendEmailSmtp(); // 服务器地址
			String mailAuth = config.getMailSmtpAuth(); // 验证
			String mailAddress = config.getSendEmailAddress(); // 邮箱
			String mailUser = config.getSendEmailAddress(); // 用户名
			String mailPassword = config.getSendEmailPassword(); // 密码
			String mailSmtpPort = config.getMailSmtpPort(); // 端口

			Properties props = System.getProperties();
			props.put("mail.smtp.host", mailServer);
			props.put("mail.smtp.auth", mailAuth);

			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);

			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(mailAddress));
			if (notice.getToAddress() != null
					&& !"".equals(notice.getToAddress())) {
				address = InternetAddress.parse(notice.getToAddress(), false);
				for (InternetAddress addr : address) {
					if (this.isEmail(addr.getAddress()) == false) {
						log.info(sdf.format(new Date() + notice.getScene()
								+ addr.getAddress() + "地址格式不正确。"));
					}
				}
				msg.setRecipients(Message.RecipientType.TO, address);
			}
			if (notice.getCcAddress() != null
					&& !"".equals(notice.getCcAddress())) {
				address = InternetAddress.parse(notice.getCcAddress(), false);
				for (InternetAddress addr : address) {
					if (this.isEmail(addr.getAddress()) == false) {
						log.info(sdf.format(new Date() + notice.getScene()
								+ addr.getAddress() + "地址格式不正确。"));
					}
				}
				msg.setRecipients(Message.RecipientType.CC, address);
			}
			if (notice.getBccAddress() != null
					&& !"".equals(notice.getBccAddress())) {
				address = InternetAddress.parse(notice.getBccAddress(), false);
				for (InternetAddress addr : address) {
					if (this.isEmail(addr.getAddress()) == false) {
						log.info(sdf.format(new Date() + notice.getScene()
								+ addr.getAddress() + "地址格式不正确。"));
					}
				}
				msg.setRecipients(Message.RecipientType.BCC, address);
			}

			String message = notice.getContent();
			msg.setSubject(notice.getTitle());
			msg.setSentDate(new Date());

			msg.setText(message);
			Multipart mm = new MimeMultipart();
			BodyPart mdp = new MimeBodyPart(); // 新建一个存放信件内容的BodyPart对象
			mdp.setContent(message, "text/html;charset=UTF-8");
			mm.addBodyPart(mdp); // 将含有信件内容的BodyPart加入到MimeMultipart对象中

			String[] fname = notice.getAttachFileName();
			byte[] data = null;
			String[] file64Str = notice.getFile64Str();
			if (file64Str != null && file64Str.length > 0) {
				sun.misc.BASE64Decoder base = new sun.misc.BASE64Decoder();
				for (int i = 0; i < fname.length; i++) {
					data = base.decodeBuffer(file64Str[i]);
					mdp = new MimeBodyPart();
					DataSource obj = new ByteArrayDataSource(data,
							"application/octet-stream");
					DataHandler dh = new DataHandler(obj);
					mdp.setDataHandler(dh);
					mdp.setFileName(MimeUtility.encodeWord(fname[i], "UTF-8",
							"Q"));
					mdp.setHeader("content-id", fname[i]);
					mm.addBodyPart(mdp);
				}
			} else {
				data = notice.getFileFlow();
				mdp = new MimeBodyPart();
				DataSource obj = new ByteArrayDataSource(data,
						"application/octet-stream");
				DataHandler dh = new DataHandler(obj);
				mdp.setDataHandler(dh);
				mdp.setFileName(MimeUtility.encodeWord(fname[0], "UTF-8", "Q"));
				mdp.setHeader("content-id", fname[0]);
				mm.addBodyPart(mdp);
			}

			msg.setContent(mm);
			msg.saveChanges();

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(mailServer, Integer.parseInt(mailSmtpPort),
					mailUser, mailPassword);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();

		} catch (MessagingException e) {
			e.printStackTrace();
			log.error(sdf.format(new Date() + notice.getScene()
					+ "异常错误，邮件发送失败。"));
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(sdf.format(new Date() + notice.getScene()
					+ "异常错误，邮件发送失败。"));
			throw e;
		}
	}

	private boolean isEmail(String str) {
		String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		return match(regex, str);
	}

	private boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

}