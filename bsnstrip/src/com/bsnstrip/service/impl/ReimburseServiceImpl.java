package com.bsnstrip.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bsnstrip.mapper.TBsnstripMapper;
import com.bsnstrip.mapper.TReimburseMapper;
import com.bsnstrip.pojo.City;
import com.bsnstrip.pojo.Country;
import com.bsnstrip.pojo.Province;
import com.bsnstrip.pojo.TBsnstrip;
import com.bsnstrip.pojo.TBsnstripExample;
import com.bsnstrip.pojo.TReimburse;
import com.bsnstrip.pojo.TReimburseExample;
import com.bsnstrip.service.BsnstripService;
import com.bsnstrip.service.ReimburseService;

@Service("reimburseService")
public class ReimburseServiceImpl implements ReimburseService{

	@Autowired
	private TReimburseMapper reimburseMapper;

	public void saveReimburse(TReimburse reimburse) {
		Integer rbid = reimburse.getRbid();

		if (rbid == null) {
			reimburseMapper.insertSelective(reimburse);
		} else {
			reimburseMapper.updateByPrimaryKeySelective(reimburse);
		}
	}
	
	public TReimburse selectByPrimaryKey(Integer rbid) {
		return reimburseMapper.selectByPrimaryKey(rbid);
	}

	public void updateReimburseStatus(TReimburse reimburse) {
		TReimburseExample example = new TReimburseExample();
		TReimburseExample.Criteria criteria = example.createCriteria();
		criteria.andRbidEqualTo(reimburse.getRbid());
		reimburseMapper.updateByExampleSelective(reimburse, example);
	}

}
