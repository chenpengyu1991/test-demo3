<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/managePlanSearch.js" type="text/javascript"></script>

<div class="postdiv">
		<fieldset style="margin:5px 1px 5px 5px;float:left;width:47%; height:320px;overflow: auto" class="layui-elem-field">
		<legend>计划查看</legend>
			<div class="repeattable">
				<table class="layui-table x-admin-sm-table-list-small">
					<colgroup>
						<col style="width:50px;"/>
						<col style="width:50px;"/>
						<col style="width:50px;"/>
					</colgroup>
					<thead>
						<tr>
							<th>年度</th>
							<th>制定人</th>
							<th>制定日期</th>
						</tr>
					</thead>			
					<tbody>
						<c:forEach var="managePlanInfo" items="${managePlanInfo}">
							<%--<tr id = "managePlanSelect" data-id = "${managePlanInfo.id},${managePlanInfo.year}"  style="cursor:hand">--%>
							<tr onclick="managePlanSearch.getPreFollowUpDetail(${managePlanInfo.id})" style="cursor:hand">
							    <td title="${managePlanInfo.year}年  ">${managePlanInfo.year}年  </td>
								<td title="<ehr:user userCode="${managePlanInfo.createDoctorCode}"></ehr:user>"><ehr:user userCode="${managePlanInfo.createDoctorCode}"></ehr:user></td>
								<td title="<fmt:formatDate value="${managePlanInfo.createDate}" pattern="yyyy/MM/dd"/>"><fmt:formatDate value="${managePlanInfo.createDate}" pattern="yyyy/MM/dd"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</fieldset>
		<div class="postcontent">
	 		<div id="managePlanResult"></div>
		</div>
</div>

