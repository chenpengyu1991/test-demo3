<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col />
			<col />
			<col />
			<col />
			<col style="width: 150px" />
		</colgroup>
		<thead>
			<tr>
				<th style="text-align: center">序号</th>
				<th style="text-align: center">年份</th>
				<th style="text-align: center">类型</th>
				<th style="text-align: center">名称</th>
				<c:if test="${type != 'onlyView'}">
					<th style="text-align: center">操作</th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sr" items="${srList}">
				<tr>
					<td style="text-align: center">${sr.serialNumber}</td>
					<td style="text-align: center">${sr.year}</td>
					<td style="text-align: center">
						<c:if test="${sr.srType == 1}">科技项目</c:if>
						<c:if test="${sr.srType == 2}">科研成果</c:if> 
						<c:if test="${sr.srType == 3}">论文期刊</c:if> 
						<c:if test="${sr.srType == 4}">论著</c:if> 
						<c:if test="${sr.srType == 5}">专利发明</c:if>
					</td>
					<td style="text-align: center">
						<c:if test="${sr.srType == 1}">${sr.projectName}</c:if>
						<c:if test="${sr.srType == 2}">${sr.projectName}</c:if> 
						<c:if test="${sr.srType == 3}">${sr.periodicalName}</c:if> 
						<c:if test="${sr.srType == 4}">${sr.title}</c:if> 
						<c:if test="${sr.srType == 5}">${sr.patentName}</c:if>
					</td>
					<td style="text-align: center">
						<a href="javascript:void(0)" id="sr${sr.id}" data-id="${sr.id}">查看</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="srSearch.search" colspan="5"/>
			</tr>
		</tbody>
	</table>
	<%-- <ehr:paging /> --%>
</div>
