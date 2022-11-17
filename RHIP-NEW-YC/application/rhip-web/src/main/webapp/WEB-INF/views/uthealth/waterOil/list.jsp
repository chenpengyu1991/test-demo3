<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<div class="repeattable">
    <table id="person_record_table">
        <colgroup>
            <col style="width: 10%"/>
            <col style="width: 8%"/>
            <col style="width: 8%"/>
            <col style="width: 10%"/>
            <col style="width: 8%"/>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
			<col style="width: 13%"/>
			<col style="width: 13%"/>
        </colgroup>
        <thead>
			<tr>
				<th>用户编码</th>
				<th>用户名</th>
				<th>水分百分比</th>
				<th>水分范围值</th>
				<th>油分百分比</th>
				<th>油分范围值</th>
				<th>测量部位</th>
				<th>检测日期</th>
				<th>入库时间</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach var="result" items="${results}">
				<tr>
					<td title="${result.userId}">${result.userId}</td>
					<td title="${result.userName}">${result.userName}</td>
					<td title="${result.waterPercent}">
						<tags:numberLabel value="${result.waterPercent}" fractionDigits="2" defaultValue="0" />
					</td>
					<td title="${result.waterLevel}">${result.waterLevel}</td>
					<td title="${result.oilPercent}">
						<tags:numberLabel value="${result.oilPercent}" fractionDigits="2" defaultValue="0" />
					</td>
					<td title="${result.oilLevel}">${result.oilLevel}</td>
					<td title="${result.bodyPart}">${result.bodyPart}</td>
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

