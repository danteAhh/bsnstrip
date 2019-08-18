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
							<h5>修改密码</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="editForm" name="editForm">
								<input type="hidden" id="userid" name="userid" value="${userid }" />
								<input type="hidden" id="empid" name="empid">
								<div class="form-group">
									<label class="col-sm-3 control-label">您的工号：</label>
									<div class="col-sm-4">
										<input id="id" name="id" class="form-control" type="text" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">您的姓名：</label>
									<div class="col-sm-2">
										<input type="text" id="empname" name="empname" class="form-control" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">您的身份证号码：</label>
									<div class="col-sm-4">
										<input type="text" id="empcode" name="empcode" class="form-control" readonly="readonly">
									</div>
								</div>
								<div class="hr-line-dashed"></div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">旧密码：</label>
									<div class="col-sm-4">
										<input type="password" id="oldPassword" name="oldPassword" class="form-control">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">新密码：</label>
									<div class="col-sm-4">
										<input type="password" id="newPassword" name="newPassword" class="form-control">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">确认新密码：</label>
									<div class="col-sm-4">
										<input type="password" id="confirmNewPassword" name="comfirmNewPassword" class="form-control">
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
					oldpassword : {
						required: true,
						regex:"^[A-Za-z0-9]{20}$",
					},
					newpassword:{
						required: true,
						regex:"^[A-Za-z0-9]{20}$",
					},
					confirmNewPassword:{
						required: true,
						regex:"^[A-Za-z0-9]{20}$",
						equalTo:"#newpassword"
					}
				},
								
				/* 自定义规则出错以后的自定义的提示消息 */
				messages : {
					oldpassword: {
						required:"请填写旧密码",
						regex:"密码由大写字母、小写字母和数字组成，且最多为20位",
					},
					newpassword:{
						required:"请填写新密码",
						regex:"密码由大写字母、小写字母和数字组成，且最多为20位",
					},
					confirmNewPassword:{
						required:"请填写确认密码",
						regex:"密码由大写字母、小写字母和数字组成，且最多为20位",
						equalTo:"两次输入密码不相同"
					},
				},
								
				/* 表单按钮提交触发函数 */
				submitHandler : function(form) {
						//form，就是普通DOM元素，不是Jquery对象
						console.log(form);

						//将表单的数据序列化:将表单的数据拼接成get提交数据一样的字符串
						var loginFormData = $(form).serialize();
						console.log(loginFormData);   //user_name=admin&user_pwd=abc

						  $.post(getContextPath()+ "/user/changePassword.do",loginFormData,
							function(resObj) {
								//console.log(resObj)
								if (resObj == "1") {
									swal({
										title: "操作成功",
										text: "修改密码成功",
								        type: "success",
								        closeOnConfirm: false
									}, function(){
										console.log(123),
										$.ajax({
											url: getContextPath()+"/logout.do",
										});
										window.location.href = getContextPath();
									});
								} else if(resObj == "0"){
									swal({
										title: "操作失败",
										text: "旧密码错误",
								        type: "error",
								        closeOnConfirm: false
									}, function(){
										window.location.href = getContextPath()+ "/user/toChangePassword.do"
									});
								} else{
									swal({
										title: "操作失败",
										text: "修改密码失败",
								        type: "error",
								        closeOnConfirm: false
									}, function(){
										window.location.href = getContextPath()+ "/user/toChangePassword.do"
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
					$("#empcode").val(result.empcode);
			    }
			})
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