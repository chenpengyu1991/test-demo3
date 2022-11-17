<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/service/main.js" type="text/javascript"></script>
<div class="Menubox">
    <ul>
        <li id="two1" onclick="setTab('two',1,6);ehrbrowserServiceIndex.loadHealthHistory('disease','con_two_1')" class="hover">疾病</li>
        <li id="two2" onclick="setTab('two',2,6);ehrbrowserServiceIndex.loadHealthHistory('surgery','con_two_2')">手术</li>
        <li id="two3" onclick="setTab('two',3,6);ehrbrowserServiceIndex.loadHealthHistory('drugAllergy','con_two_3')">过敏</li>
        <li id="two4" onclick="setTab('two',4,6);ehrbrowserServiceIndex.loadHealthHistory('vaccinationInfo','con_two_4')">接种</li>
        <li id="two5" onclick="setTab('two',5,6);ehrbrowserServiceIndex.loadHealthHistory('hospitalized','con_two_5')">住院</li>
        <li id="two6" onclick="setTab('two',6,6);ehrbrowserServiceIndex.loadHealthHistory('transBlood','con_two_6')">输血</li>
    </ul>
</div>
<div class="Contentbox">
    <!-- 疾病史 -->
    <div id="con_two_1">
        <c:choose> <c:when test="${not empty healthHistoryDTO.diseaseHistoryList}">
            <div class="repeattable">
                <table class="layui-table x-admin-sm-table-list-middle" style="margin: 2px 0px;">
                    <thead>
                    <tr>
                        <th style="height: 22px;padding: 0px;">诊断日期</th>
                        <th style="height: 22px;padding: 0px;">疾病名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="diseaseHistory" items="${healthHistoryDTO.diseaseHistoryList}">
                        <tr>
                            <td style="padding: 0px;"><fmt:formatDate value="${diseaseHistory.confirmationDate }" pattern="yyyy/MM/dd "/></td>
                            <td style="padding: 0px;">
                                <c:choose> 
	                                <c:when test="${diseaseHistory.diseaseCode eq '211' }">
	                                    <a href="#this" onclick="ehrbrowserServiceIndex.sameDiease('${diseaseHistory.personId}','${diseaseHistory.diseaseCode}','${diseaseHistory.otherDesc}',1)"> ${diseaseHistory.otherDesc}</a>
	                                </c:when> 
	                                <c:otherwise>
	                                	<a href="#this" onclick="ehrbrowserServiceIndex.sameDiease('${diseaseHistory.personId}', '${diseaseHistory.diseaseCode}','${diseaseHistory.diseaseName}',1)"> ${diseaseHistory.diseaseName}</a>
	                                </c:otherwise> 
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when> <c:otherwise>
            <div style="text-align: left;margin-left: 10px;">没有记录</div>
        </c:otherwise> </c:choose>
    </div>

    <!-- 手术史 -->
    <div id="con_two_2" style="display:none">
        <c:choose> <c:when test="${not empty healthHistoryDTO.surgeryHistoryList}">
            <div class="repeattable">
                <table class="layui-table x-admin-sm-table-list-middle" style="margin: 2px 0px;">
                    <thead>
                    <tr>
                        <th style="height: 22px;padding: 0px;">手术日期</th>
                        <th style="height: 22px;padding: 0px;">手术名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="surgeryHistory" items="${healthHistoryDTO.surgeryHistoryList}">
                        <tr>
                            <td style="padding: 0px;"><fmt:formatDate value="${surgeryHistory.opsDate}" pattern="yyyy/MM/dd "/></td>
                            <td style="padding: 0px;"><tags:textWithTip value="${surgeryHistory.opsName }"></tags:textWithTip></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when> <c:otherwise>
            <div style="text-align: left;margin-left: 10px;margin-top: 10px;">没有记录</div>
        </c:otherwise> </c:choose></div>

    <!-- 过敏史 -->
    <div id="con_two_3" style="display:none">
        <c:choose> <c:when test="${not empty healthHistoryDTO.drugAllergyHistoryList}">
            <div class="repeattable">
                <table class="layui-table x-admin-sm-table-list-middle" style="margin: 2px 0px;">
                    <thead>
                    <tr>
                        <th style="height: 22px;padding: 0px;">过敏源</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="drugAllergyHistory" items="${healthHistoryDTO.drugAllergyHistoryList}">
                        <tr>
                            <td style="padding: 0px;"><tags:textWithTip value="${drugAllergyHistory.allergensName}"></tags:textWithTip></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when> <c:otherwise>
            <div style="text-align: left;margin-left: 10px;">没有记录</div>
        </c:otherwise> </c:choose>
    </div>

    <!-- 预防接种史 -->
    <div id="con_two_4" style="display:none">
        <c:choose> <c:when test="${not empty healthHistoryDTO.vaccinationInfoList}">
            <div class="repeattable">
                <table class="layui-table x-admin-sm-table-list-middle" style="margin: 2px 0px;">
                    <thead>
                    <tr>
                        <th style="height: 22px;padding: 0px;">接种日期</th>
                        <th style="height: 22px;padding: 0px;">接种名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="vaccinationInfo" items="${healthHistoryDTO.vaccinationInfoList}">
                        <tr>
                            <td style="padding: 0px;"><fmt:formatDate value="${vaccinationInfo.vaccinationDate}" pattern="yyyy/MM/dd "/></td>
                            <td style="padding: 0px;"><tags:textWithTip value="${vaccinationInfo.vaccineName}"></tags:textWithTip></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when> <c:otherwise>
            <div style="text-align: left;margin-left: 10px;">没有记录</div>
        </c:otherwise> </c:choose>
    </div>
    <!-- 住院-->
    <div id="con_two_5" style="display:none">
        <c:choose> <c:when test="${not empty healthHistoryDTO.hospitalizedHistories}">
            <div class="repeattable">
                <table class="layui-table x-admin-sm-table-list-middle" style="margin: 2px 0px;">
                    <thead>
                    <tr>
                        <th style="height: 22px;padding: 0px;">住院日期</th>
                        <th style="height: 22px;padding: 0px;">住院机构</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="hospitalizedHistory" items="${healthHistoryDTO.hospitalizedHistories}">
                        <tr>
                            <td style="padding: 0px;"><fmt:formatDate value="${hospitalizedHistory.inDate}" pattern="yyyy/MM/dd "/></td>
                            <td style="padding: 0px;"><tags:textWithTip value="${hospitalizedHistory.inputOrganName }"></tags:textWithTip></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when> <c:otherwise>
            <div style="text-align: left;margin-left: 10px;">没有记录</div>
        </c:otherwise> </c:choose>
    </div>
    <!-- 输血史-->
    <div id="con_two_6" style="display:none">
        <c:choose> <c:when test="${not empty healthHistoryDTO.transBloodHistories}">
            <div class="repeattable">
                <table class="layui-table x-admin-sm-table-list-middle" style="margin: 2px 0px;">
                    <thead>
                    <tr>
                        <th style="height: 22px;padding: 0px;">输血日期</th>
                        <th style="height: 22px;padding: 0px;">输血原因</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="transBloodHistory" items="${healthHistoryDTO.transBloodHistories}">
                        <tr>
                            <td style="padding: 0px;"><fmt:formatDate value="${transBloodHistory.bloodDate}" pattern="yyyy/MM/dd "/>${transBloodHistory.bloodReason}</td>
                            <td style="padding: 0px;"><ehr:tip>${transBloodHistory.bloodReason}</ehr:tip></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when> <c:otherwise>
            <div style="text-align: left;margin-left: 10px;">没有记录</div>
        </c:otherwise> </c:choose>
    </div>
</div>