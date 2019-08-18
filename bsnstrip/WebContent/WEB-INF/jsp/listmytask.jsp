<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title></title>
<link rel="shortcut icon" href="${ctx }/favicon.ico">
<link href="${ctx }/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/css/font-awesome.min.css" rel="stylesheet">
<link href="${ctx }/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
<link href="${ctx }/css/plugins/chosen/chosen.css" rel="stylesheet">
<link href="${ctx }/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<link href="${ctx }/css/animate.min.css" rel="stylesheet">
<link href="${ctx }/css/style.min.css" rel="stylesheet">
<base target="iframe0" />

</head>

<body class="gray-bg">
	<div class="ibox float-e-margins">
		<div class="ibox-content">
			<div class="row row-lg">
				<div class="col-sm-12">
					<div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
						<h3>待办事务</h3>
					</div>
					<table data-striped="true" data-toggle="table" data-toolbar="#exampleTableEventsToolbar"
						id="exampleTableEvents" data-mobile-responsive="true" data-sort-name="id"
						data-sort-order="desc" data-search="true" data-show-refresh="true"
						data-show-columns="true" data-pagination="true" data-cache="false" data-icon-size="outline"
						data-page-number="true" data-page-list="[5,10,20,25]">
						<thead>
							<tr>
								<th data-field="id" data-sortable="true">任务ID</th>
								<th data-field="name">任务名称</th>
								<th data-field="starttime">创建时间</th>
								<th data-field="assignee">办理人</th>
								<th data-field="operate">操作</th>
							</tr>
						</thead>
						<c:forEach items="${mytask }" var="task">
							<tr>
								<td data-field="id" data-sortable="true">${task.id }</td>
								<td data-field="name">${task.name }</td>
								<td data-field="starttime">
									<fmt:formatDate value="${task.createTime }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td data-field="assignee">${employee.empname }</td>
								<td data-field="operate">
									<a href="${ctx }/process/viewTaskFrom.do?taskId=${task.id}&taskProdId=${task.processDefinitionId}" target="_self"><span class="btn btn-primary btn-xs">办理任务</span></a>
									<a href="${ctx }/process/viewCurrentImage.do?taskId=${task.id}" target="_self"><span class="btn btn-primary btn-xs">查看流程图</span></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<script src="${ctx }/js/jquery.min.js" type="text/javascript" type="text/javascript"></script>
	<script src="${ctx }/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${ctx }/js/content.min.js" type="text/javascript"></script>
	<script src="${ctx }/js/plugins/chosen/chosen.jquery.js" type="text/javascript"></script>
	<script src="${ctx }/js/plugins/validate/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctx }/js/plugins/validate/messages_zh.min.js" type="text/javascript"></script>
	<script src="${ctx }/js/plugins/bootstrap-table/bootstrap-table.min.js" type="text/javascript"></script>
	<script src="${ctx }/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js" type="text/javascript"></script>
	<script src="${ctx }/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"></script>
	<script src="${ctx }/js/plugins/sweetalert/sweetalert.min.js"></script>
	<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>