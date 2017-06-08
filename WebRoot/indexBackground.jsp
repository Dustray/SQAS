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
			<div class="ad-menu" id="ad-menu">
				<div class="ad-logo">
					<a href="indexBackground.jsp"><img src="image/m-logo.png" height="100" width="130"></a>
				</div>
				<div class="ad-list">
					<ul>
						<li>
								<a href="InquireServlet?limit=2&nowPage=1" target="iframe0"
									onclick="changeTitle('��ҳ������ѯ����Υ�ͼ�¼');"> 
									<div class="li-item">��ѯ����Υ����Ϣ </div>
								</a>
						</li>
						<li>
							
								<a href="addDiscipline.jsp" target="iframe0"
									onclick="changeTitle('���Υ����Ϣ');">
									<div class="li-item">���Υ����Ϣ</div>
								</a>
							

						</li>
						<li>
							<a href="AppealInquireServlet" target="iframe0"
									onclick="changeTitle('�鿴������Ϣ');">
								<div class="li-item">�鿴������Ϣ</div>
							</a>
						</li>
						<li>
							<a href="InquireServlet?limit=1" target="iframe0"
								onclick="changeTitle('��Ϣ������ɾ��');">
								<div class="li-item">��Ϣ������ɾ��</div>
							</a>
						</li>
						<li>
							<a href="memberManage.jsp" target="iframe0"
								onclick="changeTitle('��Ա����');">
								<div class="li-item">��Ա����</div>
							</a>
						</li>
						<li>
							<a href="login.jsp">
								<div class="li-item">ϵͳ�����½</div>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="ad-comment-box" id="ad-comment"
				style="background: #a9a9a9">
				<div class="ad-top-comment">
					<div class="ad-message" style="background: #434343">
						<div class="ad-top-left">
							<div class="ad-change-btn" style="background: #f0f0f0">
								<a id="ad-list" href="javascript:;" class="scm ad-list-btn" ></a>
							</div>
							<div class="ad-search-box clear">
								<form id="simpleSelectForm" name="simpleSelectForm"
									action="InquireSimpleServlet" method="post" target="iframe0">
									<div class="ad-search-sel">
										<select id="selectType" name="selectType"
											onchange="selectListening();">
											<option value="brlstuname">
												����
											</option>
											<option value="brlstuclass">
												�༶
											</option>
											<option value="brldepartmentid">
												����
											</option>
											<option value="brldate">
												����
											</option>
										</select>
									</div>
									<div class="ad-search-cha">
										<input id="selectContentA" name="selectContentA" type="text"
											class="ad-search-input" placeholder="��������Ҫ���ҵ�����"
											style="display: block" onkeyup="contentChange();" />
										<select id="selectDepartmentB" name="selectDepartmentB"
											class="ad-search-input" style="display: none"
											onchange="contentChange();">
											<option value="1">
												�ͼ첿
											</option>
											<option value="2">
												������
											</option>
											<option value="3">
												������
											</option>
											<option value="4">
												ѧϰ��
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
									<div class="font-wel" style="color:#b0b0b0">
										��ӭ����
										<strong><%=request.getSession().getAttribute("adminNow")%></strong>
									</div>
									<div class="font-wel">
										<a href="LogoutServlet"><strong style="color:#f05555">���˳���</strong> </a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div align="center" class="ad-sub-nav-box content-tabs"
						style="background: #434343">
						<label id="showTitle"
							style="font-size: 20; font-weight: 800; color: #ffffff">
							��ҳ������ѯ����Υ�ͼ�¼
						</label>
					</div>
				</div>
				<div class="ad-main-comment J_mainContent" id="ad-iframe">
					<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
						src="InquireServlet?limit=2" frameborder="0" data-id="InquireServlet"
						seamless></iframe>
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
