<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width: 200px;" />
			<col style="min-width: 100px;" />
			<col style="min-width: 100px;" />
			<%-- <col style="min-width: 100px;" /> --%>
		</colgroup>
		<thead>
			<tr>
				<%-- <c:choose>
                	<c:when test="${genreCode == '0' }">
                		<th rowspan="2">镇</th>
                	</c:when>
                	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                		<th colspan="2">医疗机构</th>
                	</c:when>
                    <c:otherwise>
                    	<th rowspan="2">医疗机构</th>
                    </c:otherwise>
                    <th>医疗机构</th>
                </c:choose> --%>
                <th>医疗机构</th>
                <th>个案退回率（%）</th>
                <th>个案合格率（%）</th>
               </tr>
               <%-- <tr>
				<c:choose>
                	<c:when test="${genreCode == '0' || genreCode eq null || genreCode == STATION}">
                	</c:when>
                	<c:when test="${genreCode == HOSPITAL}">
                		<th>镇</th>
                		<th>医院</th>
                	</c:when>
					<c:when test="${genreCode == CENTRE}">
                		<th>镇</th>
                		<th>卫生院</th>
                	</c:when>                	
                    <c:otherwise>
                    	<th>镇</th>
                		<th>卫生机构</th>
                    </c:otherwise>
                </c:choose>	
             </tr> --%>
		</thead>
		<tbody>
			<c:forEach var="result" items="${results}">
				<tr>
              		<td><ehr:tip><ehr:org code="${result.organ_code}"/></ehr:tip></td>
					<td><tags:numberLabel fractionDigits="2" type="percent" value="${result.lowToRate}" defaultValue="0" /></td>
					<td><tags:numberLabel fractionDigits="2" type="percent" value="${result.upToRate}" defaultValue="0" /></td>
					<%-- <td><fmt:formatNumber pattern="#0.00%" type="percent" value="${empty result.examRate ? 0 : result.examRate}"></fmt:formatNumber></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>