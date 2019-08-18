package com.bsnstrip.service;

import java.util.List;

import com.bsnstrip.pojo.TBsnstrip;
import com.bsnstrip.pojo.TLoan;

public interface LoanService {
	
	void saveLoan(TLoan loan);

	TLoan selectByPrimaryKey(Integer loanId);

	void updateLoanStatus(TLoan loan);
	
	List<TLoan> listLoan(Integer userId);
	
	Integer findLoanfeeById(Integer loanId);
}
