package com.bsnstrip.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bsnstrip.pojo.TLoan;
import com.bsnstrip.pojo.TUser;
import com.bsnstrip.service.LoanService;
import com.bsnstrip.utils.NumberToCN;

@Controller
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@RequestMapping("/toApplyLoan.do")
	public String toApplyLoan() {
		return "applyloan";
	}
	
	@RequestMapping(value="/numberToCN.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public String numberToCN(String fee, HttpServletResponse response) {
		BigDecimal bigDecimal = new BigDecimal(fee);
		String numberCN = NumberToCN.number2CNMontrayUnit(bigDecimal);
		String json = JSON.toJSONString(numberCN);
		return json;
	}
	
	@RequestMapping("/listLoan.do")
	@ResponseBody
	public List<TLoan> listLoan(HttpSession session) {
		TUser user = (TUser) session.getAttribute("user");
		return loanService.listLoan(user.getUserid());
	}
	
	@RequestMapping("/findLoanfeeById.do")
	@ResponseBody
	public Integer findLoanfeeById(Integer loanId) {
		Integer loanfee = loanService.findLoanfeeById(loanId);
		return loanfee;
	}
}
