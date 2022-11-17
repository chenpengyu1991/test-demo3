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
			<c:forEach var="vaccine" items="${vaccinelist}" varStatus="status">
				<tr>
					<td style="text-align: center">${vaccine.name}</td>
					<td style="text-align: center">${vaccine.idcard}</td>
					<td style="text-align: center">${vaccine.father_name}</td>
					<td style="text-align: center">${vaccine.father_idcard}</td>
					<td style="text-align: center">${vaccine.mother_name}</td>
					<td style="text-align: center">${vaccine.mother_idcard}</td>
					<td style="text-align: center">
						<!-- ${vaccine.id} -->
						<a onclick="vaccineSearch.loadDetailDialog('/ihm/vaccine/${vaccine.id}', '儿童接种疫苗','600','1000')" href="#this" >查看 </a>
					</td>
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