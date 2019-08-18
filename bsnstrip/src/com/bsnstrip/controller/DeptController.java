package com.bsnstrip.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsnstrip.pojo.TDept;
import com.bsnstrip.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/toListDept.do")
	public String toListDept(Model m) {
		List<TDept> depts = deptService.listDepts();
		m.addAttribute("depts", depts);
		return "listdept";
	}
	
	@RequestMapping("/addDept.do")
	@ResponseBody
	public String addDept(String add_deptname) {
		
		TDept dept = new TDept();
		dept.setDeptname(add_deptname);
		
		String flag = "";
		int i = deptService.insertDept(dept);
		if(i != 0) {
			flag = "true";
		}else {
			flag = "false";
		}
		return flag;
	}
	
	@RequestMapping("/updateDept.do")
	@ResponseBody
	public String updateDept(String edit_deptid, String edit_deptname) {
		
		TDept dept = new TDept();
		dept.setDeptid(Integer.valueOf(edit_deptid));
		dept.setDeptname(edit_deptname);
		
		String flag = "";
		
		int i = deptService.updateDept(dept);
		if(i!=0) {
			flag = "true";
		}else {
			flag = "false";
		}
		return flag;
	}
	
	@RequestMapping("/deleteDept.do")
	@ResponseBody
	public int deleteDept(String deptId) {
		String[] split = deptId.split(",");
		int i = 0;
		for (String deptid : split) {
			int j = deptService.deleteDept(Integer.valueOf(deptid));
			if(j != 0) {
				i++;
			}
		}
		return i;
	}
	
	@RequestMapping("/selectDeptByDeptId.do")
	@ResponseBody
	public TDept selectDeptByDeptId(String deptId) {
		return deptService.selectDeptByDeptId(Integer.valueOf(deptId));
	}
	
	@RequestMapping("/hasDeptname.do")
	@ResponseBody
	public String hasDeptname(String deptname) {

		String flag = null;

		if (deptname == null) {
			flag = "false";
		} else {
			List<TDept> depts = deptService.selectDeptByDeptname(deptname);
			if (depts.size() == 1) {
				flag = "false";
			} else {
				flag = "true";
			}
		}

		return flag;
	}
	
	@RequestMapping("/listDept.do")
	@ResponseBody
	public List<TDept> listDept() {
		List<TDept> depts = deptService.listDepts();
		return depts;
	}
}
