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

		<title>ѧ�����Ա��¼���Խ���</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<!-- CSS -->
		<link rel="stylesheet" href="assets/css/reset.css">
		<link rel="stylesheet" href="assets/css/supersized.css">
		<link rel="stylesheet" href="assets/css/style.css">
	</head>

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

	<body>
		<!-- <div>
			<label>
				ѧ�����Ա��¼���Խ���
			</label>
			<a href="index.jsp">����</a>
			<h1>
				��ӭʹ�õ�һ ��������ʾ��
			</h1>
			<a href="LoggerServlet"> �����˴��鿴��������Ч��</a>
		</div> -->
		<div class="page-container">
			<h1>
				��¼
			</h1>
			<form action="LoginServlet" method="post">
				<input type="text" id="sumSID" name="sumSID" class="username"
					placeholder="ѧ��">
				<input type="password" id="sumPassword" name="sumPassword"
					class="password" placeholder="����">
				<button type="submit" onClick="passIfNull">
					�ύ
				</button>
				<div class="error">
					<span>+</span>

				</div>
				<div  style="margin-top: 10px;">
					<a href="memberLogonPass.jsp">��Ȩע�����</a>
				</div>
			</form>
		</div>

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
