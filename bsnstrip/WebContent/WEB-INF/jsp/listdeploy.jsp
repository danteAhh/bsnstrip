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
						<h3>流程记录</h3>
					</div>
					<table data-striped="true" data-toggle="table" data-toolbar="#exampleTableEventsToolbar"
						id="exampleTableEvents" data-mobile-responsive="true" data-sort-name="id"
						data-sort-order="desc" data-search="true" data-show-refresh="true"
						data-show-columns="true" data-pagination="true" data-cache="false" data-icon-size="outline"
						data-page-number="true" data-page-list="[5,10,20,25]">
						<thead>
							<tr>
								<th data-field="id" data-sortable="true">流程ID</th>
								<th data-field="name">流程名称</th>
								<th data-field="Key">Key</th>
								<th data-field="version">版本</th>
								<th data-field="type">流程类型</th>
								<th data-field="time">创建时间</th>
								<th data-field="image">流程图</th>
							</tr>
						</thead>
						<c:forEach items="${procdefs }" var="procdef">
							<tr>
								<td data-field="id" data-sortable="true">${procdef.id }</td>
								<td data-field="name">${procdef.name }</td>
								<td data-field="Key">${procdef.key }</td>
								<td data-field="version">${procdef.version }</td>
								<c:forEach items="${deployments }" var="deployment">
									<c:if test="${procdef.deploymentId==deployment.id}">
										<td data-field="type" >${deployment.name }</td>
										<td data-field="time" >
											<fmt:formatDate value="${deployment.deploymentTime }" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td>
											<a href="${ctx }/process/showImg.do?
														imgId=${procdef.diagramResourceName}&deploymentId=${deployment.id}" target="_self"> 
												<span class="btn btn-primary btn-xs">查看流程图</span>
											</a>
										</td>
									</c:if>
								</c:forEach>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="modal inmodal fade" id="#showImg" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">新增用户</h4>
				</div>
				<div class="modal-body">
					<div class="ibox float-e-margins">
						<div class="ibox-content">
							<img>
						</div>
					</div>
				</div>
				<div class="modal-footer">
                </div>
			</div>
		</div>
	</div>



	<!--< div class="modal inmodal fade" id="editUser" tabindex="-1"
		role="dialog" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">修改用户</h4>
				</div>
				<div class="modal-body">
					<div class="ibox float-e-margins">
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="editUserForm">
							
								<div class="form-group">
									<label class="col-sm-3 control-label">ID：</label>
									<div class="col-sm-8">
										<input id="edit_id" name="edit_id" class="form-control" type="text" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">用户编号：</label> 
									<div class="col-sm-8">
										<input type="text" id="edit_no" name="edit_no" readonly="readonly" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">登录名：</label>
									<div class="col-sm-8">
										<input id="edit_name" name="edit_name" class="form-control" type="text" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">密码：</label>
									<div class="col-sm-8">
										<input id="edit_password" name="edit_password" class="form-control"
											type="password">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">确认密码：</label>
									<div class="col-sm-8">
										<input id="edit_confirm" name="edit_confirm"
											class="form-control" type="password">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">角色：</label>
									<div class="col-sm-8">
										<select class="form-control m-b" name="edit_role" id="edit_role">
											<option value="普通用户">普通用户</option>
											<option value="财务人员">财务人员</option>
											<option value="管理员">管理员</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">用户状态：</label>

									<div class="col-sm-8">
										<select class="form-control m-b" name="edit_status" id="edit_status">
											<option value="正常">正常</option>
											<option value="暂停">暂停</option>
											<option value="退休">退休</option>
											<option value="离岗">离岗</option>
										</select>
									</div>
								</div>
								<div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" class="checkbox" id="agree" name="agree"> 我已经认真阅读并同意《H+使用协议》
                                        </label>
                                    </div>
                                </div>
                            </div>
								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-3">
										<button id="edit_sub" class="btn btn-primary" type="submit">提交</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
                </div>
			</div>
		</div>
	</div> -->

	
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