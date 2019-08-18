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
		<link href="${ctx }/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
		<link href="${ctx }/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
		<link href="${ctx }/css/animate.min.css" rel="stylesheet">
		<link href="${ctx }/css/style.min.css" rel="stylesheet">
		<base target="iframe0">

	</head>

	<body class="gray-bg">
		<div class="wrapper wrapper-content animated fadeInRight">

			<div class="row">

				<div class="col-sm-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>我的资料</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="editForm" name="editForm">
								<input type="hidden" id="userid" name="userid" value="${userid }" />
								<input type="hidden" id="empid" name="empid">
								<div class="form-group">
									<label class="col-sm-3 control-label">工号：</label>
									<div class="col-sm-4">
										<input id="id" name="id" class="form-control" type="text" readonly="readonly">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">用户名：</label>
									<div class="col-sm-4">
										<input id="username" name="username" class="form-control" type="text" readonly="readonly">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">邮箱：</label>
									<div class="col-sm-2">
										<input type="text" id="email" name="email" class="form-control">
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
								<div class="hr-line-dashed"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label">姓名：</label>
									<div class="col-sm-2">
										<input type="text" id="empname" name="empname" class="form-control">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">年龄：</label>
									<div class="col-sm-2">
										<input type="text" id="empage" name="empage" class="form-control">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">性别：</label>
									<div class="col-sm-2">
										<select class="form-control m-b" id="empsex" name="empsex">
											<option value="-1">请选择</option>
											<option value="1">男</option>
											<option value="2">女</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">联系电话：</label>
									<div class="col-sm-4">
										<input type="text" id="empphone" name="empphone" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">身份证号码：</label>
									<div class="col-sm-4">
										<input type="text" id="empcode" name="empcode" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">学历：</label>
									<div class="col-sm-4">
										<input type="hidden" id="empdegree" name="empdegree">
										<select class="form-control m-b" id="degree" name="degree" onchange="setDegree();">
											<option value="-1">请选择</option>
											<option value="1">大专</option>
											<option value="2">本科</option>
											<option value="3">硕士</option>
											<option value="4">博士</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-3">
										<button class="btn btn-primary" type="submit">修改</button>
									</div>
								</div>
							</form>
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
		<script src="${ctx }/js/plugins/sweetalert/sweetalert.min.js"></script>
		<script src="${ctx }/js/demo/form-validate-demo.min.js"></script>
		<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
		<script>
		
		$(document).ready(function(){
			getUserDetail();
			getEmployeeDetail();
			getRole();
			
			
			$.validator.addMethod("regex", function(value, element, param){
				var exp = new RegExp(param);
				return exp.test(value);
			}, "格式错误");
			$.validator.setDefaults({
				ignore:":hidden:not(input)"
			}),
			$("#editForm").validate({
				/* 自定义规则 */
				rules : {
					email : {
						email:true,
					},
					empage:{
						number:true,
						range:[20,60]
					},
					empphone:{
						number:true,
						regex:"^1[3|4|5|7|8][0-9]{9}$"
					},
					empcode:{
						regex:"^[1-9][0-9]{5}(18|19|20)[0-9]{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)[0-9]{3}[0-9Xx]$"
					}
				},
								
				/* 自定义规则出错以后的自定义的提示消息 */
				messages : {
					email: {
						email:"邮箱格式不正确"
					},
					empage:{
						number:"请输入数字",
						range:"年龄区间为20岁-60岁"
					},
					empphone:{
						number:"请输入数字",
						regex:"联系电话格式不正确"
					},
					empcode:{
						regex:"身份证号码格式错误"
					}
				},
								
				/* 表单按钮提交触发函数 */
				submitHandler : function(form) {
						//form，就是普通DOM元素，不是Jquery对象
						console.log(form);

						//将表单的数据序列化:将表单的数据拼接成get提交数据一样的字符串
						var loginFormData = $(form).serialize();
						console.log(loginFormData);   //user_name=admin&user_pwd=abc

						  $.post(getContextPath()+ "/user/editUser.do",loginFormData,
							function(resObj) {
								//console.log(resObj)
								if (resObj == "true") {
									swal({
										title: "操作成功",
										text: "修改一条用户信息",
								        type: "success",
								        closeOnConfirm: false
									}, function(){
										window.location.href = getContextPath()+ "/user/toListUser.do"
									});
								} else {
									swal({
										title: "操作失败",
										text: "无法修改用户信息",
								        type: "error",
								        closeOnConfirm: false
									}, function(){
										window.location.href = getContextPath()+ "/user/toListUser.do"
									});
								}
						}); 
					}
			});
		});
		
		function getUserDetail(){
			var userid = $("#userid").val();
			
			$.ajax({
				data:{userid:userid},
				dataType:"json",
				type:"post",
				url:getContextPath()+"/user/getUserDetail.do",
				success:function(result){
					$("#id").val(result.userid);
					$("#username").val(result.username);
					$("#email").val(result.email)
			    }
			})
		}
		function getEmployeeDetail() {
			var userid = $("#userid").val();
			
			$.ajax({
				data:{userid:userid},
				dataType:"json",
				type:"post",
				url:getContextPath()+"/user/getEmployeeDetail.do",
				success:function(result){
					$("#empid").val(result.empid);
					$("#empname").val(result.empname);
					$("#empage").val(result.empage);
					var sex = result.empsex=='男'?'1':'2';
					$("#empsex").find("option[value='"+sex+"']").attr("selected",true);
					$("#empphone").val(result.empphone);
					$("#empplace").val(result.empplace);
					$("#empcode").val(result.empcode);
					var degree = result.empdegree=='博士'?4:result.empdegree=='硕士'?3:result.empdegree=='本科'?2:1;
					$("#degree").find("option[value='"+degree+"']").attr("selected",true);
					$("#empdegree").val(degree);
					console.log("标记"+$("#empdegree").val())
			    }
			})
		}
		function getRole() {
			var userid = $("#userid").val();
			
			$.ajax({
				data:{userid:userid},
				dataType:"json",
				type:"post",
				url:getContextPath()+"/user/getRoleDetail.do",
				success:function(result){
					var roleid = "";
					for (var i = 0; i < result.length; i++) {
						if(result[i].roleid==2){
							$("#role_leader").prop("checked",true);
							var leader = $('#role_leader').val() + ",";
							roleid += leader;
						}
						if(result[i].roleid==3){
							$("#role_manager").prop("checked",true);
							var manager = $('#role_manager').val() + ",";
							roleid += manager;
						}
						if(result[i].roleid==4){
							$("#role_counter").prop("checked",true);
							var counter = $('#role_counter').val() + ",";
							roleid += counter;
						}
						if(result[i].roleid==5){
							$("#role_normal").prop("checked",true);
							var normal = $('#role_normal').val() + ",";
							roleid += normal;
						}
					}
					roleid = roleid.substring(0, roleid.length - 1);
					console.log("标记:"+roleid);
					$("#roleid").val(roleid);
			    }
			})
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
		
		function setDegree() {
			var degree = $("#degree option:selected").text();
			$("#empdegree").val(degree);
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