<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>

<div class="repeattable" style="overflow-x: auto; overflow-y: auto; min-width: 1700px; width: 100%; height: 450px;">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 200px;">
            <c:forEach items="${remindTypes}" var="remindType" varStatus="status">
                <%--  <c:if test="${remindType.itemCode != '18' and  remindType.itemCode!='17'}">--%>
               <%--  <c:if test="${remindType.itemCode != '18' && remindType.itemCode != '16'}">
                </c:if> --%>
                    <col style="width: 120px;">
            </c:forEach>
        </colgroup>
        <thead>
        <tr>
            <th>机构</th>
        <c:forEach items="${remindTypes}" var="remindType" varStatus="status">
          <%--  <c:if test="${remindType.itemCode != '18' and  remindType.itemCode!='17'}">--%>
           <%--  <c:if test="${remindType.itemCode != '18' && remindType.itemCode != '16'}">
            </c:if> --%>
             <th>
                     <ehr:dic dicmeta="FS990016" code="${remindType.itemCode}"/>
             </th>
        </c:forEach>
        </tr>
        </thead>
        <tbody class="tbody">


        <c:forEach items="${remindStatisticsList}" var="remindStatistics" varStatus="status">
        <tr>
            <td>${remindStatistics.organName}</td>
            <c:forEach items="${remindTypes}" var="remindType" varStatus="status">
               <%--  <c:if test="${remindType.itemCode != '18' && remindType.itemCode != '16'}">
                </c:if> --%>
                <c:set var="count" value="count${status.index + 1}"/>
                <td>${remindStatistics[count]}</td>
            </c:forEach>
<%--
            <td>${remindStatistics.count1}</td>
            <td>${remindStatistics.count2}</td>
            <td>${remindStatistics.count3}</td>
            <td>${remindStatistics.count4}</td>
            <td>${remindStatistics.count5}</td>
            <td>${remindStatistics.count6}</td>--%>
        </tr>
        </c:forEach>

        </tbody>
    </table>

</div>
