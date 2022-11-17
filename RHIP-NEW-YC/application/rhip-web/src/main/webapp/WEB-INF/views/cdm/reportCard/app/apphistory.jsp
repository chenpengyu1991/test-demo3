<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${fn:length(reportInfo.approvalInfos ) >0}">
<fieldset class="layui-elem-field">
	<legend>历史审核信息</legend>
	<table class="posttable">
		<thead>
			<tr>
				<td><label>审批时间</label></td>
				<td><label>审批人</label></td>
				<td><label>审批机构</label></td>
				<td><label>结果</label></td>
				<td><label>备注</label></td>
			</tr>
		</thead>
		<c:forEach items="${reportInfo.approvalInfos }" varStatus="status" var="appInfo">
			<tr>
				<td><fmt:formatDate value="${appInfo.approvalDate}" pattern="yyyy/MM/dd" /></td>
				<td>${appInfo.userName}</td>
				<td>${appInfo.orgName}</td>
				<td>
				 <ehr:dic dicmeta="DMD00005" code="${appInfo.status}"></ehr:dic>
				<td>${appInfo.comments}</td>
			</tr>
		</c:forEach>
	</table>
</fieldset>
</c:if>
