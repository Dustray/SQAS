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

		<script type="text/javascript">
var str;
var result;
function getQues() {
	num1 = parseInt(Math.random() * 40 + 10, 10);
	num2 = parseInt(Math.random() * 40 + 10, 10);
	num3 = parseInt(Math.random() * 40 + 10, 10);
	num4 = parseInt(Math.random() * 40 + 10, 10);
	str = num1 + "+" + num2 + "*(" + num3 + "-" + num4 + ")";
	document.getElementById("verifyNum").setAttribute("placeholder", str);
	document.getElementById("verifyNum").value = "";
	result = (num3 - num4) * num2 + num1;
	//alert(result);
<%if (request.getParameter("info") != null) {%>
	drawToast("���ύ");
	<%}%>
}

function checkVerifyNum() {
	var a = document.getElementById("brlstuname").value;
	var b = document.getElementById("brlid").value;
	var c = document.getElementById("aplreason").value;
	var d = document.getElementById("verifyNum").value;
	if(a==""||b==""||c==""||d==""){
	drawToast("�������ݽԲ�Ϊ�գ�");
			return false;
	}
	if (document.getElementById("verifyNum").value == result) {
		return true;
	} else {
	drawToast("��֤�����");
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
	</head>


	<body onload="getQues()">
		<!--Form����ʼ-->
		<form action="SubmitAppealServlet" method="post"
			onsubmit="return checkVerifyNum()">
			<table>
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
							Υ��ID��
						</label>
					</td>
					<td>
						<input type="text" id="brlid" name="brlid" />
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
					<td>
						<label>
							�������ɣ�
						</label>
					</td>
					<td>
						<textarea maxlength="100" id="aplreason" name="aplreason"
							style="resize: none; height: 120px" placeholder="100�����ڣ��뾡�����������"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							��֤�룺
						</label>
					</td>
					<td>
						<input type="text" id="verifyNum" placeholder="1+2*(3-4)" />
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input
							style="background: #878787; color: #ffffff; font-size: 18px; height: 35px;"
							type="submit" value="�� ��" onclick="checkVerifyNum()" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
