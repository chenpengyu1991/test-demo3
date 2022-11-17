<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/followUpConclusionSearch.js" type="text/javascript"></script>

<div class="postdiv">
	<fieldset style="margin-top:2px;margin-left:5px;float:left;width:35.5%; height:324px;overflow: auto" class="layui-elem-field">
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
						<th>医生名称</th>
						<th>建卡日期</th>
					</tr>
				</thead>			
				<tbody>
					<c:forEach var="ConclusionInfo" items="${ConclusionInfo}">
						<tr onclick="followUp_main.selectConclusion(${ConclusionInfo.id})" style="cursor:hand">
							<td title="${ConclusionInfo.year}年 管理评定">${ConclusionInfo.year}年 </td>
							<td title="<ehr:user userCode='${ConclusionInfo.doctorCode}' />"><ehr:user userCode='${ConclusionInfo.doctorCode}' /></td>
							<td title="<fmt:formatDate value="${ConclusionInfo.manageEndData}" pattern="yyyy/MM/dd"/>"><fmt:formatDate value="${ConclusionInfo.manageEndData}" pattern="yyyy/MM/dd"/></td>		
						</tr>
					</c:forEach>
				</tbody>
			</table>
	   </div>
	</fieldset>
	<div class="postcontent">
		<div id="followUpConclusionResult"></div>
  	</div>
</div>  