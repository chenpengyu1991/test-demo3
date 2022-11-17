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
<c:if test="${empty medicineList}">
<div class="contact-info-box">
        <div class="contact-title">
            <div class="contact-item-info" style="width: 100%">
                <span>暂无可查询的药物！</span>
            </div>
        </div>
</c:if>
<c:if test="${not empty medicineList}">
    <div class="contact-info-box">
        <div class="contact-title">
            <div class="contact-title-item" style="width: 10%">
                <span>药物级别</span>
            </div>
            <div class="contact-title-item" style="width: 15%">
                <span>药物名称</span>
            </div>
            <div class="contact-title-item" style="width: 10%">
                <span>类别一级</span>
            </div>
            <div class="contact-title-item" style="width: 15%">
                <span>类别二级</span>
            </div>
            <div class="contact-title-item" style="width: 10%">
                <span>剂型</span>
            </div>
            <div class="contact-title-item" style="width: 20%">
                <span>规格</span>
            </div>
            <div class="contact-title-item" style="width: 20%">
                <span>生产企业</span>
            </div>
        </div>
        <ul>
            <c:forEach items="${medicineList}" var="medicine">
                <li>
                    <div class="contact-content">
                        <div class="contact-item-info" style="width: 10%; ">
                                <ehr:dic dicmeta="FS10242" code="${medicine.levelCode}" />
                        </div>
                        <div class="contact-item-info" style="width: 15%; ">
                            ${medicine.commonName}
                        </div>
                        <div class="contact-item-info" style="width: 10%; ">
                                ${medicine.categoryNameOne}
                        </div>
                        <div class="contact-item-info" style="width: 15%; ">
                                ${medicine.categoryNameTwo}
                        </div>
                        <div class="contact-item-info" style="width: 10%; ">
                                ${medicine.dosage}
                        </div>
                        <div class="contact-item-info" style="width: 20%; ">
                            ${medicine.specification}
                        </div>
                        <div class="contact-item-info" style="width: 20%; ">
                            ${medicine.manufactory}
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
		<ehr:pagination action="medicineSearch.search"/>
    </div>
</c:if>


