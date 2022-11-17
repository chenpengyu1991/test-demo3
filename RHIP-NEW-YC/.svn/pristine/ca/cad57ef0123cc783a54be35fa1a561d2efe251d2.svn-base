<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table  class="layui-table x-admin-sm-table-list-middle">
    <colgroup>
            <col style="min-width:150px;width: 12%;"/>
            <col style="min-width:80px;width: 18%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 8%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>身份证号</th>
            <th>出生时间</th>
            <th>联系电话</th>
            <th>登记机构</th>
            <th>登记日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="woman" items="${womanList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${woman.motherName}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${woman.idcard}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${woman.birthday}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd"><ehr:tip>${woman.phoneNumber}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${woman.inputOrganName}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${woman.checkDate}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd">
                    <a href="javascript:void(0)" onclick="womanSearch.motherhoodPeriodFollowupDetail(${woman.id})"
                       class="person-link-btn">查看</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table>
        <tr>
            <ehr:pagination action="womanSearch.search"/>
        </tr>
    </table>
</div>