<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<fieldset class="layui-elem-field" style="padding: 4px;margin: 4px;">
                <legend><span style="font-size: 12px;font-weight: bolder;">${diseaseName}历次诊断列表</span></legend>
	<div class="repeattable">
	    <table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
	        <colgroup>
	            <col style="width: 33%"/>
	            <col style="width: 33%"/>
	            <col style="width: 33%"/>
	        </colgroup>
	        <thead>
				<tr>
					<th>疾病名称</th>
					<%--<th>发病日期</th> --%>
					<th>诊断日期</th>
					<th>机构名称</th>
				</tr>
			</thead>
			<tbody class="tbody">
				<c:forEach items="${diseaseHistorys}" var="diseaseHistory">
						<tr>
							<td style="text-align: center;" title="${diseaseHistory.diseaseName}">${diseaseHistory.diseaseName}</td>
							<%-- <td><fmt:formatDate value="${diseaseHistory.inputDate}" pattern="yyyy/MM/dd "/></td>--%>
							<td style="text-align: center;"><fmt:formatDate value="${diseaseHistory.confirmationDate}" pattern="yyyy/MM/dd "/></td>
							<td style="text-align: center;">
								<c:choose>
									<c:when test="${not empty diseaseHistory.inputOrganCode}"><ehr:org code="${diseaseHistory.inputOrganCode}"/></c:when>
									<c:otherwise><ehr:org code="${personInfo.inputOrganCode}"/></c:otherwise>
								</c:choose>
							</td>
						</tr>
				</c:forEach>
				<c:forEach items="${diseaseDiagnosisInfos}" var="diseaseDiagnosisInfo">
						<tr>
							<td style="text-align: center;" title="${diseaseDiagnosisInfo.diseaseName}">${diseaseDiagnosisInfo.diseaseName}</td>
							<%-- <td><fmt:formatDate value="${diseaseDiagnosisInfo.pathogenesisDate}" pattern="yyyy/MM/dd "/></td>--%>
							<td style="text-align: center;"><fmt:formatDate value="${diseaseDiagnosisInfo.diagnoseDate}" pattern="yyyy/MM/dd "/></td>
							<td style="text-align: center;">
								<c:choose>
									<c:when test="${not empty diseaseDiagnosisInfo.hospitalCode}"><ehr:org code="${diseaseDiagnosisInfo.hospitalCode}"/></c:when>
									<c:otherwise><ehr:org code="${personInfo.inputOrganCode}"/></c:otherwise>
								</c:choose>
							</td>
						</tr>
				</c:forEach>
			</tbody> 
		</table>
		<table>
			<tr>
				<ehr:pagination action="ehrbrowserServiceIndex.sameDiease" colspan="3" param1="${personId }" param2="${diseaseCode}" param3="${diseaseName }"/>
			</tr>
		</table>
	</div>
</fieldset>