<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/womenHealthyCare/motherhoodPeriodFollowup.js" type="text/javascript"></script>
<div class="rightnav">
	<table>
		<tr>
	      	<td class="crumbs"><div id="location" parentMenu="women-health" childMenu="motherhoodPeriodFollowupList">当前位置:&gt;&gt;妇女保健&gt;&gt;孕期保健和高危随访管理</div>
			</td>
	  	</tr>
	 </table>
<div>
	<table class="follow-up-table">
		<thead>
			<tr>
				<th>检查时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${motherhoodPeriodFollowups}" var="mpf">
				<tr onclick="brwHealtmotherhoodPeriodFollowup.getMotherhoodPeriodFollowup(${mpf.id})" style="cursor: pointer;">
					<td>
						<input type="hidden" value="${mpf.id}" class="motherhoodPeriodFollowup" />
						<fmt:formatDate value="${mpf.checkDate}" pattern="yyyy/MM/dd"></fmt:formatDate>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div>
	<br>
	<div id="motherhoodPeriodFollowupDiv" style="position: relative;"></div>
	<br/>
</div>
</div>