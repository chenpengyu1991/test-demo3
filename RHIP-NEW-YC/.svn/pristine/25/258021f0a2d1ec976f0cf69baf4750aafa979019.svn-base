<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

	<div class="repeattable" style="margin-top: 20px; margin-left: 5px; margin-right: 5px;">
        <div>医生用量排名：</div>
		<table class="layui-table x-admin-sm-table-list-middle">
		<thead>
			<tr>
				<th>医生姓名</th>
				<th>使用数量</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${results}" var="result">
			<tr>
				<td align="center">${result.NAME}</td>
				<td align="center">${result.ALLNUM}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
