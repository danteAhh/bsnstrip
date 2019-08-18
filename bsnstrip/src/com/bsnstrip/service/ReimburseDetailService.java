package com.bsnstrip.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.bsnstrip.pojo.TReimburseDetail;

public interface ReimburseDetailService {

	Integer edit(TReimburseDetail reimburseDetail);

	List<TReimburseDetail> selectByExample(Integer rbid);
	
}
