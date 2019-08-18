package com.bsnstrip.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.bpmn.diagram.ProcessDiagramGenerator;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bsnstrip.pojo.TBsnstrip;
import com.bsnstrip.pojo.TLoan;
import com.bsnstrip.pojo.TReimburse;
import com.bsnstrip.pojo.TRepay;
import com.bsnstrip.pojo.TRole;
import com.bsnstrip.pojo.TUser;
import com.bsnstrip.service.BsnstripService;
import com.bsnstrip.service.LoanService;
import com.bsnstrip.service.ReimburseImgService;
import com.bsnstrip.service.ReimburseService;
import com.bsnstrip.service.RepayService;
import com.bsnstrip.service.WorkFlowService;
import com.bsnstrip.utils.BaoXiaoDan;

import sun.security.action.PutAllAction;

@Service
public class WorkFlowServiceImpl implements WorkFlowService {

	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private FormService formService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private ProcessEngineConfiguration processEngineConfiguration;
	@Autowired
	private BsnstripService bsnstripService;
	@Autowired
	private ReimburseImgService reimburseImgService;
	@Autowired
	private ReimburseService reimburseService;
	@Autowired
	private LoanService loanService;
	@Autowired
	private RepayService repayService;

	/**
	 * 部署流程
	 */
	public void saveNewDeploy(InputStream in, String processName) {

		try {
			ZipInputStream zipInputStream = new ZipInputStream(in);
			repositoryService.createDeployment() // 创建部署对象
					.name(processName) // 添加部署名称
					.addZipInputStream(zipInputStream).deploy(); // 完成部署
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查找流程部署
	 */
	public List<Deployment> listDeploy() {
		List<Deployment> deployments = repositoryService.createDeploymentQuery().list();
		return deployments;
	}

	/**
	 * 查找流程定义
	 * 
	 * @return
	 */
	public List<ProcessDefinition> listProcdef() {
		List<Deployment> deployments = this.listDeploy();
		List<ProcessDefinition> prodis = new ArrayList<ProcessDefinition>();
		for (Deployment deployment : deployments) {
			String deployId = deployment.getId();
			prodis.addAll(repositoryService.createProcessDefinitionQuery().deploymentId(deployId).list());
		}
		return prodis;
	}

	/**
	 * 查看流程图
	 */
	public InputStream findDeployImg(String deploymentId, String imageName) {
		Context.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);
		InputStream in = repositoryService.getResourceAsStream(deploymentId, imageName);
		return in;
	}

	/**
	 * 查看流程图（任务节点）
	 * 
	 * @param pProcessInstanceId
	 * @param response
	 * @throws Exception
	 */
	public InputStream generateImage(String taskId) {

		List<Task> tasks = taskService.createTaskQuery().taskId(taskId).list();
		Task task = tasks.get(0);
		// 流程定义
		BpmnModel bpmnModel = repositoryService.getBpmnModel(task.getProcessDefinitionId());

		// 正在活动节点
		List<String> activeActivityIds = runtimeService.getActiveActivityIds(task.getExecutionId());

		Context.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);
		// 生成流图片
		InputStream inputStream = ProcessDiagramGenerator.generateDiagram(bpmnModel, "png", activeActivityIds);
		
		return inputStream;
	}

	/**
	 * 通过待办人姓名查找待办任务
	 */
	public List<Task> findTaskListByName(String name) {
		List<Task> list = taskService.createTaskQuery().taskAssignee(name).orderByTaskCreateTime().desc().list();
		return list;
	}

	/**
	 * 保存出差申请表信息并启动流程
	 */
	public void saveStartProcess(Integer Id, Integer userId, String key) {
		// 业务数据与流程数据相关联 bussiness_key:存在业务数据ID
		// ${assignee} 流程变量表达式
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("assignee", userId.toString());
		// 绑定业务id: bsID
		String BUSSINESS_KEY = key + "." + Id;
		runtimeService.startProcessInstanceByKey(key, BUSSINESS_KEY, map);
	}

	/**
	 * 判断任务类型
	 * @param taskProdId
	 * @return
	 */
	public String findProdId(String taskProdId) {
		String[] split = taskProdId.split("\\:");
		return split[0].toString();
	}
	/**
	 * 通过任务id和bussinessKey查找业务表
	 */
	public Object findBussinessByTaskId(String taskId) {
		// 1,使用任务ID，查询对象task
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		// 2.使用任务ID，获取实例ID
		String processInstanceId = task.getProcessInstanceId();
		// 3.使用流程实例id，查询流程实例
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId)
				.singleResult();
		// 4.使用流程实例对象获取BusinessKey
		String business_key = pi.getBusinessKey();
		// 5.获取Business_key对应的主键ID
		String id = "";
		String type = "";
		if (StringUtils.isNotBlank(business_key)) {
			// 截取字符串
			id = business_key.split("\\.")[1].toString();
			type = business_key.split("\\.")[0].toString();
		}
		if("bsnstripProcess".equals(type) || "bsnstripForDept".equals(type)) {
			TBsnstrip bsnstrip = bsnstripService.selectByPrimaryKey(Integer.valueOf(id));
			return bsnstrip;
		}else if("reimburseProcess".equals(type) || "reimburseForDept".equals(type)) {
			TReimburse reimburse = reimburseService.selectByPrimaryKey(Integer.valueOf(id));
			return reimburse;
		}else if("loanProcess".equals(type) || "loanForDept".equals(type)) {
			TLoan loan = loanService.selectByPrimaryKey(Integer.valueOf(id));
			return loan;
		}else if("repayProcess".equals(type)) {
			TRepay repay = repayService.selectByPrimaryKey(Integer.valueOf(id));
			return repay;
		}
		return null;
	}

	/**
	 * 添加批注与推进出差流程
	 */
	public void saveCommentComplete(String taskId, String assignee, String comment, String back) {
		
		if(comment==null || comment.equals("")){
			comment = "-";
		}
		Authentication.setAuthenticatedUserId(assignee);
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		String processInstanceId = task.getProcessInstanceId();
		String processDefinitionId = task.getProcessDefinitionId();
		String prodId = this.findProdId(processDefinitionId);
		if("bsnstripProcess".equals(prodId) || "bsnstripForDept".equals(prodId)) {
			taskService.addComment(taskId, processInstanceId, comment);
			taskService.complete(taskId);
		}else if("reimburseProcess".equals(prodId) || "reimburseForDept".equals(prodId)) {
			TReimburse reimburse = (TReimburse) this.findBussinessByTaskId(taskId);
			Integer rbfee = reimburse.getRbfee();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("rbfee", rbfee);
			map.put("back", back);
			taskService.addComment(taskId, processInstanceId, comment);
			taskService.complete(taskId, map);
		}else if("loanProcess".equals(prodId) || "loanForDept".equals(prodId)) {
			TLoan loan = (TLoan) this.findBussinessByTaskId(taskId);
			Integer loanfee = loan.getLoanfee();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("loanfee", loanfee);
			map.put("back", back);
			taskService.addComment(taskId, processInstanceId, comment);
			taskService.complete(taskId, map);
		}else if("repayProcess".equals(prodId)) {
			taskService.addComment(taskId, processInstanceId, comment);
			taskService.complete(taskId);
		}
	}

	/**
	 * 通过任务ID查找正在进行的任务
	 */
	public List<HistoricTaskInstance> findTaskByTaskId(String taskId) {
		Task task = taskService.createTaskQuery()//
				.taskId(taskId)// 使用任务ID查询
				.singleResult();
		// 获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		// 使用流程实例ID，查询历史任务，获取历史任务对应的每个任务ID
		List<HistoricTaskInstance> htiList = this.findHisTaskByProcId(processInstanceId);
		return htiList;
	}

	/**
	 * 同过流程ID查找流程实例
	 */
	public List<HistoricTaskInstance> findHisTaskByProcId(String procId) {
		// 使用流程实例ID，查询历史任务，获取历史任务对应的每个任务ID
		List<HistoricTaskInstance> htiList = historyService.createHistoricTaskInstanceQuery()// 历史任务表查询
				.processInstanceId(procId)// 使用流程实例ID查询
				.list();
		return htiList;
	}
	
	/**
	 * 通过任务id查找历史任务记录
	 */
	public List<HistoricTaskInstance> findHisTaskByTaskId(String taskId) {
		List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().taskId(taskId).list();
		return list;

	}

	/**
	 * 查看批注
	 */
	public List<Comment> findCommentByTaskId(String taskId) {

		List<Comment> historyCommnets = new ArrayList<Comment>();
		// 1) 获取流程实例的ID
		Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId())
										.singleResult();
		// 2）通过流程实例查询所有的(用户任务类型)历史活动
		List<HistoricActivityInstance> hais = historyService.createHistoricActivityInstanceQuery()
															.processInstanceId(pi.getId()).activityType("userTask").list();
		// 3）查询每个历史任务的批注
		for (HistoricActivityInstance hai : hais) {
			String historytaskId = hai.getTaskId();
			List<Comment> comments = taskService.getTaskComments(historytaskId);
			// 4）如果当前任务有批注信息，添加到集合中
			if (comments != null && comments.size() > 0) {
				historyCommnets.addAll(comments);
			}
		}
		// 5）返回
		return historyCommnets;
	}

	/**
	 * 通过办理人查找业务列表
	 * @throws ParseException 
	 */
	public List<Object> findTaskDetail(TUser user, String processType) throws ParseException {

		List<HistoricTaskInstance> tasks = historyService.createHistoricTaskInstanceQuery()
														.taskAssignee(user.getUserid().toString()).list();
		
		List<Object> list = new ArrayList<Object>();
		List<HistoricProcessInstance> bsnstripstemp = new ArrayList<HistoricProcessInstance>();
		List<HistoricProcessInstance> reimbursetemp = new ArrayList<HistoricProcessInstance>();
		List<HistoricProcessInstance> loantemp = new ArrayList<HistoricProcessInstance>();
		List<HistoricProcessInstance> repaytemp = new ArrayList<HistoricProcessInstance>();
		
		for (HistoricTaskInstance historicTaskInstance : tasks) {
			String processInstanceId = historicTaskInstance.getProcessInstanceId();		// 获取流程实例ID
			List<HistoricProcessInstance> hpis = historyService.createHistoricProcessInstanceQuery()
																.processInstanceId(processInstanceId).list();
			HistoricProcessInstance historicProcessInstance = hpis.get(0);				// 获取流程实例
			
			String bussinesstype = historicProcessInstance.getBusinessKey().split("\\.")[0].toString();
			if("bsnstripProcess".equals(bussinesstype) || "bsnstripForDept".equals(bussinesstype)) {
				bsnstripstemp.add(historicProcessInstance);
			}
			if("reimburseProcess".equals(bussinesstype) || "reimburseForDept".equals(bussinesstype)) {
				reimbursetemp.add(historicProcessInstance);
			}
			if("loanProcess".equals(bussinesstype) || "loanForDept".equals(bussinesstype)) {
				loantemp.add(historicProcessInstance);
			}
			if("repayProcess".equals(bussinesstype)) {
				repaytemp.add(historicProcessInstance);
			}
		}
		
		if(processType.equals("bsnstrip")) {
			for (HistoricProcessInstance historicProcessInstance : bsnstripstemp) {
				String bussinessId = historicProcessInstance.getBusinessKey().split("\\.")[1].toString();	// 获取业务键
				TBsnstrip bsnstrip = bsnstripService.selectByPrimaryKey(Integer.valueOf(bussinessId));		// 获取业务表
				Date time = historicProcessInstance.getEndTime();	// 获取流程结束时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		// 日期格式化
				if (time != null && !"".equals(time.toString())) { 			// 如果存在结束时间，说明流程结束
					String fmDate = format.format(time);				// 日期格式化为字符串
					Date endTime = format.parse(fmDate);
					bsnstrip.setDealdate(endTime); 	// 将结束时间赋值给出差表
					bsnstrip.setStatus("1"); // 设置出差表的状态为已审批
					bsnstripService.updateBsnstripStatus(bsnstrip);
				}
				list.add(bsnstrip);
			}
			return list;
		}
		if(processType.equals("reimburse")) {
			for (HistoricProcessInstance historicProcessInstance : reimbursetemp) {
				String bussinessId = historicProcessInstance.getBusinessKey().split("\\.")[1].toString();	// 获取业务键
				TReimburse reimburse = reimburseService.selectByPrimaryKey(Integer.valueOf(bussinessId));
				Date time = historicProcessInstance.getEndTime();	// 获取流程结束时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		// 日期格式化
				if (time != null && !"".equals(time.toString())) { // 如果存在结束时间，说明流程结束
					String fmDate = format.format(time);				// 日期格式化为字符串
					Date endTime = format.parse(fmDate);
					reimburse.setDeaeldate(endTime); // 将结束时间赋值给出差表
					reimburse.setStatus("1"); // 设置报销表的状态为已审批
					reimburseService.updateReimburseStatus(reimburse);
				}
				list.add(reimburse);
			}
			return list;
		}
		
		if(processType.equals("loan")) {
			for (HistoricProcessInstance historicProcessInstance : loantemp) {
				String bussinessId = historicProcessInstance.getBusinessKey().split("\\.")[1].toString();	// 获取业务键
				TLoan loan = loanService.selectByPrimaryKey(Integer.valueOf(bussinessId));
				Date time = historicProcessInstance.getEndTime();	// 获取流程结束时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		// 日期格式化
				if (time != null && !"".equals(time.toString())) { // 如果存在结束时间，说明流程结束
					String fmDate = format.format(time);				// 日期格式化为字符串
					Date endTime = format.parse(fmDate);
					loan.setDealdate(endTime); // 将结束时间赋值给出差表
					loan.setStatus("1"); // 设置报销表的状态为已审批
					loanService.updateLoanStatus(loan);
				}
				list.add(loan);
			}
			return list;
		}
		
		if(processType.equals("repay")) {
			for (HistoricProcessInstance historicProcessInstance : repaytemp) {
				String bussinessId = historicProcessInstance.getBusinessKey().split("\\.")[1].toString();	// 获取业务键
				TRepay repay = repayService.selectByPrimaryKey(Integer.valueOf(bussinessId));
				Date time = historicProcessInstance.getEndTime();	// 获取流程结束时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		// 日期格式化
				if (time != null && !"".equals(time.toString())) { // 如果存在结束时间，说明流程结束
					String fmDate = format.format(time);				// 日期格式化为字符串
					Date endTime = format.parse(fmDate);
					repay.setDealdate(endTime); // 将结束时间赋值给出差表
					repay.setStatus("1"); // 设置报销表的状态为已审批
					repayService.updateLoanStatus(repay);
				}
				list.add(repay);
			}
			return list;
		}
		return null;
	}

	/**
	 * 查找业务详情-批注
	 */
	public List<Comment> findBussinessDetail(String id, String type, String roleStr) {
		String key = "";
		
		if(type.equals("bsnstrip")) {
			
			if(roleStr.indexOf("3", 0) != -1) {
				System.out.println("我是部门领导《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
				key = "bsnstripForDept.";
			}else if(roleStr.indexOf("5", 0) != -1){
				System.out.println("我是普通员工《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
				key = "bsnstripProcess.";
			}else {
				System.out.println("我什么都不是《《《《《《《《《《《《《《《《《《《《《《《《《《《");
			}
			
			StringBuffer businessKey = new StringBuffer(key);
			businessKey.append(id);
			List<HistoricProcessInstance> hpis = historyService.createHistoricProcessInstanceQuery()
															.processInstanceBusinessKey(businessKey.toString()).list();
			System.out.println("历史流程实例："+hpis.get(0)+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			List<Comment> taskCommentTemp = new ArrayList<Comment>();
			List<Comment> comments = new ArrayList<Comment>();
			
			for (HistoricProcessInstance historicProcessInstance : hpis) {
				List<HistoricTaskInstance> hitasks = historyService.createHistoricTaskInstanceQuery()
															.processInstanceId(historicProcessInstance.getId()).list();
				System.out.println("历史任务实例："+hitasks.get(0)+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				for (HistoricTaskInstance hitask : hitasks) {
					taskCommentTemp = taskService.getTaskComments(hitask.getId());
					for (Comment comment : taskCommentTemp) {
						comments.add(comment);
					}
				}
			}
			return comments;
		}
		
		if(type.equals("reimburse")) {
			
			if(roleStr.indexOf("3", 0) != -1) {
				System.out.println("我是部门领导《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
				key = "reimburseForDept.";
			}else if(roleStr.indexOf("5", 0) != -1){
				System.out.println("我是普通员工《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
				key = "reimburseProcess.";
			}else {
				System.out.println("我什么都不是《《《《《《《《《《《《《《《《《《《《《《《《《《《");
			}
			
			StringBuffer businessKey = new StringBuffer(key);
			businessKey.append(id);
			List<HistoricProcessInstance> hpis = historyService.createHistoricProcessInstanceQuery()
														.processInstanceBusinessKey(businessKey.toString()).list();
			List<Comment> taskCommentTemp = new ArrayList<Comment>();
			List<Comment> comments = new ArrayList<Comment>();
			for (HistoricProcessInstance historicProcessInstance : hpis) {
				List<HistoricTaskInstance> hitasks = historyService.createHistoricTaskInstanceQuery()
															.processInstanceId(historicProcessInstance.getId()).list();
				System.out.println("历史任务实例："+hitasks.get(0)+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				for (HistoricTaskInstance hitask : hitasks) {
					taskCommentTemp = taskService.getTaskComments(hitask.getId());
					for (Comment comment : taskCommentTemp) {
						comments.add(comment);
					}
				}
			}
			return comments;
		}
		
		if(type.equals("loan")) {
			
			if(roleStr.indexOf("3", 0) != -1) {
				System.out.println("我是部门领导《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
				key = "loanForDept.";
			}else if(roleStr.indexOf("5", 0) != -1){
				System.out.println("我是普通员工《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
				key = "loanProcess.";
			}else {
				System.out.println("我什么都不是《《《《《《《《《《《《《《《《《《《《《《《《《《《");
			}
			
			StringBuffer businessKey = new StringBuffer(key);
			businessKey.append(id);
			List<HistoricProcessInstance> hpis = historyService.createHistoricProcessInstanceQuery()
														.processInstanceBusinessKey(businessKey.toString()).list();
			List<Comment> taskCommentTemp = new ArrayList<Comment>();
			List<Comment> comments = new ArrayList<Comment>();
			for (HistoricProcessInstance historicProcessInstance : hpis) {
				List<HistoricTaskInstance> hitasks = historyService.createHistoricTaskInstanceQuery()
															.processInstanceId(historicProcessInstance.getId()).list();
				System.out.println("历史任务实例："+hitasks.get(0)+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				for (HistoricTaskInstance hitask : hitasks) {
					taskCommentTemp = taskService.getTaskComments(hitask.getId());
					for (Comment comment : taskCommentTemp) {
						comments.add(comment);
					}
				}
			}
			return comments;
		}
		
		if(type.equals("repay")) {
			StringBuffer businessKey = new StringBuffer("repayProcess.");
			businessKey.append(id);
			List<HistoricProcessInstance> hpis = historyService.createHistoricProcessInstanceQuery()
														.processInstanceBusinessKey(businessKey.toString()).list();
			List<Comment> taskCommentTemp = new ArrayList<Comment>();
			List<Comment> comments = new ArrayList<Comment>();
			for (HistoricProcessInstance historicProcessInstance : hpis) {
				List<HistoricTaskInstance> hitasks = historyService.createHistoricTaskInstanceQuery()
															.processInstanceId(historicProcessInstance.getId()).list();
				System.out.println("历史任务实例："+hitasks.get(0)+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				for (HistoricTaskInstance hitask : hitasks) {
					taskCommentTemp = taskService.getTaskComments(hitask.getId());
					for (Comment comment : taskCommentTemp) {
						comments.add(comment);
					}
				}
			}
			return comments;
		}
		
		return null;
	}

	/**
	 * 通过任务id查找待办人
	 */
	public String findAssignee(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		String assignee = task.getAssignee();
		return assignee;
	}
}
