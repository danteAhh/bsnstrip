package com.bsnstrip.service;

import java.util.List;

import com.bsnstrip.pojo.TPermission;
import com.bsnstrip.pojo.TUser;

public interface ShiroService {

	TUser getUserByUserName(String username);

	List<TPermission> findMenuListByUserId(Integer userid);

	List<TPermission> findPermissionListByUserId(Integer userid);

}
