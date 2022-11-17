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
			<th>受理编码：</th>
			<td style="text-align: left">${result.acceptNo}</td>
			<th>事件编码：</th>
            <td style="text-align: left">${result.eventNo}</td>
		</tr>
		<tr>
			<th>受理类型：</th>
            <td style="text-align: left">${result.acceptType}</td>
			<th>受理人：</th>
            <td style="text-align: left">${result.assignee}</td>
		</tr>
		<tr>
			<th>电话振铃时刻：</th>
			<td style="text-align: left"><fmt:formatDate value="${result.ringTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
			<th>开始受理时刻：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.beginTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
		</tr>
		<tr>
			<th>结束受理时刻：</th>
			<td style="text-align: left"><fmt:formatDate value="${result.endTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
			<th>发送指令时刻：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.orderTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
		</tr>
		<tr>
		    <th>现场地址：</th>
            <td style="text-align: left">${result.localeAddr}</td>
            <th>等车地址：</th>
            <td style="text-align: left">${result.waitingAddr}</td>
		</tr>
        <tr>
            <th>送往地址：</th>
            <td style="text-align: left">${result.sendToAddr}</td>
            <th>呼救电话：</th>
            <td style="text-align: left">${result.fromCall}</td>
        </tr>
        <tr>
            <th>患者姓名：</th>
            <td style="text-align: left">${result.patName}</td>
            <th>性别：</th>
            <%--<td style="text-align: left"><ehr:dic dicmeta="GBT226112003" code="${result.gender}"></ehr:dic></td>--%>
            <td style="text-align: left">${result.gender}</td>
        </tr>
        <tr>
            <th>年龄：</th>
            <td style="text-align: left">${result.age}</td>
            <th>病种判断：</th>
            <td style="text-align: left">${result.diseaseDiscribe}</td>
        </tr>
	</table>
</div>