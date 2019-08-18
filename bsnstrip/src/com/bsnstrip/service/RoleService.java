package com.bsnstrip.service;

import java.util.List;

import com.bsnstrip.pojo.TRole;

public interface RoleService {
	
	List<TRole> findRoleByUserId(Integer userId);

	TRole checkManager(Integer deptid, Integer roleid);
	
	TRole checkLeader();
	
	TRole checkCounter();
	
	int saveRole(Integer userId, Integer roleId);
	
	int deleteRole(Integer userId);
}
