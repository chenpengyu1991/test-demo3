<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="repeattable" >
    <div id="frontMachineTopDiv">
    <table id="frontMachineTable" >
    	<colgroup>
			<col style="width: 20px;" />
			<col style="width: 180px;" />
			<col style="width: 80px;" />
			<col style="width: 150px;" />
			<col style="width: 110px;" />
			<col style="width: 150px;" />
		</colgroup>
		<thead>
			<tr>
				<th>序号</th>
				<th>医院名称</th>
				<th>东方通运行情况</th>
				<th>IP地址</th>
				<th>系统类型</th>			
				<th>备注</th>
			</tr>
		</thead>
    </table>
    <div id="frontMachineDiv" class="contentfixed126" style="top:96px;">
    <table>
        <colgroup>
            <col style="width: 20px;" />
            <col style="width: 180px;" />
            <col style="width: 80px;" />
            <col style="width: 150px;" />
            <col style="width: 110px;" />
            <col style="width: 150px;" />
        </colgroup>
		<tbody>
			<c:forEach items="${organizations}" var="organization" varStatus="status">
				<tr>
					<td style="text-align: left;" >${status.count}</td>
					<td><tags:textWithTip value="${organization.organName}"></tags:textWithTip></td>
					<td style="text-align: left">${organization.statusName}</td>
					<td style="text-align: left" >${organization.machineAddress}</td>
					<td>Windows2003</td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
    </div>
    </div>
</div>
