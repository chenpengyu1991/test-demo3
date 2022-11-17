<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="repeattable">
    <form id="healthRecordForm">
    <table class="layui-table x-admin-sm-table-list-middle">
    <colgroup>
    	<col style="width: 40px;" />
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
         	<th rowspan="2">区县</th>
            <th rowspan="2">机构</th>
            <th colspan="7">城乡居民健康档案管理统计报表</th>
        </tr>
        <tr>
            <th>辖区内常住居民数</th>
            <th>建档人数</th>
            <th>健康档案建档率</th>
            <th>建立电子健康档案人数</th>
            <th>电子健康档案建档率</th>
            <th>档案中有动态记录的档案份数</th>
            <th>健康档案使用率</th>
        </tr>
        </thead>
        <tbody id="noModifyTbody">
           <c:forEach items="${reports}" var="report">
           <tr>
           		<td>
						<ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"  /></ehr:tip>
				</td>
                <td>
						<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
				</td>
               <td><c:out value="${report.permanentNum}"></c:out></td>
               <%--<td><c:out value="${report.buildRecordNum}"></c:out></td>
               <td><fmt:formatNumber value="${report.permanentNum==0?0:(report.buildRecordNum/report.permanentNum)*100}" pattern="#,##0.0"/>% </td>--%>
               <td><c:out value="${report.buildERecordNum}"></c:out></td>
               <td><fmt:formatNumber value="${report.permanentNum==0?0:(report.buildERecordNum/report.permanentNum)*100}" pattern="#,##0.0"/>% </td>
               <td><c:out value="${report.buildERecordNum}"></c:out></td>
               <td><fmt:formatNumber value="${report.permanentNum==0?0:(report.buildERecordNum/report.permanentNum)*100}" pattern="#,##0.0"/>% </td>
               <td><c:out value="${report.dynamicRecordNum}"></c:out></td>
               <td><fmt:formatNumber value="${report.buildERecordNum==0?0:(report.dynamicRecordNum/report.buildERecordNum)*100}" pattern="#,##0.0"/>% </td>
           </tr>
           </c:forEach>
          	 <c:if test="${total!=null}">
	               <tr>
	                   <td colspan="2"><b>合计</b></td>
		               <td><c:out value="${total.permanentNum}"></c:out></td>
		               <%--<td><c:out value="${total.buildRecordNum}"></c:out></td>
		               <td><fmt:formatNumber value="${total.permanentNum==0?0:(total.buildRecordNum/total.permanentNum)*100}" pattern="#,##0.0"/>% </td>--%>
	                   <td><c:out value="${total.buildERecordNum}"></c:out></td>
	                   <td><fmt:formatNumber value="${total.permanentNum==0?0:(total.buildERecordNum/total.permanentNum)*100}" pattern="#,##0.0"/>% </td>
                       <td><c:out value="${total.buildERecordNum}"></c:out></td>
                       <td><fmt:formatNumber value="${total.permanentNum==0?0:(total.buildERecordNum/total.permanentNum)*100}" pattern="#,##0.0"/>% </td>
	                   <td><c:out value="${total.dynamicRecordNum}"></c:out></td>
	                   <td><fmt:formatNumber value="${total.buildERecordNum==0?0:(total.dynamicRecordNum/total.buildERecordNum)*100}" pattern="#,##0.0"/>% </td>
	               </tr>
               </c:if>
        </tbody>
        <tbody id="modifyTbody" style="display: none">
        <tr>
       		<td>
       				<input type="hidden" name="id" value="${healthRecordCensus.id}"/>
					<ehr:tip><ehr:dic code="${healthRecordCensus.gbCode}" dicmeta="FS990001"  /></ehr:tip>
			</td>
            <td>
					<ehr:tip><ehr:org code="${healthRecordCensus.orgCode}" /></ehr:tip>
			</td>
            <td><span id="permanentNum_span">${healthRecordCensus.permanentNum}</span></td>
            <%--<td><input id="buildRecordNum_id" name="buildRecordNum" value="${healthRecordCensus.buildRecordNum}"/></td>
            <td><span id="buildRecordPercent"><fmt:formatNumber value="${healthRecordCensus.permanentNum==0?0:(healthRecordCensus.buildRecordNum/healthRecordCensus.permanentNum)*100}" pattern="#,##0.0"/>% </span></td>--%>
            <td><input id="buildRecordNum_id" name="buildRecordNum" value="${healthRecordCensus.buildERecordNum}" style="width: 98%;"/></td>
            <td><span id="buildRecordPercent"><fmt:formatNumber value="${healthRecordCensus.permanentNum==0?0:(healthRecordCensus.buildERecordNum/healthRecordCensus.permanentNum)*100}" pattern="#,##0.0"/>% </span></td>
            <td><span>${healthRecordCensus.buildERecordNum}</span></td>
            <td><span ><fmt:formatNumber value="${healthRecordCensus.permanentNum==0?0:(healthRecordCensus.buildERecordNum/healthRecordCensus.permanentNum)*100}" pattern="#,##0.0"/>% </span></td>
            <td><span id="dynamicRecordNum_span">${healthRecordCensus.dynamicRecordNum}</span></td>
       		<td><span id="dynamicRecordPercent"><fmt:formatNumber value="${healthRecordCensus.buildRecordNum==0?0:(healthRecordCensus.dynamicRecordNum/healthRecordCensus.buildRecordNum)*100}" pattern="#,##0.0"/>% </span></td>
        </tr>
        </tbody>
    </table>
    </form>
</div>
