<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="repeattable">
	<table id="person_record_table">
        <colgroup>
        	<col style="width:5%;"/>
            <col style="width:8%;"/>
            <col style="width:15%;"/>
            <col style="width:8%;"/>
            <%-- <col style="width:15%;"/> --%>
            <col style="width:13%;"/>
            <col style="width:12%;"/>
            <col style="width:8%;">
          <col style="width:8%;"/>
            <col style="width:30%;">
        </colgroup>
			<thead> 
				<tr>
                    <th>序号</th>
					<th>患者姓名</th>
					<th>机构</th> 
					<th>编号名称</th> 
					<!-- <th>流程类型</th> -->
					<th>活动号</th>
					<th>出错原因</th>					
					<th>集成日期</th>
					<th>记录人姓名</th>
					<th>CDA文档名称/表名</th>
				</tr>
			</thead>
			<tbody class="tbody">
				<c:forEach items="${integrationLogs}" var="integrationLog" varStatus="status">
					<tr>
					    <td style="text-align:center">
					        <ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number>					    </td>
						<td title="${integrationLog.clinicPeopleName}" style="text-align:left" >${integrationLog.clinicPeopleName}</td>
						<td title="<ehr:org code="${integrationLog.organCode}"></ehr:org>" style="text-align:center">
							<ehr:org code="${integrationLog.organCode}"/></td>
						<td title="<ehr:dic code="${integrationLog.numberCode}" dicmeta="JC00001"/>" style="text-align:center"><ehr:dic code="${integrationLog.numberCode}" dicmeta="JC00001"/></td>
						<%-- <td title="${integrationLog.flowType}" style="text-align:center">${integrationLog.flowType}</td> --%>
						<td title="${integrationLog.ehrId}" style="text-align:center">${integrationLog.ehrId}</td>
						<td title="${integrationLog.errorReason}" style="text-align:center">${integrationLog.errorReason}</td>
						<td title="${integrationLog.recordDate}" style="text-align:center"><fmt:formatDate value="${integrationLog.recordDate}" pattern="yyyy/MM/dd"/></td>
						<td title="${integrationLog.recordName}" style="text-align:center">${integrationLog.recordName}</td>
						<td title="${integrationLog.fileName}" style="text-align:center">${integrationLog.fileName}</td>
					</tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="integrationLog.search" colspan="9"/>
		<!-- 实现分页功能 -->
	</table>
</div>
