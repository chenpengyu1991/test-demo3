<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/manage/PlanFollowupList.js" type="text/javascript"></script>
<div class="repeattable">
        <input type="text" value="(注:高血压:蓝色,糖尿病:褐色)" readonly="readonly" style="width: 180px;"></input>
		<table class="repeattable" >
			<thead>
				<tr>
					<th>计划随访日期</th>
					<th>实际随访日期</th>
				</tr>
			</thead>			
				<tbody>
					<c:forEach var="dmPlanFollowup" items="${brwDmPlanFollowupList}">
						<tr style="cursor:hand">
							<td  style="${dmPlanFollowup.disType eq 1? 'color:#013677':'color:#771701'}"><ehr:tip><fmt:formatDate value="${dmPlanFollowup.planDate}"/></ehr:tip> </td>
							<td><ehr:tip><fmt:formatDate value="${dmPlanFollowup.followupDate}"/></ehr:tip></td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
</div>
