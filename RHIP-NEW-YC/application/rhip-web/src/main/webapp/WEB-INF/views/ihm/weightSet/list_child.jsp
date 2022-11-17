<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:150px;width: 25%;"/>
	        <col style="min-width:80px;width: 10%;"/>
			<col style="min-width:100px;width: 15%;"/>
	        <col style="min-width:100px;width: 15%;"/>
	        <col style="min-width:80px;width: 10%;"/>
	        <col style="min-width:100px;width: 15%;"/>
			<col style="min-width:80px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>机构</th>
				<th>权重类型</th>
                <th>开始时间</th>
				<th>结束时间</th>
				<th>权重指标</th>
				<th>权重度/百分比(包干型)</th>
				<th>权重值</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="weightSet" items="${weightSetList}" varStatus="status">
				<tr>
                    <td>
                   		<ehr:tip><ehr:org code="${weightSet.organCode}"/></ehr:tip>
                    </td>
                    <td class="centertd"><ehr:tip><ehr:dic dicmeta="FS990011" code="${weightSet.rpType}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${weightSet.rpBeginDate}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${weightSet.rpEndDate}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
					<td><ehr:tip><ehr:dic dicmeta="FS990012" code="${weightSet.weightIndex}"/></ehr:tip></td>
                    <td>
						<c:if test="${weightSet.rpType eq 2}">
                    		${weightSet.weightDatumBegin}~${weightSet.weightDatumEnd}
						</c:if>
					</td>
                    <td><tags:numberLabel value="${weightSet.weightValue}" /></td>
                </tr>
			</c:forEach>
		</tbody>
	</table>
</div>