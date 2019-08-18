<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<base target="_blank">

</head>

<body class="gray-bg">
	<div class="ibox float-e-margins">
		<div class="ibox-content">
			<div class="row row-lg">
				<div class="col-sm-12">
					<div class="btn-group hidden-xs" id="exampleTableEventsToolbar"
						role="group">
						<button type="button" class="btn btn-outline btn-default"
							id="btn_add" data-toggle="modal" data-target="#addDept">
							<i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
						</button>
						<button type="button" class="btn btn-outline btn-default" id="btn_edit">
							<i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>
						</button>
						<button type="button" class="btn btn-outline btn-default" id="btn_delete">
							<i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
						</button>
					</div>
					<table data-striped="true"
						data-toolbar="#exampleTableEventsToolbar" data-toggle="table"
						id="exampleTableEvents" data-mobile-responsive="true" data-sort-name="deptid"
						data-sort-order="desc" data-search="true" data-show-refresh="true"
						data-show-columns="true" data-pagination="true" data-cache="false" data-icon-size="outline"
						data-page-number="true" data-page-list="[5,10,20,25]">
						<thead>
							<tr>
								<th data-field="state" data-checkbox="true"></th>
								<th data-field="deptid" data-sortable="true">部门编号</th>
								<th data-field="deptname">部门名称</th>
							</tr>
						</thead>
						<c:forEach items="${depts }" var="dept">
							<tr>
								<td data-field="state" data-checkbox="true"></td>
								<td data-field="deptid" data-sortable="true">${dept.deptid }</td>
								<td data-field="deptname">${dept.deptname }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="modal inmodal fade" id="addDept" tabindex="-1"
		role="dialog" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">新增部门</h4>
				</div>
				<div class="modal-body">
					<div class="ibox float-e-margins">
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="addDeptForm">
							
								<div class="form-group">
									<label class="col-sm-3 control-label">部门名称：</label> 
									<div class="col-sm-8">
										<input type="text" id="add_deptname" name="add_deptname" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-3">
										<button id="sub_btn" class="btn btn-primary" type="submit">提交</button>
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
	</div>

	<div class="modal inmodal fade" id="editDept" tabindex="-1"
		role="dialog" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">修改部门</h4>
				</div>
				<div class="modal-body">
					<div class="ibox float-e-margins">
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="editDeptForm">
							
								<div class="form-group">
									<label class="col-sm-3 control-label">部门编号：</label>
									<div class="col-sm-8">
										<input id="edit_deptid" name="edit_deptid" class="form-control" 
												type="text" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">部门名称：</label>
									<div class="col-sm-8">
										<input id="edit_deptname" name="edit_deptname" class="form-control" type="text">
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
	<script type="text/javascript">
		$(document).ready(function (){
			$.validator.addMethod("regex", function(value, element, param){
				var exp = new RegExp(param);
				return exp.test(value);
			}, "格式错误");
			$.validator.setDefaults({
				ignore:":hidden:not(input)"
			}),
			//使用jquery.validate.js进行校验
			$("#addDeptForm").validate({
					/* 自定义规则 */
				rules : {
					add_deptname:{
						remote:{
							url:getContextPath()+ "/dept/hasDeptname.do",
							type:"post",
							dataType:"json",
							data:{
								deptname:function(){
									return $("#add_deptname").val();
								}
							},
						}
					},
					maxlength:20
				},
									
				/* 自定义规则出错以后的自定义的提示消息 */
				messages : {
					add_deptname:{
						remote:"该部门已存在，请修改后重试",
						maxlength:"部门名称过长"
					},
				},
									
				/* 表单按钮提交触发函数 */
				submitHandler : function(form) {
					//form，就是普通DOM元素，不是Jquery对象
					//console.log(form);

					//将表单的数据序列化:将表单的数据拼接成get提交数据一样的字符串
					var loginFormData = $(form).serialize();
					console.log(loginFormData)
					//console.log(loginFormData);   //user_name=admin&user_pwd=abc

					//使用jquery发送ajax请求向后台发送账号密码进行登录操作
					$.post(getContextPath()+ "/dept/addDept.do",loginFormData,
						function(resObj) {
							//console.log(resObj)
							if (resObj == "true") {
								swal({
										title: "操作成功",
										text: "新增一条用户信息",
										type: "success",
										closeOnConfirm: false
									}, function(){
											window.location.href = getContextPath()+ "/dept/toListDept.do"
								});
							} else {
									swal({
										title: "操作失败",
										text: "无法添加用户信息",
									    type: "error",
									    closeOnConfirm: false
									}, function(){
											window.location.href = getContextPath()+ "/dept/toListDept.do"
										});
								}
							});
					}
			});
			delDept();
			editDpet();
			$("#editDeptForm").validate({
				/* 自定义规则 */
				rules : {
					edit_deptname : {
						maxlength:20
					}
				},
								
				/* 自定义规则出错以后的自定义的提示消息 */
				messages : {
					edit_deptname: {
						maxlength:"部门名称过长"
					}
				},
								
				/* 表单按钮提交触发函数 */
				submitHandler : function(form) {
						//form，就是普通DOM元素，不是Jquery对象
						//console.log(form);

						//将表单的数据序列化:将表单的数据拼接成get提交数据一样的字符串
						var loginFormData = $(form).serialize();
						//console.log(loginFormData);   //user_name=admin&user_pwd=abc

						//使用jquery发送ajax请求向后台发送账号密码进行登录操作
						$.post(getContextPath()+ "/dept/updateDept.do",loginFormData,
							function(resObj) {
								//console.log(resObj)
								if (resObj == "true") {
									swal({
										title: "操作成功",
										text: "修改一条部门信息",
								        type: "success",
								        closeOnConfirm: false
									}, function(){
										window.location.href = getContextPath()+ "/dept/toListDept.do"
									});
								} else {
									swal({
										title: "操作失败",
										text: "无法修改部门信息",
								        type: "error",
								        closeOnConfirm: false
									}, function(){
										window.location.href = getContextPath()+ "/dept/toListDept.do"
									});
								}
						});
					}
			});
		});
		
		function delDept() {
			/* 点击删除按钮触发事件 */
			$("#btn_delete").click(function(){
				var obj = $('#exampleTableEvents').bootstrapTable('getSelections');
				var select_id = '';
	        	for (var i = 0; i < obj.length; i++) {
	        		select_id += obj[i]['deptid'] + ",";
	            }
	        	select_id = select_id.substring(0, select_id.length - 1);
	        	var len = obj.length
	        	if(len > 0){
		        	swal({
		        		title:"确定删除吗？",
		        		text:"您选中了"+len+"条信息",
		        		type:"warning",
		        		showCancelButton:true,
		        		cancelButtonText:"取消",
		        		confirmButtonText:"删除",
		        		closeOnConfirm: false
		        	},function(){
		        		$.ajax({ 
		    				url: getContextPath()+ "/dept/deleteDept.do", 
		    				data:{
		    					deptId : select_id,
		    				},
		    				success: function(msg){
//		    		        	console.log("ok")
		    		        	swal({
		    						title: "操作成功",
		    						text: "成功删除"+msg+"条部门信息",
		    				        type: "success",
		    				        closeOnConfirm: false
		    					}, function(){
		    						window.location.href = getContextPath()+ "/dept/toListDept.do"
		    					});
		    				}
		    			});
		        	})
	        	}else{
	        		swal({
						title: "错误",
						text: "请选择你要删除的用户信息",
				        type: "error",
				        closeOnConfirm: false
				    })
	        	}
			});
		}
		
		function editDpet() {
			/* 点击修改按钮触发事件 */
			$("#btn_edit").click(function(){
				var obj = $('#exampleTableEvents').bootstrapTable('getSelections');
				var len = obj.length
				if(len > 1){
					swal({
						title:"错误",
						text:"无法进行批量修改",
						type:"error",
						closeOnConfirm: false
					});
				}else if (len < 1){
					swal({
						title:"错误",
						text:"请选择要进行修改的部门",
						type:"error",
						closeOnConfirm: false
					});
				}else {
					var edit_deptid = obj[0].deptid
//					console.log(edit_no)
					$.post(getContextPath()+ "/dept/selectDeptByDeptId.do",{deptId:edit_deptid},
							function(resObj) {
						var msg = eval("("+resObj+")");
						$("#edit_deptid").val(msg.deptid)
						$("#edit_deptname").val(msg.deptname)
//						console.log(resObj.role.roleName)
					});
					$("#editDept").modal()
				}
			});
		}
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