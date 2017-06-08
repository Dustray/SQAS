<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
function changeTitle(tag) {
	document.getElementById("showTitle").innerHTML = tag;
}

function selectListening() {
	var obj = document.getElementById("selectType");
	var index = obj.selectedIndex;
	var v = obj.options[index].value;
	if (v == "brldepartmentid") {
		document.getElementById("selectContentA").style.display = "none";
		document.getElementById("selectDepartmentB").style.display = "block";
	} else {
		document.getElementById("selectContentA").style.display = "block";
		document.getElementById("selectDepartmentB").style.display = "none";
	}
	document.getElementById("selectContentA").value = "";
}
function contentChange() {
	document.getElementById("simpleSelectForm").submit();
	$("#simpleSelectForm").submit();
	document.simpleSelectForm.submit();
}
</script>
		<!-- CSS -->
		<link href="css/public.css" type="text/css" rel="stylesheet">
		<link href="css/houtai.css" type="text/css" rel="stylesheet">
		<link href="css/smartMenu.css" type="text/css" rel="stylesheet">
	</head>

	<body>
		<div id="admin">
			<div style="background: #79CDCD" class="ad-menu" id="ad-menu">
				<div style="background: #4A708B" class="ad-logo">
					<a href="index.jsp"><img src="image/m-logo.png" height="100"
							width="130">
					</a>
				</div>
				<div class="ad-list">
					<ul>
						<li>
							<a href="InquireServlet?limit=4&nowPage=1" target="iframe0"
								onclick="changeTitle('首页——查询所有违纪记录');">
								<div class="li-item">
									<em class="scm li-ico ic1"></em>查询所有违纪信息
									<span class="scm arrow"></span>
								</div> </a>
						</li>
						<li>
							<a href="inquireAdvanced.jsp" target="iframe0"
								onclick="changeTitle('高级查询');">
								<div class="li-item">
									<em class="scm li-ico ic2"></em>高级查询
									<span class="scm arrow"></span>
								</div> </a>
						</li>
						<li>
							<a href="appeal.jsp" target="iframe0"
								onclick="changeTitle('违纪申诉');">
								<div class="li-item">
									<em class="scm li-ico ic3"></em>违纪申诉
									<span class="scm arrow"></span>
								</div> </a>
						</li>
						<!-- 
						<li>
							<div class="li-item">
								<em class="scm li-ico ic4"></em>测试按钮
								<span class="scm arrow"></span>
							</div>
						</li>
						 -->
						<li>
							<a href="indexBackground.jsp">
								<div class="li-item">
									<em class="scm li-ico ic7"></em>系统管理
									<span class="scm arrow"></span>
								</div> </a>


						</li>
						<li>
							<a href="login.jsp">
								<div class="li-item">
									系统管理登陆
								</div> </a>
						</li>
					</ul>
				</div>
			</div>
			<div class="ad-comment-box" id="ad-comment">
				<div class="ad-top-comment">
					<div class="ad-message">
						<div class="ad-top-left">
							<div class="ad-change-btn">
								<a id="ad-list" href="javascript:;" class="scm ad-list-btn"></a>
							</div>
							<div class="ad-search-box clear">
								<form id="simpleSelectForm" name="simpleSelectForm"
									action="InquireSimpleServlet" method="post" target="iframe0">
									<div class="ad-search-sel">
										<select id="selectType" name="selectType"
											onchange="selectListening();">
											<option value="brlstuname">
												姓名
											</option>
											<option value="brlstuclass">
												班级
											</option>
											<option value="brldepartmentid">
												部门
											</option>
											<option value="brldate">
												日期
											</option>
										</select>
									</div>
									<div class="ad-search-cha">
										<input id="selectContentA" name="selectContentA" type="text"
											class="ad-search-input" placeholder="请输入你要查找的内容"
											style="display: block" onkeyup="contentChange();" />
										<select id="selectDepartmentB" name="selectDepartmentB"
											class="ad-search-input" style="display: none"
											onchange="contentChange();">
											<option value="1">
												纪检部
											</option>
											<option value="2">
												生卫部
											</option>
											<option value="3">
												体育部
											</option>
											<option value="4">
												学习部
											</option>
										</select>
										<input type="submit" class="scm ad-search-btn" value="" />
									</div>
								</form>
							</div>
						</div>
						<div class="ad-top-right">
							<!-- <div class="ad-notice">
								<ul>
									<li>
										<a href="javascript:;" class="scm nt1"><span
											class="scm nt-count dot">12</span> </a>
									</li>
									<li>
										<a href="javascript:;" class="scm nt2"><span
											class="scm nt-count dot">12</span> </a>
									</li>
									<li>
										<a href="javascript:;" class="scm nt3"><span
											class="scm nt-count dot">12</span> </a>
									</li>
								</ul>
							</div> -->
							<div class="ad-welcom">
								<div class="ad-wel-img">
									<img src="image/min_logo.png" height="36" width="36">
								</div>
								<div class="ad-wel-text">
									<div class="font-wel">
										<a href="http://ie.bzu.edu.cn/" style="color: red">信息工程系</a>学生会

									</div>
									<div class="font-wel">
										量化管理平台欢迎您！
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="ad-sub-nav-box content-tabs">
						<a href="#" onclick="javascript:history.back(-1);"
							target="iframe0" class="jian-a pre"></a>
						<div align="center">
							<label id="showTitle" style="font-size: 20; font-weight: 800;">
								首页——查询所有违纪记录
							</label>
						</div>
					</div>
				</div>
				<div class="ad-main-comment J_mainContent" id="ad-iframe">
					<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
						src="InquireServlet?limit=4" frameborder="0"
						data-id="InquireServlet" seamless></iframe>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/jquery.min.js">
</script>
		<script type="text/javascript" src="js/contabs.js">
</script>
		<script type="text/javascript" src="js/maintabs.js">
</script>
		<script type="text/javascript" src="js/jquery-smartMenu-min.js">
</script>
		<script type="text/javascript" src="js/jquery.nicescroll.min.js">
</script>
		<script type="text/javascript">
$(function() {
	$(".ad-menu").niceScroll( {
		cursorborder : "0 none",
		cursorcolor : "#1a1a19",
		cursoropacitymin : "0",
		boxzoom : false
	});
})
</script>
	</body>
</html>
</html>
