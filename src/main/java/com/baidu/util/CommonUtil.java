package com.baidu.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.util.StringUtils;

public final class CommonUtil {

	private static MessageDigest md5Instance;

	static {
		try {
			md5Instance = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
	}

	private CommonUtil() {
	}

	/**
	 * 将字符串进行md5加密
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String md5(String str) throws UnsupportedEncodingException {
		if (StringUtils.isEmpty(str))
			return str;
		StringBuffer hexValue = new StringBuffer();
		byte[] byteArray = str.getBytes("UTF-8");
		byte[] md5Array = md5Instance.digest(byteArray);
		for (int i = 0; i < md5Array.length; i++) {
			int val = ((int) md5Array[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString().toUpperCase();
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(md5("2"));
	}

}
