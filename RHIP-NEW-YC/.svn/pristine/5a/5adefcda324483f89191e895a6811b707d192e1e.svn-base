<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="repeattable">
    <form id="infectEmerListForm">
    <table>
    <colgroup>
        <col style="width: 60px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
    </colgroup>
        <thead>
        <tr>
            <th rowspan="2">机构</th>
            <th colspan="7">传染病及突发公共卫生事件报告和处理(含死因报告)</th>
        </tr>
        <tr>
            <th>发生传染病人数(人)</th>
            <th>报告传染病人数(人)</th>
            <th>报告及时的传染病人数(人)</th>
            <th>应报告突发公共卫生事件相关信息数(次)</th>
            <th>实报告突发公共卫生事件相关信息数(次)</th>
            <th>及时报告突发公共卫生事件相关信息数(次)</th>
            <th>网络报告死亡数(人)</th>
        </tr>
        </thead>
        <tbody id="noModifyTbody">
           <c:if test="${ROLE ne '02' && countType eq '2'}">
           <c:forEach items="${infectEmergenciesList}" var="infectEmergenciesList">
           <tr>
               <td>${infectEmergenciesList.orgName}</td>
               <%--<td>本季度</td>--%>
               <td><c:out value="${infectEmergenciesList.occurInfectiousNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.reportInfectiousNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.timelyInfectiousNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.occurEmergenciesNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.reportEmergenciesNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.timelyEmergenciesNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.netReportDeathnum}"></c:out></td>
           </tr>
           </c:forEach>
               <tr>
                   <td><b>合计</b></td>
                       <%--<td>本季度</td>--%>
                   <td><c:out value="${total.occurInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.reportInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.timelyInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.occurEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.reportEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.timelyEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.netReportDeathnum}"></c:out></td>
               </tr>
           </c:if>
           <c:if test="${ROLE ne '02' && countType eq '1'}">
           <c:forEach items="${infectEmergenciesList}" var="infectEmergenciesList">
           <tr>
               <td>${infectEmergenciesList.orgName}</td>
               <%--<td>本年度累计</td>--%>
               <td><c:out value="${infectEmergenciesList.yearOccurInfectiousNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.yearReportInfectiousNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.yearTimelyInfectiousNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.yearOccurEmergenciesNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.yearReportEmergenciesNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.yearTimelyEmergenciesNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.yearNetReportDeathnum}"></c:out></td>
           </tr>
           </c:forEach>
               <tr>
                   <td><b>合计</b></td>
                       <%--<td>本年度累计</td>--%>
                   <td><c:out value="${total.yearOccurInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.yearReportInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.yearTimelyInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.yearOccurEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.yearReportEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.yearTimelyEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.yearNetReportDeathnum}"></c:out></td>
               </tr>
           </c:if>
           <c:if test="${ROLE eq '02' && countType eq '2'}">
            <tr>
                <td>${currentOrgName}</td>
                <td><c:out value="${infectEmergencies.occurInfectiousNum}"></c:out></td>
                <td><c:out value="${infectEmergencies.reportInfectiousNum}"></c:out></td>
                <td><c:out value="${infectEmergencies.timelyInfectiousNum}"></c:out></td>
                <td><c:out value="${infectEmergencies.occurEmergenciesNum}"></c:out></td>
                <td><c:out value="${infectEmergencies.reportEmergenciesNum}"></c:out></td>
                <td><c:out value="${infectEmergencies.timelyEmergenciesNum}"></c:out></td>
                <td><c:out value="${infectEmergencies.netReportDeathnum}"></c:out></td>
            </tr>
               <tr>
                   <td><b>合计</b></td>
                   <td><c:out value="${total.occurInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.reportInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.timelyInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.occurEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.reportEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.timelyEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.netReportDeathnum}"></c:out></td>
               </tr>
            </c:if>
           <c:if test="${ROLE eq '02' && countType eq '1'}">
            <tr>
                <td>${currentOrgName}</td>
                <td><c:out value="${infectEmergencies.yearOccurInfectiousNum}"></c:out></td>
                <td><c:out value="${infectEmergencies.yearReportInfectiousNum}"></c:out></td>
                <td><c:out value="${infectEmergencies.yearTimelyInfectiousNum}"></c:out></td>
                <td><c:out value="${infectEmergencies.yearOccurEmergenciesNum}"></c:out></td>
                <td><c:out value="${infectEmergencies.yearReportEmergenciesNum}"></c:out></td>
                <td><c:out value="${infectEmergencies.yearTimelyEmergenciesNum}"></c:out></td>
                <td><c:out value="${infectEmergencies.yearNetReportDeathnum}"></c:out></td>
            </tr>
               <tr>
                   <td><b>合计</b></td>
                   <td><c:out value="${total.yearOccurInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.yearReportInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.yearTimelyInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.yearOccurEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.yearReportEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.yearTimelyEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.yearNetReportDeathnum}"></c:out></td>
               </tr>
        </c:if>
        </tbody>
        <tbody id="modifyTbody" style="display: none">
        <input type="hidden" name="id" value="${infectEmergencies.id}"/>
        <tr>
            <td>${currentOrgName}</td>
            <%--<td>本季度</td>--%>
            <td><tag:numberInput name="occurInfectiousNum" id="occurInfectiousNum" value="${infectEmergencies.occurInfectiousNum}"/></td>
            <td><tag:numberInput name="reportInfectiousNum" id="reportInfectiousNum" value="${infectEmergencies.reportInfectiousNum}"/></td>
            <td><tag:numberInput name="timelyInfectiousNum" id="timelyInfectiousNum" value="${infectEmergencies.timelyInfectiousNum}"/></td>
            <td><tag:numberInput name="occurEmergenciesNum" id="occurEmergenciesNum" value="${infectEmergencies.occurEmergenciesNum}"/></td>
            <td><tag:numberInput name="reportEmergenciesNum" id="reportEmergenciesNum" value="${infectEmergencies.reportEmergenciesNum}"/></td>
            <td><tag:numberInput name="timelyEmergenciesNum" id="timelyEmergenciesNum" value="${infectEmergencies.timelyEmergenciesNum}"/></td>
            <td><tag:numberInput name="netReportDeathnum" id="netReportDeathnum" value="${infectEmergencies.netReportDeathnum}"/></td>
        </tr>
        </tbody>
    </table>
    </form>
</div>
