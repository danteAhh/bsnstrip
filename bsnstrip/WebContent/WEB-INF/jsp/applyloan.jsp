<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>

	<head>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<link rel="shortcut icon" href="${ctx }/favicon.ico">
		<link href="${ctx }/css/bootstrap.min.css" rel="stylesheet">
		<link href="${ctx }/css/font-awesome.min.css" rel="stylesheet">
		<link href="${ctx }/css/plugins/chosen/chosen.css" rel="stylesheet">
		<link href="${ctx }/css/animate.min.css" rel="stylesheet">
		<link href="${ctx }/css/style.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${ctx }/css/plugins/simditor/simditor.css" />
		<base target="iframe0">

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
							<form class="form-horizontal m-t" id="loanForm" enctype="multipart/form-data" 
																method="post" action="${ctx }/process/saveStartLoan.do">
								
								<div class="form-group">
									<label class="col-sm-3 control-label">标题：</label>
									<div class="col-sm-6">
										<input id="loantitle" name="loantitle" class="form-control" type="text">
									</div>
								</div>
								
								<div class="form-group" id="bsiddiv">
									<label class="col-sm-3 control-label">选择出差记录：</label>
									<input type="hidden" value="" id="bsid" name="bsid">
									<div class="col-sm-2">
										<select id="id" name="id" onchange="setId();" class="chosen-select form-control">
										</select>
									</div>
								</div>
							
								<div class="form-group">
									<label class="col-sm-3 control-label">借款金额：</label>
									<div class="col-sm-2">
										<input id="loanfee" name="loanfee" type="hidden">
										<input id="fee" name="fee" class="form-control" 
													type="text" oninput="numberToCN();" onblur="setNumberCN();">
									</div>
									<div class="col-sm-2">
										<span class="form-control" style="border: 0px; color: green;" id="CNnumber"></span>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">说明：</label>
									<div class="col-sm-8">
										<textarea id="loancontent" name="loancontent" style="height: 100px;width:600px;"></textarea>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-3">
										<input type="hidden" id="detailTemp" name="detailTemp">
										<button class="btn btn-primary" type="submit">保存</button>
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
		<script src="${ctx }/js/plugins/validate/jquery.validate.min.js" type="text/javascript"></script>
		<script src="${ctx }/js/plugins/validate/messages_zh.min.js" type="text/javascript"></script>
		<script src="${ctx }/js/plugins/chosen/chosen.jquery.js"></script>
		<script>
			$(document).ready(function() {
				showBsId();
				
				$("#loanForm").validate({
					rules : {
						loantitle:{
							required:true,
						},
						fee:{
							required:true,
						},
					},
										
					/* 自定义规则出错以后的自定义的提示消息 */
					messages : {
						loantitle:{
							required:"标题不能为空",
						},
						fee:{
							required:"金额不能为空"
						},
					},
					
				})
				
			});
			
			function showBsId() {
				/* 初始化chosen插件 */
				$("#id").chosen({
					no_results_text : "未找到记录",
					placeholder_text_single : "选择出差记录",
					search_contains : true
				});
				/* chosen插件打开下拉框响应事件 */
				$("#id").on('chosen:showing_dropdown',
					function(evt, param) {
						$.post(getContextPath()+ "/bsnstrip/listBsnstripToLoan.do",
							function(resObj) {
											var jsObj = eval("("+ resObj+ ")")
											var options = "<option id='-1'>选择出差记录</option>";
											if (jsObj != ""|| jsObj != null|| typeof (jsObj) != "undefined") {
												for (var index = 0; index < jsObj.length; index++) {
														var bsnstrip = jsObj[index];
														options += "<option id='"+index+"' value="+bsnstrip.bsid+">"+ bsnstrip.bstitle+ "</option>";
												}
												$("#id").html(options);
												$("#id").trigger("chosen:updated");
											} else {
													options += "<option>没有可用的出差记录</option>"
													$("#id").html(options);
											}
							});
					});
			}
			function setId() {
				var bsid = $("#id option:selected").val();
				$("#bsid").val(bsid);
			}
			function numberToCN() {
				$("#CNnumber").show();
				var fee = $("#fee").val();
				$.ajax({
					data : {
						"fee" : fee
					},
					url : getContextPath() + "/loan/numberToCN.do",
					type : "get",
					success : function(resObj) {
						$("#CNnumber").text(resObj);
					}
				})
			}
			function setNumberCN() {
				$("#loanfee").val($("#fee").val());
				var CNnumber = $("#CNnumber").text();
				$("#fee").val(CNnumber);
				$("#CNnumber").hide();
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