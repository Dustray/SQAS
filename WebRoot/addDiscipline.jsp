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
	//var c = document.getElementById("brlstugrade").value;
	//var d = document.getElementById("pubDtbrlstuclass").value;
	var e = document.getElementById("brldate").value;
	var f = document.getElementById("brldetail").value;
	var g = document.getElementById("brlpoints").value;
	//var h = document.getElementById("brlpointsunit").value;
	var i = document.getElementById("brldealadminid").value;
	var j = document.getElementById("brldepartmentid").value;
	var k = document.getElementById("brldealdate").value;
	if (a == "" || b == "" || e == "" || f == "" || g == "" || i == ""
			|| j == "" || k == "") {
		drawToast("������Ŀ����Ϊ�գ�");
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
		<!--Form����ʼ-->
		<form action="AddDisServlet" onSubmit="return judgeNull()"
			method="post">
			<table>
				<tr>
					<td align="right">
						<label>
							Υ�����ͣ�
						</label>
					</td>
					<td>
						<input TYPE="text" id="brltype" name="brltype">
						<br>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label>
							Υ��ѧ��������
						</label>
					</td>
					<td>
						<input TYPE="text" id="brlstuname" name="brlstuname"
							placeholder="����������÷ֺŷָ�����������Ӣ�ģ�">
						<br>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label>
							Υ�����꼶��
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
					<td align="right">
						<label>
							Υ���˰༶��
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
					<td align="right">
						<label>
							Υ�����ڣ�
						</label>
					</td>
					<td>
						<input TYPE="text" id="brldate" name="brldate"
							placeholder="��ʽ��2016-05-29" value="2016-">
						<br>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label>
							ϸ�ڱ�ע��
						</label>
					</td>
					<td>
						<input TYPE="text" id="brldetail" name="brldetail">
						<br>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label>
							�۷�/ѧʱ��
						</label>
					</td>
					<td>
						<input TYPE="text" id="brlpoints" name="brlpoints">
						<br>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label>
							�˿۵�λ��
						</label>
					</td>
					<td>
						<select id="brlpointsunit" name="brlpointsunit">
							<option value="ѧʱ">
								ѧʱ
							</option>
							<option value="��������չ��">
								������չ��
							</option>
						</select>
						<br>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label>
							�Ǽ���Ա���룺
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
							�����ţ�
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
							�Ǽ����ڣ�
						</label>
					</td>
					<td>
						<input TYPE="text" id="brldealdate" name="brldealdate"
							value="ʱ��ϵͳ�Զ�����" readonly style="color: #9090d5">
						<br>
					</td>
				</tr>

				<tr>
					<td align="center" colspan="2">
						<input
							style="background: #878787; color: #ffffff; font-size: 18px; height: 35px;"
							type="submit" value="����" onClick="judgeNull();" />
					</td>
				</tr>

			</table>
		</form>
		<!--Form������-->
	</body>
</html>
