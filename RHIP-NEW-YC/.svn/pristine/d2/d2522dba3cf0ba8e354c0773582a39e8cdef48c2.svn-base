<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/hospitalInfo/detail.js" type="text/javascript"></script>

<!-- 医院信息 -->
<div class="navRight">
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
		  		<c:if test="${orgType == 'A100'}">&gt;&gt;<a id="orgTypeA2">六家医院</a></c:if>
				<c:if test="${orgType == 'B100'}">&gt;&gt;<a id="orgTypeB2">九大中心</a></c:if>
			</c:if>
	</div>
	<div class="hospitalInfo_lists">
		<ul>
			<li class="hospital-info-li">
				<div class="hospital-info">
					<div class="hospital-pic">
						<c:forEach items="${hosPicattches}" var="attche">
							<c:choose>
								<c:when test="${attche.resourceId eq hospitalInfo.id }">
									<img src="${pageContext.request.contextPath}/home/showAsImage/${attche.id}?type=1" />
								</c:when>
							</c:choose>
						</c:forEach>
					</div>
					<div class="hospital-introduces">
						<div class="introduces-title">
							<label>${hospitalInfo.hospitalName}</label>
							<span class="hospital-sign"><ehr:dic code="${hospitalInfo.hospitalLevel}" dicmeta="DM02-02"/></span>
							<!-- <span class="hospital-health">医保</span> -->
						</div>
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td valign="top">医院电话： </td>
								<td>${hospitalInfo.hospitalPhone }</td>
							</tr>
							<tr>
								<td valign="top">医院地址： </td>
								<td class="info-pos">
									${hospitalInfo.hospitalAddress }
								</td>
							</tr>
							<tr>
								<td valign="top">医院网址： </td>
								<td>
									<c:choose>
										<c:when test="${empty hospitalInfo.hospitalWebsite }">暂无</c:when>
										<c:otherwise>
											<a target="_blank" href="${hospitalInfo.hospitalWebsite }">${hospitalInfo.hospitalWebsite }</a>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td valign="top">挂号时间：</td>
								<td>${hospitalInfo.registrationTime }</td>
							</tr>
							<c:if test="${hospitalInfo.isRegisteredHospital eq  1}">
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
		</ul>
	</div>
	<div class="hospitalInfo_slideBox" style="position:relative">
		<div class="slider_title">	
			<div id="titles">
				<ul>
					<li><a class="select">医院简介</a></li>
					<li><a class="">就医指南</a></li>
					<li><a class="">微导诊</a></li>
				</ul>
			</div>
		</div>
		<div class="hospitalInfo_detail" id="tabContent1_item0">
            <div id="titleContent1_item0_0">
               	<c:choose>
					<c:when test="${not empty hospitalInfo.hospitalInfo}">
						<h1 class="info_title">医院概况：</h1>
						<div class="info_content">${hospitalInfo.hospitalInfo}
						</div>
					</c:when>
					<c:otherwise>
						<h1 class="info_title">无</h1>
					</c:otherwise>
				</c:choose>
            </div>
            <div id="titleContent1_item0_1" style="display:none">
				<c:choose>
					<c:when test="${not empty hospitalInfo.guideForMedical}">
						<h1 class="info_title">就医指南：</h1>
						<div class="info_content">${hospitalInfo.guideForMedical}
						</div>
					</c:when>
					<c:otherwise>
						<h1 class="info_title">无</h1>
					</c:otherwise>
				</c:choose>
            </div>
            <div id="titleContent1_item0_2" style="display:none">
				<c:choose>
					<c:when test="${not empty hospitalInfo.microGuidance}">
						<h1 class="info_title">微导诊：</h1>
						<div class="info_content">${hospitalInfo.microGuidance}
						</div>
					</c:when>
					<c:otherwise>
						<h1 class="info_title">无</h1>
					</c:otherwise>
				</c:choose>
            </div>
        </div>
	</div>
</div>