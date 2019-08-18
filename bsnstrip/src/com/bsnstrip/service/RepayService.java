package com.bsnstrip.service;

import com.bsnstrip.pojo.TRepay;

public interface RepayService {

	void saveRepay(TRepay repay);
	
	TRepay selectByPrimaryKey(Integer repayId);

	void updateLoanStatus(TRepay repay);

}
