<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/womenHealthyCare/postnatalFollowup.js" type="text/javascript"></script>
<div class="rightnav">
	<table>
		<tr>
	      	<td class="crumbs"><div id="location" parentMenu="women-health" childMenu="postnatalFollowupList">当前位置:&gt;&gt;妇女保健&gt;&gt;产后视访</div>
			</td>
	  	</tr>
	 </table>
<div>
	<table class="follow-up-table">
		<thead>
			<tr>
				<th>随访时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${postnatalFollowups}" var="followup">
				<tr onclick="brwHealthFollowUp.getFollowUpDetail(${followup.id})" style="cursor: pointer;">
					<td>
						<input type="hidden" value="${followup.id}" class="postnatalFollowup" />
						<fmt:formatDate value="${followup.visitDate}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div>
	<br/>
	<div id="postnatalFollowupDiv" style="position: relative;"></div>
</div>
</div>