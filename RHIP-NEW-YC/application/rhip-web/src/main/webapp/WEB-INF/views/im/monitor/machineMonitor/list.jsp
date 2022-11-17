<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>

<script src="${pageContext.request.contextPath}/js/views/im/monitor/machineMonitor/list.js" type="text/javascript"></script>

<div class="repeattable">
    <table>
        <colgroup>
            <col style="min-width:120px;width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:15%;"/>
            <col style="width:15%;"/>
            <col style="min-width:80px;width:10%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>名称</th>
            <th>IP</th>
            <th>CPU使用率(%)</th>
            <th>内存使用率(%)</th>
            <th>内存大小(G)</th>
            <th>剩余内存(G)</th>
            <th>磁盘大小(G)</th>
            <th>剩余磁盘(G)</th>
            <th>监控时间</th>
        </tr>
        </thead>
        <tbody class="tbody">
        <c:forEach items="${machineInfoList}" var="machineInfo" varStatus="status">
            <tr>
                <td class="centertd">
                    <ehr:tip>${machineInfo.name}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${machineInfo.ipAddress}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${machineInfo.cpuRate}</ehr:tip>
                </td>
                <td class="centertd">
         			<ehr:tip>${machineInfo.memoryRate}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${machineInfo.memorySize}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip><fmt:formatNumber value="${machineInfo.memorySize-machineInfo.useMemory}" pattern="#0.00"/></ehr:tip>
                </td>
                <td class="centertd">
         			<ehr:tip>${machineInfo.diskTotal}</ehr:tip>
                </td>
                <td class="centertd">
         			<ehr:tip>${machineInfo.diskUnused}</ehr:tip>
                </td>
                 
                <td class="centertd">
                    <ehr:tip><fmt:formatDate value="${machineInfo.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/></ehr:tip>
                </td>
                 
                
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table>
        <tr>
            <ehr:pagination action="machineMonitorSearch.searchReportRecord"/>
        </tr>
    </table>
</div>
