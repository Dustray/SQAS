<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<title>My JSP 'inquire.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
		<script type="text/javascript">
			$(function() {
				/* For zebra striping */
				$("table tr:nth-child(odd)").addClass("odd-row");
				/* For cell text alignment */
				$("table td:first-child, table th:first-child").addClass("first");
				/* For removing the last border */
				$("table td:last-child, table th:last-child").addClass("last");
			});
			
		</script>
		<link rel="stylesheet" href="css/mycss.css" type="text/css"></link>


	</head>

	<body>
		<div>
			<table cellspacing="0">
				<thead>
					<tr>
						<th nowrap="nowrap">
							����ID
						</th>
						<th nowrap="nowrap">
							������
						</th>
						<th nowrap="nowrap">
							Υ��ID
						</th>
						<th nowrap="nowrap">
							���ڰ༶
						</th>
						<th nowrap="nowrap">
							���߲��Ŵ���
						</th>
						<th nowrap="nowrap">
							��������
						</th>
						<th nowrap="nowrap">
							��������
						</th>
						<th nowrap="nowrap">
							����״̬
						</th>
						<th nowrap="nowrap">
							����ʱ��
						</th>
						<th nowrap="nowrap">
							������Ա
						</th>
						<th nowrap="nowrap" style="color:#ff2020">
							����
						</th>
						<th style="width: 26px;"></th>
					</tr>
				</thead>
				<!--ѭ����ʼ-->
				<tbody>
					<c:set var="AppealList" value="${requestScope.AppealList}"></c:set>
					<c:forEach items="${AppealList}" var="item">
						<tr>
							<td>
								${item.aplid}
							</td>
							<td>
								${item.aplname}
							</td>
							<td>
								${item.aplbrlid}
							</td>
							<td>
								${item.aplgradeclass}
							</td>
							<td>
								${item.apldepartment}
							</td>
							<td>
								${item.aplreason}
							</td>
							<td>
								${item.apldate}
							</td>
							<td>
								${item.aplresult}
							</td>
							<td>
								${item.apldisposdate}
							</td>
							<td>
								${item.apldisposename}
							</td>
							<td>
								<table style="border: 0px;">
									<tr><td nowrap="nowrap"><a href="DisposeAppealServlet?id=${item.aplbrlid}&type=wait" style=" color:#ff0000;">����</a></td></tr>
									<tr><td nowrap="nowrap"><a href="DisposeAppealServlet?id=${item.aplbrlid}&type=turn" style=" color:#ff0000;">����</a></td></tr>
									<tr><td nowrap="nowrap"><a href="DeleteDisServlet?id=${item.aplbrlid}" style=" color:#ff0000;">ͨ����ɾ����</a></td></tr>
									<tr><td nowrap="nowrap"><a href="AlterDisServlet?id=${item.aplbrlid}" style=" color:#ff0000;">�޸�</a></td></tr>
								</table>
								
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<!--ѭ������-->
			</table>
		</div>
	</body>
</html>
