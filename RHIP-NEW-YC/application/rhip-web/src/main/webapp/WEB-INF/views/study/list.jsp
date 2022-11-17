<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>检查一览</title>
</head>
<body>
	<div>
		<table>
			<thead>
				<tr>
					<th>时间</th>
					<th>项目</th>
					<th>结论</th>
					<th>机构</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${examineDetails}" var="examineDetail">
					<tr>
						<td><c:out value="${studyEventList.checkDate}"></c:out></td>
						<td><c:out value="${studyEventList.inspectionItemName}"></c:out></td>
						<td><c:out value="${studyEventList.inspectionQuantifyResult}"></c:out></td>
						<td><c:out value="${studyEventList.referenceRange}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>