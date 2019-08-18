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
							<h5>报销项目详情</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="signupForm" action="${ctx }/process/saveStartBsnstrip.do">
								<div class="form-group" id="project">
									<label class="col-sm-3 control-label">项目1：</label>
									<div class="col-sm-2">
										<input id="rbditem" name="rbditem" class="form-control" type="text" placeholder="项目名">
									</div>
									<div class="col-sm-2">
										<input id="rbdnum" name="rbdnum" class="form-control" type="text" placeholder="数目">
									</div>
									<div class="col-sm-2">
										<input id="rbdfee" name="rbdfee" class="form-control" type="text" placeholder="单价">
									</div>
									<div class="col-sm-2">
										<input id="rbdcount" name="rbdcount" class="form-control" type="text" placeholder="总价">
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-3">
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
		<script src="${ctx }/js/plugins/datapicker/bootstrap-datepicker.js"></script>
		<script type="text/javascript" src="${ctx }/js/plugins/simditor/module.js"></script>
		<script type="text/javascript" src="${ctx }/js/plugins/simditor/uploader.js"></script>
		<script type="text/javascript" src="${ctx }/js/plugins/simditor/hotkeys.js"></script>
		<script type="text/javascript" src="${ctx }/js/plugins/simditor/simditor.js"></script>
		<script src="${ctx }/js/plugins/chosen/chosen.jquery.js"></script>
		<script src="${ctx }/js/demo/form-validate-demo.min.js"></script>
		<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
		<script>
			$(document).ready(function() {
				/* var editor = new Simditor({
					textarea: $("#bscontent"),
				}) */
				
				getProvince();
				
			});
			function getProvince() {
				var options = "<option id='-1'>请选择</option>";
				$.ajax({
					type: 'get',
					url: getContextPath()+ '/bsnstrip/getProvince.do',
					success: function(msg){
						var res = eval("("+msg+")");
						for(var index = 0; index<res.length; index++){
							var province = res[index];
							options += "<option value="+province.id+">"+province.name+"</option>";
						}
						console.log(options);
						//将拼接的options数据设置到省的下拉框中
						document.getElementById("province").innerHTML=options;
					}
				});
			}
			function getCity(provinceId) {
				if(provinceId !="-1"){
					$.ajax({
						type : 'get',
						url : getContextPath()+ '/bsnstrip/getCity.do',
						data : {
							provinceId : provinceId,
						},
						success : function(res) {
							var obj = eval("("+res+")");
							console.log(obj);
							var options = "<option id='-1'>请选择</option>";
							for(var index = 0;index<obj.length;index++){
								var city = obj[index];
								options +="<option value="+city.id+">"+city.name+"</option>";
							}
							//将响应的数据设置到市的下拉框中
							document.getElementById("city").innerHTML=options;
						}
					});
				}
			}
			function getCountry(cityId) {
				if(cityId !="-1"){
					$.ajax({
						type : 'get',
						url : getContextPath()+ '/bsnstrip/getCountry.do',
						data : {
							cityId : cityId,
						},
						success : function(res) {
							var obj = eval("("+res+")");
							console.log(obj);
							var options = "<option id='-1'>请选择</option>";
							for(var index = 0;index<obj.length;index++){
								var country = obj[index];
								options +="<option value="+country.id+">"+country.name+"</option>";
							}
							//将响应的数据设置到市的下拉框中
							document.getElementById("country").innerHTML=options;
						}
					});
				}
			}
			function getAddress(){
				var address = $("#province option:selected").text()+$("#city option:selected").text()+$("#country option:selected").text();
				$("#address").val(address)
			}
			function getIsloan(){
				var isloan = $("#loan option:selected").val();
				$("#isloan").val(isloan);
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