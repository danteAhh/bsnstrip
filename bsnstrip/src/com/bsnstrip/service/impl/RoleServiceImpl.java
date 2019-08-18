package com.bsnstrip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsnstrip.mapper.TRoleMapper;
import com.bsnstrip.pojo.TRole;
import com.bsnstrip.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private TRoleMapper roleMapper;
	public List<TRole> findRoleByUserId(Integer userId) {
		List<TRole> roles = roleMapper.findRoleByUserId(userId);
		return roles;
	}
	
	public TRole checkManager(Integer deptId, Integer roleId) {
		return roleMapper.checkManager(deptId, roleId);
	}

	public TRole checkLeader() {
		return roleMapper.checkLeader();
	}

	public TRole checkCounter() {
		return roleMapper.checkCounter();
	}

	public int saveRole(Integer userId, Integer roleId) {
		int i = roleMapper.saveRole(userId, roleId);
		return i;
	}
	
	public int deleteRole(Integer userId) {
		int i = roleMapper.deleteRole(userId);
		return i;
	}

}
