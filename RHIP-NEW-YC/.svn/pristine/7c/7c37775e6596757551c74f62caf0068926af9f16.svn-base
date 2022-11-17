<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${fn:length(reportInfo.approvalInfos ) >0}">
<fieldset>
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
<c:if test="${approvalFlag eq 2}">
	<fieldset>
		<legend>审核</legend>
		<table class="posttable app-op-box" data-target="report${index}-manage-select" >
			<tr>
				<td ><input title="不对当前报卡进行处理" value="1" checked="checked" type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" />不处理当前报卡
				<br />
				<input value="3"  type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 通过
					<input value="2" type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 退回
					备注<input type="text" name="report[${index}].comments" reg="{'maxlength':33}" />
					</td>
			</tr>
		</table>
	</fieldset>
</c:if>
<jsp:include page="alloc.jsp"></jsp:include>
