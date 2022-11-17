<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/basicConsultation.js" type="text/javascript"></script>
<input type="hidden" value="${isView}" id="isView"/>
<div style="float: right; width: 83%;overflow:auto">
	<div id="consultationDiv" style="position: relative;"></div>
</div>
<div style="float:left;width: 16%;margin-top: -9px;">
	<table class="repeattable layui-table x-admin-sm-table-list-small">
		<thead>
			<tr>
				<th>会诊日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${PersonalConsultationDTO.consultations}" var="consultation">
				<tr onclick="basicConsultation.getConsultation(${consultation.id})" style="cursor: pointer;">
					<input type="hidden" value="${consultation.id}" class="consultation" />
					<td align="center"><fmt:formatDate value="${consultation.consulationDate}" pattern="yyyy/MM/dd"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
