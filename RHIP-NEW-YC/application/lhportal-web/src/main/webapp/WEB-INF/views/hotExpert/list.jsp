<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>
<c:if test="${empty showHotDoctorsLists}">
	<div class="box" style="border:0">
		<div class="pd10" style="float:left">
		<span>无记录！</span>
		</div>
	</div>
</c:if>
<c:if test="${not empty showHotDoctorsLists}">
	<div class="box" style="border-top:1px solid #eaeaea;border-bottom:1px solid #eaeaea;">
		<div class="pd10" style="float:left;font-size:12px;">
		符合条件的
		<span class="count">${page.getTotalRows() }</span>
		名热门专家
		</div>
	</div>
    <div class="hospitalInfo_lists">
        <ul>
        	<c:forEach items="${showHotDoctorsLists }" var="hotExpert" varStatus="status">
	            <li class="hospital-info-li">
	                <div class="hospital-info">
	                    <div class="hospital-pic pic-${status.index }">
	                    	<a href="#">
	                            <c:choose>
	                                <c:when test="${empty hotExpert.uploadFileId}">
	                                    <img src="${pageContext.request.contextPath}/images/doctor/doctor_default_img.jpg"/>
	                                </c:when>
	                                <c:otherwise>
	                                	<img src="${pageContext.request.contextPath}/home/showAsImage/${hotExpert.uploadFileId}?type=1"/>
	                                </c:otherwise>
	                            </c:choose>
	                        </a>
	                    </div>
	                    <div class="hospital-introduces">
	                        <div class="introduces-title">
	                            <label><a id="showWorkExperience-${status.index }" onclick="hotExpertSearch.showWorkExperience('${status.index }')">${hotExpert.name}</a></label>
	                            <c:if test="${not empty hotExpert.empTitName}">
	                            	<span class="hospital-sign">${hotExpert.empTitName }</span>
	                            </c:if>
	                        </div>
	                        <div class="introduces-subTitle">
	                            <label>${hotExpert.hospitalName}</label>
	                            <span>${hotExpert.deptName }</span>
	                            <%-- <div class="reserve">
	                            <a id="show${status.index }" onclick="hotExpertSearch.showHotExpertReserve({account:'${accountInfo.id}',index:'${status.index }',
	                            hospital:'${hotExpert.hospitalCode }',clinic:'${hotExpert.deptSn}', doctor:'${hotExpert.doctorSn }'})">预约</a>
	                            <a id="hide${status.index }" style="display:none" onclick="hotExpertSearch.hideHotExpertReserve('${status.index }')">收起</a>
	                            </div> --%>
	                        </div>
	                        <div class="introduces-subTitle no-padding-top" style="height:auto">
	                            <label>擅长诊治：</label>
	                            <span>${hotExpert.specializes }</span>
	                        </div>
	                    </div>
	                </div>
	                <%-- <div id="workExperience-${status.index }" class="workExperience" style="height: 120px;">
	                	<div class="workExperienceTitle"></div>
                        <div id="workExperienceDetail-${status.index }" class="workExperienceDetail">
                        	<c:if test="${not empty hotExpert.workExperience}">
	                            	${hotExpert.workExperience }<a onclick="hotExpertSearch.hideWorkExperience('${status.index }')">收起</a>
	                        </c:if>
	                        <c:if test="${empty hotExpert.workExperience}">
	                            	<div class="label">尚无该医生职业经历</div>
	                        </c:if>	
	                    </div>
	                </div> --%>
	                
	                <c:if test="${not empty hotExpert.workExperience}">
	                    <div id="workExperience-${status.index }" class="workExperience">
		                	<div class="workExperienceTitle"></div>
	                        <div id="workExperienceDetail-${status.index }" class="workExperienceDetail">
		                            ${hotExpert.workExperience }<%-- <a onclick="hotExpertSearch.hideWorkExperience('${status.index }')">收起</a> --%>
		                    </div>
	                	</div>
	                </c:if>
	                <c:if test="${empty hotExpert.workExperience}">
	                    <div id="workExperience-${status.index }" class="workExperience" style="height: 30px;">
		                	<div class="workExperienceTitle"></div>
	                        <div id="workExperienceDetail-${status.index }" class="workExperienceDetail" >
		                            	<div class="label">尚无该医生职业经历</div>
		                    </div>
	                	</div>
	                </c:if>	
	                <div id="hotExpertReserve-${status.index }" class="hotExpertReserve"  style="height: 30px;">
	                	<div class="hotExpertReserveTitle"></div>
                        <div id="hotExpertReserveDetail-${status.index }" class="hotExpertReserveDetail">
	                    </div>
	                </div>
	            </li>
        	</c:forEach>
        </ul>
    </div>
    <ehr:pagination action="hotExpertSearch.search"/>
</c:if>
