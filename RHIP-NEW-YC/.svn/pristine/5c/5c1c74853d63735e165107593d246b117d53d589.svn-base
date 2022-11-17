<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/childHealthExaminationOne.js" type="text/javascript"></script>
<div style="float: left; width: 17%;padding-top: 5px;" class="table-basic">
	<c:forEach items="${gourpChildHealthExaminationOnesMap}" var="childHealthExaminationOnes">
		<table>
			<thead>
			<tr>
				<th title="${childHealthExaminationOnes.key}">检查日期</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${childHealthExaminationOnes.value}" var="cheo">
				<tr onclick="macHealthChildHealthExaminationOne.getChildHealthExaminationOne(${cheo.id})" style="cursor: pointer;">
					<td>
						<input type="hidden" value="${cheo.id}" class="childHealthExaminationOne" />
						<fmt:formatDate value="${cheo.visitDate}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:forEach>
</div>
<div style="float: right; width: 82%">
	<div id="childHealthExaminationOneDiv" style="position: relative;"></div>
</div>