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
import com.bsnstrip.mapper.TReimburseDetailMapper;
import com.bsnstrip.mapper.TReimburseMapper;
import com.bsnstrip.pojo.City;
import com.bsnstrip.pojo.Country;
import com.bsnstrip.pojo.Province;
import com.bsnstrip.pojo.TBsnstrip;
import com.bsnstrip.pojo.TBsnstripExample;
import com.bsnstrip.pojo.TReimburse;
import com.bsnstrip.pojo.TReimburseDetail;
import com.bsnstrip.pojo.TReimburseDetailExample;
import com.bsnstrip.pojo.TReimburseExample;
import com.bsnstrip.service.BsnstripService;
import com.bsnstrip.service.ReimburseDetailService;
import com.bsnstrip.service.ReimburseService;

@Service("reimburseDetailService")
public class ReimburseDetailServiceImpl implements ReimburseDetailService{

	@Autowired
	private TReimburseDetailMapper reimburseDetailMapper;
	@Autowired
	private TReimburseMapper reimburseMapper;

	public Integer edit(TReimburseDetail reimburseDetail) {
		
		Integer i = 0;
		if(reimburseDetail.getRbdid() != null) {
			i = reimburseDetailMapper.updateByPrimaryKeySelective(reimburseDetail);
		}else {
			i = reimburseDetailMapper.insertSelective(reimburseDetail);
		}
		return i;
	}
	
	public List<TReimburseDetail> selectByExample(Integer rbid) {
		TReimburseDetailExample example = new TReimburseDetailExample();
		TReimburseDetailExample.Criteria criteria = example.createCriteria();
		criteria.andRbidEqualTo(rbid);
		List<TReimburseDetail> rbDetails = reimburseDetailMapper.selectByExample(example);
		return rbDetails;
	}
}
