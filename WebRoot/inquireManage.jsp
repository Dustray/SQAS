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
							id
						</th>
						<th nowrap="nowrap">
							����
						</th>
						<th nowrap="nowrap">
							Υ����
						</th>
						<th nowrap="nowrap">
							�꼶
						</th>
						<th nowrap="nowrap">
							�༶
						</th>
						<th nowrap="nowrap">
							����
						</th>
						<th nowrap="nowrap">
							ϸ��
						</th>
						<th nowrap="nowrap">
							�۷�
						</th>
						<th nowrap="nowrap">
							�Ǽ���Ա
						</th>
						<th nowrap="nowrap">
							�Ǽǲ���
						</th>
						<th nowrap="nowrap">
							�Ǽ�ʱ��
						</th>
						<th nowrap="nowrap" style="color:#ff2020">
							����
						</th>
						<th style="width: 26px;"></th>
					</tr>
				</thead>
				<!--ѭ����ʼ-->
				<tbody>
					<c:set var="DisciplineList" value="${requestScope.DisciplineList}"></c:set>
					<c:forEach items="${DisciplineList}" var="item">
						<tr>
							<td>
								${item.brlid}
							</td>
							<td>
								${item.brltype}
							</td>
							<td>
								${item.brlstuname}
							</td>
							<td>
								${item.brlstugrade}
							</td>
							<td>
								${item.brlstuclass}
							</td>
							<td>
								${item.brldate}
							</td>
							<td>
								${item.brldetail}
							</td>
							<td>
								${item.brlpoints}${item.brlpointsunit}
							</td>
							<td>
								{item.sumid}(���ѧ�����Ա�����޷���ʾ)
							</td>
							<td>
								{item.sudid}(���ѧ���Ჿ�Ŵ����޷���ʾ)
							</td>
							<td>
								${item.brldealdate}
							</td>
							<td nowrap="nowrap">
								<a href="AlterDisServlet?id=${item.brlid}" style=" color:#ff0000;">�޸�</a>&nbsp;
								<a href="DeleteDisServlet?id=${item.brlid}" style=" color:#ff0000;">ɾ��</a>
								
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<!--ѭ������-->
			</table>
		</div>
	</body>
</html>
