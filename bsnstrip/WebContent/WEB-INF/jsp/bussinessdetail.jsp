<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>

	<head>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<link rel="shortcut icon" href="${ctx }/favicon.ico">
		<link href="${ctx }/css/bootstrap.min.css" rel="stylesheet">
		<link href="${ctx }/css/font-awesome.min.css" rel="stylesheet">
		<link href="${ctx }/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
		<link href="${ctx }/css/plugins/chosen/chosen.css" rel="stylesheet">
		<link href="${ctx }/css/animate.min.css" rel="stylesheet">
		<link href="${ctx }/css/style.min.css" rel="stylesheet">

	</head>

	<body class="gray-bg">
		<div class="wrapper wrapper-content animated fadeInRight">

			<div class="row">

				<div class="col-sm-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>详情</h5>
						</div>
						<input type="hidden" id="processType" name="processType" value="${processType }">
						<c:if test="${processType=='bsnstrip' }">
							<div class="ibox-content">
								<form class="form-horizontal m-t" id="signupForm">
									<div class="form-group">
										<label class="col-sm-3 control-label">标题：</label>
										<div class="col-sm-6">
											<input id="bstitle" name="bstitle" class="form-control" type="text" readonly="readonly" value="${bsnstrip.bstitle}">
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label">目的地：</label>
										<div class="col-sm-6">
											<input type="text" id="address" name="address" class="form-control" readonly="readonly" value="${bsnstrip.address }">
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label">出差周期：</label>
										<div class="col-sm-8">
											<div class="input-daterange input-group col-sm-8" >
												<input type="text" class="form-control" name="begindate" id="begindate" readonly="readonly" 
														value="<fmt:formatDate value="${bsnstrip.begindate }" />" 
														style="text-align: center;" pattern="yyyy-MM-dd HH:mm:ss" />
												<span class="input-group-addon">——</span>
												<input type="text" class="form-control" name="enddate" id="enddate" readonly="readonly" 
															value="<fmt:formatDate value="${bsnstrip.enddate }" />" 
															style="text-align: center;" pattern="yyyy-MM-dd HH:mm:ss" />
												<span class="input-group-addon">共</span>
												<input type="text" class="form-control" name="day" id="day" readonly="readonly" style="text-align: center;" />
											</div>
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label">说明：</label>
										<div class="col-sm-8">
											<textarea type="text" id="bscontent" name="bscontent" readonly="readonly" 
														style="height: 50px;width: 600px;" class="form-control">${bsnstrip.bscontent }</textarea>
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label">是否需要借款：</label>
											<div class="col-sm-2">
											<input type="text" id="isloan" name="isloan" class="form-control" readonly="readonly" 
													style="text-align: center;" value="${bsnstrip.isloan==0?'不需要':'需要' }">
										</div>
									</div>
								</form>
								<HR align="center" width="100%" color="#987cb9" size="2">
								<table data-striped="true" data-toggle="table"
											data-toolbar="#exampleTableEventsToolbar"
											id="exampleTableEvents" data-mobile-responsive="true"
											data-sort-name="id" data-sort-order="desc" data-search="true"
											data-show-refresh="true" data-show-columns="true"
											data-cache="false" data-icon-size="outline"
											data-page-number="true">
											<thead>
												<tr>
													<th data-field="id" data-sortable="true">任务ID</th>
													<th data-field="name" data-sortable="true">任务名称</th>
													<th data-field="assignee" data-sortable="true">办理人</th>
													<th data-field="start" data-sortable="true">审批开始时间</th>
													<th data-field="end" data-sortable="true">审批结束时间</th>
													<th data-field="comment" data-sortable="true">批注</th>
												</tr>
											</thead>
											
										<c:forEach items="${hislist }" var="list">
											<tr>
												<td data-field="id" data-sortable="true">${list.id }</td>
												<td data-field="name" data-sortable="true">${list.name }</td>
												<c:forEach items="${users }" var="user">
													<c:forEach items="${employees }" var="employee">
														<c:if test="${user.userid == list.assignee && employee.empid == user.employeeid}">
															<td data-field="assignee" data-sortable="true">${employee.empname }</td>
														</c:if>
													</c:forEach>
												</c:forEach>
												<td data-field="start" data-sortable="true">
													<fmt:formatDate value="${list.startTime }" pattern="yyyy-MM-dd HH:mm:ss" />
												</td>
												<td data-field="end" data-sortable="true">
													<fmt:formatDate value="${list.endTime }" pattern="yyyy-MM-dd HH:mm:ss" />
												</td>
											
												<c:forEach items="${comments }" var="comment">
													<c:if test="${comment.taskId == list.id }">
														<td data-field="comment" data-sortable="true">${comment.message }</td>
													</c:if>
												</c:forEach>
											</tr>
										</c:forEach>
								</table>
							</div>
						</c:if>
						
						<c:if test="${processType=='reimburse' }">
							<div class="ibox-content">
								<form class="form-horizontal m-t" id="signupForm">
									<div class="form-group">
										<label class="col-sm-3 control-label">标题：</label>
										<div class="col-sm-6">
											<input type="hidden" id="rbid" name="rbid" value="${reimburse.rbid }">
											<input id="rbtitle" name="rbtitle" class="form-control" type="text" readonly="readonly" value="${reimburse.rbtitle}">
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label">报销人：</label>
										<div class="col-sm-2">
											<input type="text" id="rbman" name="rbman" class="form-control" readonly="readonly" value="${rbman }">
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label">报销类型：</label>
										<div class="col-sm-2">
											<input type="text" id="rbtype" name=rbtype class="form-control" readonly="readonly" value="${reimburse.rbtype=='0'?'出差报销':'日常报销' }">
										</div>
										<label class="col-sm-2 control-label">报销金额：</label>
										<div class="col-sm-2">
											<input type="text" id="rbfee" name=rbfee class="form-control" readonly="readonly" value="${reimburse.rbfee }元">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">单据：</label>
										<div class="col-sm-2" id="imgBox">
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label">说明：</label>
										<div class="col-sm-8">
											<textarea id="rbcontent" name="rbcontent" readonly="readonly" 
														style="height: 50px;width: 600px;" class="form-control">${reimburse.rbcontent }</textarea>
										</div>
									</div>
								</form>
								<div class="hr-line-dashed"></div>
								<div class="btn-group hidden-xs" id="ReimburseDetail" role="group">
									<h3>报销详情</h3>
								</div>
								<table data-striped="true" data-toggle="table" data-toolbar="#ReimburseDetail"
										id="exampleTableEvents" data-mobile-responsive="true"
										data-sort-name="id" data-sort-order="desc" data-search="true"
										data-show-refresh="true" data-show-columns="true"
										data-cache="false" data-icon-size="outline"
										data-page-number="true">
									<thead>
										<tr>
											<th data-field=rbditem>项目名称</th>
											<th data-field="rbdnum">数量</th>
											<th data-field="rbdfee">单价</th>
											<th data-field="rbdcount" data-sortable="true">总价</th>
										</tr>
									</thead>
								
									<c:forEach items="${rbdetails }" var="rbdetail">
										<tr>
											<td data-field="rbditem">${rbdetail.rbditem }</td>
											<td data-field="rbdnum">${rbdetail.rbdnum }</td>
											<td data-field="rbdfee">${rbdetail.rbdfee }</td>
											<td data-field="rbdcount" data-sortable="true">${rbdetail.rbdcount }</td>
										</tr>
									</c:forEach>
								</table>
								<HR align="center" width="100%" color="#987cb9" size="2">
								<table data-striped="true" data-toggle="table"
											data-toolbar="#exampleTableEventsToolbar"
											id="exampleTableEvents" data-mobile-responsive="true"
											data-sort-name="id" data-sort-order="desc" data-search="true"
											data-show-refresh="true" data-show-columns="true"
											data-cache="false" data-icon-size="outline"
											data-page-number="true">
											<thead>
												<tr>
													<th data-field="id" data-sortable="true">任务ID</th>
													<th data-field="name" data-sortable="true">任务名称</th>
													<th data-field="assignee" data-sortable="true">办理人</th>
													<th data-field="start" data-sortable="true">审批开始时间</th>
													<th data-field="end" data-sortable="true">审批结束时间</th>
													<th data-field="comment" data-sortable="true">批注</th>
												</tr>
											</thead>
											
										<c:forEach items="${hislist }" var="list">
											<tr>
												<td data-field="id" data-sortable="true">${list.id }</td>
												<td data-field="name" data-sortable="true">${list.name }</td>
												<c:forEach items="${users }" var="user">
													<c:forEach items="${employees }" var="employee">
														<c:if test="${user.userid == list.assignee && employee.empid == user.employeeid}">
															<td data-field="assignee" data-sortable="true">${employee.empname }</td>
														</c:if>
													</c:forEach>
												</c:forEach>
												<td data-field="start" data-sortable="true">
													<fmt:formatDate value="${list.startTime }" pattern="yyyy-MM-dd HH:mm:ss" />
												</td>
												<td data-field="end" data-sortable="true">
													<fmt:formatDate value="${list.endTime }" pattern="yyyy-MM-dd HH:mm:ss" />
												</td>
											
												<c:forEach items="${comments }" var="comment">
													<c:if test="${comment.taskId == list.id }">
														<td data-field="comment" data-sortable="true">${comment.message }</td>
													</c:if>
												</c:forEach>
											</tr>
										</c:forEach>
								</table>
							</div>
						</c:if>
						
						<c:if test="${processType=='loan' }">
							<div class="ibox-content">
								<form class="form-horizontal m-t" id="signupForm">
									<div class="form-group">
										<label class="col-sm-3 control-label">标题：</label>
										<div class="col-sm-6">
											<input id="loantitle" name="loantitle" class="form-control" type="text" readonly="readonly" value="${loan.loantitle}">
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label">借款人：</label>
										<div class="col-sm-2">
											<input type="text" id="lnman" name="lnman" class="form-control" readonly="readonly" value="${lnman }">
										</div>
										<label class="col-sm-2 control-label">借款金额：</label>
										<div class="col-sm-2">
											<input type="text" id="loanfee" name=loanfee class="form-control" readonly="readonly" value="${loan.loanfee }元">
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label">说明：</label>
										<div class="col-sm-8">
											<textarea id="loancontent" name="loancontent" readonly="readonly" 
														style="height: 50px;width: 600px;" class="form-control">${loan.loancontent }</textarea>
										</div>
									</div>
								</form>
								<HR align="center" width="100%" color="#987cb9" size="2">
								<table data-striped="true" data-toggle="table"
											data-toolbar="#exampleTableEventsToolbar"
											id="exampleTableEvents" data-mobile-responsive="true"
											data-sort-name="id" data-sort-order="desc" data-search="true"
											data-show-refresh="true" data-show-columns="true"
											data-cache="false" data-icon-size="outline"
											data-page-number="true">
											<thead>
												<tr>
													<th data-field="id" data-sortable="true">任务ID</th>
													<th data-field="name" data-sortable="true">任务名称</th>
													<th data-field="assignee" data-sortable="true">办理人</th>
													<th data-field="start" data-sortable="true">审批开始时间</th>
													<th data-field="end" data-sortable="true">审批结束时间</th>
													<th data-field="comment" data-sortable="true">批注</th>
												</tr>
											</thead>
											
										<c:forEach items="${hislist }" var="list">
											<tr>
												<td data-field="id" data-sortable="true">${list.id }</td>
												<td data-field="name" data-sortable="true">${list.name }</td>
												<c:forEach items="${users }" var="user">
													<c:forEach items="${employees }" var="employee">
														<c:if test="${user.userid == list.assignee && employee.empid == user.employeeid}">
															<td data-field="assignee" data-sortable="true">${employee.empname }</td>
														</c:if>
													</c:forEach>
												</c:forEach>
												<td data-field="start" data-sortable="true">
													<fmt:formatDate value="${list.startTime }" pattern="yyyy-MM-dd HH:mm:ss" />
												</td>
												<td data-field="end" data-sortable="true">
													<fmt:formatDate value="${list.endTime }" pattern="yyyy-MM-dd HH:mm:ss" />
												</td>
											
												<c:forEach items="${comments }" var="comment">
													<c:if test="${comment.taskId == list.id }">
														<td data-field="comment" data-sortable="true">${comment.message }</td>
													</c:if>
												</c:forEach>
											</tr>
										</c:forEach>
								</table>
							</div>
						</c:if>
						
						<c:if test="${processType=='repay' }">
							<div class="ibox-content">
								<form class="form-horizontal m-t" id="signupForm">
									<div class="form-group">
										<label class="col-sm-3 control-label">标题：</label>
										<div class="col-sm-6">
											<input id="repaytitle" name="repaytitle" class="form-control" type="text" readonly="readonly" value="${repay.repaytitle}">
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label">还款人：</label>
										<div class="col-sm-2">
											<input type="text" id="rpman" name="rpman" class="form-control" readonly="readonly" value="${rpman }">
										</div>
										<label class="col-sm-2 control-label">还款金额：</label>
										<div class="col-sm-2">
											<input type="text" id="repayfee" name="repayfee" class="form-control" readonly="readonly" value="${repay.repayfee }元">
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label">说明：</label>
										<div class="col-sm-8">
											<textarea id="repaycontent" name="repaycontent" readonly="readonly" 
														style="height: 50px;width: 600px;" class="form-control">${repay.repaycontent }</textarea>
										</div>
									</div>
								</form>
								<HR align="center" width="100%" color="#987cb9" size="2">
								<table data-striped="true" data-toggle="table"
											data-toolbar="#exampleTableEventsToolbar"
											id="exampleTableEvents" data-mobile-responsive="true"
											data-sort-name="id" data-sort-order="desc" data-search="true"
											data-show-refresh="true" data-show-columns="true"
											data-cache="false" data-icon-size="outline"
											data-page-number="true">
											<thead>
												<tr>
													<th data-field="id" data-sortable="true">任务ID</th>
													<th data-field="name" data-sortable="true">任务名称</th>
													<th data-field="assignee" data-sortable="true">办理人</th>
													<th data-field="start" data-sortable="true">审批开始时间</th>
													<th data-field="end" data-sortable="true">审批结束时间</th>
													<th data-field="comment" data-sortable="true">批注</th>
												</tr>
											</thead>
											
										<c:forEach items="${hislist }" var="list">
											<tr>
												<td data-field="id" data-sortable="true">${list.id }</td>
												<td data-field="name" data-sortable="true">${list.name }</td>
												<c:forEach items="${users }" var="user">
													<c:forEach items="${employees }" var="employee">
														<c:if test="${user.userid == list.assignee && employee.empid == user.employeeid}">
															<td data-field="assignee" data-sortable="true">${employee.empname }</td>
														</c:if>
													</c:forEach>
												</c:forEach>
												<td data-field="start" data-sortable="true">
													<fmt:formatDate value="${list.startTime }" pattern="yyyy-MM-dd HH:mm:ss" />
												</td>
												<td data-field="end" data-sortable="true">
													<fmt:formatDate value="${list.endTime }" pattern="yyyy-MM-dd HH:mm:ss" />
												</td>
											
												<c:forEach items="${comments }" var="comment">
													<c:if test="${comment.taskId == list.id }">
														<td data-field="comment" data-sortable="true">${comment.message }</td>
													</c:if>
												</c:forEach>
											</tr>
										</c:forEach>
								</table>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<script src="${ctx }/js/jquery.min.js"></script>
		<script src="${ctx }/js/bootstrap.min.js"></script>
		<script src="${ctx }/js/content.min.js"></script>
		<script src="${ctx }/js/plugins/validate/jquery.validate.min.js"></script>
		<script src="${ctx }/js/plugins/validate/messages_zh.min.js"></script>
		<script src="${ctx }/js/plugins/bootstrap-table/bootstrap-table.min.js" type="text/javascript"></script>
		<script src="${ctx }/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js" type="text/javascript"></script>
		<script src="${ctx }/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"></script>
		<script src="${ctx }/js/plugins/datapicker/bootstrap-datepicker.js"></script>
		<script src="${ctx }/js/plugins/chosen/chosen.jquery.js"></script>
		<script src="${ctx }/js/demo/form-validate-demo.min.js"></script>
		<script>
		
		$(document).ready(function(){
			var beginDate = $("#begindate").val();
			var endDate = $("#enddate").val();
			$("#day").val(DateMinus(beginDate,endDate)+"天");
			$("#test").text($("#bscontent").text());
			
			var processType = $("#processType").val();
			if(processType=='reimburse'){
				calPic();
			}
			
		});
		function calPic(){
			var rbid = $("#rbid").val();
			$.ajax({
		       	 type:'post',
		         dataType:'json', 
		         data:{rbid: rbid},
		         url: getContextPath()+"/process/calculatePicNum2.do",
		         success: function(data) {
		        	 var path = eval(data);
		        	 for (var i = 0; i < path.length; i++) {
		        		var imgPic = "<img alt='单据' width='600' height='200' src='${ctx }/process/showReimburseIMG.do?picName="+path[i]+"'></img>"
		        		$("#imgBox").append(imgPic);
						console.log(path[i]);
					}
		         },
		      });
		}
		function DateMinus(date1,date2){//date1:小日期   date2:大日期
			var sdate = new Date(date1); 
			var now = new Date(date2); 
			var days = now.getTime() - sdate.getTime(); 
			var day = parseInt(days / (1000 * 60 * 60 * 24)); 
			return day; 
		}
		function setValue() {
			$("#button").val('不通过');
		}
		
			/**
			 * 封装获取上下文路径的方法 
			 * @returns {String}
			 */
			function getContextPath() {
				var local = window.location;
				//获取 pathname 属性的值 
				var pathname = local.pathname;
				//将字符串以 斜杠/切割成数组
				var arr = pathname.split("/");
				//获取上下文路径
				var contextPath = arr[1];
				return "/" + contextPath;// : /ajax
			}
		</script>
	</body>

</html>