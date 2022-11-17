<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
	<table>
		<colgroup>
			<col/>
			<col/>
			<col/>
			<col/>
			<col/>
			<col/>
			<col/>
			<col style="width: 100px"/>
		</colgroup>
		<thead>
		<tr>
			<th>医护人员</th>
			<th>登记年份</th>
			<th>项目名称</th>
			<th>举办单位</th>
			<th>学时数</th>
			<th>一类学分</th>
			<th>二类学分</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${dtoList}">
				<tr>
					<c:set var="ceSize" value="${fn:length(dto.ceList)}"></c:set>
					<td style="text-align: center"  rowspan="${ceSize}" >
						<ehr:staff-name staffCode="${dto.staffCode}" />
					</td>
					<c:forEach var="ce" end="0" items="${dto.ceList}">
						<td style="text-align: center">${ce.recordYear}</td>
						<td style="text-align: center">${ce.projectName}</td>
						<td style="text-align: center">${ce.organizer}</td>
						<td style="text-align: center">${ce.period}</td>
						<td style="text-align: center">${ce.creditA}</td>
						<td style="text-align: center">${ce.creditB}</td>
					</c:forEach>
					<td style="text-align: center" rowspan="${ceSize}" >
						<a href="javascript:void(0)" onclick="ceSearch.viewByStaff('${dto.staffCode}')">查看</a>
						<a href="javascript:void(0)" onclick="ceSearch.edit('${dto.staffCode}')">修改</a>
					</td>
				</tr>
				<c:forEach var="ce" begin="1" items="${dto.ceList}">
					<tr>
						<td style="text-align: center">${ce.recordYear}</td>
						<td style="text-align: center">${ce.projectName}</td>
						<td style="text-align: center">${ce.organizer}</td>
						<td style="text-align: center">${ce.period}</td>
						<td style="text-align: center">${ce.creditA}</td>
						<td style="text-align: center">${ce.creditB}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="ceSearch.search"/>
		</tr>
	</table>
</div>
