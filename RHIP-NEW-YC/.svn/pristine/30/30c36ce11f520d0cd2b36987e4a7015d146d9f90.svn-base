<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="repeattable">
	<form id="dmPopularceInfo">
		<table>
			<thead>
				<tr>
					<th rowspan="2" style="width: 15%;">镇区名称</th>
					<th colspan="3" style="width: 50%;"><c:out value="${year}"/>年人口数统计情况</th>
				</tr>
				<tr>
				    <th class="zimu">男性人口数</th>	
				    <th class="zimu">女性人口数</th> 
				    <th class="zimu">人口总数</th> 
				</tr>
			</thead>
			<tbody id="displayBody">
				<c:forEach items="${townList}" var="town">
	  				<tr style="text-align: center;">
	  					<td><c:out value="${town.organName}"/></td>
	  					<td><c:out value="${town.manNum}"/></td>
	  					<td><c:out value="${town.womanNum}"/></td>
	  					<td><c:out value="${town.totalNum}"/></td>
	  				</tr>
	  			</c:forEach>
			</tbody>
			<tbody id="editBody" style="display: none;">
				<c:forEach items="${townList}" var="town" varStatus="status">
	  				<tr style="text-align: center;">
	  					<td style="display: none;">
	  						<input type="hidden" name="dmPopulaceInfo[${status.index}].id"          value="${town.id}">
	  						<input type="hidden" name="dmPopulaceInfo[${status.index}].organCode"   value="${town.organCode}">
	  						<input type="hidden" name="dmPopulaceInfo[${status.index}].countYear"   value="${town.countYear}">
	  						<input type="hidden" name="dmPopulaceInfo[${status.index}].organName"   value="${town.organName}">
	  					</td>
	  					<td><c:out value="${town.organName}"/></td>
	  					<td><tag:numberInput maxlength="9" name="dmPopulaceInfo[${status.index}].manNum"   value="${town.manNum}"/></td>
	  					<td><tag:numberInput maxlength="9" name="dmPopulaceInfo[${status.index}].womanNum" value="${town.womanNum}"/></td>
	  					<td><tag:numberInput maxlength="9" name="dmPopulaceInfo[${status.index}].totalNum" value="${town.totalNum}"/></td>
	  				</tr>
	  			</c:forEach>
			</tbody>
		</table>
	</form>
</div>

