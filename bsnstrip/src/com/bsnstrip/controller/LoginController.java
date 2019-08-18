package com.bsnstrip.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsnstrip.pojo.TEmployee;
import com.bsnstrip.pojo.TRole;
import com.bsnstrip.pojo.TUser;
import com.bsnstrip.service.EmployeeService;
import com.bsnstrip.service.RoleService;
import com.bsnstrip.service.UserService;



@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public String login(String username, String password, HttpSession session) {
		
		String flag = null;
		System.out.println(password);
		TUser user = userService.findUserByUsername(username);
		
		if(user != null) {
			String status = user.getStatus();
			
			if(status.equals("0")) {
				flag = "2";
			}else {
				boolean check = userService.CheckPassword(password, user.getPassword());
				if(check == true) {
					
					TEmployee employee = employeeService.findEmployeeByEmployeeId(user.getEmployeeid());
					List<TRole> roles = roleService.findRoleByUserId(user.getUserid());
					TRole role = new TRole();
					
					for (TRole tRole : roles) {
						String rolename = tRole.getRolename();
						if(rolename.equals("超级管理员")) {
							role = tRole;
							break;
						}else if(rolename.equals("总经理")){
							role = tRole;
							break;
						}else if(rolename.equals("部门领导")){
							role = tRole;
							break;
						}else if(rolename.equals("财务人员")){
							role = tRole;
							break;
						}else {
							role = tRole;
							break;
						}
					}
					flag = "1";
					// 将登录的用户信息存放到Session中
					session.setAttribute("user", user);
					session.setAttribute("employee", employee);
					session.setAttribute("role", role);
				}else {
					flag = "0";
				}
			}
		}else {
			flag = "0";
		}
		
		return flag;
		
	}

	@RequestMapping("/index.do")
	public String index(HttpSession session) {
		return "index";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login.jsp";
	}
}
