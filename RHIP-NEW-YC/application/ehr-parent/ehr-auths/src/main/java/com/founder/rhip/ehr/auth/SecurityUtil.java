package com.founder.rhip.ehr.auth;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class SecurityUtil {
	
	public static void main(String[] abc) {
		String uString = makeKey();
		System.out.println(uString);
	}

	/**
	 * 制作一个key
	 * @return
	 */
	public static String makeKey() {
		SecureRandom sr = new SecureRandom();
		KeyGenerator kg = null;
		try {
			kg = KeyGenerator.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		kg.init(sr);
		SecretKey key = kg.generateKey();
		byte[] rawKeyData = key.getEncoded();
		String keyString = getBASE64(rawKeyData);
		return keyString;
	}

	/**
	 * 加密
	 * @param rawKeyData
	 * @param data
	 * @return
	 */
	public static byte[] encrypte(byte rawKeyData[], byte data[]) {
		byte[] encryptedData = null;
		try {
			SecureRandom sr = new SecureRandom();
			DESKeySpec dks = new DESKeySpec(rawKeyData);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key, sr);
			encryptedData = cipher.doFinal(data);
		} catch (Exception e) {
			throw new RuntimeException("加密失败");
		}

		return encryptedData;

	}

	/**
	 * 解密
	 * @param rawKeyData
	 * @param encryptedData
	 * @return
	 */
	public static byte[] decrypte(byte rawKeyData[], byte encryptedData[]) {
		byte decryptedData[] = null;
		try {
			SecureRandom sr = new SecureRandom();
			DESKeySpec dks = new DESKeySpec(rawKeyData);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key, sr);
			decryptedData = cipher.doFinal(encryptedData);
		} catch (Exception e) {
			throw new RuntimeException("验证失败");
		}
		return decryptedData;
	}

	/**
	 * SHA1签名
	 * @param info
	 * @return
	 */
	public static byte[] makeSHA1(byte[] info) {
		java.security.MessageDigest alga = null;
		try {
			alga = java.security.MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("签名失败");
		}
		alga.update(info);
		return alga.digest();
	}

	/**
	 * base64编码
	 * @param b
	 * @return
	 */
	@SuppressWarnings("restriction")//TODO
	public static String getBASE64(byte[] b) {
		String s = null;
		if (b != null) {
			s = new sun.misc.BASE64Encoder().encode(b);
		}
		return s;
	}
	/**
	 * base64解码
	 * @param s
	 * @return
	 */
	@SuppressWarnings("restriction")//TODO
	public static byte[] getFromBASE64(String s) {
		byte[] b = null;
		if (s != null) {
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
				return b;
			} catch (Exception e) {
				throw new RuntimeException("解码失败");
			}
		}
		return b;
	}
}
