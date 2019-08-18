package com.bsnstrip.mapper;

import com.bsnstrip.pojo.TRepay;
import com.bsnstrip.pojo.TRepayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRepayMapper {
    long countByExample(TRepayExample example);

    int deleteByExample(TRepayExample example);

    int deleteByPrimaryKey(Integer repayid);

    int insert(TRepay record);

    int insertSelective(TRepay record);

    List<TRepay> selectByExampleWithBLOBs(TRepayExample example);

    List<TRepay> selectByExample(TRepayExample example);

    TRepay selectByPrimaryKey(Integer repayid);

    int updateByExampleSelective(@Param("record") TRepay record, @Param("example") TRepayExample example);

    int updateByExampleWithBLOBs(@Param("record") TRepay record, @Param("example") TRepayExample example);

    int updateByExample(@Param("record") TRepay record, @Param("example") TRepayExample example);

    int updateByPrimaryKeySelective(TRepay record);

    int updateByPrimaryKeyWithBLOBs(TRepay record);

    int updateByPrimaryKey(TRepay record);
}