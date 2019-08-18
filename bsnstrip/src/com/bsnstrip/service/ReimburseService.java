package com.bsnstrip.service;

import java.util.List;

import com.bsnstrip.pojo.City;
import com.bsnstrip.pojo.Country;
import com.bsnstrip.pojo.Province;
import com.bsnstrip.pojo.TBsnstrip;
import com.bsnstrip.pojo.TReimburse;

public interface ReimburseService {
	void saveReimburse(TReimburse reimburse);
	TReimburse selectByPrimaryKey(Integer rbid);
	void updateReimburseStatus(TReimburse reimburse);
}
