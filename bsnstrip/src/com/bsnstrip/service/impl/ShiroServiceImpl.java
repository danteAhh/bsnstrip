package com.bsnstrip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsnstrip.mapper.ShiroMapper;
import com.bsnstrip.pojo.TPermission;
import com.bsnstrip.pojo.TUser;
import com.bsnstrip.service.ShiroService;

@Service
public class ShiroServiceImpl implements ShiroService {
	
	@Autowired
	private ShiroMapper shiroMapper;

	public TUser getUserByUserName(String username) {
		return shiroMapper.getUserByUserName(username);
	}


	public List<TPermission> findMenuListByUserId(Integer userid) {
		return shiroMapper.findMenuListByUserId(userid);
	}

	public List<TPermission> findPermissionListByUserId(Integer userid) {
		return shiroMapper.findPermissionListByUserId(userid);
	}


}
