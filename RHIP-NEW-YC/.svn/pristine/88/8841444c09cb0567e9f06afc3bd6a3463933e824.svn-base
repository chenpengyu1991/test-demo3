<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
	<table class="posttable">
		<colgroup>
			<col style="min-width:150px;width:18%;"/>
	        <col/>
			<col style="min-width:80px;width:18%;"/>
	        <col/>
		</colgroup>
		<tr>
			<th>事件编码：</th>
			<td style="text-align: left">${result.eventNo}</td>
			<th>事故编码：</th>
            <td style="text-align: left">${result.alarmNo}</td>
		</tr>
		<tr>
			<th>首次呼救电话：</th>
            <td style="text-align: left">${result.firstCall}</td>
			<th>事件名称：</th>
            <td style="text-align: left">${result.eventTitle}</td>
		</tr>
		<tr>
		    <th>首次调度员：</th>
            <td style="text-align: left">${result.firstDispatcher}</td>
            <th>首次受理时刻：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.firstAcceptTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
		</tr>
        <tr>
            <th>是否挂起：</th>
            <td style="text-align: left">
                <c:if test="${result.isHold eq 1}">
                    是
                </c:if>
                <c:if test="${result.isHold eq 0}">
                    否
                </c:if>
            </td>
            <th>是否测试：</th>
            <td style="text-align: left">
                <c:if test="${result.isTest eq 1}">
                    是
                </c:if>
                <c:if test="${result.isTest eq 0}">
                    否
                </c:if>
            </td>
        </tr>
        <tr>
            <th>是否标注：</th>
            <td style="text-align: left">
                <c:if test="${result.isFlag eq 1}">
                    是
                </c:if>
                <c:if test="${result.isFlag eq 0}">
                    否
                </c:if>
            </td>
            <th>经度：</th>
            <td style="text-align: left">${result.longitude}</td>
        </tr>
        <tr>
            <th>纬度：</th>
            <td style="text-align: left">${result.latitude}</td>
            <th>中心编码：</th>
            <td style="text-align: left">${result.centerNo}</td>
        </tr>
	</table>
</div>