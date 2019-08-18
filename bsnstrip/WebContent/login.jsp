<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录-智能出差报销管理系统</title>

<link rel="shortcut icon" href="${ctx }/favicon.ico">
<link href="${ctx }/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/css/font-awesome.min.css" rel="stylesheet">
<link href="${ctx }/css/animate.min.css" rel="stylesheet">
<link href="${ctx }/css/style.min.css" rel="stylesheet">
<base target="_blank">
<link href="${ctx }/css/mylogin.min.css" rel="stylesheet">

<!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
<script>
	if (window.top !== window.self) {
		window.top.location = window.location;
	}
</script>
</head>

<body class="gray-bg">

	<div class="middle-box text-center loginscreen animated fadeInDown">
		<div>
			<div>
				<h3 class="logo-name">
					<br>
				</h3>
			</div>
			<h2 style="font-weight: bold;">欢迎使用</h2>
			<h3>智能出差报销管理系统</h3>

			<form id="loginForm" class="m-t" role="form">
				<div class="form-group">
					<input class="form-control" placeholder="用户名" id="username"
						name="username" style="color: black;">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="密码"
						id="password" name="password" style="color: black;">
				</div>
				<div id="errorMsg"></div>
				<button type="submit" class="btn btn-primary block full-width m-b">登录</button>

				<p class="text-muted text-center">
					<a href="login.html#"><small>忘记密码了？</small></a>
				</p>
			</form>
		</div>
	</div>
	<script src="${ctx }/js/jquery.min.js"></script>

	<!-- 引入jquery.validate.js 表单校验框架 -->
	<script type="text/javascript" src="${ctx }/js/plugins/validate/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${ctx }/js/plugins/validate/messages_zh.min.js"></script>
	<script src="${ctx }/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

	<!-- 登录校验 -->
	<script type="text/javascript">
		//文档加载完毕以后执行代码
		$(function() {
			/* 账号密码框获取光标清空错误提示的信息 */
			$("#username,#password").focus(function() {
				$("#errorMsg").text("");
			});

			var icon = "<i class='fa fa-times-circle'></i>  ";
			//使用jquery.validate.js进行校验
			$("#loginForm").validate({
					/* 自定义规则 */
					rules : {
						username : "required",
						password : "required"
					},
								
					/* 自定义规则出错以后的自定义的提示消息 */
					messages : {
						username : icon + "请输入账号！",
						password : icon + "请输入密码！"
					},
								
					/* 表单按钮提交触发函数 */
					submitHandler : function(form) {
						//form，就是普通DOM元素，不是Jquery对象
						//console.log(form);

						//将表单的数据序列化:将表单的数据拼接成get提交数据一样的字符串
						var loginFormData = $(form).serialize();
						console.log(loginFormData);//username=admin&password=abc

						//使用jquery发送ajax请求向后台发送账号密码进行登录操作
						$.post(
							getContextPath()+ "/login.do",
							loginFormData,
							function(resObj) {
								console.log(resObj);
								if (resObj == "0") {
									//登录失败
									$("#errorMsg").text("账号或密码错误");
									$("#errorMsg").css("color","red");
								} else if (resObj == "2") {
									$("#errorMsg").text("账号已被停用");
									$("#errorMsg").css("color","red");
								} else {
									//登录成功，跳转到首页
									$("#errorMsg").text("登录成功");
									$("#errorMsg").css("color","green");
									window.location.href = getContextPath()+ "/index.do"
								}
						});
					}
			});

		});

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