<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:100px;width:100px;"/>
			<col style="min-width:200px;width:150px;"/>
	        <col style="min-width:80px;width:100px;"/>
	        <col style="min-width:80px;width:100px;"/>
			<col style="min-width:80px;width:120px;"/>
            <col style="min-width:80px;width:100px;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>类型</th>
				<th>填写单位</th>
				<th>部门</th>
				<th>填写月份</th>
				<th>填写日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="selfcheck" items="${selfchecks}" varStatus="status">
				<tr>
					<td>
						<ehr:tip><c:choose><c:when test="${selfcheck.type == '1'}">法定传染病</c:when><c:otherwise>新生儿产房接种</c:otherwise></c:choose></ehr:tip>							
					</td>
					<td><ehr:tip><ehr:org code="${selfcheck.reportUnitCode}"/></ehr:tip></td>
					<td><ehr:tip><ehr:dic dicmeta="IDM00333" code="${selfcheck.departmentCode}"/><c:if test="${empty selfcheck.departmentCode}">新生儿产房</c:if></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM" value="${selfcheck.reportMonth}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${selfcheck.reportDate}"/></ehr:tip></td>
					<td class="centertd">
						<c:choose>
	                    	<c:when test="${editFlag == '1'}">
								<a href="javascript:void(0)" onclick='javascript:selfFillSearch.addFillDc("edit",${selfcheck.id},${selfcheck.type})' class="person-link-btn">修改&nbsp;</a>                            
							</c:when>	
							<c:otherwise>
								<a href="javascript:void(0)" onclick='javascript:selfFillSearch.addFillDc("view",${selfcheck.id},${selfcheck.type})' class="person-link-btn">查看&nbsp;</a>
							</c:otherwise>												
						</c:choose>	
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="selfFillSearch.searchFill" />
		</tr>
	</table>
</div>