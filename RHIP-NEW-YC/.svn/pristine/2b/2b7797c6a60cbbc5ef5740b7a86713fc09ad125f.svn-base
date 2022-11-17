<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld" %>

<div class="navRight">
	<div class="contentlist">
	  <div class="location">
		当前位置:<a style="text-decoration: none;" href="${pageContext.request.contextPath}/userSpace/reserve/schedule">预约挂号</a>
	  </div>
		<div class="reserveSelect">
			<div class="repeattable" style="width: 100%;margin-right: 5px;">
					<br/>
					<div class="jinggaoInfo">
					<c:choose>
						<c:when test="${success eq true }">
						           请于${startTimeHour}点<c:if test="${not empty startTimeMin }">${startTimeMin}分</c:if>到${endTimeHour}点<c:if test="${not empty endTimeMin }">${endTimeMin}分</c:if>进行预约挂号！ 
						</c:when>
						<c:otherwise>
							对不起，您暂时无法使用预约挂号功能！
						</c:otherwise>
						</c:choose>
					</div>
			</div>
			
			<div id="showDoctorDiv">
			</div>
		</div>
	</div>
</div>


