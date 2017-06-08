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

		<title>My JSP 'error.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
function go() {
	window.history.go(-1);
}
setTimeout("go()", 3000);
</script>
	</head>

	<body>
		<body>
			<table align="center">
				<tr align="center">
					<td>
						<%
							if (request.getParameter("info").toString().equalsIgnoreCase("nolimit")) {
						%><span id="message" style="color: red">&nbsp;<%=request.getParameter("info")%>:Have no legal power!</span>
						<%
							} else if (request.getParameter("info").toString().equalsIgnoreCase("ExistAppealFailed")) {
						%><span id="message" style="color: red">&nbsp;<%=request.getParameter("info")%>：申诉失败，已存在此申诉信息，请勿重复提交。</span>
						<%
							} else if (request.getParameter("info").toString().equalsIgnoreCase("verifyFailed")) {
						%><span id="message" style="color: red">&nbsp;<%=request.getParameter("info")%>：验证失败，请检查信息是否错误。</span>
						<%
							} else if (request.getParameter("info").toString().equalsIgnoreCase("noLogin")) {
						%><span id="message" style="color: red">&nbsp;<%=request.getParameter("info")%>：您未登录！</span>
						<%
							}else if (request.getParameter("info").toString().equalsIgnoreCase("existMemInfo")) {
						%><span id="message" style="color: red">&nbsp;<%=request.getParameter("info")%>：已存在此学生会成员信息！</span>
						<%
							} else {
						%><span id="message" style="color: red">Unknown error！</span>
						<%
							}
						%>
					</td>
				</tr>
				<tr align="center">
					<td>
						三秒钟后自动跳转到上一页......
					</td>
				</tr>
				<tr align="center">
					<td>
						<a href="javascript:'" onClick="javascript:history.back(-1);"><img
								src="image/goLastPage1.png" width="100" border="0" title="立即返回">
						</a>
					</td>
				</tr>
			</table>
		</body>
	</body>
</html>
