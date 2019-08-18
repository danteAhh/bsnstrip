package com.bsnstrip.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsnstrip.pojo.TEmployee;
import com.bsnstrip.pojo.TRole;
import com.bsnstrip.pojo.TUser;
import com.bsnstrip.service.EmployeeService;
import com.bsnstrip.service.RoleService;
import com.bsnstrip.service.UserService;
import com.bsnstrip.utils.MD5Utils;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/toListUser.do")
	public String toListUser(HttpSession session, Model m) {
		String roleStr = "";
		TUser tUser = (TUser) session.getAttribute("user");
		List<TRole> tRoles = roleService.findRoleByUserId(tUser.getUserid());
		for (TRole tRole : tRoles) {
			roleStr += tRole.getRoleid().toString();			 // 将用户拥有的角色拼成字符串
		}
		if(roleStr.indexOf("3", 0) != -1) {
			System.out.println("我是部门领导《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
			List<TUser> users = userService.listDeptUser(tUser.getDeptid());
			List<TEmployee>	employees = new ArrayList<TEmployee>();
			List<TRole> roles = new ArrayList<TRole>();
			for (TUser temp : users) {
				Integer employeeid = temp.getEmployeeid();
				List<TRole> role = roleService.findRoleByUserId(temp.getUserid());
				for (TRole tRole : role) {
					tRole.setUserid(temp.getUserid());
					roles.add(tRole);
				}
				TEmployee employee = employeeService.findEmployeeByEmployeeId(employeeid);
				employees.add(employee);
			}
			m.addAttribute("roles", roles);
			m.addAttribute("users", users);
			m.addAttribute("employees", employees);
			
		}else {
			List<TUser> users = userService.listUser();
			List<TEmployee>	employees = new ArrayList<TEmployee>();
			List<TRole> roles = new ArrayList<TRole>();
			for (TUser temp : users) {
				Integer employeeid = temp.getEmployeeid();
				List<TRole> role = roleService.findRoleByUserId(temp.getUserid());
				for (TRole tRole : role) {
					tRole.setUserid(temp.getUserid());
					roles.add(tRole);
				}
				TEmployee employee = employeeService.findEmployeeByEmployeeId(employeeid);
				employees.add(employee);
			}
			m.addAttribute("roles", roles);
			m.addAttribute("users", users);
			m.addAttribute("employees", employees);
		}
		
		return "listuser";
	}
	
	@RequestMapping("/addUser.do")
	@ResponseBody
	public String addUser(TEmployee employee, TUser user, String roleid) {
		String flag = "";
		try {
			Integer empid = employeeService.saveEmployee(employee);
			user.setEmployeeid(empid);
			
			String password = "123456";			// 默认密码123456
			Map<String, String> generate = MD5Utils.generate(password);
			String salt = generate.get("salt");		// 获取随机盐
			String md5password = generate.get("password");		// 获取加密后的密码
			user.setPassword(md5password);
			user.setSalt(salt);
			
			user.setStatus("1");
			Integer userid = userService.saveUser(user);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String date = format.format(new Date());
			String newUserId = date + userid.toString();
			
			user.setUserid(Integer.valueOf(newUserId));
			
			userService.saveUser(user);
			
			String[] split = roleid.split(",");
			for (String id : split) {
				roleService.saveRole(Integer.valueOf(newUserId), Integer.valueOf(id));
			}
			
			flag = "true";
		} catch (NumberFormatException e) {
			flag = "false";
		}
		return flag;
	}
	
	@RequestMapping("/checkManager.do")
	@ResponseBody
	public String checkManager(String deptid, String roleid) {
		String flag = "";
		TRole manager = roleService.checkManager(Integer.valueOf(deptid), Integer.valueOf(roleid));
		if(manager==null) {
			flag = "1";
		}else {
			flag = "0";
		}
		return flag;
	}
	
	@RequestMapping("/checkLeader.do")
	@ResponseBody
	public String checkLeader() {
		String flag = "";
		TRole leader = roleService.checkLeader();
		if(leader==null) {
			flag = "1";
		}else {
			flag = "0";
		}
		return flag;
	}
	
	@RequestMapping("/checkCounter.do")
	@ResponseBody
	public String checkCounter() {
		String flag = "";
		TRole counter = roleService.checkCounter();
		if(counter==null) {
			flag = "1";
		}else {
			flag = "0";
		}
		return flag;
	}
	
	@RequestMapping("/hasUsername.do")
	@ResponseBody
	public String hasUsername(String username) {
		String flag = "";
		TUser user = userService.findUserByUsername(username);
		if(user!=null) {
			flag = "false";
		}else {
			flag = "true";
		}
		return flag;
	}
	
	@RequestMapping("/deleteUser.do")
	@ResponseBody
	public int deleteUser(HttpSession session, String userId) {
		
		TUser user = (TUser) session.getAttribute("user");
		Integer id_online = user.getUserid();
		
		String[] split = userId.split(",");
		int i = 0;
		for (String userid : split) {
			Integer id = Integer.valueOf(userid);
			if(id != id_online) {
				i += userService.deleteUser(id);
			}
		}
		if(i==split.length) {
			return i;
		}else {
			return 0;
		}
	}
	
	@RequestMapping("/toUserDetail.do")
	public String listUserDetail(Integer userid, Model m) {
		m.addAttribute("userid", userid);
		return "listuserdetail";
	}
	
	@RequestMapping("/getUserDetail.do")
	@ResponseBody
	public TUser getUserDetail(Integer userid) {
		TUser user = userService.selectByPrimaryKey(userid);
		return user;
	}
	
	@RequestMapping("/getEmployeeDetail.do")
	@ResponseBody
	public TEmployee getEmployeeDetail(Integer userid) {
		TUser user = userService.selectByPrimaryKey(userid);
		TEmployee employee = employeeService.findEmployeeByEmployeeId(user.getEmployeeid());
//		List<TRole> roles = roleService.findRoleByUserId(userid);
		return employee;
	}
	
	@RequestMapping("/getRoleDetail.do")
	@ResponseBody
	public List<TRole> getRoleDetail(Integer userid) {
		List<TRole> roles = roleService.findRoleByUserId(userid);
		return roles;
	}
	
	@RequestMapping("/editUser.do")
	@ResponseBody
	public String editUser(TEmployee employee, String roleid, TUser user) {
		
		String flag = "";
		try {
			String empsex = employee.getEmpsex();
			if(empsex.equals("1")) {
				employee.setEmpsex("男");
			}else {
				employee.setEmpsex("女");
			}
			String empdegree = employee.getEmpdegree();
			if(empdegree.equals("1")) {
				employee.setEmpdegree("大专");
			}else if(empdegree.equals("2")) {
				employee.setEmpdegree("本科");
			}else if(empdegree.equals("3")) {
				employee.setEmpdegree("硕士");
			}else if(empdegree.equals("4")) {
				employee.setEmpdegree("博士");
			}
			employeeService.saveEmployee(employee);
			userService.saveUser(user);
			String[] split = roleid.split(",");
			for (String id : split) {
				roleService.deleteRole(user.getUserid());
				roleService.saveRole(user.getUserid(), Integer.valueOf(id));
			}
			flag = "true";
		} catch (NumberFormatException e) {
			flag = "false";
		}
		return flag;
	}
	
	@RequestMapping("/toPersonalCenter.do")
	public String toPersonalCenter(HttpSession session, Model m) {
		TUser user = (TUser) session.getAttribute("user");
		Integer userid = user.getUserid();
		m.addAttribute("userid", userid);
		return "personalcenter";
	}
	
	@RequestMapping("/editMyData.do")
	@ResponseBody
	public String editMyData(TEmployee employee, TUser user) {
		
		String flag = "";
		try {
			String empsex = employee.getEmpsex();
			if(empsex.equals("1")) {
				employee.setEmpsex("男");
			}else {
				employee.setEmpsex("女");
			}
			String empdegree = employee.getEmpdegree();
			if(empdegree.equals("1")) {
				employee.setEmpdegree("大专");
			}else if(empdegree.equals("2")) {
				employee.setEmpdegree("本科");
			}else if(empdegree.equals("3")) {
				employee.setEmpdegree("硕士");
			}else if(empdegree.equals("4")) {
				employee.setEmpdegree("博士");
			}
			employeeService.saveEmployee(employee);
			userService.saveUser(user);
			flag = "true";
		} catch (NumberFormatException e) {
			flag = "false";
		}
		return flag;
	}
	
	@RequestMapping("/toChangePassword.do")
	public String toChangePassword(HttpSession session, Model m) {
		TUser user = (TUser) session.getAttribute("user");
		Integer userid = user.getUserid();
		m.addAttribute("userid", userid);
		return "changepassword";
	}
	
	
	@RequestMapping("/changePassword.do")
	@ResponseBody
	public String changePassword(HttpSession session, String oldPassword, String newPassword) {
		String flag = "";
		
		TUser user = (TUser) session.getAttribute("user");
		String password = user.getPassword();
		boolean check = userService.CheckPassword(oldPassword, password);
		if(check == false) {
			flag = "0";
		}else {
			try {
				Map<String, String> map = MD5Utils.generate(newPassword);
				String salt = map.get("salt");
				String md5password = map.get("password");
				
				TUser tUser = new TUser();
				tUser.setUserid(user.getUserid());
				tUser.setPassword(md5password);
				tUser.setSalt(salt);
				userService.saveUser(tUser);
				flag = "1";
			} catch (Exception e) {
				flag = "2";
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	@RequestMapping("/toChangeHeadPic.do")
	public String toChangeHeadPic() {
		return "changeheadpic";
	}
}