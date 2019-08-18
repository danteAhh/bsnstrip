<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE>
<html>
<head>
	<link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="${ctx }/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx }/css/animate.min.css" rel="stylesheet">
    <link href="${ctx }/css/style.min.css" rel="stylesheet">
    <base target="_blank">
<title>欢迎使用</title>
</head>
<body class="gray-bg">
	<div class="row  border-bottom white-bg dashboard-header">
		<div class="col-sm-12">
            <blockquote class="text-success" style="font-size:14px">
                <h1 style="text-align: center;">欢迎使用</h1>
				<h2 style="text-align: center;">智能出差报销管理系统</h2>
            </blockquote>
            <hr>
        </div>
	</div>
	
	<div class="wrapper wrapper-content">
	<div class="row">
    <div class="col-sm-4">
		<div class="ibox float-e-margins">
	    	<div class="ibox-title">
	        	<h5>联系信息</h5>
			</div>
	    	<div class="ibox-content">
	            <p><i class="fa fa-qq"></i> 管理员QQ：<a href="http://wpa.qq.com/msgrd?v=3&uin=527041154site=qq&menu=yes" target="_blank">527041154</a>
	            </p>
	            <p><i class="fa fa-weixin"></i> 管理员微信：<a href="javascript:;">danteAhh</a></p><br>
	            <p><i class="fa fa-qq"></i> 财务QQ：<a href="http://wpa.qq.com/msgrd?v=3&uin=527041154site=qq&menu=yes" target="_blank">527041154</a>
	            </p>
	            <p><i class="fa fa-weixin"></i> 财务微信：<a href="javascript:;">danteAhh</a></p>
	            <p><i class="fa fa-credit-card"></i> 财务支付宝：<a href="javascript:;" class="支付宝信息">15625786563</a></p>
	     	</div>
	     </div>
     </div>
     
     <div class="col-sm-8">
     	<div class="ibox float-e-margins">
			<div class="ibox-title">
	        	<h5>公告</h5>
			</div>
			<div class="ibox-content no-padding">
                        <div class="panel-body">
                            <div class="panel-group" id="version">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                        	<a data-toggle="collapse" data-parent="#version" href="#v40">祝大家五一快乐！</a>
                                        	<code class="pull-right"> | 2019.01.01</code>
                                        	<code class="pull-right">王德阳</code>
                                        </h5>
                                    </div>
                                    <div id="v40" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            <p>祝大家五一快乐！</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v32">麻烦大家在结算日前尽快还款！</a>
                                                <code class="pull-right"> | 2019.04.27</code>
                                                <code class="pull-right">孙晓菲</code>
                                            </h5>
                                    </div>
                                    <div id="v32" class="panel-collapse collapse">
                                        <div class="panel-body">
                                           	 麻烦大家在结算日前尽快还款！
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v31">个人中心功能已恢复！</a>
                                                <code class="pull-right"> | 2019.04.03</code>
                                                <code class="pull-right">陈立夫</code>
                                            </h5>
                                    </div>
                                    <div id="v31" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <ol>
                                                <li>修复了个人资料显示失效的问题</li>
                                                <li>对用户的资料进行备份</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#version" href="#v301">个人中心功能正在维护...</a>
                                            <code class="pull-right"> | 2019.04.03</code>
                                            <code class="pull-right">陈立夫</code>
                                        </h5>
                                    </div>
                                    <div id="v301" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <p>预计2小时候恢复</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                           <a data-toggle="collapse" data-parent="#version" href="#v30">《报销新规则》</a>
                                           <code class="pull-right"> | 2019.03.15</code>
                                           <code class="pull-right">孙晓菲</code>
                                        </h5>
                                    </div>
                                    <div id="v30" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <p>以后处理报销需要打印两份报销单，一份财务部备案，一份由部门备案</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
				</div>
     		</div>
     	</div>
     </div>
     
    <script src="${ctx }/js/jquery.min.js"></script>
    <script src="${ctx }/js/bootstrap.min.js"></script>
    <script src="${ctx }/js/plugins/layer/layer.min.js"></script>
    <script src="${ctx }/js/content.min.js"></script>
    <script src="${ctx }/js/welcome.min.js"></script>
</body>
</html>