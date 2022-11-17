<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${approvalFlag eq 2}">
	<fieldset>
		<legend>审核</legend>
		<table class="posttable app-op-box" data-target="report${index}-manage-select" >
			<tr>
				<td >
				<%--隐藏掉不处理的选项 
				<input title="不对当前报卡进行处理" value="1" checked="checked" type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" />不处理当前报卡
				<br />
				--%>
				<input checked="checked" value="3"  type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 通过
					<input value="2" type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 
					<ehr:authorize ifAnyGranted="0307,0207">
						作废
					</ehr:authorize>
					<ehr:authorize ifAnyGranted="0407,0107">
						退回 <input value="4" type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 不管理
					</ehr:authorize>
					
					备注<input type="text" name="report[${index}].comments" reg="{'maxlength':500}" />
					</td>
			</tr>
			<c:if test="${reportInfo.reportType !='2' and '3' eq reportInfo.cdmStatusInfo.reportStatus}">
				<ehr:authorize ifAnyGranted="0107">
					<c:choose>
						<c:when test="${not empty superManageOrganCode}">
							<c:set var="currentSuperManageOrganCode" value="${superManageOrganCode}"></c:set>
						</c:when>
						<c:otherwise>
							<c:set var="currentSuperManageOrganCode" value="${reportInfo.createCenterOrganCode}"></c:set>
						</c:otherwise>
					</c:choose>
					
					<tr  id="report${index}-manage-select">
						<td>分配到:<ehr:org-type-list reg="{'dependOn':'report[${index}].approvalOp','dependValue':'3','required':true}" name="report[${index}].superManageOrganCode"  type="centre"  value="${currentSuperManageOrganCode}"/>
						</td>
					</tr>
				</ehr:authorize>
			</c:if>
		</table>
	</fieldset>
</c:if>
<jsp:include page="alloc.jsp"></jsp:include>
