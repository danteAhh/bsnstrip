package com.bsnstrip.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bsnstrip.service.ReimburseService;
import com.bsnstrip.utils.NumberToCN;

@Controller
@RequestMapping("/reimburse")
public class ReimburseController {
	
	@Autowired
	private ReimburseService reimburseService;
	
	@RequestMapping("/toApplyReimburse.do")
	public String toApplyBsnstrip(HttpSession session) {
		return "applyreimburse";
	}
	
	@RequestMapping(value="/numberToCN.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public String numberToCN(String fee, HttpServletResponse response) {
		BigDecimal bigDecimal = new BigDecimal(fee);
		String numberCN = NumberToCN.number2CNMontrayUnit(bigDecimal);
		String json = JSON.toJSONString(numberCN);
		return json;
	}
	
}
