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
<link href="${ctx }/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
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
							id="btn_add" data-toggle="modal" data-target="#addUser">
							<i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
						</button>
						<button type="button" class="btn btn-outline btn-default" id="btn_delete">
							<i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
						</button>
					</div>
					<table data-striped="true"
						data-toolbar="#exampleTableEventsToolbar" data-toggle="table"
						id="exampleTableEvents" data-mobile-responsive="true" data-sort-name="userid"
						data-sort-order="desc" data-search="true" data-show-refresh="true"
						data-show-columns="true" data-pagination="true" data-cache="false" data-icon-size="outline"
						data-page-number="true" data-page-list="[5,10,20,25]">
						<thead>
							<tr>
								<th data-field="state" data-checkbox="true"></th>
								<th data-field="userid" data-sortable="true">工号</th>
								<th data-field="empname">姓名</th>
								<th data-field="rolename">角色</th>
								<th data-field="email">邮箱</th>
								<th data-field="status">账号状态</th>
								<th data-field="operate">操作</th>
							</tr>
						</thead>
						<c:forEach items="${users }" var="user">
							<tr>
								<td data-field="state" data-checkbox="true"></td>
								<td data-field="userid" data-sortable="true">${user.userid }</td>
								<c:forEach items="${employees }" var="employee">
									<c:if test="${employee.empid==user.employeeid }">
										<td data-field="empname">${employee.empname }</td>
									</c:if>
								</c:forEach>
								
								<td data-field="rolename">
									<c:forEach items="${roles }" var="role">
										<c:if test="${role.userid==user.userid }">
											${role.rolename } |
										</c:if>
									</c:forEach>
								</td>
								
								<td data-field="email">${user.email }</td>
								<td data-field="status">${user.status=='1'?'正常':'停用' }</td>
								<td data-field="operate">
									<a class="btn btn-primary btn-xs" href="${ctx }/user/toUserDetail.do?userid=${user.userid}" target="_self">查看</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="modal inmodal fade" id="addUser" tabindex="-1"
		role="dialog" aria-hidden="true" data-backdrop="static">
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
							<form class="form-horizontal m-t" id="addUserForm">
							
								<div class="form-group">
									<label class="col-sm-3 control-label">姓名：</label>
									<div class="col-sm-8">
										<input id="empname" name="empname" class="form-control"
											type="text">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">部门：</label>
									<div class="col-sm-8">
										<input type="hidden" id="deptid" name="deptid">
										<select class="form-control m-b chosen-select" name="dpid" id="dpid">
										</select>
									</div>
								</div>
							
								<div class="form-group">
									<label class="col-sm-3 control-label">用户名：</label>
									<div class="col-sm-8">
										<input id="username" name="username" class="form-control" type="text">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">邮箱：</label>
									<div class="col-sm-8">
										<input id="email" name="email" class="form-control"
											type="text">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">角色：</label>
									<input type="hidden" id="roleid" name="roleid">
									<div class="col-sm-8">
										<div class="checkbox checkbox-inline checkbox-success">
                                        	<input type="checkbox" id="role_normal" value="5" onchange="setRoleId();">
                                        	<label for="inlineCheckbox1">普通用户</label>
                                    	</div>
                                    	<div class="checkbox checkbox-success checkbox-inline">
                                        	<input type="checkbox" id="role_counter" value="4" onchange="setRoleId();">
                                        	<label for="inlineCheckbox2">财务人员</label>
                                    	</div>
                                    	<div class="checkbox checkbox-inline checkbox-success">
                                       	 	<input type="checkbox" id="role_manager" value="3" onchange="setRoleId();">
                                        	<label for="inlineCheckbox3">部门领导</label>
                                    	</div>
                                    	<div class="checkbox checkbox-inline checkbox-success">
                                       	 	<input type="checkbox" id="role_leader" value="2" onchange="setRoleId();">
                                       	 	<label for="inlineCheckbox4">总经理</label>
                                    	</div>
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
		$(document).ready(function() {
			chooseDept();
			delUser();
			
			
			$.validator.addMethod("regex", function(value, element, param){
				var exp = new RegExp(param);
				return exp.test(value);
			}, "格式错误");
			$.validator.setDefaults({
				ignore:":hidden:not(input)"
			}),
			//使用jquery.validate.js进行校验
			$("#addUserForm").validate({
					/* 自定义规则 */
				rules : {
					empname:{
						required:true,
					},
					username:{
						required:true,
						remote:{
							url:getContextPath()+ "/user/hasUsername.do",
							type:"post",
							dataType:"json",
							data:{
								username:function(){
									return $("#username").val();
								}
							},
						}
					},
					email:{
						email:true
					}
				},
									
				/* 自定义规则出错以后的自定义的提示消息 */
				messages : {
					empname:{
						required:"请填写姓名",
					},
					username:{
						required:"请填写用户名",
						remote:"已存在相同的用户名",
					},
					email : {
						email:"邮箱格式不正确"
					}
				},
									
				/* 表单按钮提交触发函数 */
				submitHandler : function(form) {
					//form，就是普通DOM元素，不是Jquery对象
					//console.log(form);

					//将表单的数据序列化:将表单的数据拼接成get提交数据一样的字符串
					var loginFormData = $(form).serialize();
					console.log(loginFormData);   //user_name=admin&user_pwd=abc

					$.post(getContextPath()+ "/user/addUser.do",loginFormData,
						function(resObj) {
							//console.log(resObj)
							if (resObj == "true") {
								swal({
										title: "操作成功",
										text: "新增一条用户信息",
										type: "success",
										closeOnConfirm: false
									}, function(){
											window.location.href = getContextPath()+ "/user/toListUser.do"
								});
							} else {
									swal({
										title: "操作失败",
										text: "无法添加用户信息",
									    type: "error",
									    closeOnConfirm: false
									}, function(){
											window.location.href = getContextPath()+ "/user/toListUser.do"
										});
								}
							}); 
					}
			});
		})
		
		function delUser() {
			$("#btn_delete").click(function(){
				var obj = $('#exampleTableEvents').bootstrapTable('getSelections');
				var select_id = '';
	        	for (var i = 0; i < obj.length; i++) {
	        		select_id += obj[i]['userid'] + ",";
	            }
	        	select_id = select_id.substring(0, select_id.length - 1);
	        	console.log(select_id);
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
		    				url: getContextPath()+ "/user/deleteUser.do", 
		    				data:{
		    					userId : select_id,
		    				},
		    				success: function(msg){
		    					if(msg != 0){
			    		        	swal({
			    						title: "操作成功",
			    						text: "成功删除"+msg+"条用户信息",
			    				        type: "success",
			    				        closeOnConfirm: false
			    					}, function(){
			    						window.location.href = getContextPath()+ "/user/toListUser.do"
			    					});
			    		        }else{
			    		        	swal({
			    						title: "错误",
			    						text: "您无法删除自己",
			    				        type: "error",
			    				        closeOnConfirm: false
			    				    })
			    		        }
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
		
		function chooseDept() {
			$("#addUser").on('shown.bs.modal',function(){
				
				/* 初始化chosen插件 */
				$("#dpid").chosen({
					no_results_text:"未找到部门",
					placeholder_text_single:"选择部门",
					search_contains:true
				});
				
				/* chosen插件打开下拉框响应事件 */
				$("#dpid").on('chosen:showing_dropdown',function(evt,param){
					$.post(getContextPath()+ "/dept/listDept.do",
						function(resObj) {
						var jsObj = eval(resObj)
						//console.log(jsObj)
						//console.log(jsObj[0].userNo)
						var options = "<option id='-1'>选择部门</option>";
						if(jsObj != "" || jsObj != null || typeof(jsObj) != "undefined"){
							for(var index = 0;index<jsObj.length;index++){
								var deptid = jsObj[index];
								console.log(deptid);
								options +="<option value="+deptid.deptid+">"+deptid.deptname+"</option>";
								console.log(options)
							}
							$("#dpid").html(options);
							$("#dpid").trigger("chosen:updated");
						}else{
							options+="<option>没有找到部门</option>"
							$("#dpid").html(options);
						}
					});
				});
				
				//chosen插件选择响应事件 
				$("#dpid").on('change',function(evt,param){
					//console.log("改变选择事件."+"选中值"+$(".selectUserNo option:selected").text())
					var deptid = $("#dpid option:selected").val()
					console.log(deptid)
					$("#deptid").val(deptid)
				});
			});
		}
		
		function setRole() {
			var role = $("#role option:selected").val();
			console.log(role);
			$("#roleid").val(role);
		}
		
		function checkRole() {
			var roleid = $("#roleid").val();
			if(roleid==2){
				checkLeader();
			}else if(roleid==3){
				checkManager();
			}else if(roleid==4){
				checkCounter();
			}
		}
		
		function checkManager(param) {
			var deptid = $("#deptid").val();
			var roleid = 3;
			$.ajax({
				data:{"deptid":deptid, "roleid":roleid},
				dataType:"json",
				type:"post",
				url:getContextPath()+"/user/checkManager.do",
				success:function(result){
			        if(result=='1'){
			        	alert("可以添加")
			        }else{
			        	alert("该部门已存在领导角色")
			        }
			    }
			})
		}
		
		function checkLeader() {
			$.ajax({
				dataType:"json",
				type:"post",
				url:getContextPath()+"/user/checkLeader.do",
				success:function(result){
			        if(result=='1'){
			        	alert("可以添加")
			        }else{
			        	alert("已存在总经理角色")
			        }
			    }
			})
		}
		
		function checkCounter() {
			$.ajax({
				dataType:"json",
				type:"post",
				url:getContextPath()+"/user/checkCounter.do",
				success:function(result){
			        if(result=='1'){
			        	alert("可以添加")
			        }else{
			        	alert("已存在财务角色")
			        }
			    }
			})
		}
		
		function setStatus(){
			var status = $("#edit_status option:selected").val();
			$("#status").val(status);
		}
		
		function setRoleId() {
			var roleid = "";
			if ($('#role_normal').is(':checked')) {
				var normal = $('#role_normal').val() + ",";
				roleid += normal;
			}
			if ($('#role_counter').is(':checked')) {
				var counter = $('#role_counter').val() + ",";
				roleid += counter;
			}
			if ($('#role_manager').is(':checked')) {
				var manager = $('#role_manager').val() + ",";
				roleid += manager;
			}
			if ($('#role_leader').is(':checked')) {
				var leader = $('#role_leader').val() + ",";
				roleid += leader;
			}
			roleid = roleid.substring(0, roleid.length - 1);
			console.log(roleid);
			$("#roleid").val(roleid);
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