package com.bsnstrip.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.bsnstrip.pojo.TRole;
import com.bsnstrip.pojo.TRoleExample;

public interface TRoleMapper {
    long countByExample(TRoleExample example);

    int deleteByExample(TRoleExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(TRole record);

    int insertSelective(TRole record);

    List<TRole> selectByExample(TRoleExample example);

    TRole selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);
    
    List<TRole> findRoleByUserId(@Param("userId")Integer userId);

	TRole checkManager(@Param("deptId") Integer deptId, @Param("roleId") Integer roleId);
	
	TRole checkLeader();
	
	TRole checkCounter();
	
	int saveRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
	
	int deleteRole(@Param("userId") Integer userId);
}