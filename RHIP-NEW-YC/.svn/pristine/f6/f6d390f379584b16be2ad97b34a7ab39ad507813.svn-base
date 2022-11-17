<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/ehrbrowser/whch/birth.css"></link>
<div class="rightnav">
	<table>

		<tr>
	      	<td class="crumbs"><div id="location" parentMenu="child-care" childMenu="newBornDetail">当前位置:&gt;&gt;儿童保健&gt;&gt;子女出生证明</div>
			</td>
	  	</tr>
	 </table>
<div class="scroll-div">	 
<div class="birthDay">
	<!-- 姓名 -->
	<label class="birthInfo" style="left: 240px;top: 108px;">
		${chBirthCertificate.neonatalName}
	</label>
	<!-- 性别 -->
	<c:if test="${chBirthCertificate.neonatalGender == 1 }">
		<label class="birthInfo" style="left: 325px;top: 108px;">√</label>
	</c:if>
	<c:if test="${chBirthCertificate.neonatalGender == 2 }">
		<label class="birthInfo" style="left: 353px;top: 108px;">√</label>
	</c:if>
	<!-- 出生日期 -->
	<label class="birthInfo" style="left: 427px;top: 108px;">
		<fmt:formatDate value="${chBirthCertificate.neonatalBirthday}" pattern="yyyy"/>
	</label>
	<label class="birthInfo" style="left: 472px;top: 108px;">
		<fmt:formatDate value="${chBirthCertificate.neonatalBirthday}" pattern="MM"/>
	</label>
	<label class="birthInfo" style="left: 502px;top: 108px;">
		<fmt:formatDate value="${chBirthCertificate.neonatalBirthday}" pattern="dd"/>
	</label>
	<label class="birthInfo" style="left: 527px;top: 108px;">
		<fmt:formatDate value="${chBirthCertificate.neonatalBirthday}" pattern="HH"/>
	</label>
	<label class="birthInfo" style="left: 557px;top: 108px;">
		<fmt:formatDate value="${chBirthCertificate.neonatalBirthday}" pattern="mm"/>
	</label>
	
	<!-- 出生地 -->
	<label class="birthInfo" style="left: 210px;top: 142px;">${chBirthCertificate.paprovince}</label>
	<label class="birthInfo" style="left: 275px;top: 142px;">${chBirthCertificate.pacity}</label>
	<label class="birthInfo" style="left: 340px;top: 142px;">${chBirthCertificate.pacounty}</label>
	<label class="birthInfo" style="left: 415px;top: 142px;">${chBirthCertificate.patownShip}</label>
	
	<!-- 孕周 -->
	<label class="birthInfo" style="left: 545px;top: 142px;">
		${chBirthCertificate.gestationalWeek}
	</label>
	
	<!-- 健康状况 -->
	
	<c:choose>
		<c:when test="${chBirthCertificate.neonatalHealth == 1}">
			<label class="birthInfo" style="left: 275px;top: 174px;">√</label>
		</c:when>
		<c:when test="${chBirthCertificate.neonatalHealth == 2}">
			<label class="birthInfo" style="left: 340px;top: 174px;">√</label>
		</c:when>
		<c:when test="${chBirthCertificate.neonatalHealth == 3}">
			<label class="birthInfo" style="left: 390px;top: 174px;">√</label>
		</c:when>
	</c:choose>

	<!-- 体重身高 -->
	<label class="birthInfo" style="left: 445px;top: 174px;">${chBirthCertificate.birthWeight}</label>
	<label class="birthInfo" style="left: 540px;top: 174px;">${chBirthCertificate.birthStature}</label>
	
	<!-- 母亲 -->
	<label class="birthInfo" style="left: 250px;top: 215px;">${chBirthCertificate.motherName}</label>
	<label class="birthInfo" style="left: 340px;top: 215px;">${chBirthCertificate.motherAge}</label>
	<label class="birthInfo" style="left: 415px;top: 215px;">
		<ehr:dic code="${chBirthCertificate.motherNationality}" dicmeta="GBT26592000"/>
	</label>
	<label class="birthInfo" style="left: 535px;top: 215px;">
		<ehr:dic code="${chBirthCertificate.motherNation}" dicmeta="GBT3304"/>
	</label>
	
	<!-- 身份证号 -->
	<c:forEach var="c" items="${midCard}" varStatus="status">
		<c:set var="leftPx" value="${status.index * 16 + 255}"></c:set>
		<label class="birthInfo" style="left: ${leftPx}px;top: 250px;">${c}</label>
	</c:forEach>
	
	<!-- 父亲 -->
	<label class="birthInfo" style="left: 250px;top: 280px;">${chBirthCertificate.fatherName}</label>
	<label class="birthInfo" style="left: 340px;top: 280px;">${chBirthCertificate.fatherAge}</label>
	<label class="birthInfo" style="left: 415px;top: 280px;">
		<ehr:dic code="${chBirthCertificate.motherNationality}" dicmeta="GBT26592000"/>
	</label>
	<label class="birthInfo" style="left: 535px;top: 280px;">
		<ehr:dic code="${chBirthCertificate.fatherNation}" dicmeta="GBT3304"/>
	</label>
	
	<!-- 身份证号 -->
	
	<c:forEach var="c" items="${fidCard}" varStatus="status">
		<c:set var="leftPx" value="${status.index * 16 + 255}"></c:set>
		<label class="birthInfo" style="left: ${leftPx}px;top: 313px;">${c}</label>
	</c:forEach>
	
	<!-- 出生地点分类 -->	
	
	<c:choose>
		<c:when test="${chBirthCertificate.birthPlaceType == 1}">
			<label class="birthInfo" style="left: 337px;top: 345px;">√</label>
		</c:when>
		<c:when test="${chBirthCertificate.birthPlaceType == 2}">
			<label class="birthInfo" style="left: 437px;top: 345px;">√</label>
		</c:when>
		<c:when test="${chBirthCertificate.birthPlaceType == 3}">
			<label class="birthInfo" style="left: 491px;top: 345px;">√</label>
		</c:when>
		<c:when test="${chBirthCertificate.birthPlaceType == 9}">
			<label class="birthInfo" style="left: 576px;top: 345px;">√</label>
		</c:when>
	</c:choose>
	
	<!-- 接种机构名称 -->	
	<label class="birthInfo" style="left: 260px;top: 375px;">
		${chBirthCertificate.midwiferyOrganName}
	</label>
	
	<!-- 出生证编号 -->	
	<label class="birthInfo" style="left: 235px;top: 422px;">
		${chBirthCertificate.birthCertificateNo}
	</label>
	
	<!-- 签发日期 -->	
	<label class="birthInfo" style="left: 430px;top: 422px;">
		<fmt:formatDate value="${chBirthCertificate.issuedDate}" pattern="yyyy"/>
	</label>
	<label class="birthInfo" style="left: 480px;top: 422px;">
		<fmt:formatDate value="${chBirthCertificate.issuedDate}" pattern="MM"/>
	</label>
	<label class="birthInfo" style="left: 510px;top: 422px;">
		<fmt:formatDate value="${chBirthCertificate.issuedDate}" pattern="dd"/>
	</label>
	
	<!-- 签发机构 -->	
	<label class="birthInfo" style="left: 600px;top: 390px; font-size: 16px;font-weight: bold;">
		${chBirthCertificate.visaOrganName}
	</label>
</div>
</div>
</div>