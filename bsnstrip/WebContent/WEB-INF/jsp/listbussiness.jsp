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
<base target="iframe0">

</head>

<body class="gray-bg">
	<div class="ibox float-e-margins">
		<div class="ibox-content">
			<div class="row row-lg">
				<div class="col-sm-12">
				<c:if test="${processType=='bsnstrip' }">
					<div class="btn-group hidden-xs" id="exampleTableEventsToolbar"
						role="group">
					</div>
					<table data-striped="true"
						data-toolbar="#exampleTableEventsToolbar" data-toggle="table"
						id="exampleTableEvents" data-mobile-responsive="true" data-sort-name="applydate"
						data-sort-order="desc" data-search="true" data-show-refresh="true"
						data-show-columns="true" data-pagination="true" data-cache="false" data-icon-size="outline"
						data-page-number="true" data-page-list="[5,10,20,25]">
						<thead>
							<tr>
								<th data-field="bstitle" >标题</th>
								<th data-field="applydate" data-sortable="true">申请时间</th>
								<th data-field="dealdate" >审批结束时间</th>
								<th data-field="status" >状态</th>
								<th data-field="handle" >操作</th>
							</tr>
						</thead>
						<c:forEach items="${bsnstrips }" var="bsnstrip">
							<c:if test="${bsnstrip.userid==user.userid }">
							<tr>
								<td data-field="bstitle" >${bsnstrip.bstitle }</td>
								<td data-field="applydate">
									<fmt:formatDate value="${bsnstrip.applydate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
								</td>
								<td data-field="dealdate" >
									<fmt:formatDate value="${bsnstrip.dealdate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
								</td>
								<td data-field="status">${bsnstrip.status==0?'审批中':bsnstrip.back==0?'不通过':'通过' }</td>
								<td data-field="handle" >
									<a href="${ctx }/process/toBussinessDetail.do?id=${bsnstrip.bsid}&type=${processType }" target="_self">
										<span class="btn btn-primary btn-xs">详细信息</span>
									</a>
								</td>
							</tr>
							</c:if>
						</c:forEach>
					</table>
					</c:if>
					
					
					<c:if test="${processType=='reimburse' }">
						<div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
						</div>
						<table data-striped="true"
							data-toolbar="#exampleTableEventsToolbar" data-toggle="table"
							id="exampleTableEvents" data-mobile-responsive="true" data-sort-name="applydate"
							data-sort-order="desc" data-search="true" data-show-refresh="true"
							data-show-columns="true" data-pagination="true" data-cache="false" data-icon-size="outline"
							data-page-number="true" data-page-list="[5,10,20,25]">
							<thead>
								<tr>
									<th data-field="rbtitle" >标题</th>
									<th data-field="applydate" data-sortable="true">申请时间</th>
									<th data-field="deaaldate" >审批结束时间</th>
									<th data-field="status" >状态</th>
									<th data-field="handle" >操作</th>
								</tr>
							</thead>
							<c:forEach items="${reimburses }" var="reimburse">
								<c:if test="${reimburse.userid==user.userid }">
									<tr>
										<td data-field="rbtitle" >${reimburse.rbtitle }</td>
										<td data-field="applydate">
											<fmt:formatDate value="${reimburse.applydate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
										</td>
										<td data-field="deaeldate" >
											<fmt:formatDate value="${reimburse.deaeldate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
										</td>
										<td data-field="status">${reimburse.status==0?'审批中':reimburse.back==0?'不通过':'通过' }</td>
										<td data-field="handle" >
											<a href="${ctx }/process/toBussinessDetail.do?id=${reimburse.rbid}&type=${processType }" target="_self">
												<span class="btn btn-primary btn-xs">详细信息</span>
											</a>
											<c:if test="${reimburse.status==1 && reimburse.back==1 }">
												<a href="${ctx }/process/downloadPDF.do?id=${reimburse.rbid}&type=${processType }">
													<span class="btn btn-success btn-xs">下载报销单</span>
												</a>
											</c:if>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</table>
					</c:if>
					
					<c:if test="${processType=='loan' }">
						<div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
						</div>
						<table data-striped="true"
							data-toolbar="#exampleTableEventsToolbar" data-toggle="table"
							id="exampleTableEvents" data-mobile-responsive="true" data-sort-name="applydate"
							data-sort-order="desc" data-search="true" data-show-refresh="true"
							data-show-columns="true" data-pagination="true" data-cache="false" data-icon-size="outline"
							data-page-number="true" data-page-list="[5,10,20,25]">
							<thead>
								<tr>
									<th data-field="rbtitle" >标题</th>
									<th data-field="applydate" data-sortable="true">申请时间</th>
									<th data-field="deaaldate" >审批结束时间</th>
									<th data-field="status" >状态</th>
									<th data-field="handle" >操作</th>
								</tr>
							</thead>
							<c:forEach items="${loans }" var="loan">
								<c:if test="${loan.userid==user.userid }">
									<tr>
										<td data-field="loantitle" >${loan.loantitle }</td>
										<td data-field="applydate">
											<fmt:formatDate value="${loan.applydate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
										</td>
										<td data-field="dealdate" >
											<fmt:formatDate value="${loan.dealdate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
										</td>
										<td data-field="status">${loan.status==0?'审批中':loan.back==0?'不通过':'通过' }</td>
										<td data-field="handle" >
											<a href="${ctx }/process/toBussinessDetail.do?id=${loan.loanid}&type=${processType }" target="_self">
												<span class="btn btn-primary btn-xs">详细信息</span>
											</a>
											<c:if test="${loan.status==1 && loan.back==1 }">
												<a href="${ctx }/process/downloadPDF.do?id=${loan.loanid}&type=${processType }">
													<span class="btn btn-success btn-xs">下载借款单</span>
												</a>
											</c:if>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</table>
					</c:if>
					
					<c:if test="${processType=='repay' }">
						<div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
						</div>
						<table data-striped="true"
							data-toolbar="#exampleTableEventsToolbar" data-toggle="table"
							id="exampleTableEvents" data-mobile-responsive="true" data-sort-name="applydate"
							data-sort-order="desc" data-search="true" data-show-refresh="true"
							data-show-columns="true" data-pagination="true" data-cache="false" data-icon-size="outline"
							data-page-number="true" data-page-list="[5,10,20,25]">
							<thead>
								<tr>
									<th data-field="rbtitle" >标题</th>
									<th data-field="applydate" data-sortable="true">申请时间</th>
									<th data-field="deaaldate" >审批结束时间</th>
									<th data-field="status" >状态</th>
									<th data-field="handle" >操作</th>
								</tr>
							</thead>
							<c:forEach items="${repays }" var="repay">
								<c:if test="${repay.userid==user.userid }">
									<tr>
										<td data-field="repaytitle" >${repay.repaytitle }</td>
										<td data-field="applydate">
											<fmt:formatDate value="${repay.applydate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
										</td>
										<td data-field="dealdate" >
											<fmt:formatDate value="${repay.dealdate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
										</td>
										<td data-field="status">${repay.status==0?'审批中':repay.back==0?'不通过':'通过' }</td>
										<td data-field="handle" >
											<a href="${ctx }/process/toBussinessDetail.do?id=${repay.repayid}&type=${processType }" target="_self">
												<span class="btn btn-primary btn-xs">详细信息</span>
											</a>
											<c:if test="${repay.status==1 && repay.back==1 }">
												<a href="${ctx }/process/downloadPDF.do?id=${repay.repayid}&type=${processType }">
													<span class="btn btn-success btn-xs">下载还款单</span>
												</a>
											</c:if>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</table>
					</c:if>
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
	<script src="${ctx }/js/MyEMCAScript_user.js" type="text/javascript"></script>
	<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
	<script type="text/javascript">
		$(document).ready(function () {

		})
	</script>
</body>

</html>