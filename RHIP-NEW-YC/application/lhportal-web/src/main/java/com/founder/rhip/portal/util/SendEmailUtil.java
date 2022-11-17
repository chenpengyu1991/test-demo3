package com.founder.rhip.portal.util;

import org.apache.commons.mail.HtmlEmail;

import com.founder.rhip.portal.common.EmailAccount;
import com.founder.rhip.portal.common.EmailInfo;

public class SendEmailUtil {
//	private static EmailAccount EMAIL_ACCOUNT;;
//	static {
//		String host = WebProperties.getMsg("host");
//		String user = WebProperties.getMsg("user");
//		String userEmail = WebProperties.getMsg("userEmail");
//		String pwd = WebProperties.getMsg("pwd");
//		EMAIL_ACCOUNT = new EmailAccount(host, user, userEmail, pwd);
//	}

	public static void sendHtml(EmailAccount EMAIL_ACCOUNT,String to, String subject, String htmlMessage) {
		EmailInfo ei = new EmailInfo(EMAIL_ACCOUNT, to, subject, htmlMessage);
		HtmlEmail email = new HtmlEmail();
		email.setHostName(ei.getFrom().getHost());
		email.setSSL(true);
		email.setSslSmtpPort("465");
		email.setCharset("GB2312");
		email.setAuthentication(ei.getFrom().getUserEmail(), ei.getFrom().getPwd());
		// email.setDebug(true);
		try {
			email.setFrom(ei.getFrom().getUserEmail(), ei.getFrom().getUser(), "GB2312");
			email.addTo(ei.getTo());
			email.setSubject(ei.getSubject());
			email.setHtmlMsg(ei.getContent());
			email.send();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
}
