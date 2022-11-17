<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/twoToFivevisit.js" type="text/javascript"></script>

<div style="float: left; width: 17%;margin-top: 5px;" class="repeattable" id="sfrqListDiv">
	<%-- <c:forEach items="${gourpTwoToFivevisitMap}" var="twoToFivevisits">
		<table class="layui-table x-admin-sm-table-list-small">
			<thead>
			<tr>
				<th title="${twoToFivevisits.key}">${twoToFivevisits.key}</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${twoToFivevisits.value}" var="twoToFivevisit">
				<tr onclick="brwHealthTwotoFivevisit.getTwotoFivevisitDetail(${twoToFivevisit.id})" style="cursor: pointer;">
					<td>
						<input type="hidden" value="${twoToFivevisit.id}" class="WhYcfbjCqsf" />
						<fmt:formatDate value="${twoToFivevisit.sfrq}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:forEach> --%>
	<table class="layui-table x-admin-sm-table-list-small">
		<thead>
		<tr>
			<th>随访日期</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${whYcfbjCqsfList}" var="twoToFivevisit">
			<tr onclick="brwHealthTwotoFivevisit.getTwotoFivevisitDetail(${twoToFivevisit.id})" style="cursor: pointer;">
				<input type="hidden" value="${twoToFivevisit.id}" class="WhYcfbjCqsf" />
				<td>
						<fmt:formatDate value="${twoToFivevisit.recordDate}" pattern="yyyy/MM/dd"/>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<div style="float: right; width: 82%">
	<div id="WhYcfbjCqsfDiv" style="position: relative;"></div>
</div>