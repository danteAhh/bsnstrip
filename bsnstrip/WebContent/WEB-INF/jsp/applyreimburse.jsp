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
							<h5>报销申请表</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="reimburseForm" enctype="multipart/form-data" method="post" 
																				action="${ctx }/process/saveStartReimburse.do">
								<div class="form-group">
									<label class="col-sm-3 control-label">报销类型：</label>
									<div class="col-sm-2">
										<input type="hidden" id="rbtype" name="rbtype">
										<select id="type" name="type" onchange="showBsId();getType();" class="chosen-select form-control">
											<option value="-1">请选择</option>
											<option value="0">出差报销</option>
											<option value="1">日常报销</option>
										</select>
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
									<label class="col-sm-3 control-label">标题：</label>
									<div class="col-sm-6">
										<input id="rbtitle" name="rbtitle" class="form-control" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">报销金额：</label>
									<div class="col-sm-2">
										<input id="rbfee" name="rbfee" type="hidden">
										<input id="fee" name="fee" class="form-control" 
													type="text" oninput="numberToCN();" onblur="setNumberCN();">
									</div>
									<div class="col-sm-2">
										<span class="form-control" style="border: 0px; color: green;" id="CNnumber"></span>
									</div>
								</div>

								<div class="form-group" id="file-pretty">
									<label class="col-sm-3 control-label">上传票据：</label>
									<div class="col-sm-6">
										<input type="file" multiple="multiple" name="rbimg" id="rbimg" 
																class="form-control col-sm-4" onchange="checkImg();">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">说明：</label>
									<div class="col-sm-8">
										<textarea id="rbcontent" name="rbcontent" style="height: 100px;width:600px;"></textarea>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-3">
										<input type="hidden" id="detailTemp" name="detailTemp">
										<button class="btn btn-primary" type="submit">保存</button>
										<button class="btn btn-primary" type="button" data-target="#editDetail" data-toggle="modal" >添加详情</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal inmodal fade" id="editDetail" tabindex="-1"
		role="dialog" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">报销详情</h4>
				</div>
				<div class="modal-body">
					<div class="ibox float-e-margins">
						<div class="ibox-content" >
							<form class="form-horizontal m-t" id="detailbox">
								<div class="form-group" id="project1">
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
								<div class="form-group" id="project2">
									<label class="col-sm-3 control-label">项目2：</label>
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
								<div class="form-group" id="project3">
									<label class="col-sm-3 control-label">项目3：</label>
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
								<div class="form-group" id="project4">
									<label class="col-sm-3 control-label">项目4：</label>
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
								<div class="form-group" id="project5">
									<label class="col-sm-3 control-label">项目5：</label>
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
								<div class="col-sm-offset-3 form-horizontal m-t">
									<button class="btn btn-primary" type="button" onclick="getForm();" data-dismiss="modal">保存</button>
									<input type="hidden" id="index" value="6">
									<button class="btn btn-primary" type="button" onclick="addDetail();">添加项目</button>
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
		<script src="${ctx }/js/jquery.min.js"></script>
		<script src="${ctx }/js/bootstrap.min.js"></script>
		<script src="${ctx }/js/content.min.js"></script>
		<script src="${ctx }/js/plugins/validate/jquery.validate.min.js" type="text/javascript"></script>
		<script src="${ctx }/js/plugins/validate/messages_zh.min.js" type="text/javascript"></script>
		<script src="${ctx }/js/plugins/chosen/chosen.jquery.js"></script>
		<script>
			$(document).ready(function() {
				$("#bsiddiv").hide();
				
				$("#reimburseForm").validate({
					rules : {
						rbtitle:{
							required:true,
						},
						fee:{
							required:true,
						},
						rbimg:{
							required:true
						}
					},
										
					/* 自定义规则出错以后的自定义的提示消息 */
					messages : {
						rbtitle:{
							required:"标题不能为空",
						},
						fee:{
							required:"金额不能为空"
						},
						rbimg:{
							required:"请上传单据"
						}
					},
					
				})

			});
			function checkImg() {
				var files = $("#rbimg")[0].files;
				
				for(var i=0; i< files.length; i++){
					var file = files[i];
					var suffix = file.name.split(".")[1];
					var size = file.size;
					if( suffix == 'jpg' || suffix == 'png'){
						console.log("ok");
						if(size > 1024*1024){
							alert("上传图片大小不能大于1M");
							$("#rbimg").val("");
						}
					}else{
						alert("请选择'jpg''png'的图片类型上传");
						$("#rbimg").val("");  
					}
				}	
			}
			function getForm() {
				var form = $("#detailbox").serialize();
				console.log(form);
				$("#detailTemp").val(form);
			}
			function addDetail() {
				var index;
				index = $("#index").val();
				var newbox = "<div class='form-group' id='project"+index+"'>"
							+ "<label class='col-sm-3 control-label'>项目"+index+"：</label>"
							+ "<div class='col-sm-2'>"
							+ "<input id='rbditem' name='rbditem' class='form-control' type='text' placeholder='项目名'></div>"
							+ "<div class='col-sm-2'>"
							+ "<input id='rbdnum' name='rbdnum' class='form-control' type='text' placeholder='数目'></div>"
							+ "<div class='col-sm-2'>"
							+ "<input id='rbdfee' name='rbdfee' class='form-control' type='text' placeholder='单价'></div>"
							+ "<div class='col-sm-2'>"
							+ "<input id='rbdcount' name='rbdcount' class='form-control' type='text' placeholder='总价'></div></div>";
				var elm = "#project" + (index - 1);
				$(elm).append(newbox);
				index++;
				$("#index").val(index);
			}
			function showBsId() {
				var selected = $("#type option:selected").val();
				if (selected == 0) {
					$("#bsiddiv").show(
						function() {
						/* 初始化chosen插件 */
						$("#id").chosen({
								no_results_text : "未找到记录",
								placeholder_text_single : "选择出差记录",
								search_contains : true
						});
						/* chosen插件打开下拉框响应事件 */
						$("#id").on('chosen:showing_dropdown',
								function(evt, param) {
										$.post(getContextPath()+ "/bsnstrip/listBsnstrip.do",
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
						});
				} else {
					$("#bsiddiv").hide();
				}
			}
			function getType(){
				var type = $("#type option:selected").val();
				$("#rbtype").val(type);
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
					url : getContextPath() + "/reimburse/numberToCN.do",
					type : "get",
					success : function(resObj) {
						$("#CNnumber").text(resObj);
					}
				})
			}
			function setNumberCN() {
				$("#rbfee").val($("#fee").val());
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