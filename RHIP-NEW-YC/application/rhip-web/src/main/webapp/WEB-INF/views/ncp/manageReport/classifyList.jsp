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
            <th rowspan="2">管理机构</th>
            <th colspan="2">确诊病例</th>
            <th rowspan="2">疑似病例</th>
            <th rowspan="2">无症状感染</th>
        </tr>
        <tr>
            <th>县内治疗</th>
            <th>县外治疗</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${reports}" var="report">
                <tr>
                    <td><ehr:tip><ehr:org code="${report.manageOrgCode}" /></ehr:tip></td>
                    <td>${report.insideTreatNum}</td>
                    <td>${report.outsideTreatNum}</td>
                    <td>${report.suspectedNum}</td>
                    <td>${report.asymptomaticNum}</td>
                </tr>
            </c:forEach>
            <c:if test="${total!=null}">
                <tr>
                    <td><b>合计</b></td>
                    <td>${total.insideTreatNum}</td>
                    <td>${total.outsideTreatNum}</td>
                    <td>${total.suspectedNum}</td>
                    <td>${total.asymptomaticNum}</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>
