<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script src="${pageContext.request.contextPath}/js/views/reserve/schedule.js" type="text/javascript"></script>
	
<div id="reserveSearch" class="reserveSearch">
	<c:if test="${empty registerScheduleLists }">
		<div class="box" style="border:0">
			<div class="pd10" style="float:left">
			<span>无记录！</span>
			</div>
		</div>
	</c:if>
	<c:if test="${not empty registerScheduleLists }">
		<div class="box" style="border:0">
			<div class="pd10" style="float:left">
			搜索结果：共有
			<span class="count">${page.getTotalRows() }</span>
			条相关结果记录
			</div>
		</div>
		<div class="box">
			<div class="pd10">
				<c:if test="${type eq '01' }">
					<c:forEach items="${registerScheduleLists}" var="registerSchedule" varStatus="status">
						<div class="item">
							<h3>
								<span class="star"></span>
								<a onclick="reserveschedule.selectOptions({hospital:'${registerSchedule.hospitalCode }',clinic:'${registerSchedule.deptSn }'})">
									${fn:replace(registerSchedule.deptName, searchContent,searchContentRed)} ${registerSchedule.hospitalName }
								</a>
							</h3>
							<div class="tro detail-${status.index }">
								<c:forEach items="${hospitalInfoLists}" var="attche">
									<c:if test="${registerSchedule.hospitalCode eq attche.hospitalNo}">
										${attche.hospitalInfo} 
									</c:if>
								</c:forEach>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${type eq '02' }">
					<c:forEach items="${registerScheduleLists}" var="attche1" varStatus="status">
						<div class="item">
							<h3>
								<span class="star"></span>
								<a onclick="reserveschedule.selectOptions({hospital:'${attche1.hospitalCode }',deptName:'${attche1.deptName }'})">
									${fn:replace(attche1.deptName, searchContent,searchContentRed)} ${attche1.hospitalName }
								</a>
							</h3>
							<div class="tro detail-${status.index }">
								<c:forEach items="${hospitalInfoLists}" var="attche">
									<c:if test="${attche1.hospitalCode eq attche.hospitalNo}">
										${attche.hospitalInfo} 
									</c:if>
								</c:forEach>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<ehr:pagination action="reserveschedule.reserveSearchList"/>
	</c:if>
	
</div>
