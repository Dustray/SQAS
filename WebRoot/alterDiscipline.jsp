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
	var a = document.getElementById("brltype").value;
	var b = document.getElementById("brlstuname").value;
	var e = document.getElementById("brldate").value;
	var f = document.getElementById("brldetail").value;
	var g = document.getElementById("brlpoints").value;
	var i = document.getElementById("brldealadminid").value;
	var j = document.getElementById("brldepartmentid").value;
	var k = document.getElementById("brldealdate").value;
	if (a == "" || b == "" || e == "" || f == "" || g == "" || i == ""
			|| j == "" || k == "") {
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
		<form action="UpdateDisServlet?id = ${item.brlid}"
			onSubmit="return judgeNull()" method="post">
			<table>
					<c:set var="brli" value="${requestScope.brli}"></c:set>
						<tr>
							<td align="right">
								<label>
									ID：
								</label>
							</td>
							<td>
								<input TYPE="text" id="brlid" name="brlid"
									value="${brli.brlid}">
								<br>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label>
									违纪类型：
								</label>
							</td>
							<td>
								<input TYPE="text" id="brltype" name="brltype"
									value="${brli.brltype}">
								<br>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label>
									违纪学生姓名：
								</label>
							</td>
							<td>
								<input TYPE="text" id="brlstuname" name="brlstuname"
									placeholder="多个名字请用分号分隔（不区分中英文）" value="${brli.brlstuname}">
								<br>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label>
									违纪人年级：
								</label>
							</td>
							<td>
								<select id="brlstugrade" name="brlstugrade" >
									<option value="${brli.brlstugrade}">
										原：${brli.brlstugrade}
									</option>
									<option value="2013">
										2013
									</option>
									<option value="2014">
										2014
									</option>
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
									违纪人班级：
								</label>
							</td>
							<td>
								<select id="brlstuclass" name="brlstuclass">
									<option value="${brli.brlstuclass}">
										原：${brli.brlstuclass}
									</option>
									<option value="计算机本科一班">
										计算机本科一班
									</option>
									<option value="计算机本科二班">
										计算机本科二班
									</option>
									<option value="通信一班">
										通信一班
									</option>
									<option value="通信二班">
										通信二班
									</option>
									<option value="物联网">
										物联网
									</option>
									<option value="软件一班">
										软件一班
									</option>
									<option value="软件二班">
										软件二班
									</option>
									<option value="网络一班">
										网络一班
									</option>
									<option value="网络二班">
										网络二班
									</option>
								</select>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label>
									违纪日期：
								</label>
							</td>
							<td>
								<input TYPE="text" id="brldate" name="brldate"
									placeholder="格式：2016-05-29" value="${brli.brldate}">
								<br>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label>
									细节备注：
								</label>
							</td>
							<td>
								<input TYPE="text" id="brldetail" name="brldetail"
									value="${brli.brldetail}">
								<br>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label>
									扣分：
								</label>
							</td>
							<td>
								<input TYPE="text" id="brlpoints" name="brlpoints"
									value="${brli.brlpoints}">
								<br>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label>
									分值单位：
								</label>
							</td>
							<td>
								<select id="brlpointsunit" name="brlpointsunit"
									value="${brli.brlpointsunit}">
									<option value="学时">
										学时
									</option>
									<option value="分素质拓展分">
										素质拓展分
									</option>
								</select>
								<br>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label>
									登记人员代码：
								</label>
							</td>
							<td>
								<input TYPE="text"
									value="<%=request.getSession().getAttribute("adminID")%>"
									readonly id="brldealadminid" name="brldealadminid"
									style="color: #9090d5">
								<br>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label>
									管理部门：
								</label>
							</td>
							<td>
								<input TYPE="text"
									value="<%=request.getSession().getAttribute("adminDepName")%>"
									readonly id="brldepartmentid" name="brldepartmentid"
									style="color: #9090d5">
								<br>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label>
									登记日期：
								</label>
							</td>
							<td>
								<input TYPE="text" id="brldealdate" name="brldealdate"
									value="时间系统自动生成" readonly style="color: #9090d5">
								<br>
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
