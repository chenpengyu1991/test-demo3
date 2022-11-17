<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:150px;width: 30%;"/>
	        <col style="min-width:100px;width: 15%;"/>
			<col style="min-width:80px;width: 10%;"/>
	        <col style="min-width:150px;width: 20%;"/>
	        <col style="min-width:80px;width: 10%;"/>
			<col style="min-width:100px;width: 15%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>机构</th>
				<th>医护人员姓名</th>
                <th>权重类型</th>
				<th>权重指标名称</th>
				<th>权重分值</th>
				<th>权重得分</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="every" items="${result}" varStatus="status">
				<tr>
                    <td>
                   		<ehr:tip><ehr:org code="${every.organCode}"/></ehr:tip>
                    </td>
                    <td>
						<ehr:tip>${every.doctorName}</ehr:tip>
					</td>
					<td class="centertd">
						<ehr:tip><ehr:dic dicmeta="FS990011" code="${every.rpType}"/></ehr:tip>
					</td>
					<td>
						<ehr:tip><ehr:dic dicmeta="FS990012" code="${every.weightIndex}"/></ehr:tip>
					</td>
                    <td class="centertd">
						<c:choose>
							<c:when test="${every.rpType eq '1'}">
								<tags:numberLabel value="${every.weightValue}" />
							</c:when>
							<c:otherwise>
								详见设置
							</c:otherwise>
						</c:choose>
					</td>
					<td><tags:numberLabel value="${every.totalScore}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>