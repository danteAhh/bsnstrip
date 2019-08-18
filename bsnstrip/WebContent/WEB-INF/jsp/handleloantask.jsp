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
							<h5>借款申请表</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="signupForm" action="${ctx }/process/saveCommentComplete.do">
								<input type="hidden" id="taskId" name="taskId" value="${taskId }">
								<input type="hidden" id="taskProdId" name="taskProdId" value="${taskProdId }">
								<div class="form-group">
									<label class="col-sm-3 control-label">标题：</label>
									<div class="col-sm-6">
										<input id="loantitle" name="loantitle" class="form-control" type="text" readonly="readonly" value="${loan.loantitle }">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">借款人：</label>
									<div class="col-sm-2">
										<input type="text" id="lnman" name="lnman" class="form-control" readonly="readonly" value="${lnman }">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">借款金额：</label>
									<div class="col-sm-2">
										<input type="text" id="loanfee" name="loanfee" class="form-control" readonly="readonly" value="${loan.loanfee }">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">说明：</label>
									<div class="col-sm-8">
										<textarea id="loancontent" name="loancontent" readonly="readonly" 
													style="height: 50px;width: 600px;" class="form-control">${loan.loancontent }</textarea>
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
										<c:if test="${loan.userid != assignee }">
											<button class="btn btn-danger" type="submit" onclick="setValue();">拒绝</button>
										</c:if>
									</div>
								</div>
							</form>
							<div class="hr-line-dashed"></div>
							<div class="btn-group hidden-xs" id="CheckDetail" role="group">
								<h3>审批详情</h3>
							</div>
							<table data-striped="true" data-toggle="table" data-toolbar="#CheckDetail"
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
		});
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