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
							类型
						</th>
						<th nowrap="nowrap">
							违纪人
						</th>
						<th nowrap="nowrap">
							年级
						</th>
						<th nowrap="nowrap">
							班级
						</th>
						<th nowrap="nowrap">
							日期
						</th>
						<th nowrap="nowrap">
							细节
						</th>
						<th nowrap="nowrap">
							扣分
						</th>
						<th nowrap="nowrap">
							登记人员
						</th>
						<th nowrap="nowrap">
							登记部门
						</th>
						<th nowrap="nowrap">
							登记时间
						</th>
						<th nowrap="nowrap" style="color:#ff2020">
							操作
						</th>
						<th style="width: 26px;"></th>
					</tr>
				</thead>
				<!--循环开始-->
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
								{item.sumid}(外键学生会成员代号无法显示)
							</td>
							<td>
								{item.sudid}(外键学生会部门代号无法显示)
							</td>
							<td>
								${item.brldealdate}
							</td>
							<td nowrap="nowrap">
								<a href="AlterDisServlet?id=${item.brlid}" style=" color:#ff0000;">修改</a>&nbsp;
								<a href="DeleteDisServlet?id=${item.brlid}" style=" color:#ff0000;">删除</a>
								
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<!--循环结束-->
			</table>
		</div>
	</body>
</html>
