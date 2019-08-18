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
		<link href="${ctx }/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
		<base target="iframe0">

	</head>

	<body class="gray-bg">
		<div class="wrapper wrapper-content animated fadeInRight">

			<div class="row">

				<div class="col-sm-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>出差申请表</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="bsnstripForm" action="${ctx }/process/saveStartBsnstrip.do">
								<div class="form-group">
									<input type="hidden" id="role" name="role" value="${role}">
									<label class="col-sm-3 control-label">标题：</label>
									<div class="col-sm-6">
										<input id="bstitle" name="bstitle" class="form-control" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">目的地：</label>
									<div class="col-sm-2">
										<select id="province" name="province" onchange="getCity(this.value)" data-placeholder="选择省份..." class="chosen-select form-control" tabindex="1">
										</select>
									</div>
									<div class="col-sm-2">
										<select id="city" name="city" onchange="getCountry(this.value)" data-placeholder="选择城市..." class="chosen-select form-control" tabindex="2">
											<option value="-1">请选择</option>
										</select>
									</div>
									<div class="col-sm-2">
										<select id="country" name="country" onchange="getAddress()" data-placeholder="选择乡镇..." class="chosen-select form-control" tabindex="3">
											<option value="-1">请选择</option>
										</select>
									</div>
									<input type="hidden" value="" id="address" name="address">
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">出差周期：</label>
									<div class="col-sm-8">
										<div class="input-daterange input-group col-sm-6">
											<input type="text" class="form-control" name="begin" id="begin"  />
											<span class="input-group-addon">到</span>
											<input type="text" class="form-control" name="end" id="end" />
										</div>
										<c:if test="${role=='3' }">
											<div class="col-sm-6">
												<span class="help-block m-b-none">
													<i class="fa fa-info-circle">部门领导用户申请出差时，出差日期必须大于15天</i>
												</span>
											</div>
										</c:if>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">说明：</label>
									<div class="col-sm-8">
										<textarea id="bscontent" name="bscontent" style="height: 100px;width:600px;"></textarea>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">是否需要借款：</label>
										<div class="col-sm-2">
										<input type="hidden" id="isloan" name="isloan">
										<select id="loan" name="loan" onchange="getIsloan();" class="chosen-select form-control">
											<option value=-1>请选择</option>
											<option value="0">不需要</option>
											<option value="1">需要</option>
										</select>
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
		<script src="${ctx }/js/plugins/validate/jquery.validate.min.js" type="text/javascript"></script>
		<script src="${ctx }/js/plugins/validate/messages_zh.min.js" type="text/javascript"></script>
		<script src="${ctx }/js/plugins/datapicker/bootstrap-datepicker.js"></script>
		<script>
			$(document).ready(function() {
				getProvince();
				
				var date = new Date();
				var role = $("#role").val();
				if(role==3){
					$("#begin").datepicker({
						startDate:date,
						todayBtn:"linked",
						todayHighlight:true,
				    });
					var d = AddDays(15);
					console.log(d)
					$("#end").datepicker({
						startDate:d,
						todayBtn:"linked",
						todayHighlight:true,
				    });
				}else{
					console.log("员工")
					$("#begin, #end").datepicker({
						startDate:date,
						todayBtn:"linked",
						todayHighlight:true,
				    });
				}
				
				

				$("#bsnstripForm").validate({
					rules : {
						bstitle:{
							required:true,
						},
						end:{
							required:true,
							date:true,
						}
					},
										
					/* 自定义规则出错以后的自定义的提示消息 */
					messages : {
						bstitle:{
							required:"标题不能为空",
						},
						end:{
							required:"日期不能为空",
							date:"日期格式错误"
						}
					},
					
				})
				
			});
			
			function AddDays(num) {
	            var newdate = new Date();
	            var newtimems = newdate.getTime() + (num * 24 * 60 * 60 * 1000);
	            newdate.setTime(newtimems);
	            var time = newdate.getFullYear() + "-" + (newdate.getMonth()+1) + "-" + newdate.getDate();
	            return time;
	        }
			
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