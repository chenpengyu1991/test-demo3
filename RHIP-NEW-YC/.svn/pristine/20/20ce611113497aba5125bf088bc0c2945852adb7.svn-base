<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
    <table id="person_record_table">
		<thead> 
			<tr>
				<th style="width: 10%">编号</th>
				<th style="width: 40%">角色</th>
				<th style="width: 40%">描述</th>
			</tr>
		</thead>
		<tbody> 
			<c:forEach var="role" items="${roles}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<%-- <td><a href="#this" onclick="javascript:detail(${role.id })">${role.name}</a></td> --%>
					<td>${role.name}</td>
					<td>${role.description}</td>
				</tr>
			</c:forEach> 

		</tbody> 
	</table>
    <ehr:paging/>
</div>
