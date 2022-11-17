<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="repeattable">
    <table>
    <colgroup>
        <col style="width: 20%;" />
        <col style="width: 20%;" />
        <col style="width: 20%;" />
        <col style="width: 20%;" />
        <col style="width: 20%;" />
    </colgroup>
        <thead>
        <tr>
            <th>管理机构</th>
            <th>管理卡数</th>
            <th>监测次数</th>
            <th>复查次数</th>
            <th>随访次数</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${reports}" var="report">
                <tr>
                    <td><ehr:tip><ehr:org code="${report.manageOrgCode}" /></ehr:tip></td>
                    <td>${report.healthCardNum}</td>
                    <td>${report.monitorNum}</td>
                    <td>${report.reviewNum}</td>
                    <td>${report.followupNum}</td>
                </tr>
            </c:forEach>
            <c:if test="${total!=null}">
                <tr>
                    <td><b>合计</b></td>
                    <td>${total.healthCardNum}</td>
                    <td>${total.monitorNum}</td>
                    <td>${total.reviewNum}</td>
                    <td>${total.followupNum}</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>
