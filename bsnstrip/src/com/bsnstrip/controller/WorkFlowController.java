package com.bsnstrip.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Repeatable;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.bsnstrip.pojo.TBsnstrip;
import com.bsnstrip.pojo.TEmployee;
import com.bsnstrip.pojo.TLoan;
import com.bsnstrip.pojo.TReimburse;
import com.bsnstrip.pojo.TReimburseDetail;
import com.bsnstrip.pojo.TReimburseImg;
import com.bsnstrip.pojo.TRepay;
import com.bsnstrip.pojo.TRole;
import com.bsnstrip.pojo.TUser;
import com.bsnstrip.service.BsnstripService;
import com.bsnstrip.service.EmployeeService;
import com.bsnstrip.service.LoanService;
import com.bsnstrip.service.ReimburseDetailService;
import com.bsnstrip.service.ReimburseImgService;
import com.bsnstrip.service.ReimburseService;
import com.bsnstrip.service.RepayService;
import com.bsnstrip.service.RoleService;
import com.bsnstrip.service.UserService;
import com.bsnstrip.service.WorkFlowService;
import com.bsnstrip.utils.BaoXiaoDan;
import com.bsnstrip.utils.HuanKuanDan;
import com.bsnstrip.utils.JieKuanDan;
import com.sun.javafx.css.CalculatedValue;

@Controller
@RequestMapping("/process")
public class WorkFlowController {

	@Autowired
	private WorkFlowService workflowService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private BsnstripService bsnstripService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ReimburseService reimburseService;
	@Autowired
	private ReimburseImgService reimburseImgService;
	@Autowired
	private ReimburseDetailService reimburseDetailService;
	@Autowired
	private LoanService loanService;
	@Autowired
	private RepayService repayService;
	
	/**
	 * 流程部署
	 * @param processName
	 * @param filename
	 * @return
	 */
	@RequestMapping("/deployProcess.do")
	@ResponseBody
	public String deployProcess(String processName, MultipartFile filename) {
		String flag = "";
		try {
			workflowService.saveNewDeploy(filename.getInputStream(), processName);
			flag = "true";
		} catch (IOException e) {
			flag = "false";
		}
		return flag;
	}
	
	/**
	 * 跳转到流程部署页面
	 * @return
	 */
	@RequestMapping("/toDeployProcess.do")
	public String toDeployProcess() {
		return "deployProcess";
	}
	
	/**
	 * 查看流程信息
	 * @return
	 */
	@RequestMapping("/toListProcess.do")
	public String toListProcess(Model m) {
		List<Deployment> deployments = workflowService.listDeploy();
		List<ProcessDefinition> procdefs = workflowService.listProcdef();
		m.addAttribute("deployments", deployments);
		m.addAttribute("procdefs", procdefs);
		return "listdeploy";
	}
	
	/**
	 * 查看流程图
	 */
	@RequestMapping("/showImg.do")
	public String showImg(String deploymentId, String imgId, HttpServletResponse response) {
		InputStream in = workflowService.findDeployImg(deploymentId, imgId);
		try {
			OutputStream out = response.getOutputStream();
			// 把图片的输入流程写入resp的输出流中
			byte[] b = new byte[1024];
			for (int len = -1; (len = in.read(b)) != -1;) {
				out.write(b, 0, len);
			}
			// 关闭流
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查看流程图（任务节点）
	 */
	@RequestMapping("/viewCurrentImage.do")
	public String generateImage(String taskId, HttpServletResponse response) {
		InputStream inputStream = workflowService.generateImage(taskId);
		try {
			byte[] b = new byte[1024];
			int len;
			while ((len = inputStream.read(b, 0, 1024)) != -1) {
				response.getOutputStream().write(b, 0, len);
			}
		} catch (Exception e) {
			throw new RuntimeException("生成流程图异常！", e);
		}
		return null;
	}
	/**
	 * 启动出差申请流程
	 * @param bsnstrip
	 * @param session
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/saveStartBsnstrip.do")
	public String saveStartBsnstrip(HttpSession session, String begin, String end, TBsnstrip bsnstrip) throws ParseException {
		String roleStr = "";
		String key = "";
		
		TUser user = (TUser) session.getAttribute("user");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式化
		Date beginDate = format.parse(begin);
		Date endDate = format.parse(end);
		bsnstrip.setBegindate(beginDate);
		bsnstrip.setEnddate(endDate);
		bsnstrip.setApplydate(new Date()); //设置当前时间为申请提交时间
		bsnstrip.setStatus("0"); // 0代表审批中
		bsnstrip.setUserid(user.getUserid());
		bsnstripService.saveBsnstrip(bsnstrip);
		
		List<TRole> roles = roleService.findRoleByUserId(user.getUserid());
		for (TRole tRole : roles) {
			roleStr += tRole.getRoleid().toString();			 // 将用户拥有的角色拼成字符串
		}
		if(roleStr.indexOf("3", 0) != -1) {
			System.out.println("我是部门领导《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
			key = "bsnstripForDept";
		}else if(roleStr.indexOf("5", 0) != -1){
			System.out.println("我是普通员工《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
			key = "bsnstripProcess";
		}else {
			System.out.println("我什么都不是《《《《《《《《《《《《《《《《《《《《《《《《《《《");
		}
		workflowService.saveStartProcess(bsnstrip.getBsid(), user.getUserid(), key);
		return "redirect:/process/listMytask.do";
	}
	
	/**
	 * 启动报销申请流程
	 * @param reimburse
	 * @param session
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/saveStartReimburse.do", method=RequestMethod.POST)
	public String saveStartReimburse(TReimburse reimburse, String detailTemp, HttpSession session, 
										MultipartFile[] rbimg, HttpServletRequest request) 
						throws UnsupportedEncodingException {
		String roleStr = "";
		String key = ""; 
		
		TUser user = (TUser) session.getAttribute("user");
		
		reimburse.setUserid(user.getUserid());
		reimburse.setStatus("0");
		reimburse.setApplydate(new Date());
		reimburseService.saveReimburse(reimburse);
		
		Integer rbid = reimburse.getRbid();
		reimburseImgService.saveReimburseIMG(rbimg, rbid, request);
		
		String[] split = detailTemp.split("\\&");
		TReimburseDetail rbdDetail = new TReimburseDetail();
		for(int i=0; i<split.length; i++) {
			
			if(split[i].startsWith("rbditem")) {
				String[] rbditem = split[i].split("\\=");
				
				try {
					String decode = URLDecoder.decode(rbditem[1], "UTF-8");
					rbdDetail.setRbditem(decode);
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
				
			}else if(split[i].startsWith("rbdnum")) {
				String[] rbdnum = split[i].split("\\=");
				
				try {
					String decode = URLDecoder.decode(rbdnum[1], "UTF-8");
					rbdDetail.setRbdnum(Integer.valueOf(decode));
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
				
			}else if(split[i].startsWith("rbdfee")) {
				String[] rbdfee = split[i].split("\\=");
				
				try {
					String decode = URLDecoder.decode(rbdfee[1], "UTF-8");
					rbdDetail.setRbdfee(Integer.valueOf(decode));
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
				
			}else if(split[i].startsWith("rbdcount")) {
				String[] rbdcount = split[i].split("\\=");
				
				try {
					String decode = URLDecoder.decode(rbdcount[1], "UTF-8");
					rbdDetail.setRbdcount(Integer.valueOf(decode));
					
					rbdDetail.setRbid(rbid);
					reimburseDetailService.edit(rbdDetail);
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
			
		}
		
		List<TRole> roles = roleService.findRoleByUserId(user.getUserid());
		for (TRole tRole : roles) {
			roleStr += tRole.getRoleid().toString();			 // 将用户拥有的角色拼成字符串
		}
		if(roleStr.indexOf("3", 0) != -1) {
			System.out.println("我是部门领导《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
			key = "reimburseForDept";
		}else if(roleStr.indexOf("5", 0) != -1){
			System.out.println("我是普通员工《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
			key = "reimburseProcess";
		}else {
			System.out.println("我什么都不是《《《《《《《《《《《《《《《《《《《《《《《《《《《");
		}
		
		workflowService.saveStartProcess(reimburse.getRbid(), user.getUserid(), key);
		
		return "redirect:/process/listMytask.do";
	}
	
	/**
	 * 启动借款申请流程
	 * @param session
	 * @param loan
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/saveStartLoan.do")
	public String saveStarLoan(HttpSession session, TLoan loan) throws ParseException {
		String roleStr = "";
		String key = ""; 
		
		TUser user = (TUser)session.getAttribute("user");
		
		loan.setUserid(user.getUserid());
		loan.setApplydate(new Date());
		loan.setStatus("0");			// 0代表审批中
		loan.setIsrepay("0");			// 0代表为还款
		loanService.saveLoan(loan);
		
		List<TRole> roles = roleService.findRoleByUserId(user.getUserid());
		for (TRole tRole : roles) {
			roleStr += tRole.getRoleid().toString();			 // 将用户拥有的角色拼成字符串
		}
		if(roleStr.indexOf("3", 0) != -1) {
			System.out.println("我是部门领导《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
			key = "loanForDept";
		}else if(roleStr.indexOf("5", 0) != -1){
			System.out.println("我是普通员工《《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
			key = "loanProcess";
		}else {
			System.out.println("我什么都不是《《《《《《《《《《《《《《《《《《《《《《《《《《《");
		}
		
		workflowService.saveStartProcess(loan.getLoanid(), user.getUserid(), key);
		return "redirect:/process/listMytask.do";
	}
	
	@RequestMapping("/saveStartRepay.do")
	public String saveStartRepay(HttpSession session, TRepay repay) throws ParseException {
		
		String key = "repayProcess";
		
		repay.setApplydate(new Date());
		repay.setStatus("0");			// 0代表审批中
		TUser user = (TUser)session.getAttribute("user");
		repay.setUserid(user.getUserid());
		
		repayService.saveRepay(repay);
		
		workflowService.saveStartProcess(repay.getRepayid(), user.getUserid(), key);
		return "redirect:/process/listMytask.do";
	}
	
	/**
	 * 我的待办列表
	 * @param session
	 * @return mav
	 */
	@RequestMapping("/listMytask.do")
	public ModelAndView listMytask(HttpSession session) {

		TUser user = (TUser) session.getAttribute("user");
		List<Task> task = workflowService.findTaskListByName(String.valueOf(user.getUserid()));
		ModelAndView mav = new ModelAndView();
		mav.addObject("mytask", task);
		mav.setViewName("listmytask");
		return mav;
	}
	
	
	/**
	 * 通过bussinessKek查找业务数据
	 * @param taskId
	 * @return mav
	 * @throws IOException 
	 */
	@RequestMapping("/viewTaskFrom.do")
	
	public ModelAndView viewTaskFrom(String taskId, String taskProdId, HttpServletResponse response) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		String prodId = workflowService.findProdId(taskProdId);
		String assignee = workflowService.findAssignee(taskId);
		System.out.println("prodId:"+prodId+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		if("bsnstripProcess".equals(prodId) || "bsnstripForDept".equals(prodId)) {
			TBsnstrip bsnstrip = (TBsnstrip) workflowService.findBussinessByTaskId(taskId);
			List<Comment> comments = workflowService.findCommentByTaskId(taskId);
			List<HistoricTaskInstance> hislist = workflowService.findTaskByTaskId(taskId);
			List<TEmployee> employees = new ArrayList<TEmployee>();
			List<TUser> users = new ArrayList<TUser>();
			for (HistoricTaskInstance list : hislist) {
				TUser user = userService.selectByPrimaryKey(Integer.valueOf(list.getAssignee()));
				TEmployee employee = employeeService.findEmployeeByEmployeeId(user.getEmployeeid());
				employees.add(employee);
				users.add(user);
			}
			mav.addObject("assignee", assignee);
			mav.addObject("users", users);
			mav.addObject("employees", employees);
			mav.addObject("hislist", hislist);
			mav.addObject("bsnstrip", bsnstrip);
			mav.addObject("taskId", taskId);
			mav.addObject("comments", comments);
			mav.addObject("taskProdId", taskProdId);
			mav.setViewName("handlebsnstriptask");
		}
		
		if("reimburseProcess".equals(prodId) || "reimburseForDept".equals(prodId)) {
			TReimburse reimburse = (TReimburse) workflowService.findBussinessByTaskId(taskId);
			Integer userid = reimburse.getUserid();
			TUser rbuser = userService.selectByPrimaryKey(userid);
			TEmployee rbemp = employeeService.findEmployeeByEmployeeId(rbuser.getEmployeeid());
			String rbman = rbemp.getEmpname();
			
			List<Comment> comments = workflowService.findCommentByTaskId(taskId);
			List<HistoricTaskInstance> hislist = workflowService.findTaskByTaskId(taskId);
			List<TEmployee> employees = new ArrayList<TEmployee>();
			List<TUser> users = new ArrayList<TUser>();
			for (HistoricTaskInstance list : hislist) {
				TUser user = userService.selectByPrimaryKey(Integer.valueOf(list.getAssignee()));
				TEmployee employee = employeeService.findEmployeeByEmployeeId(user.getEmployeeid());
				employees.add(employee);
				users.add(user);
			}
			
			List<TReimburseDetail> rbdetails = reimburseDetailService.selectByExample(reimburse.getRbid());
			mav.addObject("assignee", assignee);
			mav.addObject("users", users);
			mav.addObject("rbman", rbman);
			mav.addObject("employees", employees);
			mav.addObject("hislist", hislist);
			mav.addObject("reimburse", reimburse);
			mav.addObject("rbdetails", rbdetails);
			mav.addObject("taskId", taskId);
			mav.addObject("taskProdId", taskProdId);
			mav.addObject("comments", comments);
			mav.setViewName("handlereimbursetask");
		}
		
		if("loanProcess".equals(prodId) || "loanForDept".equals(prodId)) {
			TLoan loan = (TLoan) workflowService.findBussinessByTaskId(taskId);
			Integer userid = loan.getUserid();
			TUser lnuser = userService.selectByPrimaryKey(userid);
			TEmployee lnemp = employeeService.findEmployeeByEmployeeId(lnuser.getEmployeeid());
			String lnman = lnemp.getEmpname();
			
			List<Comment> comments = workflowService.findCommentByTaskId(taskId);
			List<HistoricTaskInstance> hislist = workflowService.findTaskByTaskId(taskId);
			List<TEmployee> employees = new ArrayList<TEmployee>();
			List<TUser> users = new ArrayList<TUser>();
			for (HistoricTaskInstance list : hislist) {
				TUser user = userService.selectByPrimaryKey(Integer.valueOf(list.getAssignee()));
				TEmployee employee = employeeService.findEmployeeByEmployeeId(user.getEmployeeid());
				employees.add(employee);
				users.add(user);
			}
			mav.addObject("assignee", assignee);
			mav.addObject("users", users);
			mav.addObject("lnman", lnman);
			mav.addObject("employees", employees);
			mav.addObject("hislist", hislist);
			mav.addObject("loan", loan);
			mav.addObject("taskId", taskId);
			mav.addObject("taskProdId", taskProdId);
			mav.addObject("comments", comments);
			mav.setViewName("handleloantask");
		}
		
		if("repayProcess".equals(prodId)) {
			TRepay repay = (TRepay) workflowService.findBussinessByTaskId(taskId);
			Integer userid = repay.getUserid();
			TUser rpuser = userService.selectByPrimaryKey(userid);
			TEmployee rpemp = employeeService.findEmployeeByEmployeeId(rpuser.getEmployeeid());
			String rpman = rpemp.getEmpname();
			
			List<Comment> comments = workflowService.findCommentByTaskId(taskId);
			List<HistoricTaskInstance> hislist = workflowService.findTaskByTaskId(taskId);
			List<TEmployee> employees = new ArrayList<TEmployee>();
			List<TUser> users = new ArrayList<TUser>();
			for (HistoricTaskInstance list : hislist) {
				TUser user = userService.selectByPrimaryKey(Integer.valueOf(list.getAssignee()));
				TEmployee employee = employeeService.findEmployeeByEmployeeId(user.getEmployeeid());
				employees.add(employee);
				users.add(user);
			}
			mav.addObject("assignee", assignee);
			mav.addObject("users", users);
			mav.addObject("rpman", rpman);
			mav.addObject("employees", employees);
			mav.addObject("hislist", hislist);
			mav.addObject("repay", repay);
			mav.addObject("taskId", taskId);
			mav.addObject("taskProdId", taskProdId);
			mav.addObject("comments", comments);
			mav.setViewName("handlerepaytask");
		}
		
		return mav;
	}
	
	@RequestMapping("/calculatePicNum.do")
	@ResponseBody
	public List<String> calculatePicNum(HttpServletResponse response, String taskId) {
		TReimburse reimburse = (TReimburse) workflowService.findBussinessByTaskId(taskId);
		List<TReimburseImg> imgs = reimburseImgService.selectImgByRbid(reimburse.getRbid());
		List<String> strings = new ArrayList<String>();
		for (TReimburseImg tReimburseImg : imgs) {
			if(tReimburseImg != null) {
				String rbimgpath = tReimburseImg.getRbimgpath();
				String[] split = rbimgpath.split("\\\\");
				String imgName = split[split.length-1];
				strings.add(imgName);
			}
		}
		JSON.toJSONString(strings);
		return strings;
	}
	
	@RequestMapping("/calculatePicNum2.do")
	@ResponseBody
	public List<String> calculatePicNum2(HttpServletResponse response, Integer rbid) {
		List<TReimburseImg> imgs = reimburseImgService.selectImgByRbid(rbid);
		List<String> strings = new ArrayList<String>();
		for (TReimburseImg tReimburseImg : imgs) {
			if(tReimburseImg != null) {
				String rbimgpath = tReimburseImg.getRbimgpath();
				String[] split = rbimgpath.split("\\\\");
				String imgName = split[split.length-1];
				strings.add(imgName);
			}
		}
		JSON.toJSONString(strings);
		return strings;
	}
	
	@RequestMapping(value = "/showReimburseIMG.do")
	@ResponseBody
	public void showReimburseIMG(HttpServletRequest request, HttpServletResponse response, String picName) {
		System.out.println(picName+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		String path = request.getSession().getServletContext().getRealPath("/resource/reimburseIMG");
		System.out.println(path+"/"+picName+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			fis = new FileInputStream(new File(path+"\\\\"+picName));
			os = response.getOutputStream();
			int count = 0;
			byte[] buffer = new byte[1024 * 8];
			while ((count = fis.read(buffer)) != -1) {
				os.write(buffer, 0, count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			fis.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加批注与推进流程
	 * @param taskId
	 * @param comment
	 * @param session
	 * @return
	 */
	@RequestMapping("/saveCommentComplete.do")
	public String saveCommentComplete(String taskId, String comment, HttpSession session, String button, String taskProdId) {
		
		String back = "";
		
		TUser user = (TUser)session.getAttribute("user");
		String prodId = workflowService.findProdId(taskProdId);
		System.out.println("prodId:"+prodId+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		if("bsnstripProcess".equals(prodId) || "bsnstripForDept".equals(prodId)) {
			TBsnstrip bsnstrip = (TBsnstrip) workflowService.findBussinessByTaskId(taskId);
			if(button != null && "不通过".equals(button)){
				bsnstrip.setBack("0");
				System.out.println("设置结果值："+"0"+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			}else {
				bsnstrip.setBack("1");
				System.out.println("设置结果值："+"1"+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			}
			bsnstripService.saveBsnstrip(bsnstrip);
		}else if("reimburseProcess".equals(prodId) || "reimburseForDept".equals(prodId)) {
			TReimburse reimburse = (TReimburse) workflowService.findBussinessByTaskId(taskId);
			if(button != null && "不通过".equals(button)){
				reimburse.setBack("0");
				back = "不通过";
			}else {
				reimburse.setBack("1");
				back = "通过";
			}
			reimburseService.saveReimburse(reimburse);
		}else if("loanProcess".equals(prodId) || "loanForDept".equals(prodId)) {
			TLoan loan = (TLoan) workflowService.findBussinessByTaskId(taskId);
			if(button != null && "不通过".equals(button)){
				loan.setBack("0");
				back = "不通过";
			}else {
				loan.setBack("1");
				back = "通过";
			}
			loanService.saveLoan(loan);
		}else if("repayProcess".equals(prodId)) {
			TRepay repay = (TRepay) workflowService.findBussinessByTaskId(taskId);
			if(button != null && "不通过".equals(button)){
				repay.setBack("0");
				back = "不通过";
			}else {
				repay.setBack("1");
				back = "通过";
			}
			repayService.saveRepay(repay);
		}
		
		
		workflowService.saveCommentComplete(taskId, user.getUserid().toString(), comment, back);
		return "redirect:/process/listMytask.do";
	}
	
	/**
	 * 业务状态
	 * @param session
	 * @param m
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/toListBussiness.do")
	public String toListBussiness(HttpSession session, Model m, String processType) throws ParseException {
		TUser user = (TUser) session.getAttribute("user");
		List<Object> findTaskDetail = workflowService.findTaskDetail(user, processType);
		
		List<TBsnstrip> bsnstrips = new ArrayList<TBsnstrip>();
		List<TReimburse> reimburses = new ArrayList<TReimburse>();
		List<TLoan> loans = new ArrayList<TLoan>();
		List<TRepay> repays = new ArrayList<TRepay>();
		
		if(processType.equals("bsnstrip")) {
			for (Object object : findTaskDetail) {
				bsnstrips.add((TBsnstrip)object);
			}
			m.addAttribute("bsnstrips", bsnstrips);
			m.addAttribute("processType", processType);
		}
		
		if(processType.equals("reimburse")) {
			for (Object object : findTaskDetail) {
				reimburses.add((TReimburse)object);
			}
			m.addAttribute("reimburses", reimburses);
			m.addAttribute("processType", processType);
		}
		
		if(processType.equals("loan")) {
			for (Object object : findTaskDetail) {
				loans.add((TLoan)object);
			}
			m.addAttribute("loans", loans);
			m.addAttribute("processType", processType);
		}
		
		if(processType.equals("repay")) {
			for (Object object : findTaskDetail) {
				repays.add((TRepay)object);
			}
			m.addAttribute("repays", repays);
			m.addAttribute("processType", processType);
		}
		
		return "listbussiness";
	}
	
	/**
	 * 业务详情
	 * @param processType 
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/toBussinessDetail.do")
	public String toBussinessDetail(String id, Model m, HttpSession session, String type) throws ParseException {
		
		String roleStr = "";
		TUser user = (TUser) session.getAttribute("user");
		List<TRole> roles = roleService.findRoleByUserId(user.getUserid());
		for (TRole tRole : roles) {
			roleStr += tRole.getRoleid().toString();			 // 将用户拥有的角色拼成字符串
		}
		
		List<Comment> comments = workflowService.findBussinessDetail(id, type, roleStr);
		List<HistoricTaskInstance> hititemp = new ArrayList<HistoricTaskInstance>();
		List<HistoricTaskInstance> hiti = new ArrayList<HistoricTaskInstance>();
		for (Comment comment : comments) {
			hititemp = workflowService.findHisTaskByTaskId(comment.getTaskId());		// 通过批注查找对应的任务实例
			for (HistoricTaskInstance h : hititemp) {
				hiti.add(h);
			}
			System.out.println("待办人："+hiti.get(0).getAssignee()+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}
		
		
		List<TUser> users = new ArrayList<TUser>();
		List<TEmployee> employees = new ArrayList<TEmployee>();
		for (HistoricTaskInstance list : hiti) {			// 查找批注人对应的信息
			TUser assignee = userService.selectByPrimaryKey(Integer.valueOf(list.getAssignee()));
			TEmployee employee = employeeService.findEmployeeByEmployeeId(assignee.getEmployeeid());
			employees.add(employee);
			users.add(assignee);
		}
		
		List<Object> findTaskDetail = workflowService.findTaskDetail(user, type);

		List<TBsnstrip> bsnstrips = new ArrayList<TBsnstrip>();
		List<TReimburse> reimburses = new ArrayList<TReimburse>();
		List<TLoan> loans = new ArrayList<TLoan>();
		List<TRepay> repays = new ArrayList<TRepay>();

		if (type.equals("bsnstrip")) {
			for (Object object : findTaskDetail) {
				bsnstrips.add((TBsnstrip) object);
			}
			for (TBsnstrip bsnstrip : bsnstrips) {
				if(id.equals(bsnstrip.getBsid().toString())) {
					m.addAttribute("bsnstrip", bsnstrip);
					m.addAttribute("processType", type);
				}
			}
		}

		if (type.equals("reimburse")) {
			for (Object object : findTaskDetail) {
				reimburses.add((TReimburse) object);
			}
			for (TReimburse reimburse : reimburses) {
				if(id.equals(reimburse.getRbid().toString())) {
					List<TReimburseDetail> rbdetails = reimburseDetailService.selectByExample(reimburse.getRbid());
					Integer userid = reimburse.getUserid();
					TUser rbUser = userService.selectByPrimaryKey(userid);
					TEmployee rbEmp = employeeService.findEmployeeByEmployeeId(rbUser.getEmployeeid());
					String rbman = rbEmp.getEmpname();
					m.addAttribute("rbman", rbman);
					m.addAttribute("reimburse", reimburse);
					m.addAttribute("rbdetails", rbdetails);
					m.addAttribute("processType", type);
				}
			}
		}
		if (type.equals("loan")) {
			for (Object object : findTaskDetail) {
				loans.add((TLoan) object);
			}
			for (TLoan loan : loans) {
				if(id.equals(loan.getLoanid().toString())) {
					Integer userid = loan.getUserid();
					TUser lnUser = userService.selectByPrimaryKey(userid);
					TEmployee lnEmp = employeeService.findEmployeeByEmployeeId(lnUser.getEmployeeid());
					String lnman = lnEmp.getEmpname();
					m.addAttribute("lnman", lnman);
					m.addAttribute("loan", loan);
					m.addAttribute("processType", type);
				}
			}
		}
		
		if (type.equals("repay")) {
			for (Object object : findTaskDetail) {
				repays.add((TRepay) object);
			}
			for (TRepay repay : repays) {
				if(id.equals(repay.getRepayid().toString())) {
					Integer userid = repay.getUserid();
					TUser rpUser = userService.selectByPrimaryKey(userid);
					TEmployee rpEmp = employeeService.findEmployeeByEmployeeId(rpUser.getEmployeeid());
					String rpman = rpEmp.getEmpname();
					m.addAttribute("rpman", rpman);
					m.addAttribute("repay", repay);
					m.addAttribute("processType", type);
				}
			}
		}
		m.addAttribute("users", users);
		m.addAttribute("employees", employees);
		m.addAttribute("comments", comments);
		m.addAttribute("hislist", hiti);
		return "bussinessdetail";
	}
	
	@RequestMapping("/downloadPDF.do")
	public void downloadPDF(HttpServletRequest request, HttpServletResponse response, String id, String type) throws Exception {
		
		if(type.equals("reimburse")) {
			TReimburse reimburse = reimburseService.selectByPrimaryKey(Integer.valueOf(id));
			List<TReimburseDetail> rbDetails = reimburseDetailService.selectByExample(Integer.valueOf(id));
			TUser user = userService.selectByPrimaryKey(reimburse.getUserid());
			TEmployee employee = employeeService.findEmployeeByEmployeeId(user.getEmployeeid());
			
			String fileName = BaoXiaoDan.getTable(request, reimburse, rbDetails, employee);
			String path = request.getSession().getServletContext().getRealPath("/resource/PDF");
			
			FileInputStream in = new FileInputStream(path+"/"+fileName);
			ServletOutputStream out = response.getOutputStream();
			
			response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			IOUtils.copy(in, out);
			
			reimburse.setCheckdate(new Date());
			reimburseService.saveReimburse(reimburse);
		}
		
		if(type.equals("loan")) {
			TLoan loan = loanService.selectByPrimaryKey(Integer.valueOf(id));
			TUser user = userService.selectByPrimaryKey(loan.getUserid());
			TEmployee employee = employeeService.findEmployeeByEmployeeId(user.getEmployeeid());
			
			String fileName = JieKuanDan.getTable(request, loan, employee);
			String path = request.getSession().getServletContext().getRealPath("/resource/PDF");
			
			FileInputStream in = new FileInputStream(path+"/"+fileName);
			ServletOutputStream out = response.getOutputStream();
			
			response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			IOUtils.copy(in, out);
			
			loan.setCheckdate(new Date());
			loanService.saveLoan(loan);
			System.out.println("下载中==============================================");
		}
		
		if(type.equals("repay")) {
			TRepay repay = repayService.selectByPrimaryKey(Integer.valueOf(id));
			TUser user = userService.selectByPrimaryKey(repay.getUserid());
			TEmployee employee = employeeService.findEmployeeByEmployeeId(user.getEmployeeid());
			
			String fileName = HuanKuanDan.getTable(request, repay, employee);
			String path = request.getSession().getServletContext().getRealPath("/resource/PDF");
			
			FileInputStream in = new FileInputStream(path+"/"+fileName);
			ServletOutputStream out = response.getOutputStream();
			
			response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			IOUtils.copy(in, out);
			
			repay.setCheckdate(new Date());
			repayService.saveRepay(repay);
			System.out.println("下载中==============================================");
		}
	}
}