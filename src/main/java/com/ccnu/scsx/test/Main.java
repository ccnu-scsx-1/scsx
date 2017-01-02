package com.ccnu.scsx.test;

import com.ccnu.scsx.utils.Md5Utils;
import com.ccnu.scsx.utils.UUIDUtils;

/**
 * Create By Joban on2017年1月2日上午11:29:23
 */
public class Main {
	public static void main(String[] args) {
		String str = Md5Utils.getMD5("junpeng");
		System.out.println(str);
		String id = UUIDUtils.getUUID();
		System.out.println(id);
	}
}
