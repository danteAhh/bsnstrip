<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>部署流程</title>

    <link rel="shortcut icon" href="${ctx }/favicon.ico"> 
    <link href="${ctx }/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx }/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx }/css/animate.min.css" rel="stylesheet">
    <link href="${ctx }/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${ctx }/css/style.min.css" rel="stylesheet"><base target="iframe0" />

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>所有表单元素</h5>
                    </div>
                    <div class="ibox-content">
                        <form method="post" class="form-horizontal" enctype="multipart/form-data" action="${ctx }/process/deployProcess.do" target="target">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">部署类型：</label>
                                <div class="col-sm-2">
                                	<input type="hidden" id="processName" name="processName">
									<select id="name" name="name" onchange="getProcessName()" class="chosen-select form-control" tabindex="1">
										<option value="-1">请选择</option>
										<option value="出差">出差流程</option>
										<option value="报销">报销流程</option>
										<option value="借款">借款流程</option>
										<option value="还款">还款流程</option>
										<option value="部门出差">部门出差</option>
										<option value="部门报销">部门报销</option>
										<option value="部门借款">部门借款</option>
									</select>
								</div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">选择流程文件:</label>

                                <div class="col-sm-10">
                                    <input type="file" class="form-control" id="filename" name="filename">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                            	<label class="col-sm-2 control-label"></label>
                            	<button type="submit" class="btn btn-primary btn-lg">提交</button>
                            </div>
                        </form>
                        <iframe name="target" id="target" width="800px" height="600px" ></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${ctx }/js/jquery.min.js"></script>
    <script src="${ctx }/js/bootstrap.min.js"></script>
    <script src="${ctx }/js/content.min.js"></script>
    <script src="${ctx }/js/plugins/sweetalert/sweetalert.min.js"></script>
    <script>
       
			$(document).ready(function() {
				$("#target").hide();
				$("#target").load(function(){
					textStr = $(this);
					var msg = textStr[0].contentDocument.body.textContent;
					if(msg == 'true'){
    		        	swal({
    						title: "操作成功",
    						text: "成功部署流程",
    				        type: "success",
    				        closeOnConfirm: false
    					}, function(){
    						window.location.href = getContextPath()+ "/process/toListProcess.do"
    					});
    		        }else{
    		        	swal({
    						title: "错误",
    						text: "未知错误",
    				        type: "error",
    				        closeOnConfirm: false
    				    })
    		        }
				})
			});

					function getProcessName() {
						var processName = $("#name option:selected").val();
						$("#processName").val(processName);
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
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>