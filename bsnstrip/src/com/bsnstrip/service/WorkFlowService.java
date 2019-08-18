package com.bsnstrip.service;

import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import com.bsnstrip.pojo.TBsnstrip;
import com.bsnstrip.pojo.TEmployee;
import com.bsnstrip.pojo.TUser;

public interface WorkFlowService {
	
	void saveNewDeploy(InputStream in, String filename);
	
	List<Task> findTaskListByName(String name);
	
	void saveStartProcess(Integer Id, Integer userId, String key);
	
	String findProdId(String taskProdId);
	
	Object findBussinessByTaskId(String taskId);
	
	void saveCommentComplete(String taskId, String assignee, String text, String back);
	
	List<HistoricTaskInstance> findTaskByTaskId(String taskId);
	
	List<HistoricTaskInstance> findHisTaskByProcId(String procId);
	
	List<Comment> findCommentByTaskId(String taskId);
	
	List<Object> findTaskDetail(TUser user, String processType) throws ParseException;
	
	List<Comment> findBussinessDetail(String id, String processType, String roleStr);
	
	List<HistoricTaskInstance> findHisTaskByTaskId(String taskId);
	
	List<Deployment> listDeploy();

	List<ProcessDefinition> listProcdef();
	
	InputStream findDeployImg(String deploymentId, String imageName);
	
	InputStream generateImage(String taskId);

	String findAssignee(String taskId);
}
