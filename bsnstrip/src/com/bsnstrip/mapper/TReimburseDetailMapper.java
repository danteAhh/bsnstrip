package com.bsnstrip.mapper;

import com.bsnstrip.pojo.TReimburseDetail;
import com.bsnstrip.pojo.TReimburseDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TReimburseDetailMapper {
    long countByExample(TReimburseDetailExample example);

    int deleteByExample(TReimburseDetailExample example);

    int deleteByPrimaryKey(Integer rbdid);

    int insert(TReimburseDetail record);

    int insertSelective(TReimburseDetail record);

    List<TReimburseDetail> selectByExample(TReimburseDetailExample example);

    TReimburseDetail selectByPrimaryKey(Integer rbdid);

    int updateByExampleSelective(@Param("record") TReimburseDetail record, @Param("example") TReimburseDetailExample example);

    int updateByExample(@Param("record") TReimburseDetail record, @Param("example") TReimburseDetailExample example);

    int updateByPrimaryKeySelective(TReimburseDetail record);

    int updateByPrimaryKey(TReimburseDetail record);
}