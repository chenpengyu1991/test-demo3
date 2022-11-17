<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/womenHealthyCare/neonatalFamilyVisit.js" type="text/javascript"></script>
<div class="rightnav">
	<table>
		<tr>
	      	<td class="crumbs"><div id="location" parentMenu="women-health" childMenu="neonatalFamilyVisitList">当前位置:&gt;&gt;妇女保健&gt;&gt;新生儿家庭视访</div>
			</td>
	  	</tr>
	 </table>
<div>
	<table class="follow-up-table">
		<thead>
			<tr>
				<th>访视日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${neonatalFamilyVisits}" var="nfv">
				<tr onclick="brwHealthNeonatalFamily.getNeonatalFamilyVisit(${nfv.id})" style="cursor: pointer;">
					<td>
						<input type="hidden" value="${nfv.id}" class="neonatalFamilyVisit" />
						<fmt:formatDate value="${nfv.visitDate}" pattern="yyyy/MM/dd"></fmt:formatDate>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div>
	<br/>
	<div id="neonatalFamilyDiv" style="position: relative;"></div>
	<br/>
</div>
</div>