<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<title>智能出差报销系统——控制台</title>
		<!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

		<link rel="shortcut icon" href="${ctx }/yq.ico">
		<link href="${ctx }/css/bootstrap.min.css" rel="stylesheet">
		<link href="${ctx }/css/font-awesome.min.css" rel="stylesheet">
		<link href="${ctx }/css/animate.min.css" rel="stylesheet">
		<link href="${ctx }/css/style.min.css" rel="stylesheet">
	</head>
	<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
		<div id="wrapper">
			<!--左侧导航开始-->
			<nav class="navbar-default navbar-static-side" role="navigation">
				<div class="nav-close"><i class="fa fa-times-circle"></i>
				</div>
				<div class="sidebar-collapse">
					<ul class="nav" id="side-menu">
						<li class="nav-header">
							<div class="dropdown profile-element">
								<!--头像-->
								<span><img alt="image" class="img-circle" src="${ctx }/img/profile_small.jpg" /></span>
								<a data-toggle="dropdown" class="dropdown-toggle" href="#">
									<span class="clear">
                            			<span class="block m-t-xs"><strong class="font-bold">${employee.empname}</strong></span>
                            			<span class="text-muted text-xs block">
                            				${role.rolename }
										<b class="caret"></b></span>
									</span>
								</a>
								<ul class="dropdown-menu animated fadeInRight m-t-xs">
									<li>
										<a class="J_menuItem" href="${ctx }/user/toChangeHeadPic.do">修改头像</a>
									</li>
									<li>
										<a class="J_menuItem" href="${ctx }/user/toPersonalCenter.do">个人资料</a>
									</li>
									<li class="divider"></li>
									<li>
										<a href="${ctx}/logout.do">安全退出</a>
									</li>
								</ul>
							</div>
							<div class="logo-element">
								<span><img alt="image" class="img-circle" src="${headPic }" /></span>
							</div>
						</li>
						<li>
							<a class="J_menuItem" href="${ctx }/welcome.jsp">
								<i class="fa fa-home"></i>
								<span class="nav-label">主页</span>
							</a>
						</li>
						
						<li>
							<a class="J_menuItem">
								<i class="fa fa-user"></i>
								<span class="nav-label">个人中心</span>
							</a>
							<ul class="nav nav-second-level">
								<li>
									<a class="J_menuItem" href="${ctx }/user/toPersonalCenter.do" data-index="0">我的资料</a>
								</li>
								<li>
									<a class="J_menuItem" href="${ctx }/user/toChangePassword.do">修改密码</a>
								</li>
							</ul>
						</li>
						
						<!--我的待办事务-->
						<li>
							<a class="J_menuItem" href="${ctx }/process/listMytask.do">
								<i class="fa fa-tags"></i>
								<span class="nav-label">我的待办事务</span>
							</a>
						</li><!--我的待办事务-->
						
						<c:if test="${role.rolename=='超级管理员' }">
							<!--流程管理-->
							<li>
								<a class="J_menuItem">
									<i class="fa fa-puzzle-piece"></i>
									<span class="nav-label">流程管理</span>
									<span class="fa arrow"></span>
								</a>
								<ul class="nav nav-second-level">
									<li>
										<a class="J_menuItem" href="${ctx}/process/toDeployProcess.do" data-index="0">发布流程</a>
									</li>
									<li>
										<a class="J_menuItem" href="${ctx }/process/toListProcess.do">查看流程</a>
									</li>
									
								</ul>
							</li><!--流程管理-->
						</c:if>
						
						<c:if test="${role.rolename=='部门领导' || role.rolename=='普通员工' }">
							<!-- 出差管理 -->
							<li>
								<a class="J_menuItem">
									<i class="fa fa-car"></i>
									<span class="nav-label">出差管理</span>
									<span class="fa arrow"></span>
									<!-- <span class="label label-warning pull-right">16</span> -->
								</a>
								<ul class="nav nav-second-level">
									<li>
										<a class="J_menuItem" href="${ctx}/bsnstrip/toApplyBsnstrip.do" data-index="0">发布出差申请</a>
									</li>
									<li>
										<a class="J_menuItem" href="${ctx }/process/toListBussiness.do?processType=bsnstrip">我的出差记录</a>
									</li>
									
								</ul>
							</li><!-- 出差管理 -->
						</c:if>
						
						<c:if test="${role.rolename=='部门领导' || role.rolename=='普通员工' }">
							<!-- 报销管理 -->
							<li>
								<a class="J_menuItem">
									<i class="fa fa-money"></i>
									<span class="nav-label">报销管理</span>
									<span class="fa arrow"></span>
								</a>
								<ul class="nav nav-second-level">
									<li>
										<a class="J_menuItem" href="${ctx}/reimburse/toApplyReimburse.do" data-index="0">发布报销申请</a>
									</li>
									<li>
										<a class="J_menuItem" href="${ctx }/process/toListBussiness.do?processType=reimburse">我的报销单</a>
									</li>
								</ul>
							</li><!-- 报销管理  -->
						</c:if>
						
						<c:if test="${role.rolename=='部门领导' || role.rolename=='普通员工' }">
							<!-- 借款管理 -->
							<li>
								<a class="J_menuItem">
									<i class="fa fa-gg-circle"></i>
									<span class="nav-label">借款管理</span>
									<span class="fa arrow"></span>
								</a>
								<ul class="nav nav-second-level">
									<li>
										<a class="J_menuItem" href="${ctx}/loan/toApplyLoan.do" data-index="0">发布借款申请</a>
									</li>
									<li>
										<a class="J_menuItem" href="${ctx }/process/toListBussiness.do?processType=loan">我的借款单</a>
									</li>
								</ul>
							</li><!-- 借款管理  -->
						</c:if>
						
						<c:if test="${role.rolename=='部门领导' || role.rolename=='普通员工' }">
							<!-- 还款管理 -->
							<li>
								<a class="J_menuItem">
									<i class="fa fa-gg"></i>
									<span class="nav-label">还款管理</span>
									<span class="fa arrow"></span>
								</a>
								<ul class="nav nav-second-level">
									<li>
										<a class="J_menuItem" href="${ctx}/repay/toApplyRepay.do" data-index="0">发布还款申请</a>
									</li>
									<li>
										<a class="J_menuItem" href="${ctx }/process/toListBussiness.do?processType=repay">我的还款单</a>
									</li>
								</ul>
							</li><!-- 还款管理  -->
						</c:if>
						
						<c:if test="${role.rolename == '超级管理员'}" >
							<!--部门管理-->
								<li>
									<a class="J_menuItem" href="${ctx}/dept/toListDept.do">
										<i class="fa fa-comments"></i>
										<span class="nav-label">部门管理</span>
									</a>
								</li><!--部门管理-->
						</c:if>
						
						<c:if test="${role.rolename=='超级管理员' || role.rolename=='总经理' || role.rolename=='部门领导'}">
							<!--员工管理-->
							<li>
								<a class="J_menuItem" href="${ctx}/user/toListUser.do">
									<i class="fa fa-users"></i>
									<span class="nav-label">员工管理</span>
								</a>
							</li><!--员工管理-->
						</c:if>
						
						<%-- <!--统计中心-->
						<li>
							<a class="J_menuItem" href="${ctx }/statistics">
								<i class="fa fa-pie-chart"></i>
								<span class="nav-label">统计</span>
								<span class="fa arrow"></span>
							</a>
						</li><!--统计中心--> --%>
					</ul>
				</div>
			</nav>
			<!--左侧导航结束-->
			
			<!--右侧部分开始-->
			<div id="page-wrapper" class="gray-bg dashbard-1">
				<div class="row border-bottom">
					<!--上方导航-->
					<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
						<!--上方左侧搜索框-->
						<div class="navbar-header">
							<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
						</div>
						<div class="nav navbar-top-links navbar-right">
							<img alt="" src="${ctx }/img/TITLE.png" align="middle" style="margin-top: 15px;">
						</div>
					</nav>
				</div>
				<div class="row content-tabs">
					<button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i></button>
					<nav class="page-tabs J_menuTabs">
						<div class="page-tabs-content">
							<a href="${ctx }/welcome.jsp" class="active J_menuTab" target="iframe0">主页</a>
						</div>
					</nav>
					<button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i></button>
					<div class="btn-group roll-nav roll-right">
						<button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span></button>
						<ul role="menu" class="dropdown-menu dropdown-menu-right">
							<li class="J_tabShowActive">
								<a>定位当前选项卡</a>
							</li>
							<li class="divider"></li>
							<li class="J_tabCloseAll">
								<a>关闭全部选项卡</a>
							</li>
							<li class="J_tabCloseOther">
								<a>关闭其他选项卡</a>
							</li>
						</ul>
					</div>
					<a href="${ctx}/logout.do" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
				</div>
				<div class="row J_mainContent" id="content-main">
					<iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${ctx }/welcome.jsp" frameborder="0" seamless></iframe>
				</div>
				<div class="footer">
					<div class="pull-right">&copy; 2019
						<a href="#" target="_blank">luohaojian</a>
					</div>
				</div>
			</div>
		</div>
		<script src="${ctx }/js/jquery.min.js"></script>
		<script src="${ctx }/js/bootstrap.min.js"></script>
		<script src="${ctx }/js/plugins/metisMenu/jquery.metisMenu.js"></script>
		<script src="${ctx }/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
		<script src="${ctx }/js/plugins/layer/layer.min.js"></script>
		<script src="${ctx }/js/hplus.min.js"></script>
		<script src="${ctx }/js/contabs.min.js"></script>
		<script src="${ctx }/js/plugins/pace/pace.min.js"></script>
	</body>

</html>