package com.bsnstrip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsnstrip.mapper.TRepayMapper;
import com.bsnstrip.pojo.TLoanExample;
import com.bsnstrip.pojo.TRepay;
import com.bsnstrip.pojo.TRepayExample;
import com.bsnstrip.service.RepayService;

@Service
public class RepayServiceImpl implements RepayService {

	@Autowired
	private TRepayMapper repayMapper;

	public void saveRepay(TRepay repay) {
		Integer repayid = repay.getRepayid();
		
		if(repayid == null) {
			repayMapper.insertSelective(repay);
		}else {
			repayMapper.updateByPrimaryKeySelective(repay);
		}
	}

	public TRepay selectByPrimaryKey(Integer repayId) {
		return repayMapper.selectByPrimaryKey(repayId);
	}

	public void updateLoanStatus(TRepay repay) {
		TRepayExample example = new TRepayExample();
		TRepayExample.Criteria criteria = example.createCriteria();
		criteria.andRepayidEqualTo(repay.getRepayid());
		repayMapper.updateByExampleSelective(repay, example);		
	}
}
