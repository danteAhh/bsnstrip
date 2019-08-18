package com.bsnstrip.utils.workflow;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bsnstrip.pojo.TEmployee;
import com.bsnstrip.pojo.TUser;
import com.bsnstrip.service.EmployeeService;
import com.bsnstrip.service.UserService;

public class TaskAssignForManager implements TaskListener{

	public void notify(DelegateTask delegateTask) {
		// 该包没有扫描进spring容器，只能通过程序获得
		// 获取Spring容器
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		// 通过spring容器获取bean
		UserService userService = (UserService) context.getBean("userService");
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		// 当前登录人在HttpSession,通过HttpServletRequest获取登录人
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		TUser user = (TUser)request.getSession().getAttribute("user");
		// 通过当前任务人id查找部门领导
		TUser manager = userService.findManagerByUserId(user.getUserid());
		
		delegateTask.setAssignee(manager.getUserid().toString());
	}
	
}