<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="com.dustray.entity.Stuunimeminfo"%>
<%@page import="com.dustray.entity.Loginpersoninfo"%>
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

		<title>My JSP 'addDiscipline.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type="text/javascript">
function judgeNull() {
	var a = document.getElementById("sumsid").value;
	var b = document.getElementById("sumname").value;
	var c = document.getElementById("sumgetpass").value;
	var d = document.getElementById("sumpassword").value;
	var e = document.getElementById("sumpasswordagain").value;

	if (a == "" || b == "" || c == "" || d == "" || e == "") {
		drawToast("������Ŀ����Ϊ�գ�");
		return false;
	} else if (d != e) {
		drawToast("�����������벻һ��");
		return false;
	}
}

var intervalCounter = 0;
function hideToast() {
	var alert = document.getElementById("toast");
	alert.style.opacity = 0;
	clearInterval(intervalCounter);
}
function drawToast(message) {
	var alert = document.getElementById("toast");
	if (alert == null) {
		var toastHTML = '<div id="toast" style="color:#000000;">' + message + '</div>';
		document.body.insertAdjacentHTML('beforeEnd', toastHTML);
	} else {
		alert.style.opacity = .5;
	}
	intervalCounter = setInterval("hideToast()", 3000);
}
</script>


		<!-- CSS -->
		<link rel="stylesheet" href="assets/css/reset.css">
		<link rel="stylesheet" href="assets/css/supersized.css">
		<link rel="stylesheet" href="assets/css/style.css">
	</head>

	<body class="page-container" >
		<%
			request.setCharacterEncoding("gbk");
		%>
		<h1 style="margin-top: -30px">
			ѧ�����Աע��
		</h1>
		<!--Form����ʼ-->
		<form action="MemberRegPassServlet" onSubmit="return judgeNull()"
			method="post">
			<table style="width: 240px">
				<tr>
					<td align="center">
						<input TYPE="text" id="sumsid" name="sumsid" placeholder="ѧ��">
						<br>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input TYPE="text" id="sumname" name="sumname" placeholder="����">
						<br>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input TYPE="text" id="sumgetpass" name="sumgetpass"
							placeholder="��Ȩ����">
						<br>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input TYPE="password" id="sumpassword" name="sumpassword"
							placeholder="����">
						<br>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input TYPE="password" id="sumpasswordagain"
							name="sumpasswordagain" placeholder="ȷ������">
						<br>
					</td>
				</tr>
				<tr>
					<td align="center">

						<button type="submit" onClick="judgeNull()"
							style="background: #8df;">
							�ύ
						</button>
					</td>
				</tr>

			</table>
		</form>
		<!--Form������-->

		<!-- Javascript -->
		<script src="assets/js/jquery-1.8.2.min.js">
</script>
		<script src="assets/js/supersized.3.2.7.min.js">
</script>
		<script src="assets/js/supersized-init.js">
</script>
		<script src="assets/js/scripts.js">
</script>
	</body>
</html>
