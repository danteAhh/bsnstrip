package com.bsnstrip.mapper;

import com.bsnstrip.pojo.TReimburseImg;
import com.bsnstrip.pojo.TReimburseImgExample;
import com.bsnstrip.pojo.TReimburseImgKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TReimburseImgMapper {
    long countByExample(TReimburseImgExample example);

    int deleteByExample(TReimburseImgExample example);

    int deleteByPrimaryKey(TReimburseImgKey key);

    int insert(TReimburseImg record);

    int insertSelective(TReimburseImg record);

    List<TReimburseImg> selectByExample(TReimburseImgExample example);

    TReimburseImg selectByPrimaryKey(TReimburseImgKey key);

    int updateByExampleSelective(@Param("record") TReimburseImg record, @Param("example") TReimburseImgExample example);

    int updateByExample(@Param("record") TReimburseImg record, @Param("example") TReimburseImgExample example);

    int updateByPrimaryKeySelective(TReimburseImg record);

    int updateByPrimaryKey(TReimburseImg record);
}