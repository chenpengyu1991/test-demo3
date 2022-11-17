package com.founder.rhip.ehr.auth;

import java.util.Date;
import java.util.UUID;

public class TokenUtil {

	public static long MAX_INTERVAL = 30 * 60 * 1000;

	private static String KEY = "zfG10wSK4N8=";
	
	private static String TOKEN_SEPARATOR="|";
	
	private static final String  TOKEN_SEPARATOR_PATTERN="["+TOKEN_SEPARATOR+"]";

	public static void main(String[] abc) {
		String uString = "admin_test_$_.USer";
		String token = makeToken(uString);
		System.out.println(token);
		System.out.println(checkToken(token));
	}

	private static byte[] getKey() {
		byte[] key = SecurityUtil.getFromBASE64(KEY);// TODO
		return key;
	}

	public static String makeToken(String usernmae) {
		//
		// TOKEN内容
		// DES(BASE64(DES(信息内容))|BASE64(信息内容签名))
		//
		StringBuilder content = new StringBuilder(usernmae);
		content.append(TOKEN_SEPARATOR);
		content.append(new Date().getTime());
		content.append(TOKEN_SEPARATOR);
		UUID uuid = UUID.randomUUID();
		content.append(uuid.toString());
		// 信息内容签名
		byte[] contentSign = SecurityUtil.makeSHA1(content.toString().getBytes());
		// 获取key
		byte[] key = getKey();
		// 信息内容 加密
		byte[] decryptedContent = SecurityUtil.encrypte(key, content.toString().getBytes());
		// token 内容
		StringBuilder toeknContent = new StringBuilder();
		toeknContent.append(SecurityUtil.getBASE64(decryptedContent));
		toeknContent.append(TOKEN_SEPARATOR);
		toeknContent.append(SecurityUtil.getBASE64(contentSign));
		// token 加密
		byte[] decryptedToeknContent = SecurityUtil.encrypte(key, toeknContent.toString().getBytes());
		// 最终token
		String token = SecurityUtil.getBASE64(decryptedToeknContent);
		return token;
	}

	public static String checkToken(String token) {
		// token解密
		byte[] ToeknContentByte = SecurityUtil.decrypte(getKey(), SecurityUtil.getFromBASE64(token));
		String toeknContentString = new String(ToeknContentByte);
		String[] toeknContentArray = toeknContentString.split(TOKEN_SEPARATOR_PATTERN);
		// 分解出签名和信息内容
		String sign = toeknContentArray[1];
		String decryptedContent = toeknContentArray[0];
		// 信息内容解密
		byte[] contentByte = SecurityUtil.decrypte(getKey(), SecurityUtil.getFromBASE64(decryptedContent));
		String content = new String(contentByte);
		String[] contentArray = content.split(TOKEN_SEPARATOR_PATTERN);
		// 分解信息内容
		String userName = contentArray[0];
		String date = contentArray[1];
		// 验证是否过期
		if (new Date().getTime() - Long.parseLong(date) > MAX_INTERVAL) {
			// TODO log
			return null;
		}
		// 对解密的信息内容求取签名
		byte[] newSignByte = SecurityUtil.makeSHA1(contentByte);
		String newSign = SecurityUtil.getBASE64(newSignByte);
		// 签名一致，则返回用户名
		if (sign.equals(newSign)) {
			return userName;
		}
		return null;
	}

}
