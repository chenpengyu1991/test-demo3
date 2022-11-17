<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>
<%@ page import="com.founder.rhip.portal.common.InteractionStatus" %>
<c:set var="REPLY" value="<%=InteractionStatus.REPLY.getValue()%>"/>
<c:set var="RETURN" value="<%=InteractionStatus.RETURN.getValue()%>"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/info/interaction.css"/>

<script src="${pageContext.request.contextPath}/js/views/layouts/page.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/medicineOperation/list.js" type="text/javascript"></script>
<c:if test="${empty patientbedList}">
    <div class="contact-info-box">
    <div class="contact-title">
        <div class="contact-item-info" style="width: 100%">
            <span>暂无床位！</span>
        </div>
    </div>
</c:if>
<c:if test="${not empty patientbedList}">
    <div class="contact-info-box">
        <div class="contact-title">
            <div class="contact-title-item" style="width: 16%">
                <span>医院名称</span>
            </div>
            <div class="contact-title-item" style="width: 16%">
                <span>科室名称</span>
            </div>
            <div class="contact-title-item" style="width: 16%">
                <span>总床位</span>
            </div>
            <div class="contact-title-item" style="width: 16%">
                <span>剩余床位</span>
            </div>
            <div class="contact-title-item" style="width: 16%">
                <span>联系电话</span>
            </div>
            <div class="contact-title-item" style="width: 16%">
                <span>更新时间</span>
            </div>
        </div>
        <ul>
            <c:forEach items="${patientbedList}" var="patientbedList">
                <li>
                    <div class="contact-content">
                        <div class="contact-item-info" style="width: 16%; ">
                               ${patientbedList.hospitalName}
                        </div>
                        <div class="contact-item-info" style="width: 16%; ">
                                ${patientbedList.depName}
                        </div>
                        <div class="contact-item-info" style="width: 16%; ">
                                ${patientbedList.sumBed}
                        </div>
                        <div class="contact-item-info" style="width: 16%; ">
                                ${patientbedList.residueBed}
                        </div>
                        <div class="contact-item-info" style="width: 16%; ">
                                ${patientbedList.telNo}
                        </div>
                        <div class="contact-item-info" style="width: 16%; ">
                                ${patientbedList.updateTime}
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <ehr:pagination action="medicineSearch.search"/>
    </div>
</c:if>


