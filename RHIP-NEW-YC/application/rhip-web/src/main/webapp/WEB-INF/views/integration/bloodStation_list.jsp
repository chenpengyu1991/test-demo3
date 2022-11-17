<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div class="repeattable">
    <div id="bloodStationTopDiv">
    <table id="bloodStationTable">
    	<colgroup>
			<col style="width:15%;"/>
	        <col style="width:15%;"/>
	        <col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2" style="width: 110px;">医院名称</th>
				<th rowspan="2" style="width: 110px;">项目名称</th>
				<c:forEach items="${dateList}" var="d">
					<th colspan="2"><fmt:formatDate value="${d}" pattern="MM月dd日"/></th>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach items="${dateList}" var="d">
					<th>应传数量</th>
					<th>实际数量</th>
				</c:forEach>
			</tr>
		</thead>
    </table>
    <div id="bloodStationDiv" class="contentfixed149">
    <table>
    	<colgroup>
			<col style="width:15%;"/>
	        <col style="width:15%;"/>
	        <col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:5%;"/>
		</colgroup>
		<tbody>
		<c:forEach items="${hmMonitorList}" var="monitor">
			 <c:if test="${fn:contains(projectNameList, 'bs01')}">
                 <tr>
                     <c:if test="${fn:contains(projectNameList, 'bs01')}">
                     <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
                     </c:if>
                     <td style="text-align: left">献血记录</td>
                     <c:forEach items="${monitor.monitors}" var="m">
                         <td style="text-align: left" >${m.shouldOutpatientCount}</td>
						 <td style="text-align: left" >${m.actualOutpatientCount}</td>
                     </c:forEach>
                 </tr>
             </c:if>
             <c:if test="${fn:contains(projectNameList, 'bs02')}">
                 <tr>
                    <c:if test="${!fn:contains(projectNameList, 'bs01')}">
                     <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
                     </c:if>
                     <td style="text-align: left">免费用血</td>
                     <c:forEach items="${monitor.monitors}" var="m">
                         <td style="text-align: left" >${m.shouldInpatientCount}</td>
						 <td style="text-align: left" >${m.actualInpatientCount}</td>
                     </c:forEach>
                 </tr>
             </c:if>
             <c:if test="${fn:contains(projectNameList, 'bs03')}">
                 <tr>
                     <c:if test="${!fn:contains(projectNameList, 'bs01') && !fn:contains(projectNameList, 'bs02')}">
                     <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
                     </c:if>
                     <td style="text-align: left">血液库存</td>
                     <c:forEach items="${monitor.monitors}" var="m">
                         <td style="text-align: left" >${m.shouldDiseaseDiagnosisCount}</td>
						 <td style="text-align: left" >${m.actualDiseaseDiagnosisCount}</td>
                     </c:forEach>
                 </tr>
             </c:if>
             <c:if test="${fn:contains(projectNameList, 'bs04')}">
                 <tr>
                     <c:if test="${!fn:contains(projectNameList, 'bs01') && !fn:contains(projectNameList, 'bs02') && !fn:contains(projectNameList, 'bs03')}">
                     <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
                     </c:if>
                     <td style="text-align: left">血液出库</td>
                     <c:forEach items="${monitor.monitors}" var="m">
                         <td style="text-align: left" >${m.shouldOutpatientPrescriptionCount}</td>
						 <td style="text-align: left" >${m.actualOutpatientPrescriptionCount}</td>
                     </c:forEach>
                 </tr>
             </c:if>
        </c:forEach>
		</tbody>
	</table>
    </div>
    </div>
</div>
