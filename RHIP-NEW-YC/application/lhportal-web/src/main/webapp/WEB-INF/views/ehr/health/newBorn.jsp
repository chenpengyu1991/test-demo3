<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/newBorn.js" type="text/javascript"></script>
<div style="float: left; width: 25%" class="repeattable">
	<table>
		<thead>
			<tr>
				<th>幼儿姓名</th>
				<th>出生日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${chBirthCertificates}" var="chb">
				<tr onclick="portalBrwHealthNewBorn.getChBirthCertificate(${chb.id})" >
					<td>
						<input type="hidden" value="${chb.id}" class="healthNewBorn" />
						<c:out value="${chb.neonatalName}"></c:out>
					</td>
					<td>
						<fmt:formatDate value="${chb.neonatalBirthday}" pattern="yyyy/MM/dd"></fmt:formatDate>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div style="float: right; width: 74%">
	<div id="newBornDetailDiv" style="position: relative;"></div>
</div>