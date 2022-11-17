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
			<th>车辆编码：</th>
			<td style="text-align: left">${result.tambulanceNo}</td>
			<th>分站编码：</th>
            <td style="text-align: left">${result.stationNo}</td>
		</tr>
		<tr>
			<th>实际标识：</th>
            <td style="text-align: left">${result.actualMark}</td>
			<th>车牌号码：</th>
            <td style="text-align: left">${result.busNo}</td>
		</tr>
		<tr>
		    <th>车辆类型：</th>
            <td style="text-align: left">${result.vehicleType}</td>
            <th>任务编码：</th>
            <td style="text-align: left">${result.taskNum}</td>
		</tr>
        <tr>
            <th>工作状态编码：</th>
            <td style="text-align: left">${result.stateNo}</td>
            <th>司机：</th>
            <td style="text-align: left">${result.driver}</td>
        </tr>
        <tr>
            <th>医生：</th>
            <td style="text-align: left">${result.doctor}</td>
            <th>护士：</th>
            <td style="text-align: left">${result.nurse}</td>
        </tr>
        <tr>
            <th>担架工：</th>
            <td style="text-align: left">${result.stretcher}</td>
            <th>车载电话：</th>
            <td style="text-align: left">${result.carTelphone}</td>
        </tr>
        <tr>
            <th>GPS时间：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.gpsTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
            <th>经度：</th>
            <td style="text-align: left">${result.longitude}</td>
        </tr>
        <tr>
            <th>纬度：</th>
            <td style="text-align: left">${result.latitude}</td>
            <th>高度：</th>
            <td style="text-align: left">${result.height}</td>
        </tr>
        <tr>
            <th>速度：</th>
            <td style="text-align: left">${result.speed}</td>
            <th>方向：</th>
            <td style="text-align: left">${result.direction}</td>
        </tr>
        <tr>
            <th>中心编码：</th>
            <td style="text-align: left">${result.centerNo}</td>
            <th>是否有效：</th>
            <td style="text-align: left">
                <c:if test="${result.isValid eq 1}">
                    是
                </c:if>
                <c:if test="${result.isValid eq 0}">
                    否
                </c:if>
            </td>
        </tr>
	</table>
</div>