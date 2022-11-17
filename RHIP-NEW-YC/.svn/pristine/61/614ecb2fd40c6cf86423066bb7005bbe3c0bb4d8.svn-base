<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="repeattable">
    <table id="person_record_table">
        <colgroup>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
			<col style="width: 20%"/>
			<col style="width: 20%"/>
        </colgroup>
        <thead>
			<tr>
				<th>用户编码</th>
				<th>用户名</th>
				<th>测量类型</th>
				<th>测量级别</th>
				<th>检测日期</th>
				<th>入库时间</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach var="result" items="${results}">
				<tr>
					<td title="${result.userId}">${result.userId}</td>
					<td title="${result.userName}">${result.userName}</td>
					<td title="${result.testType}">${result.testType}</td>
					<td title="${result.level}"
							<c:choose>
								<c:when test="${result.level eq '正常'}">bgcolor="#7fffd4"</c:when>
								<c:when test="${result.level eq '轻度'}">bgcolor="aqua"</c:when>
								<c:when test="${result.level eq '中度'}">bgcolor="yellow"</c:when>
								<c:when test="${result.level eq '重度'}">bgcolor="red"</c:when>
								<c:when test="${result.level eq '紧张'}">bgcolor="#32ffd"</c:when>
								<c:when test="${result.level eq '焦虑'}">bgcolor="#934fd"</c:when>
								<c:when test="${result.level eq '抑郁'}">bgcolor="#233fd"</c:when>
								<c:when test="${result.level eq '好'}">bgcolor="#745fd"</c:when>
								<c:when test="${result.level eq '下降'}">bgcolor="#987fd"</c:when>
								<c:when test="${result.level eq ''}"></c:when>
								<c:otherwise>bgcolor="red"</c:otherwise>
							</c:choose>
									>${result.level}</td>
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

