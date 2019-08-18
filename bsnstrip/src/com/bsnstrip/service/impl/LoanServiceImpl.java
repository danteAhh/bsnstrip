package com.bsnstrip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsnstrip.mapper.TLoanMapper;
import com.bsnstrip.pojo.TBsnstrip;
import com.bsnstrip.pojo.TBsnstripExample;
import com.bsnstrip.pojo.TLoan;
import com.bsnstrip.pojo.TLoanExample;
import com.bsnstrip.pojo.TReimburse;
import com.bsnstrip.pojo.TReimburseExample;
import com.bsnstrip.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private TLoanMapper loanMapper;

	public void saveLoan(TLoan loan) {
		Integer loanId = loan.getLoanid();

		if (loanId == null) {
			loanMapper.insertSelective(loan);
		} else {
			TLoanExample example = new TLoanExample();
			TLoanExample.Criteria criteria = example.createCriteria();
			criteria.andLoanidEqualTo(loanId);
			loanMapper.updateByExampleSelective(loan, example);
		}
	}

	public TLoan selectByPrimaryKey(Integer loanId) {
		return loanMapper.selectByPrimaryKey(loanId);
	}

	public void updateLoanStatus(TLoan loan) {
		TLoanExample example = new TLoanExample();
		TLoanExample.Criteria criteria = example.createCriteria();
		criteria.andLoanidEqualTo(loan.getLoanid());
		loanMapper.updateByExampleSelective(loan, example);
	}

	public List<TLoan> listLoan(Integer userId) {
		return loanMapper.listLoan(userId);
	}

	public Integer findLoanfeeById(Integer loanId) {
		TLoan loan = loanMapper.selectByPrimaryKey(loanId);
		return loan.getLoanfee();
	}

}