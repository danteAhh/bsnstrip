package com.bsnstrip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bsnstrip.pojo.TReimburseDetail;
import com.bsnstrip.service.ReimburseDetailService;

@Controller
@RequestMapping("/reimburseDetail")
public class ReimburseDetailController {
	
	@Autowired
	private ReimburseDetailService reimburseDetailService;
	
	@RequestMapping("/edit.do")
	@ResponseBody
	public String edit(TReimburseDetail reimburseDetail) {
		Integer insert = reimburseDetailService.edit(reimburseDetail);
		if(insert != 0) {
			Integer rbdid = reimburseDetail.getRbdid();
			String jsonid = JSON.toJSONString(rbdid);
			return jsonid;
		}
		return null;
	}
	
	@RequestMapping("/toAddDetail.do")
	public String toAddDetail() {
		return "adddetail";
	}
}
