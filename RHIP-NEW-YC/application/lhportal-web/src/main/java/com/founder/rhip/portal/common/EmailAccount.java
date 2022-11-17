package com.founder.rhip.portal.common;


public class EmailAccount {
	
	private String host;//// smtp服务器
	private String user; // 用户名
	private String userEmail;// 用户的qq
	private String pwd; // 密码
	public EmailAccount(String host,String user, String userEmail, String pwd) {
		this.host=host;
		this.user = user;
		this.userEmail = userEmail;
		this.pwd = pwd;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
