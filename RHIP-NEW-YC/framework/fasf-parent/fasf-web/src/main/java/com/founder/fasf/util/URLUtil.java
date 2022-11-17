
package com.founder.fasf.util;

import java.util.HashMap;

public abstract class URLUtil {

	/**
	 * 向url中追加参�?
	 * 
	 * @param targetUrl
	 *            目标url
	 * @param parameters
	 *            �?��追加到url上的参数�?
	 * @return 追加了参数的url
	 */
	public static String appendParameter2Url(String targetUrl, HashMap<String, String> parameters) {
		String rsUrl = targetUrl + "";
		if (!targetUrl.contains("?")) {
			rsUrl += "?";
		}
		StringBuffer sb = new StringBuffer();
		for (String key : parameters.keySet()) {
			if (key != null) {
				String value = parameters.get(key);
				if (value != null) {
					sb.append("&").append(key).append("=").append(value);
				}
			}
		}
		if (rsUrl.endsWith("?") || rsUrl.endsWith("&")) {
			rsUrl += sb.toString().replaceFirst("&", "");
		} else {
			rsUrl += sb.toString();
		}
		return rsUrl;
	}

	/**
	 * 删除url中的参数�?�?
	 * 
	 * @param targetUrl
	 *            目标url
	 * @return 删除了参数的url
	 */
	public static String removeParamters(String targetUrl) {
		if (targetUrl.contains("?")) {
			return targetUrl.split("?")[0];
		}
		return targetUrl;
	}
}
