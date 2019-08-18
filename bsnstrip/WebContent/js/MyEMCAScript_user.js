//文档加载完毕以后执行代码
$(function() {
	
	
	
	
		/**
		 * JQuery Chosen 
		 *
		 */
		/* 在模态框里面添加chosen插件 */
		$("#addUser").on('shown.bs.modal',function(){
			
			/* 初始化chosen插件 */
			$(".selectUserNo").chosen({
				no_results_text:"未找到该编号",
				placeholder_text_single:"选择用户编号",
				search_contains:true
			});
			
			/* chosen插件打开下拉框响应事件 */
			$(".selectUserNo").on('chosen:showing_dropdown',function(evt,param){
				$.post(getContextPath()+ "/user/listUserNo.do",
					function(resObj) {
					var jsObj = eval(resObj)
					//console.log(jsObj)
					//console.log(jsObj[0].userNo)
					var options = "<option id='-1'>选择用户编号</option>";
					if(jsObj != "" || jsObj != null || typeof(jsObj) != "undefined"){
						for(var index = 0;index<jsObj.length;index++){
							var userNo = jsObj[index];
							console.log(userNo);
							options +="<option id='"+index+"' value="+userNo.userNo+">"+userNo.userNo+"</option>";
							console.log(options)
						}
						$(".selectUserNo").html(options);
						$(".selectUserNo").trigger("chosen:updated");
					}else{
						options+="<option>没有可用的用户编号</option>"
						$(".selectUserNo").html(options);
					}
				});
			});
			
			//chosen插件选择响应事件 
			$(".selectUserNo").on('change',function(evt,param){
				//console.log("改变选择事件."+"选中值"+$(".selectUserNo option:selected").text())
				var user_no = $(".selectUserNo option:selected").text()
				//console.log(user_no)
				$("#user_no").val(user_no)
			});
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * JQuery Validate 
		 *
		 */

		/*
		 *  自定义校验事件
		 *  value:输入的值
		 *  element:表单元素
		 *  param:参数
		 */
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
				user_id:{
					number:true,
					remote:{
						url:getContextPath()+ "/user/hasUserId.do",
						type:"post",
						dataType:"json",
						data:{
							user_id:function(){
								return $("#user_id").val();
							}
						},
					}
				},
				user_no:{
					required:true
				},
				login_name : {
					required:true,
					regex:"^[0-9a-zA-Z]{6,20}$",
					remote:{
					url:getContextPath()+ "/user/hasLoginName.do",
					type:"post",
					dataType:"json",
					data:{
							login_name:function(){
							return $("#login_name").val();
							}
						},
					}
				},
				password : {
					regex:"^[0-9a-zA-Z]*$",
					maxlength:20
				},
				confirm_password:{
					equalTo: "#password"
				}
			},
								
			/* 自定义规则出错以后的自定义的提示消息 */
			messages : {
				user_id:{
					number:"ID值只能为整数",
					remote:"该id已存在，请修改后重试"
				},
				user_no:{
					required:"请选择用户编号"
				},
				login_name : {
					required:"请输入登录名",
					regex:"登录名由6-20位数字，字母或其组合组成",
					remote:"该登录名已存在，请修改后重试"
				},
				password: {
					regex:"密码由数字，字母及其组合组成",
					maxlength:"密码的长度不得超过20"
				},
				confirm_password:{
					equalTo:"两次密码输入不一致"
				}
			},
								
			/* 表单按钮提交触发函数 */
			submitHandler : function(form) {
				//form，就是普通DOM元素，不是Jquery对象
				//console.log(form);

				//将表单的数据序列化:将表单的数据拼接成get提交数据一样的字符串
				var loginFormData = $(form).serialize();
				//console.log(loginFormData);   //user_name=admin&user_pwd=abc

				//使用jquery发送ajax请求向后台发送账号密码进行登录操作
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
										window.location.href = getContextPath()+ "/user/list.do"
							});
						} else {
								swal({
									title: "操作失败",
									text: "无法添加用户信息",
								    type: "error",
								    closeOnConfirm: false
								}, function(){
										window.location.href = getContextPath()+ "/user/list.do"
									});
							}
						});
				}
		});
		
		
		
		
		$("#editUserForm").validate({
			/* 自定义规则 */
			rules : {
				edit_password : {
					regex:"^[0-9a-zA-Z]*$",
					maxlength:20
				},
				edit_confirm:{
					equalTo: "#edit_password"
				}
			},
							
			/* 自定义规则出错以后的自定义的提示消息 */
			messages : {
				edit_password: {
					regex:"密码由数字，字母及其组合组成",
					maxlength:"密码的长度不得超过20"
				},
				edit_confirm:{
					equalTo:"两次密码输入不一致"
				}
			},
							
			/* 表单按钮提交触发函数 */
			submitHandler : function(form) {
					//form，就是普通DOM元素，不是Jquery对象
					//console.log(form);

					//将表单的数据序列化:将表单的数据拼接成get提交数据一样的字符串
					var loginFormData = $(form).serialize();
					//console.log(loginFormData);   //user_name=admin&user_pwd=abc

					//使用jquery发送ajax请求向后台发送账号密码进行登录操作
					$.post(getContextPath()+ "/user/updateUser.do",loginFormData,
						function(resObj) {
							//console.log(resObj)
							if (resObj == "true") {
								swal({
									title: "操作成功",
									text: "修改一条用户信息",
							        type: "success",
							        closeOnConfirm: false
								}, function(){
									window.location.href = getContextPath()+ "/user/list.do"
								});
							} else {
								swal({
									title: "操作失败",
									text: "无法修改用户信息",
							        type: "error",
							        closeOnConfirm: false
								}, function(){
									window.location.href = getContextPath()+ "/user/list.do"
								});
							}
					});
				}
		});
		
		
			
			
			
			
		/**
		 * 
		 * bootstrap table
		 * 
		 * 
		 */
		/* 选中事件 */
//		$('#exampleTableEvents').on('check.bs.table', function (row) {
//			var obj = $('#exampleTableEvents').bootstrapTable('getSelections');
//		});
//		/* 取消选中事件 */
//		$('#exampleTableEvents').on('uncheck.bs.table', function (row) {
//			var obj = $('#exampleTableEvents').bootstrapTable('getSelections');
//		});
			
			
		/* 点击删除按钮触发事件 */
		$("#btn_delete").click(function(){
			var obj = $('#exampleTableEvents').bootstrapTable('getSelections');
			var select_id = '';
        	for (var i = 0; i < obj.length; i++) {
        		select_id += obj[i]['no'] + ",";
            }
        	select_id = select_id.substring(0, select_id.length - 1);
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
	    					user_no : select_id,
	    				},
	    				success: function(){
//	    		        	console.log("ok")
	    		        	swal({
	    						title: "操作成功",
	    						text: "成功删除用户信息",
	    				        type: "success",
	    				        closeOnConfirm: false
	    					}, function(){
	    						window.location.href = getContextPath()+ "/user/list.do"
	    					});
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
		
		// 刷新按钮
		$('#exampleTableEvents').on('refresh.bs.table', function () {
			console.log("refresh")
		});

		
		
		/* 点击修改按钮触发事件 */
		$("#btn_edit").click(function(){
			var obj = $('#exampleTableEvents').bootstrapTable('getSelections');
			var len = obj.length
			if(len > 1){
				swal({
					title:"错误",
					text:"无法进行批量修改",
					type:"error",
					closeOnConfirm: false
				});
			}else if (len < 1){
				swal({
					title:"错误",
					text:"请选择要进行修改的部门",
					type:"error",
					closeOnConfirm: false
				});
			}else {
				var edit_no = obj[0].no
//				console.log(edit_no)
				$.post(getContextPath()+ "/user/selectUserByUserNo.do",{user_no:edit_no},
						function(resObj) {
//					console.log(resObj.userNo)
					$("#edit_id").val(resObj.userId)
					$("#edit_no").val(resObj.userNo)
					$("#edit_name").val(resObj.loginName)
					$("#edit_role").find("option[value='"+resObj.role.roleName+"']").attr("selected",true)
//					console.log(resObj.role.roleName)
					$("#edit_status").val(resObj.status=='3'?'离岗':resObj.status=='0'?'暂停':resObj.status=='1'?'正常':'退休').attr("selected",true)
				});
				$("#editUser").modal()
			}
		});
	
	
	
	


		
		/* 
		*
		* 封装获取上下文路径的方法 
		*
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
		
});