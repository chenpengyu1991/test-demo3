<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.idm.common.MalariaStatus" %>
<div class="repeattable">
	<table>
		<colgroup>
	        <col style="min-width:70px;width:70px;"/>
			<col style="min-width:60px;width:60px;"/>
	        <col style="min-width:50px;width:50px;"/>
			<col style="min-width:120px;width:80px;"/>
			<col style="min-width:80px;width:80px;"/>
			<col style="min-width:180px;width:50%;"/>
			<col style="min-width:120px;width:120px;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>联系电话</th>
				<th>休治对象</th>
				<th>地址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="drugreg" items="${listFg}" varStatus="status">
				<tr id="${drugreg.id}">
					<td><ehr:tip>${drugreg.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${drugreg.gender}" /></ehr:tip></td>
					<td><ehr:tip>${drugreg.age}</ehr:tip></td>
					<td><ehr:tip>${drugreg.phoneNumber}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic dicmeta="IDM00272" code="${drugreg.restObject}" /></ehr:tip></td>
					<td>
						<ehr:tip><ehr:dic dicmeta="FS990001" code="${drugreg.patownShip}"></ehr:dic><ehr:dic dicmeta="FS990001" code="${drugreg.pastreet}"></ehr:dic><c:out value="${drugreg.pahomeNumber}"></c:out></ehr:tip>
					</td>
					<td class="centertd">
                 		<a id="drugRegId" href="javascript:void(0)" onclick="standardSearch.addFg(${drugreg.id})" >
	                 		<c:choose>
	                 			<c:when test="${not empty drugreg.id}">修改</c:when>
	                 			<c:otherwise>新增</c:otherwise>
	                 		</c:choose>
						</a>&nbsp;
                	</td>				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="standardSearch.searchStandard" />
		</tr>
	</table>
</div>