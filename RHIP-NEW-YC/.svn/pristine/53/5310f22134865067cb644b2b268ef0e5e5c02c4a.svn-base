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
            <col style="min-width:70px;width:120px;"/>
            <col style="min-width:60px;width:80px;"/>
            <col style="min-width:50px;width:80px;"/>
            <col style="min-width:50px;width:140px;"/>
            <col/>
            <col style="min-width:80px;width:100px;"/>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>电话</th>
            <th>住址</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="caseInfo" items="${statusInfo}" varStatus="status">
            <c:if test="${caseInfo.filDto.chyluria == 1 || caseInfo.filDto.lymphedema == 1}">
            <tr>
            <c:if test="${'1' == caseInfo.filDto.logoff}">
                <tr class="offedperson">
            </c:if>
            <c:if test="${'1' == report.logoff}">
                <tr>
            </c:if>
                <td class="centertd" title="${caseInfo.filDto.name}">
                    ${caseInfo.filDto.name}
                </td>
                <td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${caseInfo.filDto.gender}" /></td>
                <td class="centertd"><ehr:tip>${caseInfo.filDto.age}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${caseInfo.filDto.phoneNumber}</ehr:tip></td>
                <td>
                <ehr:tip>${caseInfo.filDto.paAddress}</ehr:tip>
                </td>
                <td class="centertd">
                	<a title="督导检查" class="person-link-btn layui-btn layui-btn-xs" href="javascript:void(0)" onclick="filStandard.initSc(${caseInfo.filDto.singleId},${caseInfo.filDto.logoff})" style="color: #FFF;font-size: 12px;">督导检查</a>
                    <%-- <a href="javascript:void(0)" onclick="filStandard.initSc(${caseInfo.filDto.singleId},${caseInfo.filDto.logoff})"class="person-link-btn">督导检查</a> --%>
                </td>
            </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>

    <table>
        <tr>
            <ehr:pagination action="filStandard.searchSc" />
        </tr>
    </table>
</div>