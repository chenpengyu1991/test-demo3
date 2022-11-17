<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%--<div id="diseaseControlDiv" style="height: 535px;overflow: auto"></div>--%>

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:80px;"/>
			<col style="width:65px;"/>
			<col style="width:65px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col/>
			<col/>
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2" class="centerth">随访日期</th>
				<th rowspan="1" colspan="3" class="centerth">临床表现</th>
				<th rowspan="2" class="centerth">病情进展</th>
				<th rowspan="2" class="centerth">病情加重后转诊医疗机构</th>
				<th rowspan="2" class="centerth">备注<br>（填写病情加重的症状和体征）</th>
			</tr>
			<tr>
				<th  class="centerth">体温（℃）</th>
				<th class="centerth">皮疹</th>
				<th class="centerth">其他症状体征</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="follow" items="${follows}" varStatus="status">
			<tr>
				<td field="visitDt"><ehr:tip><fmt:formatDate value="${follow.visitDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>
				<td field="temperature"><ehr:tip>${follow.temperature}</ehr:tip></td>
				<td field="rashStr"><ehr:tip><ehr:dic dicmeta="IDM00377" code="${follow.rash}"></ehr:dic></ehr:tip></td>
				<td field="otherSymptom"><ehr:tip>${follow.otherSymptom}</ehr:tip></td>
				<td field="diseaseProgressStr"><ehr:tip><ehr:dic dicmeta="IDM00378" code="${follow.diseaseProgress}"></ehr:dic></ehr:tip></td>
				<td field="transferUnit"><ehr:tip>${follow.transferUnit}</ehr:tip></td>
				<td field="comments"><ehr:tip>${follow.comments}</ehr:tip></td>
				<td field="rash" style="display: none">${follow.rash}</td>
				<td field="diseaseProgress" style="display: none">${follow.diseaseProgress}</td>
				</td></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<table>
		<tr>
			<ehr:pagination action="brwControl.search" />
		</tr>
	</table>
</div>