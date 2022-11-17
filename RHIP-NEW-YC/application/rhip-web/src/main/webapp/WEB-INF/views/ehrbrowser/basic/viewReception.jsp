<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%--<script src="${pageContext.request.contextPath}/js/views/ehr/person/reception.js" type="text/javascript"></script>--%>
        <style>
            #receptionViewDiv s.pop_No{width:500px;}
        </style>
<div class="Contentbox" style="text-align: left; width: 99%">
    <i class="pop_No">
        <a></a>
    </i>
    <div id="receptionViewDiv" style="text-align: left;">
        <div class="postcontent" style="padding: 0 10px 0 10px;">
            <h1 align="center"><span style="font-size: 24px;">接诊记录表</span></h1>
            <div style="height: 40px;margin-top: 10px">
                <span class="span_floatleft">&emsp;&emsp;<b>姓名：</b>${personInfo.name}</span>
                <c:choose>
                    <c:when test="${not empty personInfo.healthFileNoHtml}">
                        ${personInfo.healthFileNoHtml}
                    </c:when>
                    <c:otherwise>
                        <s class="pop_No" >
                            <span class="text"><b>编号：</b></span>
                            <span></span><span></span><span></span><span></span><span></span>
                            <span class="line">-</span>
                            <span></span><span></span><span></span>
                            <span class="line">-</span>
                            <span></span><span></span><span></span>
                            <span class="line">-</span>
                            <span></span><span></span><span></span><span></span>
                        </s>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <hr style="width: 100%"/>
        <div class="postdiv">
            <table class="posttable" style="width: 100%;margin-top: 10px">
                <colgroup>
                    <col style="width: 20%"/>
                    <col style="width: 30%"/>
                    <col style="width: 50%"/>
                </colgroup>
                <tr>
                    <th>就诊者的主观资料：</th>
                    <td colspan="2">${reception.subjectiveData}</td>
                </tr>
                <tr>
                    <th>就诊者的客观资料：</th>
                    <td colspan="2">
                        <c:forEach items="${studyEvents}" var="studyEvent" varStatus="status">
                            ${studyEvent.inspectionItemName}
                            <c:if test="${!status.last}">
                                ，
                            </c:if>
                        </c:forEach>
                        <br/>
                        <c:forEach items="${examineEvents}" var="examineEvent" varStatus="status">
                            ${examineEvent.checkListTitle}
                            <c:if test="${!status.last}">
                                ，
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <th>评估：</th>
                    <td colspan="2">${reception.assessment}</td>
                </tr>
                <tr>
                    <th>处置计划：</th>
                    <td colspan="2">
                        <c:forEach items="${outpatientReportDTO.recordNumnerDrugs}" var="records">
                            <div style="float:left;">
                                <img  src="${pageContext.request.contextPath}/images/R.png" style="width:28px;height:30px;"/>
                            </div>
                            <div style="margin-left: 20px!important;margin-top:10px!important;float:left;width:90%;">
                                <c:forEach items="${records}" var="record">
                                    <c:if test="${record.key ne 'recordNumber'}">
                                        <span style="font-weight: bold">处方号：<c:out value="${record.key }"></c:out></span><br />
                                        <c:forEach items="${record.value}" var="outpatientReport">
                                            <c:out value="${outpatientReport.drugGenericName }"></c:out>
                                            &lt;<c:out value="${outpatientReport.drugSpecifications }"></c:out>&gt; X
                                            <c:out value="${outpatientReport.quantity }"></c:out>
                                            <c:out value="${outpatientReport.quantityUnit }"></c:out>
                                            <div style="margin-left: 20px">
                                                Sig:
                                                <c:if test="${not empty outpatientReport.drugUseDose}">
                                                    每次用量:
                                                    <c:out value="${outpatientReport.drugUseDose }"></c:out>
                                                    <c:out value="${outpatientReport.drugUseDoseUnit }"></c:out>
                                                </c:if>
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <c:if test="${not empty outpatientReport.drugUseFrequency}">
                                                    <c:out value="${outpatientReport.drugUseFrequency }"></c:out>
                                                    <c:if test="${not empty outpatientReport.drugUseDays}">X</c:if>
                                                </c:if>
                                                <c:out value="${outpatientReport.drugUseDays }"></c:out>
                                                <c:if test="${not empty outpatientReport.drugUseDays}">
                                                    天
                                                </c:if>
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <ehr:dic dicmeta="CV0600102" code="${outpatientReport.drugUseRouteCode }"/>
                                            </div>
                                        </c:forEach>
                                    </c:if>
                                </c:forEach>
                                处方医生：<%--${records.recordNumber}--%>${outpatientReportDTO.prescribeDoctorName}
                            </div>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td colspan="3" align="right"><b>责任医生：</b>${reception.manageDoctorName}</td>
                </tr>
                <tr>
                    <td colspan="3" align="right"><b>接诊日期：</b><fmt:formatDate value="${reception.receptionDate}" pattern="yyyy/MM/dd"/></td>
                </tr>
            </table>
        </div>
    </div>
</div>
