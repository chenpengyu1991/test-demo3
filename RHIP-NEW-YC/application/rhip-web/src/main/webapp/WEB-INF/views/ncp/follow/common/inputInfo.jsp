<%@ page import="com.founder.rhip.ncp.common.NcpConstants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="MONITOR" value="<%=NcpConstants.NCP_MONITOR_TYPE_1%>"/>
<c:set var="REEXAM" value="<%=NcpConstants.NCP_MONITOR_TYPE_2%>"/>
<c:set var="FOLLOW" value="<%=NcpConstants.NCP_MONITOR_TYPE_3%>"/>
<fieldset class="layui-elem-field">
	<legend>
		<c:if test="${MONITOR eq type}">监测医生信息</c:if>
		<c:if test="${REEXAM eq type}">复查医生信息</c:if>
		<c:if test="${FOLLOW eq type}">随访医生信息</c:if>
	</legend>
	<input type="hidden" name="doctorName" value="${input.doctorName}" />
	<input type="hidden" name="monitorDoctor" value="${input.monitorDoctor}" />
	<input type="hidden" name="monitorOrg" value="${input.monitorOrg}" />
	<input type="hidden" name="createTime" readonly="readonly" value='<fmt:formatDate value="${input.createTime}" pattern="yyyy/MM/dd" />' />
	<input type="hidden" name="createId" value="${input.createId}" />
	<table class="posttable">
		<colgroup>
			<col style="min-width: 100px; width: 30%" />
			<col style="min-width: 150px; width: 70%" />
		</colgroup>
		<tr>
			<th><label class="required">责任医生</label></th>
			<td title="${input.doctorName}">
				<ehr:staff-name staffCode="${input.monitorDoctor}"/>
			<td>
		</tr>
		<tr>
			<th><label class="required">随访机构</label></th>
			<td><ehr:org code="${input.monitorOrg}" /></td>
		</tr>
		<%--0193329: 【新冠肺炎健康管理】 去掉随访录入页面的‘下次随访日期‘字段
		<c:if test="${FOLLOW eq type}">
			<tr>
				<th><label class="required">下次随访日期</label></th>
				<td>
					<tag:dateInput onlyfuture="true" name="nextMonitorDate" style="width:178px;" date="${input.nextMonitorDate}" reg="{'required':true}" />
				</td>
			</tr>
		</c:if>--%>
	</table>
</fieldset>