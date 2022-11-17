<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${approvalFlag eq 3}">
	<fieldset>
		<legend>
			<ehr:authorize ifAnyGranted="02">管理</ehr:authorize>
			<ehr:authorize ifAnyGranted="03,11">分配</ehr:authorize>
		</legend>
		<table class="posttable app-op-box" data-target="report${index}-manage-select" >
			<tr>
				<td>
				<input title="不对当前报卡进行处理" value="1" checked="checked" type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" />不处理当前报卡
				<br />
				<ehr:authorize ifAnyGranted="02">
							<input value="3"  type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 不纳入管理
							<input value="2"  type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 退回 
				</ehr:authorize>
				<ehr:authorize ifAnyGranted="03">
					<input value="3"  type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 分配
					<input value="2"  type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 退回 
		
				</ehr:authorize>
				<ehr:authorize ifAnyGranted="11">
										<input value="3"  type="radio" name="report[${index}].approvalOp" data-target="report${index}-manage-select" /> 分配
				</ehr:authorize>

				备注<input type="text"  name="report[${index}].comments" reg="{'maxlength':33}" />
				
			</tr>
					<ehr:authorize ifAnyGranted="11">
					<tr class="hide" id="report${index}-manage-select">
						<td>分配到:<ehr:org-type-list code="320002922,320002930,320002981,320002994,320003006,320003020,320003021,320003041,320003049,320003061,320003080,320003134,320003136,320003160,320003169,320003177,320003178,320003180,320003190,320003191,320003228,320003234,320003247,320003263,320003265,320003282,320003295,320003300,320003303,320003353,320003364,320003394,32000_," reg="{'dependOn':'report[${index}].approvalOp','dependValue':'3','required':true}" name="report[${index}].superManageOrganCode"  value="${ reportInfo.createOrganCode}"/>
						</td>
					</tr>
				</ehr:authorize>
				
				<ehr:authorize ifAnyGranted="03">
					<tr class="hide" id="report${index}-manage-select">
						<td>分配到:
						<ehr:dic-org-list    name="report[${index}].manageOrganCode"   ></ehr:dic-org-list>
						</td>
					</tr>
				</ehr:authorize>
		</table>
	</fieldset>
</c:if>

