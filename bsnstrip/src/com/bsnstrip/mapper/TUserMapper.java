package com.bsnstrip.mapper;

import com.bsnstrip.pojo.TUser;
import com.bsnstrip.pojo.TUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserMapper {
    long countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    // 通过用户id查找部门领导
    TUser findManagerByUserId(@Param("userId")Integer userId);
    // 查找总经理
    TUser getLeader();
    // 查找财务
    TUser getCounter();
}