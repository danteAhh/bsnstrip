package com.bsnstrip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsnstrip.pojo.City;
import com.bsnstrip.pojo.Country;
import com.bsnstrip.pojo.Province;
import com.bsnstrip.pojo.TBsnstrip;
import com.bsnstrip.pojo.TRole;
import com.bsnstrip.pojo.TUser;
import com.bsnstrip.service.BsnstripService;
import com.bsnstrip.service.RoleService;

@Controller
@RequestMapping("/bsnstrip")
public class BsnstripController {
	
	@Autowired
	private BsnstripService bsnstripService;
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("/toApplyBsnstrip.do")
	public String toApplyBsnstrip(HttpSession session, Model m) {
		TUser user = (TUser) session.getAttribute("user");
		List<TRole> roles = roleService.findRoleByUserId(user.getUserid());
		for (TRole tRole : roles) {
			Integer roleid = tRole.getRoleid();
			if(roleid == 3) {
				System.out.println(roleid);
				m.addAttribute("role", roleid);
			}
		}
		return "applybsnstrip";
	}
	
	@RequestMapping("/getProvince.do")
	@ResponseBody
	public List<Province> getProvince(HttpServletRequest request) throws IOException {
		List<Province> provinces = bsnstripService.getProvince(request);
		return provinces;
	}
	
	@RequestMapping("/getCity.do")
	@ResponseBody
	public List<City> getCity(String provinceId, HttpServletRequest request) throws IOException {
		List<City> cities = bsnstripService.getCity(provinceId, request);
		return cities;
	}
	
	@RequestMapping("/getCountry.do")
	@ResponseBody
	public List<Country> getCountry(String cityId, HttpServletRequest request) {
		List<Country> countries = bsnstripService.getCountry(cityId, request);
		return countries;
	}
	
	@RequestMapping("/listBsnstrip.do")
	@ResponseBody
	public List<TBsnstrip> listBsnstrip(HttpSession session) {
		TUser user = (TUser)session.getAttribute("user");
		List<TBsnstrip> bsnstrips = bsnstripService.listBsnstrip(user.getUserid());
		return bsnstrips;
	}
	
	@RequestMapping("/listBsnstripToLoan.do")
	@ResponseBody
	public List<TBsnstrip> listBsnstripToLoan(HttpSession session) {
		TUser user = (TUser)session.getAttribute("user");
		List<TBsnstrip> bsnstrips = bsnstripService.listBsnstripToLoan(user.getUserid());
		return bsnstrips;
	}
}
