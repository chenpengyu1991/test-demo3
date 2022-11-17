<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:150px;width: 15%;"/>
			<col style="min-width:150px;width: 15%;"/>
			<col style="min-width:150px;width: 15%;"/>
			<col style="min-width:150px;width: 15%;"/>
			<col style="min-width:150px;width: 15%;"/>
			<col style="min-width:150px;width: 15%;"/>
			<col style="min-width:80px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号码</th>
				<th>父亲姓名</th>
				<th>父亲身份证号码</th>
				<th>母亲姓名</th>
				<th>母亲身份证号码</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="taboo" items="${taboolist}" varStatus="status">
				<tr>
					<td style="text-align: center">${taboo.name}</td>
					<td style="text-align: center">${taboo.idcard}</td>
					<td style="text-align: center">${taboo.father_name}</td>
					<td style="text-align: center">${taboo.father_idcard}</td>
					<td style="text-align: center">${taboo.mother_name}</td>
					<td style="text-align: center">${taboo.mother_idcard}</td>
					<td style="text-align: center">${taboo.id}</td>
				</tr>
			</c:forEach>
		</tbody>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="vaccineSearch.vaccineSearch"/>
		</tr>
	</table>
</div>