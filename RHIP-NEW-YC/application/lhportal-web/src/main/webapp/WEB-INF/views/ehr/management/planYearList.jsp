<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/manage/planYearList.js" type="text/javascript"></script>
<div class="repeattable">
		<table class="repeattable" >
			<thead>
				<tr>
					<th style="text-align: center;">年度计划</th>
				</tr>
			</thead>			
			<tbody>
				<c:forEach var="dmPlanInfo" items="${brwDmPlanInfoList}">
					<tr class="planYear" onclick="brwPlanYear.selectPlanFollowup(${dmPlanInfo.personId},${dmPlanInfo.planYear})" style="cursor:hand">
						<td style="text-align: center;"> <a > ${dmPlanInfo.planYear}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
