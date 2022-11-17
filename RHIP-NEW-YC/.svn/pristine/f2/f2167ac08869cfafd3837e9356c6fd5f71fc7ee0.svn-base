<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<body>
	<div class="report_box contentDialog">
		<c:set var="examEvent" value="${examReport.examineEvent}" scope="request">
		</c:set>
		<div>
			<div align="right">
				<fmt:formatDate value="${examEvent.checkDate}" pattern="yyyy/MM/dd" />
			</div>
			<h3 align="center">
				<c:out value="${examEvent.checkListTitle}"></c:out>
			</h3>
			<div align="right">
				No:
				<c:out value="${examEvent.recordNumber}"></c:out>
			</div>
		</div>
		<table class="layout_table">
			<tr>
				<td style="width: 60">姓名</td>
				<td style="width: 120" ><c:out value="${examEvent.name}"></c:out></td>
				<td style="width: 60">性别</td>
				<td style="width: 120" ><ehr:dic dicmeta="GBT226112003" code="${examEvent.gender}" /></td>
				<td style="width: 80">年龄</td>
				<td><c:out value="${examEvent.age}"></c:out></td>
			</tr>
			<tr>
				<td>科室</td>
				<td><c:out value="${examEvent.applyRoomName}"></c:out></td>
				<td>医生</td>
				<td><c:out value="${examEvent.applyPeopleName}"></c:out></td>
				<td>样本类型</td>
				<td><c:out value="${examEvent.sampleTypeName}"></c:out></td>
			</tr>
			<tr>
				<td colspan="6">
					<hr />
				</td>
			</tr>
			<tr>
				<td style="vertical-align: top; height: 220px; overflow: auto" colspan="6">
					<table class="repeattable">
						<thead>
							<tr>
								<th>日期</th>
								<th>项目</th>
								<th>结果</th>
								<th>参考范围</th>
								<th>单位</th>
								<th>提示</th>
								<th>机构</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${examReport.examineDetails}" var="examineDetail">
								<tr>
									<td><fmt:formatDate value="${examineDetail.checkDate}" pattern="yyyy/MM/dd" /></td>
									<td><ehr:tip>${examineDetail.inspectionItemName}</ehr:tip></td>
									<td><c:out value="${examineDetail.inspectionResult}"></c:out></td>
									<td><c:out value="${examineDetail.referenceRange}"></c:out></td>
									<td><c:out value="${examineDetail.inspectionUnit}"></c:out></td>
									<td>
                                        <c:choose>
                                            <c:when test="${examineDetail.prompt eq '0'}">
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${examineDetail.prompt}"></c:out>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
									<td><tags:textWithTip value="${examineDetail.detectionOrgName}"></tags:textWithTip></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
					
					</td>
			</tr>
			<tr>
				<td colspan="6">
					<hr />
				</td>
			</tr>
			<tr>
				<td>检验医生</td>
				<td colspan="3"><c:out value="${examEvent.checkPeopleName}"></c:out></td>
				<td>审核者</td>
				<td><c:out value="${examEvent.auditName}"></c:out></td>

			</tr>
			<%--<tr>
				<td colspan="4"></td>
				<td>审核时间</td>
				<td><fmt:formatDate value="${examEvent.auditDate}" pattern="yyyy/MM/dd HH:mm:ss" /></td>

			</tr>--%>
		</table>
		<div>声明:本报告仅针对所接受样本负责</div>

	</div>