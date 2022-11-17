<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>
<script src="${pageContext.request.contextPath}/js/views/layouts/page.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/hospitalInfo/init.js" type="text/javascript"></script>

<div class="navRight">
	<div class="contentlist">
		<input type="hidden" id="grade" value="${grade}"/>
		<input type="hidden" id="orgType" value="${orgType}"/>
		<div class="location">
		  	当前位置：<c:if test="${operation == 'hospitalInfoClick'}"><a id="yljg" class="space">医疗机构</a></c:if>
		  					  <c:if test="${operation == 'yyjtInfoClick'}"><a id="yyjt" class="space">医院集团</a></c:if>
		  	<c:if test="${not empty grade}">
		  		<c:if test="${grade == '1'}">&gt;&gt;<a id="levelOne1">一级医院</a></c:if>
				<c:if test="${grade == '2'}">&gt;&gt;<a id="levelTwo1">二级医院</a></c:if>
				<c:if test="${grade == '3'}">&gt;&gt;<a id="levelThree1">三级医院</a></c:if>
				<c:if test="${grade == '4'}">&gt;&gt;<a id="levelFour1">其他</a></c:if>
			</c:if>
			<c:if test="${not empty orgType}">
		  		<c:if test="${orgType == 'A100'}">&gt;&gt;<a id="orgTypeA1">六家医院</a></c:if>
				<c:if test="${orgType == 'B100'}">&gt;&gt;<a id="orgTypeB1">九大中心</a></c:if>
			</c:if>
		</div>
		<div class="hospitalInfo_lists">
			<ul>
			 	<c:forEach items="${hospitalPageList}" var="record" varStatus="status">
				<li class="hospital-info-li">
					<div class="hospital-info">
						<div class="hospital-pic pic-${status.index }">
							<c:if test="${operation == 'hospitalInfoClick'}">
								<a href="${pageContext.request.contextPath }/infoShow/hospitalInfo?id=${record.id}&grade=${record.hospitalLevel }" target="_blank">
									<c:forEach items="${hosPicattches}" var="attche">
										<c:choose>
											<c:when test="${attche.resourceId eq record.id }">
												<img src="${pageContext.request.contextPath}/home/showAsImage/${attche.id}?type=1" />
											</c:when>
										</c:choose>
									</c:forEach>
								</a>
							</c:if>
							<c:if test="${operation == 'yyjtInfoClick'}">
								<a href="${pageContext.request.contextPath }/infoShow/hospitalInfo?id=${record.id}&orgType=${record.organizationType }" target="_blank">
									<c:forEach items="${hosPicattches}" var="attche">
										<c:choose>
											<c:when test="${attche.resourceId eq record.id }">
												<img src="${pageContext.request.contextPath}/home/showAsImage/${attche.id}?type=1" />
											</c:when>
										</c:choose>
									</c:forEach>
								</a>
							</c:if>
						</div>
						<div class="hospital-introduces">
							<div class="introduces-title">
								<c:if test="${operation == 'hospitalInfoClick'}">
									<a href="${pageContext.request.contextPath }/infoShow/hospitalInfo?id=${record.id}&grade=${record.hospitalLevel }">${record.hospitalName}</a>
								</c:if>
								<c:if test="${operation == 'yyjtInfoClick'}">
									<a href="${pageContext.request.contextPath }/infoShow/hospitalInfo?id=${record.id}&orgType=${record.organizationType }">${record.hospitalName}</a>
								</c:if>
								<span class="hospital-sign"><ehr:dic code="${record.hospitalLevel}" dicmeta="DM02-02"/></span>
								<!-- <span class="hospital-health">医保</span> -->
							</div>
							<table cellspacing="0" cellpadding="0" class="newTab">
								<tr>
									<td valign="top">医院电话： </td>
									<td>${record.hospitalPhone }</td>
								</tr>
								<tr>
									<td valign="top">医院地址： </td>
									<td class="info-pos">
										${record.hospitalAddress }
									</td>
								</tr>
								<tr>
									<td valign="top">医院网址： </td>
									<td>
										<c:choose>
											<c:when test="${empty record.hospitalWebsite }">暂无</c:when>
											<c:otherwise>
												<a target="_blank" href="${record.hospitalWebsite }">${record.hospitalWebsite }</a>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
								<tr>
									<td valign="top">医院概况：</td>
									<td class="hospital-feature">
										 <div class="feature-detail detail-${status.index }">
												 ${record.hospitalInfo }
										 </div>
										 <div class="feature-right">
											 <label>
											 	<c:if test="${operation == 'hospitalInfoClick'}">
													<a href="${pageContext.request.contextPath }/infoShow/hospitalInfo?id=${record.id}&grade=${record.hospitalLevel }">查看更多&gt;</a>
												</c:if>
												<c:if test="${operation == 'yyjtInfoClick'}">
													<a href="${pageContext.request.contextPath }/infoShow/hospitalInfo?id=${record.id}&orgType=${record.organizationType }">查看更多&gt;</a>
												</c:if>
											 </label>
										 </div>
									</td>
								</tr>
								<c:if test="${record.isRegisteredHospital eq  1}">
								<tr>
									<td valign="top">提供服务：</td>
									<td class="server" valign="top">
												<i class="icon-order"></i>
												预约挂号
												<i class="fixed"></i>
<!-- 												<i class="icon-tip"></i>
												就诊提醒 -->
									</td>
								</tr>
								</c:if>
							</table>
						</div>
					</div>
				</li>
		      </c:forEach>
			</ul>
		</div>
		<c:if test="${operation == 'hospitalInfoClick'}">
			<ehr:pagination action="contentPage.yyjgSearch"/>
		</c:if>
		<c:if test="${operation == 'yyjtInfoClick'}">
			<ehr:pagination action="contentPage.yyjtSearch"/>
		</c:if>
	</div>
</div>