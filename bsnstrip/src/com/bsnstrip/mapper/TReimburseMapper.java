package com.bsnstrip.mapper;

import com.bsnstrip.pojo.TReimburse;
import com.bsnstrip.pojo.TReimburseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TReimburseMapper {
    long countByExample(TReimburseExample example);

    int deleteByExample(TReimburseExample example);

    int deleteByPrimaryKey(Integer rbid);

    int insert(TReimburse record);

    int insertSelective(TReimburse record);

    List<TReimburse> selectByExampleWithBLOBs(TReimburseExample example);

    List<TReimburse> selectByExample(TReimburseExample example);

    TReimburse selectByPrimaryKey(Integer rbid);

    int updateByExampleSelective(@Param("record") TReimburse record, @Param("example") TReimburseExample example);

    int updateByExampleWithBLOBs(@Param("record") TReimburse record, @Param("example") TReimburseExample example);

    int updateByExample(@Param("record") TReimburse record, @Param("example") TReimburseExample example);

    int updateByPrimaryKeySelective(TReimburse record);

    int updateByPrimaryKeyWithBLOBs(TReimburse record);

    int updateByPrimaryKey(TReimburse record);
}