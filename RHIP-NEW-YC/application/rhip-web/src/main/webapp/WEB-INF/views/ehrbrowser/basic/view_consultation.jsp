<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/viewConsultation.js" type="text/javascript"></script>

<div id="consultationViewDiv" style="text-align: left;">
	<style>
		#consultationViewDiv s.pop_No{width:500px;}
	</style>
	<div class="postcontent">
		<h1 align="center" style="font-size: 24px;">会诊记录表</h1>
		<div style="height: 40px;margin-top: 10px">
			<span class="span_floatleft">&emsp;&emsp;<b>姓名：</b>${personInfo.name}</span>
			<c:choose>
				<c:when test="${not empty personInfo.healthFileNoHtml}">
					${personInfo.healthFileNoHtml}
				</c:when>
				<c:otherwise>
					<s class="pop_No">
						<span class="text"><b>编号：</b></span>
						<span></span><span></span><span></span><span></span><span></span>
						<span class="line">-</span>
						<span></span><span></span><span></span>
						<span class="line">-</span>
						<span></span><span></span><span></span>
						<span class="line">-</span>
						<span></span><span></span><span></span><span></span>
					</s>
				</c:otherwise>
			</c:choose>
		</div>
		<hr style="width: 100%"/>
		<div class="postdiv">
			<table class="posttable x-admin-sm-table-list-middle" style="width: 100%;margin-top: 10px">
				<colgroup>
					<col style="width: 13%"/>
					<col style="width: 37%"/>
					<col style="width: 50%"/>
				</colgroup>
				<tr>
					<th>会诊原因：</th>
					<td colspan="2">${consultation.consulationReason}</td>
				</tr>
				<tr>
					<th>会诊意见：</th>
					<td colspan="2">${consultation.consulationOpinion}</td>
				</tr>
				<tr>
					<td colspan="3"><b>会诊医生及其所在医疗卫生机构:</b> </td>
				</tr>
				<tr>
					<td colspan="2" align="center"><b>医疗卫生机构名称</b></td>
					<td align="center"><b>会诊医生签字</b></td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="hidden" name="Consultation.consulationOrgAndName" id="consulationOrgAndName" value='${consultation.consulationOrgAndName}'>
						<div id="orgAndDoc">

						</div>
					</td>
				</tr>
				<tr>
					<td colspan="3" align="right"><b>责任医生：</b>${consultation.manageDoctorName}</td>
				</tr>
				<tr>
					<td colspan="3" align="right"><b>会诊日期：</b><fmt:formatDate value="${consultation.consulationDate}" pattern="yyyy/MM/dd"/></td>
				</tr>
			</table>
		</div>
	</div>
</div>

<%--

<div style="float: left; width: 17%; margin-top: 5px" class="repeattable">
	<table>
		<thead>
			<tr>
				<th>孕产妇编号</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${whYcfbjJdList}" var="whYcfbjJd">
				<tr onclick="pregnantwomentabList.getPregnantwomentabList(${whYcfbjJd.id})" style="cursor: pointer;">
					<input type="hidden" value="${whYcfbjJd.id}" class="WhYcfbjJd" />
					<td>${whYcfbjJd.ycfbh}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div style="float: right; width: 82%">
	<div id="WhYcfbjJdDiv" style="position: relative;"></div>
</div>--%>
