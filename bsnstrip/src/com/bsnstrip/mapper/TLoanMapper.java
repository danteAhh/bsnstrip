package com.bsnstrip.mapper;

import com.bsnstrip.pojo.TLoan;
import com.bsnstrip.pojo.TLoanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLoanMapper {
    long countByExample(TLoanExample example);

    int deleteByExample(TLoanExample example);

    int deleteByPrimaryKey(Integer loanid);

    int insert(TLoan record);

    int insertSelective(TLoan record);

    List<TLoan> selectByExampleWithBLOBs(TLoanExample example);

    List<TLoan> selectByExample(TLoanExample example);

    TLoan selectByPrimaryKey(Integer loanid);

    int updateByExampleSelective(@Param("record") TLoan record, @Param("example") TLoanExample example);

    int updateByExampleWithBLOBs(@Param("record") TLoan record, @Param("example") TLoanExample example);

    int updateByExample(@Param("record") TLoan record, @Param("example") TLoanExample example);

    int updateByPrimaryKeySelective(TLoan record);

    int updateByPrimaryKeyWithBLOBs(TLoan record);

    int updateByPrimaryKey(TLoan record);
    
    List<TLoan> listLoan(@Param("userId") Integer userId);
}