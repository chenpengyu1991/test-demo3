<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable" style="overflow-x: auto;overflow-y: auto; min-width: 800px; width: 100%; height: 450px;">
	<table class="layui-table x-admin-sm-table-list-middle" >
		<colgroup>
			<col style="min-width:150px;width: 20%;"/>
			<col span="20" style="min-width:60px;width: 4%" />
		</colgroup>
		<thead>
			<tr>
                <th>医疗机构</th>
                <th>合计</th>
				<th>0岁-</th>
				<th>1岁-</th>
				<th>5岁-</th>
				<th>10岁-</th>
				<th>15岁-</th>
				<th>20岁-</th>
				<th>25岁-</th>
				<th>30岁-</th>
				<th>35岁-</th>
				<th>40岁-</th>
				<th>45岁-</th>
				<th>50岁-</th>
				<th>55岁-</th>
				<th>60岁-</th>
				<th>65岁-</th>
				<th>70岁-</th>
				<th>75岁-</th>
				<th>80岁-</th>
				<th>85岁-</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="age" items="${agelist}" varStatus="status">
				<tr>
                    <td>
                    	<c:if test="${empty age.organCode}"><b>总计</b></c:if>
                    	<c:choose>
                    		<c:when test="${genreCode == '0' }"><ehr:tip><ehr:dic dicmeta="FS990001" code="${age.organCode}"/></ehr:tip></c:when>
                    		<c:otherwise><ehr:tip><ehr:org  code="${age.organCode}"/></ehr:tip></c:otherwise>
                    	</c:choose>
                    </td>
					<td><tags:numberLabel value="${age.total}" type="number" defaultValue="0"/> </td>
					<td><tags:numberLabel value="${age.one}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.two}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.three}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.four}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.five}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.six}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.serven}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.eight}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.nine}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.ten}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.eleven}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.twelve}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.thirteen}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.fourteen}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.fifteen}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.sixteen}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.seventeen}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.eighteen}" type="number" defaultValue="0"/></td>
					<td><tags:numberLabel value="${age.nineteen}" type="number" defaultValue="0"/></td>
                </tr>
			</c:forEach>
		</tbody>
	</table>
</div>