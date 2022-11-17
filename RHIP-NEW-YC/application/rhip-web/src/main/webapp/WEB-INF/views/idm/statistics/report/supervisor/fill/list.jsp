<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:1200px;width:200px;"/>
	        <col style="min-width:80px;width:100px;"/>
			<col style="min-width:80px;width:120px;"/>
            <col style="min-width:80px;width:150px;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>填写单位</th>
				<th>填写月份</th>
				<th>填写日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="supervisor" items="${supervisors}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org code="${supervisor.reportUnitCode}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM" value="${supervisor.reportMonth}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${supervisor.reportDate}"/></ehr:tip></td>
					<td class="centertd">
						<c:choose>
	                    	<c:when test="${editFlag == '1'}">
								<a href="javascript:void(0)" onclick='javascript:fillSearch.addFill("edit",${supervisor.id})' class="person-link-btn">修改&nbsp;</a>                            
							</c:when>	
							<c:otherwise>
								<a href="javascript:void(0)" onclick='javascript:fillSearch.addFill("view",${supervisor.id})' class="person-link-btn">查看&nbsp;</a>
							</c:otherwise>												
						</c:choose>	
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="fillSearch.searchFill" />
		</tr>
	</table>
</div>