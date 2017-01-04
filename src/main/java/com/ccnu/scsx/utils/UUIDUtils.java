package com.ccnu.scsx.utils;

import java.util.UUID;

/**
 * Create By Joban on2017年1月2日上午9:13:41
 */
public class UUIDUtils {
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replaceAll("-", "");
		return uuidStr;
	}

}
