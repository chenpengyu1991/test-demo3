<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld" %>

<div class="navLeft">
	<%-- <div class="leftTitleBg">
		<c:if test="${operation == 'hospitalInfoClick'}">
			<label>医疗机构</label>
		</c:if>
		<c:if test="${operation == 'yyjtInfoClick'}">
			<label>医院集团</label>
		</c:if>
		<c:if test="${operation == 'interactionInfoClick'}">
			<label>在线咨询</label>
		</c:if>
		<c:if test="${operation == 'fileManagerClick'}">
			<label>资料下载</label>
		</c:if>
		<c:if test="${operation == 'surveyInfoClick'}">
			<label>调查问卷</label>
		</c:if>
		<c:if test="${operation == 'prescriptionMhClick'}">
			<label>健康指导</label>
		</c:if>
		<c:if test="${operation == 'healthPromorionClick'}">
			<label>健康宣传</label>
		</c:if>
		<c:if test="${operation == 'serviceInfoClick'}">
			<label>${parentInfoType.name }</label>
		</c:if>
	</div> --%>
	<div id="leftSubTitle" class="leftSubTitleBg">
		<ul>
			<c:choose>
				<c:when test="${operation =='hospitalInfoClick'}">
					<li class="sidemenu"><a id="levelOne">一级医院</a></li>
		            <li class="sidemenu"><a id="levelTwo">二级医院</a></li>
		            <li class="sidemenu"><a id="levelThree">三级医院</a><li>
					<li class="sidemenu"><a id="levelFour">其他</a><li>
				</c:when>
				<c:when test="${operation =='yyjtInfoClick'}">
					<li class="sidemenu"><a id="orgTypeA">六家医院</a></li>
		            <li class="sidemenu"><a id="orgTypeB">九大中心</a></li>
		            <li class="sidemenu"><a>科研</a></li>
				</c:when>
				<c:when test="${operation =='interactionInfoClick'}">
					<li class="sidemenu"><a id="zx">咨询</a></li>
		            <li class="sidemenu"><a id="jy">建议</a></li>
		            <li class="sidemenu"><a id="ts">投诉</a></li>
				</c:when>
				<c:when test="${operation =='fileManagerClick'}">
					<li class="sidemenu"><a id="bgxz">表格下载</a></li>
		            <li class="sidemenu"><a id="zcwj">政策文件</a></li>
		            <li class="sidemenu"><a id="rjxz">软件下载</a></li>
				</c:when>
				<c:when test="${operation =='surveyInfoClick'}">
					<li class="sidemenu"><a id="dcwj">调查问卷</a></li>
				</c:when>
				<c:when test="${operation =='prescriptionMhClick'}">
					<li class="sidemenu"><a id="jkzd">健康指导</a></li>
				</c:when>
				<c:when test="${operation =='healthPromorionClick'}">
					<li class="sidemenu"><a id="jkxc">健康宣传</a></li>
				</c:when>
				<c:when test="${ fn:length(infoTypeList) != 0}">
					<c:forEach items="${infoTypeList}" var="infoType">
					    <li class="sidemenu"><a id="subTitle${infoType.id}" data-code="${infoType.id}" data-parentCode="${infoType.parentCode}" >${infoType.name}</a></li>
					</c:forEach>
                    <c:if test="${mdmMedicineOp eq 'mdmMedicineOp' }">
						<li class="sidemenu"><a id="mdmMedicineOp" >国家基本药物目录查询</a></li>
					</c:if>
                    <c:if test="${chargeitem eq 'chargeitem'}">
                        <li class="sidemenu"><a id="chargeitem">收费项目查询</a></li>
                    </c:if>
					<c:if test="${patientbed eq 'patientbed'}">
						<li class="sidemenu"><a id="patientbed">床位查询</a></li>
					</c:if>
				</c:when>
				<c:otherwise>
						<li class="sidemenu"><a id="title${parentInfoType.id}" data-code="${parentInfoType.id}">${parentInfoType.name}</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>