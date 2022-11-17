<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld" %>
<c:choose>
	<c:when test="${not empty registerSchedules }">
		<jsp:include page="showFrequent.jsp"/>
		<c:if test="${not empty dateList}">
		<div class="schedule-list">
			<table style="font-size:13px; text-align:center;float: left;">
		        <colgroup>
		            <col style="width:16%;"/>
		            <col style="width:12%;"/>
		            <col style="width:12%;"/>
		            <col style="width:12%;"/>
		            <col style="width:12%;"/>
		            <col style="width:12%;"/>
		            <col style="width:12%;"/>
		            <col style="width:12%;"/>
		        </colgroup>
				<thead> 
					<tr style="background-color:#F2F2F2">
						<td>时段</td>
						<c:forEach var="oneDate" items="${dateList}">
						<td style="padding:0;margin:0">
							<div style="height:22px; padding-top:4px">
								<fmt:formatDate value="${oneDate}" pattern="MM月dd日"/>
							</div>
							<div style="height:22px;padding-top:4px;background: #b3b3b3 none repeat scroll 0 0;color: #fff;">
								<fmt:formatDate value="${oneDate}" pattern="EEEE"/>
							</div>
						</td>
						</c:forEach>
				   </tr>
				</thead>
				<tbody class="tbody">
		
						<ehr:hotExpertRegisterSchedule contextPath="${pageContext.request.contextPath}" hospitalCode="${hospitalCode }"
							 deptSn="${deptSn}" doctorSn="${doctorSn}"
							 clinicType="" registerFee=""
							 startDate="${startDate}"
							 endDate="${endDate}"
							 >
						</ehr:hotExpertRegisterSchedule>
						<c:forEach items="${registerSchedules}" var="registerSchedule" varStatus="status">
					<div id="showReserveTimeDiv-${registerSchedule.id }" class="showReserveTimeDiv"></div>
					</c:forEach>
				</tbody>
			</table>
			<div class="reserve-time">
			</div>
	      </div>
		</c:if>
		<script type="text/javascript">
		    $(".cur-reserve").height(160); 
		</script>
	</c:when>
	<c:otherwise>
		<div class="label">您所选择的医生号已预约完！</div>	
	</c:otherwise>
</c:choose> 
