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
			<c:forEach var="sideEffect" items="${sideEffectlist}" varStatus="status">
				<tr>
					<td style="text-align: center">${sideEffect.name}</td>
					<td style="text-align: center">${sideEffect.idcard}</td>
					<td style="text-align: center">${sideEffect.father_name}</td>
					<td style="text-align: center">${sideEffect.father_idcard}</td>
					<td style="text-align: center">${sideEffect.mother_name}</td>
					<td style="text-align: center">${sideEffect.mother_idcard}</td>
					<td style="text-align: center">${sideEffect.id}</td>
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