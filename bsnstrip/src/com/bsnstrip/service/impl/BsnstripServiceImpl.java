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

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bsnstrip.mapper.TBsnstripMapper;
import com.bsnstrip.pojo.City;
import com.bsnstrip.pojo.Country;
import com.bsnstrip.pojo.Province;
import com.bsnstrip.pojo.TBsnstrip;
import com.bsnstrip.pojo.TBsnstripExample;
import com.bsnstrip.service.BsnstripService;

@Service("bsnstripService")
public class BsnstripServiceImpl implements BsnstripService{

	@Autowired
	private TBsnstripMapper bsnstripMapper;

	// 保存出差申请表信息
	public void saveBsnstrip(TBsnstrip bsnstrip) {
		Integer bsid = bsnstrip.getBsid();

		if (bsid == null) {
			bsnstripMapper.insertSelective(bsnstrip);
		} else {
			TBsnstripExample example = new TBsnstripExample();
			TBsnstripExample.Criteria criteria = example.createCriteria();
			criteria.andBsidEqualTo(bsid);
			bsnstripMapper.updateByExampleSelective(bsnstrip, example);
		}
	}

	// 获取省份
	public List<Province> getProvince(HttpServletRequest request){
		InputStream inputStream = null;
		try {
			String path = request.getSession().getServletContext().getRealPath("/resource");
			System.out.println(path+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			inputStream = new FileInputStream(new File(path+"/province.json"));
			String text = IOUtils.toString(inputStream,"utf8");
			List<Province> list = JSON.parseArray(text, Province.class);
			return list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<City> getCity(String provinceId, HttpServletRequest request) {
		InputStream inputStream = null;
		try {
			String path = request.getSession().getServletContext().getRealPath("/resource");
			inputStream = new FileInputStream(new File(path+"/city.json"));
			String text = IOUtils.toString(inputStream,"utf8");
			Map<String, Object> map = JSON.parseObject(text, HashMap.class);
			List<City> cities = JSON.parseArray(String.valueOf(map.get(provinceId)), City.class);
			return cities;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Country> getCountry(String cityId, HttpServletRequest request) {
		InputStream inputStream = null;
		try {
			String path = request.getSession().getServletContext().getRealPath("/resource");
			inputStream = new FileInputStream(new File(path+"/country.json"));
			String text = IOUtils.toString(inputStream,"utf8");
			Map<String, Object> map = JSON.parseObject(text, HashMap.class);
			List<Country> countries = JSON.parseArray(String.valueOf(map.get(cityId)), Country.class);
			return countries;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public TBsnstrip selectByPrimaryKey(Integer bsid) {
		return bsnstripMapper.selectByPrimaryKey(bsid);
	}

	public void updateBsnstripStatus(TBsnstrip bsnstrip) {
		TBsnstripExample example = new TBsnstripExample();
		TBsnstripExample.Criteria criteria = example.createCriteria();
		criteria.andBsidEqualTo(bsnstrip.getBsid());
		bsnstripMapper.updateByExampleSelective(bsnstrip, example);
	}
	
	public List<TBsnstrip> listBsnstrip(Integer userId){
		List<TBsnstrip> bsnstrips = bsnstripMapper.listBsnstrip(userId);
		return bsnstrips;
	}

	public List<TBsnstrip> listBsnstripToLoan(Integer userId) {
		List<TBsnstrip> bsnstrips = bsnstripMapper.listBsnstripToLoan(userId);
		return bsnstrips;
	}
}
