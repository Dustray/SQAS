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
		<!--Form����ʼ-->
		<form action="InquireAdvancedServlet" method="post">
			<table>
				<tr>
					<td>
						<label>
							���ͣ�
						</label>
					</td>
					<td>
						<input type="text" id="brltype" name="brltype" />
					</td>
				</tr>
				<tr>
					<td>
						<label>
							������
						</label>
					</td>
					<td>
						<input type="text" id="brlstuname" name="brlstuname" />
					</td>
				</tr>
				<tr>
					<td>
						<label>
							�꼶��
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
							�༶��
						</label>
					</td>
					<td>
						<select id="brlstuclass" name="brlstuclass">
							<option value="���������һ��">
								���������һ��
							</option>
							<option value="��������ƶ���">
								��������ƶ���
							</option>
							<option value="ͨ��һ��">
								ͨ��һ��
							</option>
							<option value="ͨ�Ŷ���">
								ͨ�Ŷ���
							</option>
							<option value="������">
								������
							</option>
							<option value="���һ��">
								���һ��
							</option>
							<option value="�������">
								�������
							</option>
							<option value="����һ��">
								����һ��
							</option>
							<option value="�������">
								�������
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							���ڣ�
						</label>
					</td>
					<td>
						<input type="text" id="brldate" name="brldate" />
					</td>
				</tr>
				<tr>
					<td>
						<label>
							�۷֣�
						</label>
					</td>
					<td>
						<input type="text" id="brlpoints" name="brlpoints" />
					</td>
				</tr>
				<tr>
					<td>
						<label>
							���ţ�
						</label>
					</td>
					<td>
						<select id="brldepartmentid" name="brldepartmentid">
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
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input
							style="background: #878787; color: #ffffff; font-size: 18px; height: 35px;"
							type="submit" value="��ѯ" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
