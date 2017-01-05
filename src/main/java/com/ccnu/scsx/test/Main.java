package com.ccnu.scsx.test;

import com.alibaba.fastjson.JSON;
import com.ccnu.scsx.enu.PositionCode;
import com.ccnu.scsx.model.ScsxUser;
import com.ccnu.scsx.utils.Md5Utils;
import com.ccnu.scsx.utils.UUIDUtils;
import java.util.Map;

/**
 * Create By Joban on2017年1月2日上午11:29:23
 */
public class Main {
	public static void main(String[] args) {
		/*String str = Md5Utils.getMD5("junpeng");//加密MD5
		System.out.println(str);
		String id = UUIDUtils.getUUID();//生成UUID
		System.out.println(id);
		//json串变对象
		String jsonString = "{\"name\":\"Joban\",\"password\":\"123\",\"email\":\"Joban@123.com\"}";
		ScsxUser user = JSON.parseObject(jsonString, ScsxUser.class);
		System.out.println(user.getName());*/
		int code = PositionCode.C_Engineer.getCode();
		System.out.println(code);
		System.out.println(PositionCode.getDescByCode(1));
		/*String jsonString1 = "{\"pageNum\":4}";
		Map<String,Integer> object = JSON.parseObject(jsonString1,Map.class);
		System.out.println(object.get("pageNum"));*/
	}
}
