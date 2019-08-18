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
							<h5>出差申请表</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="signupForm" action="${ctx }/process/saveCommentComplete.do">
								<input type="hidden" id="taskId" name="taskId" value="${taskId }">
								<input type="hidden" id="taskProdId" name="taskProdId" value="${taskProdId }">
								<div class="form-group">
									<label class="col-sm-3 control-label">标题：</label>
									<div class="col-sm-6">
										<input id="bstitle" name="bstitle" class="form-control" type="text" readonly="readonly" value="${bsnstrip.bstitle }">
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
											value="<fmt:formatDate value="${bsnstrip.begindate }" />" style="text-align: center;" pattern="yyyy-MM-dd HH:mm:ss" />
											<span class="input-group-addon">——</span>
											<input type="text" class="form-control" name="enddate" id="enddate" readonly="readonly" 
														value="<fmt:formatDate value="${bsnstrip.enddate }" />" style="text-align: center;" pattern="yyyy-MM-dd HH:mm:ss" />
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
								<div class="form-group">
									<label class="col-sm-3 control-label">批注：</label>
									<div class="col-sm-8">
										<textarea id="comment" name="comment" class="from-control" 
													style="height: 100px;width: 600px;"></textarea>
									</div>
								</div>
								<div class="form-group">
									<input type="hidden" id="button" name="button" >
									<div class="col-sm-8 col-sm-offset-3">
										<button class="btn btn-primary" type="submit">通过</button>
										<c:if test="${bsnstrip.userid != assignee }">
											<button class="btn btn-danger" type="submit" onclick="setValue();">拒绝</button>
										</c:if>
									</div>
								</div>
							</form>
							<div class="hr-line-dashed"></div>
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
		<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
		<script>
		
		$(document).ready(function(){
			var beginDate = $("#begindate").val();
			var endDate = $("#enddate").val();
			$("#day").val(DateMinus(beginDate,endDate)+"天");
			$("#test").text($("#bscontent").text());
			
			
		});
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