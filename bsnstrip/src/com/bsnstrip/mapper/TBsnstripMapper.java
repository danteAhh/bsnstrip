package com.bsnstrip.mapper;

import com.bsnstrip.pojo.TBsnstrip;
import com.bsnstrip.pojo.TBsnstripExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBsnstripMapper {
    long countByExample(TBsnstripExample example);

    int deleteByExample(TBsnstripExample example);

    int deleteByPrimaryKey(Integer bsid);

    int insert(TBsnstrip record);

    int insertSelective(TBsnstrip record);

    List<TBsnstrip> selectByExampleWithBLOBs(TBsnstripExample example);

    List<TBsnstrip> selectByExample(TBsnstripExample example);

    TBsnstrip selectByPrimaryKey(Integer bsid);

    int updateByExampleSelective(@Param("record") TBsnstrip record, @Param("example") TBsnstripExample example);

    int updateByExampleWithBLOBs(@Param("record") TBsnstrip record, @Param("example") TBsnstripExample example);

    int updateByExample(@Param("record") TBsnstrip record, @Param("example") TBsnstripExample example);

    int updateByPrimaryKeySelective(TBsnstrip record);

    int updateByPrimaryKeyWithBLOBs(TBsnstrip record);

    int updateByPrimaryKey(TBsnstrip record);
    
    List<TBsnstrip> listBsnstrip(@Param("userId") Integer userId);
    
    List<TBsnstrip> listBsnstripToLoan(@Param("userId") Integer userId);
}