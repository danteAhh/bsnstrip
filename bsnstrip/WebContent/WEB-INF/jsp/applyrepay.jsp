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
		<base target="iframe0">

	</head>

	<body class="gray-bg">
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="row">
				<div class="col-sm-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>还款申请表</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" enctype="multipart/form-data" id="repayForm" 
																method="post" action="${ctx }/process/saveStartRepay.do">
								
								<div class="form-group">
									<label class="col-sm-3 control-label">标题：</label>
									<div class="col-sm-6">
										<input id="repaytitle" name="repaytitle" class="form-control" type="text">
									</div>
								</div>
								
								<div class="form-group" id="bsiddiv">
									<label class="col-sm-3 control-label">选择借款记录：</label>
									<input type="hidden" value="" id="loanid" name="loanid">
									<div class="col-sm-2">
										<select id="id" name="id" onchange="setId();setFee();" class="chosen-select form-control">
										</select>
									</div>
								</div>
							
								<div class="form-group">
									<label class="col-sm-3 control-label">还款金额：</label>
									<div class="col-sm-2">
										<input id="repayfee" name="repayfee" type="hidden">
										<input id="fee" name="fee" class="form-control" 
													type="text" readonly="readonly">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">说明：</label>
									<div class="col-sm-8">
										<textarea id="repaycontent" name="repaycontent" style="height: 100px;width:600px;"></textarea>
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
		<script src="${ctx }/js/plugins/validate/jquery.validate.min.js"></script>
		<script src="${ctx }/js/plugins/validate/messages_zh.min.js"></script>
		<script src="${ctx }/js/plugins/chosen/chosen.jquery.js"></script>
		<script>
			$(document).ready(function() {
				showBsId();
				
				$("#repayForm").validate({
					rules : {
						repaytitle:{
							required:true,
						},
					},
										
					/* 自定义规则出错以后的自定义的提示消息 */
					messages : {
						repaytitle:{
							required:"标题不能为空",
						},
					},
					
				})
			});
			
			function showBsId() {
				/* 初始化chosen插件 */
				$("#id").chosen({
					no_results_text : "未找到记录",
					placeholder_text_single : "选择借款记录",
					search_contains : true
				});
				/* chosen插件打开下拉框响应事件 */
				$("#id").on('chosen:showing_dropdown',
					function(evt, param) {
						$.post(getContextPath()+ "/loan/listLoan.do",
							function(resObj) {
											var jsObj = eval("("+ resObj+ ")")
											var options = "<option id='-1'>选择借款记录</option>";
											if (jsObj != ""|| jsObj != null|| typeof (jsObj) != "undefined") {
												for (var index = 0; index < jsObj.length; index++) {
														var loan = jsObj[index];
														options += "<option id='"+index+"' value="+loan.loanid+">"+ loan.loantitle+ "</option>";
												}
												$("#id").html(options);
												$("#id").trigger("chosen:updated");
											} else {
													options += "<option>没有可用的借款记录</option>"
													$("#id").html(options);
											}
							});
					});
			}
			function setFee(){
				var loanid = $("#loanid").val();
				console.log(loanid);
				$.ajax({
					data : {
						"loanId" : loanid
					},
					url : getContextPath() + "/loan/findLoanfeeById.do",
					type : "get",
					success : function(resObj) {
						$("#repayfee").val(resObj);
						var fee = $("#repayfee").val();
						$.ajax({
							data : {
								"repayfee" : fee
							},
							url : getContextPath() + "/repay/numberToCN.do",
							type : "get",
							success : function(resObj) {
								$("#fee").val(resObj);
							}
						})
					}
				})
			}
			
			function setId() {
				var loanid = $("#id option:selected").val();
				$("#loanid").val(loanid);
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