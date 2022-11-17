<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="repeattable">
    <table id="person_record_table">
        <colgroup>
            <col style="width: 10%"/>
            <col style="width: 8%"/>
            <col style="width: 8%"/>
            <col style="width: 12%"/>
            <col style="width: 8%"/>
            <col style="width: 8%"/>
            <col style="width: 8%"/>
			<col style="width: 12%"/>
		</colgroup>
        <thead>
			<tr>
				<th>用户编码</th>
				<th>用户名</th>
				<th>血氧</th>
				<th>血氧级别</th>
				<th>体温</th>
				<th>体温级别</th>
				<th>心率</th>
				<th>心率级别</th>
				<th>检测日期</th>
				<th>入库时间</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach var="result" items="${results}">
				<tr>
					<td title="${result.userId}">${result.userId}</td>
					<td title="${result.userName}">${result.userName}</td>
					<td title="${result.oxygen}">${result.oxygen}</td>
					<td title="${result.oxygenLevelName}"
						<c:choose>
						<c:when test="${result.oxygenLevelName eq '正常'}">bgcolor="#7fffd4"</c:when>
						<c:when test="${result.oxygenLevelName eq '轻度缺氧'}">bgcolor="#ffe4c4"</c:when>
							<c:when test="${result.oxygenLevelName eq ''}"></c:when>
							<c:otherwise>bgcolor="red"</c:otherwise>
						</c:choose>
							>
					${result.oxygenLevelName}
					</td>
					<td title="${result.bodyTemperature}">${result.bodyTemperature}</td>
					<td title="${result.bodyTempLevelName}"
							<c:choose>
								<c:when test="${result.bodyTempLevelName eq '正常'}">bgcolor="#7fffd4"</c:when>
								<c:when test="${result.bodyTempLevelName eq '轻度缺氧'}">bgcolor="#ffe4c4"</c:when>
								<c:when test="${result.bodyTempLevelName eq ''}"></c:when>
								<c:otherwise>bgcolor="red"</c:otherwise>
							</c:choose>
							>${result.bodyTempLevelName}</td>
					<td title="${result.heartRate}">${result.heartRate}</td>
					<td title="${result.heartRateLevelName}"
							<c:choose>
								<c:when test="${result.heartRateLevelName eq '正常'}">bgcolor="#7fffd4"</c:when>
								<c:when test="${result.heartRateLevelName eq '心动过缓'}">bgcolor="#ffe4c4"</c:when>
								<c:when test="${result.heartRateLevelName eq ''}"></c:when>
								<c:otherwise>bgcolor="red"</c:otherwise>
							</c:choose>
							>${result.heartRateLevelName}</td>
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

