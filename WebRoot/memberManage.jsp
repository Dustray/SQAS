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
	var c = document.getElementById("sumdepartmentid").value;
	var d = document.getElementById("sumposition").value;
	if (a == "" || b == "" || c == "" || d == "" ) {
		drawToast("所有项目不能为空！");
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
		var toastHTML = '<div id="toast">' + message + '</div>';
		document.body.insertAdjacentHTML('beforeEnd', toastHTML);
	} else {
		alert.style.opacity = .5;
	}
	intervalCounter = setInterval("hideToast()", 3000);
}
</script>


		<link rel="stylesheet" href="css/mycss.css" type="text/css"></link>
	</head>

	<body>
		<%
			request.setCharacterEncoding("gbk");
		%>
		<!--Form表单开始-->
		<form action="MemberRegServlet" onSubmit="return judgeNull()"
			method="post">
			<table>
				<tr>
					<td align="right">
						<label>
							成员学号：
						</label>
					</td>
					<td>
						<input TYPE="text" id="sumsid" name="sumsid">
						<br>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label>
							成员姓名：
						</label>
					</td>
					<td>
						<input TYPE="text" id="sumname" name="sumname">
						<br>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label>
							成员年级：
						</label>
					</td>
					<td>
						<select id="sumgrade" name="sumgrade">
							<option value="2015">
								2015
							</option>
							<option value="2016">
								2016
							</option>
						</select>
					</td>
				</tr>

				<tr>
					<td align="right">
						<label>
							部门：
						</label>
					</td>
					<td>
						<input TYPE="text"
							value="<%=request.getSession().getAttribute("adminDepName")%>"
							readonly id="sumdepartmentid" name="sumdepartmentid"
							style="color: #9090d5">
						<br>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label>
							成员职位：
						</label>
					</td>
					<td>
						<!-- <input TYPE="text" id="sumposition" name="sumposition" value="干事"> -->
						<select id="sumposition" name="sumposition">
							<option value="干事">
								干事
							</option>
							<option value="（副）部长">
								（副）部长
						</select>
						<br>
					</td>
				</tr>
				<tr>
					<td align="right" colspan="2">
						<label>
							*您的授权码为
							<label style="color: ff0000"><%=request.getSession().getAttribute("adminID")%></label>
							，请告知您所添加的人，注册密码时需提供此授权码。
						</label>
					</td>

				</tr>
				<tr>
					<td align="center" colspan="2">
						<input
							style="background: #878787; color: #ffffff; font-size: 18px; height: 35px;"
							type="submit" value="保存" onClick="judgeNull();" />
					</td>
				</tr>

			</table>
		</form>
		<!--Form表单结束-->
	</body>
</html>
