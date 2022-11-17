<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable"  style="overflow-x: auto;overflow-y: auto; min-width: 800px; width: 100%; height: 450px;">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 25%;"/>
			<col style="min-width:80px;"/>
            <c:forEach  var="occupationType" items="${occupationTypelist}" varStatus="occupationstatus">
            	<col style="min-width:80px;"/>
            </c:forEach>			
		</colgroup>
		<thead>
			<tr>
                <th>医疗机构</th>
                <th>合计</th>
                <c:forEach  var="occupationType" items="${occupationTypelist}" varStatus="occupationstatus">
                	<th><ehr:dic dicmeta="GBT6565" code="${occupationType.occupation}"/></th>
                </c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="occupation" items="${occupationlist}" varStatus="status">
				<tr>
                    <td>
                    	<c:if test="${occupation.organCode=='total'}"><b>总计</b></c:if>
                    	<c:choose>
                    		<c:when test="${genreCode == '0' }"><ehr:tip><ehr:dic dicmeta="FS990001" code="${occupation.organCode}"/></ehr:tip></c:when>
                    		<c:otherwise><ehr:tip><ehr:org  code="${occupation.organCode}"/></ehr:tip></c:otherwise>
                    	</c:choose>
                    </td>
                    <td><tags:numberLabel value="${occupation['total']}" defaultValue="0" /></td>
	                <c:forEach  var="occupationType" items="${occupationTypelist}" varStatus="occupationstatus">
	                	<td><tags:numberLabel value="${occupation[occupationType.occupation]}" defaultValue="0" /></td>
	                </c:forEach>  
                </tr>
			</c:forEach>
		</tbody>
	</table>
</div>