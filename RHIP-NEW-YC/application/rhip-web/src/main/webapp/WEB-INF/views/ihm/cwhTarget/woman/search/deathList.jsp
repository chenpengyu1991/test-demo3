<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table>
        <colgroup>
            <col style="min-width:150px;width: 12%;"/>
            <col style="min-width:80px;width: 8%;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 8%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>身份证号</th>
            <th>分娩时间</th>
            <th>分娩孕周</th>
            <th>分娩方式</th>
            <th>助产机构</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="child" items="${womanList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${child.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${child.idcard}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${child.deliveryDay}" pattern="yyyy/MM/dd HH:mm"></fmt:formatDate></ehr:tip></td>
                <td class="centertd"><ehr:tip>${child.deliveryWeek}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${child.deliveryWay}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${child.midwiferyOrganName}</ehr:tip></td>
                <td class="centertd">
                    <a href="javascript:void(0)" onclick="childSearch.viewBirthCertificate(${child.id})"
                       class="person-link-btn">查看</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table>
        <tr>
            <ehr:pagination action="childSearch.search"/>
        </tr>
    </table>
</div>