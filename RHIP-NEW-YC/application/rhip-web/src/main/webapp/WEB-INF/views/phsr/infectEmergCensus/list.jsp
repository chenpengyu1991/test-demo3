<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="repeattable">
    <form id="infectEmerListForm">
    <table class="layui-table x-admin-sm-table-list-middle">
    <colgroup>
    	<col style="width: 40px;" />
        <col style="width: 60px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
        <col style="width: 46px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
        <col style="width: 46px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
        <col style="width: 46px;" />
    </colgroup>
        <thead>
        <tr>
         	<th rowspan="2">区县</th>
            <th rowspan="2">机构</th>
            <th colspan="9">传染病及突发公共卫生事件报告和处理统计报表</th>
        </tr>
        <tr>
            <th>登记传染病病例数</th>
            <th>网络报告的传染病病例数</th>
            <th>传染病疫情报告率</th>
            <th>报告传染病病例数</th>
            <th>报告及时的病例数</th>
            <th>传染病疫情报告及时率</th>
            <th>报告突发公共卫生事件相关信息数</th>
            <th>及时报告的突发公共卫生事件相关信息数</th>
            <th>突发公共卫生事件相关信息报告率</th>
        </tr>
        </thead>
        <tbody id="noModifyTbody">
           <c:forEach items="${infectEmergenciesList}" var="infectEmergenciesList">
           <tr>
           		<td>
						<ehr:tip><ehr:dic code="${infectEmergenciesList.gbCode}" dicmeta="FS990001"  /></ehr:tip>
				</td>
               <td>
						<ehr:tip><ehr:org code="${infectEmergenciesList.orgCode}" /></ehr:tip>
				</td>
               <%--<td>本季度</td>--%>
               <td><c:out value="${infectEmergenciesList.registerInfectiousNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.networkInfectiousNum}"></c:out></td>
               <td><fmt:formatNumber value="${infectEmergenciesList.registerInfectiousNum==0?0:(infectEmergenciesList.networkInfectiousNum/infectEmergenciesList.registerInfectiousNum)*100}" pattern="#,##0.0"/>% </td>
               <td><c:out value="${infectEmergenciesList.reportInfectiousNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.timelyInfectiousNum}"></c:out></td>
               <td><fmt:formatNumber value="${infectEmergenciesList.reportInfectiousNum==0?0:(infectEmergenciesList.timelyInfectiousNum/infectEmergenciesList.reportInfectiousNum)*100}" pattern="#,##0.0"/>% </td>
               <td><c:out value="${infectEmergenciesList.occurEmergenciesNum}"></c:out></td>
               <td><c:out value="${infectEmergenciesList.timelyEmergenciesNum}"></c:out></td>
               <td><fmt:formatNumber value="${infectEmergenciesList.occurEmergenciesNum==0?0:(infectEmergenciesList.timelyEmergenciesNum/infectEmergenciesList.occurEmergenciesNum)*100}" pattern="#,##0.0"/>% </td>
           </tr>
           </c:forEach>
            <c:if test="${total!=null}">
               <tr>
                   <td colspan="2"><b>合计</b></td>
                       <%--<td>本季度</td>--%>
	               <td><c:out value="${total.registerInfectiousNum}"></c:out></td>
	               <td><c:out value="${total.networkInfectiousNum}"></c:out></td>
	               <td><fmt:formatNumber value="${total.registerInfectiousNum==0?0:(total.networkInfectiousNum/total.registerInfectiousNum)*100}" pattern="#,##0.0"/>% </td>
                   <td><c:out value="${total.reportInfectiousNum}"></c:out></td>
                   <td><c:out value="${total.timelyInfectiousNum}"></c:out></td>
                   <td><fmt:formatNumber value="${total.reportInfectiousNum==0?0:(total.timelyInfectiousNum/total.reportInfectiousNum)*100}" pattern="#,##0.0"/>% </td>
                   <td><c:out value="${total.occurEmergenciesNum}"></c:out></td>
                   <td><c:out value="${total.timelyEmergenciesNum}"></c:out></td>
                   <td><fmt:formatNumber value="${total.occurEmergenciesNum==0?0:(total.timelyEmergenciesNum/total.occurEmergenciesNum)*100}" pattern="#,##0.0"/>% </td>
               </tr>
            </c:if>
        </tbody>
        <tbody id="modifyTbody" style="display: none">
        <tr>
       		<td>
       			<input type="hidden" name="id" value="${infectEmergencies.id}"/>
					<ehr:tip><ehr:dic code="${infectEmergencies.gbCode}" dicmeta="FS990001"  /></ehr:tip>
			</td>
				
            <td>${currentOrgName}</td>
            <%--<td>本季度</td>--%>
            <td><tag:numberInput name="registerInfectiousNum" id="registerInfectiousNum" value="${infectEmergencies.registerInfectiousNum}"/></td>
            <td><tag:numberInput name="networkInfectiousNum" id="networkInfectiousNum" value="${infectEmergencies.networkInfectiousNum}"/></td>
            <td><span id="infectPercent"><fmt:formatNumber value="${infectEmergencies.registerInfectiousNum==0?0:(infectEmergencies.networkInfectiousNum/infectEmergencies.registerInfectiousNum)*100}" pattern="#,##0.0"/>%</span></td>
            <td><tag:numberInput name="reportInfectiousNum" id="reportInfectiousNum" value="${infectEmergencies.reportInfectiousNum}"/></td>
            <td><tag:numberInput name="timelyInfectiousNum" id="timelyInfectiousNum" value="${infectEmergencies.timelyInfectiousNum}"/></td>
            <td><span id="infectiousPercent" ><fmt:formatNumber value="${infectEmergencies.reportInfectiousNum==0?0:(infectEmergencies.timelyInfectiousNum/infectEmergencies.reportInfectiousNum)*100}" pattern="#,##0.0"/>%</span></td>
            <td><tag:numberInput name="occurEmergenciesNum" id="occurEmergenciesNum" value="${infectEmergencies.occurEmergenciesNum}"/></td>
            <td><tag:numberInput name="timelyEmergenciesNum" id="timelyEmergenciesNum" value="${infectEmergencies.timelyEmergenciesNum}"/></td>
       		<td><span id="emergenciesPercent"><fmt:formatNumber value="${infectEmergencies.occurEmergenciesNum==0?0:(infectEmergencies.timelyEmergenciesNum/infectEmergencies.occurEmergenciesNum)*100}" pattern="#,##0.0"/>%</span></td>
        </tr>
        </tbody>
    </table>
    </form>
</div>
