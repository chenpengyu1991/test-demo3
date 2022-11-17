<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld" %>
<%@ page import="com.founder.rhip.portal.common.InteractionStatus" %>
<c:set var="REPLY" value="<%=InteractionStatus.REPLY.getValue()%>"/>
<c:set var="RETURN" value="<%=InteractionStatus.RETURN.getValue()%>"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/info/interaction.css"/>

<script src="${pageContext.request.contextPath}/js/views/layouts/page.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/medicineOperation/list.js" type="text/javascript"></script>
<c:if test="${empty chargeItemList}">
    <div class="contact-info-box">
    <div class="contact-title">
        <div class="contact-item-info" style="width: 100%">
            <span>暂无可查询的项目！</span>
        </div>
    </div>
</c:if>
<c:if test="${not empty chargeItemList}">
    <div class="contact-info-box">
        <div class="contact-title">
            <div class="contact-title-item" style="width: 20%">
                <span>大类</span>
            </div>
            <div class="contact-title-item" style="width: 30%">
                <span>项目名称</span>
            </div>
            <div class="contact-title-item" style="width: 20%">
                <span>规格</span>
            </div>
            <div class="contact-title-item" style="width: 15%">
                <span>单价</span>
            </div>
            <div class="contact-title-item" style="width: 15%">
                <span>常用剂量</span>
            </div>
        </div>
        <ul>
            <c:forEach items="${chargeItemList}" var="chargeItemList">
                <li>
                    <div class="contact-content">
                        <div class="contact-item-info" style="width: 20%; ">
                            <c:choose>
                                <c:when test="${chargeItemList.type == 1}">医保药品</c:when>
                                <c:otherwise>收费项目</c:otherwise>
                            </c:choose>
                        </div>
                        <div class="contact-item-info" style="width: 30%; ">
                                ${chargeItemList.itemName}
                        </div>
                        <div class="contact-item-info" style="width: 20%; ">
                                ${chargeItemList.spec}
                        </div>
                        <div class="contact-item-info" style="width: 15%; ">
                                ${chargeItemList.price1}
                        </div>
                        <div class="contact-item-info" style="width: 15%; ">
                                ${chargeItemList.commdosage}
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <ehr:pagination action="medicineSearch.search"/>
    </div>
</c:if>


