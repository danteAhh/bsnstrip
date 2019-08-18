package com.bsnstrip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bsnstrip.pojo.TPermission;
import com.bsnstrip.pojo.TUser;

public interface ShiroMapper {
	
	TUser getUserByUserName(@Param("username")String username);

	List<TPermission> findMenuListByUserId(@Param("userId")Integer userid);

	List<TPermission> findPermissionListByUserId(@Param("userId")Integer userid);
}
