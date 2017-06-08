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

		<title>My JSP 'inquireAdvanced.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="css/mycss.css" type="text/css"></link>
	</head>

	<body>
		<!--Form表单开始-->
		<form action="InquireAdvancedServlet" method="post">
			<table>
				<tr>
					<td>
						<label>
							类型：
						</label>
					</td>
					<td>
						<input type="text" id="brltype" name="brltype" />
					</td>
				</tr>
				<tr>
					<td>
						<label>
							姓名：
						</label>
					</td>
					<td>
						<input type="text" id="brlstuname" name="brlstuname" />
					</td>
				</tr>
				<tr>
					<td>
						<label>
							年级：
						</label>
					</td>
					<td>
						<select id="brlstugrade" name="brlstugrade">

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
					<td>
						<label>
							班级：
						</label>
					</td>
					<td>
						<select id="brlstuclass" name="brlstuclass">
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
					<td>
						<label>
							日期：
						</label>
					</td>
					<td>
						<input type="text" id="brldate" name="brldate" />
					</td>
				</tr>
				<tr>
					<td>
						<label>
							扣分：
						</label>
					</td>
					<td>
						<input type="text" id="brlpoints" name="brlpoints" />
					</td>
				</tr>
				<tr>
					<td>
						<label>
							部门：
						</label>
					</td>
					<td>
						<select id="brldepartmentid" name="brldepartmentid">
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
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input
							style="background: #878787; color: #ffffff; font-size: 18px; height: 35px;"
							type="submit" value="查询" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
