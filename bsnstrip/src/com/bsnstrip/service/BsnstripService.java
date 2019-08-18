package com.bsnstrip.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.bsnstrip.pojo.City;
import com.bsnstrip.pojo.Country;
import com.bsnstrip.pojo.Province;
import com.bsnstrip.pojo.TBsnstrip;
import com.bsnstrip.pojo.TReimburse;

public interface BsnstripService {

	void saveBsnstrip(TBsnstrip bsnstrip);
	
	List<Province> getProvince(HttpServletRequest request);
	
	List<City> getCity(String provinceId, HttpServletRequest request);
	
	List<Country> getCountry(String cityId, HttpServletRequest request);

	TBsnstrip selectByPrimaryKey(Integer baid);

	void updateBsnstripStatus(TBsnstrip bsnstrip);
	
	List<TBsnstrip> listBsnstrip(Integer userId);

	List<TBsnstrip> listBsnstripToLoan(Integer userId);
}
