package com.bsnstrip.service;

import java.util.List;

import com.bsnstrip.pojo.TUser;

public interface UserService {
	
	TUser getCounter();
	
	TUser getLeader();
	
	TUser findManagerByUserId(Integer userId);
	
	TUser findUserByUsername(String username);
	
	boolean CheckPassword(String password, String md5Password);
	
	TUser selectByPrimaryKey(Integer userid);
	
	List<TUser> listUser();

	Integer saveUser(TUser user);
	
	int deleteUser(Integer userId);

	List<TUser> listDeptUser(Integer deptId);
}
