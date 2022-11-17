<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/grjlda/grjlhjkjhda/grjljcjgList.js" type="text/javascript"></script>
<div>
	<div class="repeattable">
		<table id="personalDose_record_table">
			<colgroup>
				<col style="width:4%;"/>
				<col style="width:20%;"/>
				<col style="width:16%;"/>
				<col style="width:12%;"/>
				<col style="width:12%;"/>
				<col style="width:12%;"/>
				<col style="width:12%;"/>
				<col style="width:12%;"/>
			</colgroup>
			<thead>
				<tr>
					<th style="text-align: center;">序号</th>
					<th style="text-align: center;">检测时间</th>
					<th style="text-align: center;">检测结果(mSv)</th>
					<th style="text-align: center;">录入时间</th>
					<th style="text-align: center;">录入人</th>
					<th style="text-align: center;">确认时间</th>
					<th style="text-align: center;">确认人</th>
					<th style="text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody class="tbody">
				<c:forEach items="${infoRecords}" var="record" varStatus="status">
					<tr>
						<td style="text-align: center"><ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number></td>
						<td title="${record.detectionQuarter }" style="text-align: center;">${record.detectionQuarter }</td>
						<td title="${record.detectionResult }" style="text-align: center">${record.detectionResult }</td>
						<td title="${record.inputTime }" style="text-align: center">
						    <c:choose>
						        <c:when test="${not empty record.inputTime}">
						            <fmt:formatDate value="${record.inputTime}" pattern="yyyy/MM/dd"/>
						        </c:when>
						        <c:otherwise>不详</c:otherwise>
						    </c:choose>
						</td>
						<td title="${record.inputPerson }" style="text-align: center">${record.inputPerson }</td>
						<td title="${record.confirmTime }" style="text-align: center">
                            <c:choose>
						        <c:when test="${not empty record.confirmTime}">
						            <fmt:formatDate value="${record.confirmTime}" pattern="yyyy/MM/dd"/>
						        </c:when>
						        <c:otherwise>不详</c:otherwise>
						    </c:choose>
                        </td>
						<td title="${record.confirmPerson }" style="text-align: center">${record.confirmPerson }</td>
						<td style="text-align: center">
						    <a class="grjljcjgListModify" href="#this" onclick="grjljcjgList.updateDoseDetectionRecord('${record.id}')">修改</a> 
						    <a class="grjljcjgListDelete" href="#this" onclick="grjljcjgList.deleteDoseDetectionRecord('${record.id}')">删除</a>
						</td>
					<tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="grjlhjkjhda.searchDoseDetection" colspan="14" />
		</table>
	</div>
</div>
