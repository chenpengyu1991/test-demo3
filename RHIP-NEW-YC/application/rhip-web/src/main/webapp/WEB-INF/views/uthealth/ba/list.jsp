<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<div class="repeattable">
    <table id="person_record_table">
        <colgroup>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 15%"/>
			<col style="width: 15%"/>
        </colgroup>
        <thead>
			<tr>
				<th>用户编码</th>
				<th>用户名</th>
				<th>体脂率</th>
				<th>BMI</th>
				<th>基础代谢率</th>
				<th>身体水分率</th>
				<th>检测日期</th>
				<th>入库时间</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach var="result" items="${results}">
				<tr>
					<td title="${result.userId}">${result.userId}</td>
					<td title="${result.userName}">${result.userName}</td>
					<td title="${result.fat}"><tags:numberLabel value="${result.fat}" fractionDigits="2" defaultValue="0" /></td>
					<td title="${result.bmi}"><tags:numberLabel value="${result.bmi}" fractionDigits="2" defaultValue="0" /></td>
					<td title="${result.bmr}"><tags:numberLabel value="${result.bmr}" fractionDigits="2" defaultValue="0" /></td>
					<td title="${result.bodyWater}"><tags:numberLabel value="${result.bodyWater}" fractionDigits="2" defaultValue="0" /></td>
					<td title="${result.checkDate}">${result.checkDate}</td>
					<td>
						<ehr:tip>${fn:substring(result.create_at,0,10)}</ehr:tip>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ehr:paging />
</div>

