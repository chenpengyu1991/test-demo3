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
			<th>任务编码：</th>
			<td style="text-align: left">${result.taskNo}</td>
			<th>受理编码：</th>
            <td style="text-align: left">${result.acceptNo}</td>
		</tr>
		<tr>
			<th>分站编码：</th>
            <td style="text-align: left">${result.stationNo}</td>
			<th>车辆编码：</th>
            <td style="text-align: left">${result.carId}</td>
		</tr>
        <tr>
            <th>是否结束：</th>
            <td style="text-align: left">
                <c:if test="${result.isEnd eq 1}">
                    是
                </c:if>
                <c:if test="${result.isEnd eq 0}">
                    否
                </c:if>
            </td>
            <th>异常结束原因：</th>
            <td style="text-align: left">${result.exceptionReason}</td>
        </tr>
		<tr>
			<th>生成任务时刻：</th>
			<td style="text-align: left"><fmt:formatDate value="${result.generationTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
			<th>接收命令时刻：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.orderTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
		</tr>
		<tr>
			<th>出车时刻：</th>
			<td style="text-align: left"><fmt:formatDate value="${result.leaveTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
			<th>到达现场时刻：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.arrivedTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
		</tr>
        <tr>
            <th>离开现场时刻：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.leaveLocalTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
            <th>到达医院时刻：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.arrivedHospitalTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
        </tr>
        <tr>
            <th>完成时刻：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.endTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
            <th>返回站中时刻：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.arrivedStationTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
        </tr>
        <tr>
            <th>司机：</th>
            <td style="text-align: left">${result.driver}</td>
            <th>医生：</th>
            <td style="text-align: left">${result.doctor}</td>
        </tr>
        <tr>
            <th>护士：</th>
            <td style="text-align: left">${result.nurse}</td>
            <th>担架工：</th>
            <td style="text-align: left">${result.stretcher}</td>
        </tr>
        <tr>
            <th>实际送往地点：</th>
            <td style="text-align: left">${result.sendToPlace}</td>
        </tr>
	</table>
</div>