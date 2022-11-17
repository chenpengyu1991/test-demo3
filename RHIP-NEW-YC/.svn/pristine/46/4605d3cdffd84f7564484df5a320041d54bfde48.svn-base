<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable" id="cdmHealthPlanList">
		<table class="repeattable" >
			<thead>
				<tr>
					<th style="text-align: center;">年度计划</th>
				</tr>
			</thead>			
			<tbody>
				<c:forEach var="dmPlanInfo" items="${dmPlanInfoList}">
					<tr style="cursor:hand">
						<td style="text-align: center"> <a title="点击查看保健计划" style="display: block;width: 100%" class="healthplan-link" href="javascript:void(0)" data-personid="${dmPlanInfo.personId}" data-planyear="${dmPlanInfo.planYear}">${dmPlanInfo.planYear}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
