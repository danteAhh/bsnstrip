package com.bsnstrip.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bsnstrip.service.RepayService;
import com.bsnstrip.utils.NumberToCN;

@Controller
@RequestMapping("/repay")
public class RepayController {

	@Autowired
	private RepayService repayService;
	
	@RequestMapping("/toApplyRepay.do")
	public String toApplyRepay() {
		return "applyrepay";
	}
	
	@RequestMapping(value="/numberToCN.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public String numberToCN(String repayfee, HttpServletResponse response) {
		BigDecimal bigDecimal = new BigDecimal(repayfee);
		String numberCN = NumberToCN.number2CNMontrayUnit(bigDecimal);
		String json = JSON.toJSONString(numberCN);
		return json;
	}
}
