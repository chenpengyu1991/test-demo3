<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${approvalFlag eq 3}">
	<fieldset>
		<legend>
			<ehr:authorize ifAnyGranted="0407">管理</ehr:authorize>
			<ehr:authorize ifAnyGranted="0207,0107">分配</ehr:authorize>
		</legend>
		<table class="posttable app-op-box" data-target="report${index}-manage-select" >
			<tr>
				<td>
				<%--隐藏此选项 <input title="不对当前报卡进行处理" value="1" checked="checked" type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" />不处理当前报卡
				<br />--%>
				<ehr:authorize ifAnyGranted="0407">
							<input value="3" checked="checked"  type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 不纳入管理
							<input value="2"  type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 退回 
				</ehr:authorize>
				<ehr:authorize ifAnyGranted="0207">
					<input value="3" checked="checked"  type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 分配
					<input value="2"  type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 退回 
		
				</ehr:authorize>
				<ehr:authorize ifAnyGranted="0107">
						<input value="3"  checked="checked"  type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 分配
						<input value="4"    type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 不管理
				</ehr:authorize>

				备注<input type="text"  name="report[${index}].comments" reg="{'maxlength':500}" />
				
			</tr>
				<ehr:authorize ifAnyGranted="0107">
					<c:choose>
						<c:when test="${not empty superManageOrganCode}">
							<c:set var="currentSuperManageOrganCode" value="${superManageOrganCode}"></c:set>
						</c:when>
						<c:otherwise>
							<c:set var="currentSuperManageOrganCode" value="${reportInfo.createOrganCode}"></c:set>
						</c:otherwise>
					</c:choose>
					<tr  id="report${index}-manage-select">
						<td>分配到:<ehr:org-type-list type="centre" reg="{'dependOn':'report[${index}].approvalOp','dependValue':'3','required':true}" name="report[${index}].superManageOrganCode"  value="${currentSuperManageOrganCode}"/>
						</td>
					</tr>
				</ehr:authorize>
				
				<ehr:authorize ifAnyGranted="0207">
					<tr  id="report${index}-manage-select">
						<td>分配到:
						<ehr:dic-org-list reg="{'dependOn':'report[${index}].approvalOp','dependValue':'3','required':true}"   name="report[${index}].manageOrganCode" value="${manageOrganCode}" isShowOneself="true"/>
						</td>
					</tr>
				</ehr:authorize>
		</table>
	</fieldset>
</c:if>

