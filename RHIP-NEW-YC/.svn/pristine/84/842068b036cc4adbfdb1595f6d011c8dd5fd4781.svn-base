<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<table id="reportCard_table">
		<colgroup>
			<col style=" width: 9%;" />
			<col style="width: 8%" />
			<col style="width: 18%" />
			<col style="width: 10%" />
			<col style="width: 10%" />
			<col style="width: 13%" />
			<col style="width: 11%" />
			<c:if test="${reportFlag!=2}">
				<col style="width: 6%" />
			</c:if>
		</colgroup>
			
		<thead> 
			<tr>
					<th >姓名</th>
					<th >性别</th> 
					<th>身份证号</th>
					<th>年龄</th>
					<th >上报机构</th>
					<th >上报时间</th>
					<th >报卡状态</th>
					<c:if test="${reportFlag!=2}">
						<th>操作</th>
					</c:if>
					
			</tr>
		</thead>
		<tbody class="tbody">
		<c:forEach var="reportInfo" items="${reportInfoList}">
			<tr>
				<td>  <a title="点击查看 ${reportInfo.name} 的报卡详细信息" class="report-link" href="javascript:void(0)" data-id="${reportInfo.id}">${reportInfo.name}</a></td>
				<td><ehr:tip> <ehr:dic dicmeta="GBT226112003" code="${reportInfo.gender}" /> </ehr:tip> </td>
				<td><ehr:tip>${reportInfo.idcard}</ehr:tip></td>
				<td><ehr:tip>${reportInfo.age}</ehr:tip></td>
				<td><ehr:tip>${reportInfo.createOrganName}</ehr:tip></td>
				<td><ehr:tip> <fmt:formatDate value="${reportInfo.createDate}" pattern="yyyy/MM/dd" /> </ehr:tip></td>
				<td><ehr:tip> <ehr:dic dicmeta="DMD00005" code="${reportInfo.status}"  /> </ehr:tip></td>
				<c:if test="${reportFlag!=2}">
					<td><a title="审核报卡" class="app-report-link"  href="javascript:void(0)" data-id="${reportInfo.id}">审核</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
	<c:if test="${reportFlag==2}">
		<ehr:pagination action="ismReportCardList.search" colspan="7"/>
	</c:if>
	<c:if test="${reportFlag==3}">
		<ehr:pagination action="ismReportCardList.search" colspan="8"/>
	</c:if>
</table>
