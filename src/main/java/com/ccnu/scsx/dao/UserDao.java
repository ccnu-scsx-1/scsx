package com.ccnu.scsx.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ccnu.scsx.dao.impl.BaseDaoImpl;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.mapper.ScsxUserMapper;
import com.ccnu.scsx.model.ScsxUser;

/**
 * Create By Joban on2017年1月2日上午9:44:36
 */
@Repository
public class UserDao extends BaseDaoImpl<ScsxUser> implements IBaseDao<ScsxUser> {
	@Autowired
	private ScsxUserMapper userMapper;

	@Override
	public BaseMapper<ScsxUser> getMapper() {
		return userMapper;
	}

	public ScsxUser findByNameAndPassword(String name, String password, Byte role) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("password", password);
		map.put("role", role);
		return userMapper.findByNameAndPassword(map);
	}
	
	public void register(ScsxUser user) {
		userMapper.insert(user);
	}

}
