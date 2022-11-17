<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.idm.common.MalariaStatus" %>
<c:set var="VERIFY" value="<%=MalariaStatus.VERIFY.getValue()%>" />
<c:set var="WRITE" value="<%=MalariaStatus.WRITE.getValue()%>" />
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:70px;width:140px;"/>
            <col style="min-width:60px;width:100px;"/>
            <col style="min-width:50px;width:100px;"/>
            <col/>
            <col/>
            <col/>
            <col/>
            <col style="min-width:80px;width:100px;"/>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>象皮肿</th>
            <th>乳糜尿</th>
            <th>鞘膜积液</th>
            <th>淋巴管（结）</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="caseInfo" items="${statusInfo}" varStatus="status">
            <c:if test="${caseInfo.filDto.chyluria == 1 || caseInfo.filDto.lymphedema == 1}">
            <c:if test="${'1' == caseInfo.filDto.logoff}">
                <tr class="offedperson">
            </c:if>
            <c:if test="${'1' == report.logoff}">
                <tr>
            </c:if>
                <td class="centertd">${caseInfo.filDto.name}</td>
                <td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${caseInfo.filDto.gender}" /></td>
                <td class="centertd"><ehr:tip>${caseInfo.filDto.age}</ehr:tip></td>
                <td class="centertd"><c:if test="${caseInfo.filDto.lymphedema == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${caseInfo.filDto.chyluria == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${caseInfo.filDto.tunicaVaginali == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${caseInfo.filDto.lymphatic == 1}">√</c:if></td>
                <td class="centertd">
                    <a href="javascript:void(0)" title="随访情况" onclick="filStandard.initFollowUp(${caseInfo.filDto.singleId},${caseInfo.filDto.lymphedema},${caseInfo.filDto.chyluria},${caseInfo.filDto.logoff})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe60e;</i>随访</a>
                </td>
            </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>

    <table>
        <tr>
            <ehr:pagination action="filStandard.searchFollowup" />
        </tr>
    </table>
</div>