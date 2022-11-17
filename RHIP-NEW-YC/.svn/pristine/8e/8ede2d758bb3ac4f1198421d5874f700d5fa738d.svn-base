<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
	<table class="posttable">
		<colgroup>
			<col style="min-width:150px;width:20%;"/>
	        <col/>
			<col style="min-width:150px;width:20%;"/>
	        <col/>
		</colgroup>
		<tr>
			<th>报销编号：</th>
			<td style="text-align: left">${result.reid}</td>
			<th>献血者编号：</th>
            <td style="text-align: left">${result.dorid}</td>
		</tr>
		<tr>
			<th>用血者姓名：</th>
            <td style="text-align: left">${result.patientname}</td>
			<th>用血者证件类型：</th>
            <td style="text-align: left">${result.patientidentitytype}</td>
		</tr>
		<tr>
			<th>用血者证件号：</th>
			<td style="text-align: left">${result.patientidentityid}</td>
			<th>用血时间：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.usetime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
		</tr>
		<tr>
			<th>用血量：</th>
			<td style="text-align: left">${result.useamount}</td>
			<th>用血医院：</th>
            <td style="text-align: left">${result.hospital}</td>
		</tr>
		<tr>
		    <th>用血原因：</th>
            <td style="text-align: left">${result.reason}</td>
            <th>发票号：</th>
            <td style="text-align: left">${result.invoice}</td>
		</tr>
        <tr>
            <th>献血者用血者关系：</th>
            <td style="text-align: left">${result.relation}</td>
            <th>证明资料类型：</th>
            <td style="text-align: left">${result.provetype}</td>
        </tr>
        <tr>
            <th>返回政策：</th>
            <td style="text-align: left">${result.principle}</td>
            <th>报销金额：</th>
            <td style="text-align: left">${result.money}</td>
        </tr>
        <tr>
            <th>报销人姓名：</th>
            <td style="text-align: left">${result.payee}</td>
            <th>报销人证件类型：</th>
            <td style="text-align: left">${result.payeeidentitytype}</td>
        </tr>
         <tr>
            <th>报销人证件号：</th>
            <td style="text-align: left">${result.payeeidentityid}</td>
            <th>报销时间：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.payeetime}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
        </tr>
         <tr>
            <th>报销血站：</th>
            <td style="text-align: left">${result.bloodstation}</td>
            <th>区域：</th>
            <td style="text-align: left">${result.branch}</td>
        </tr>
         <tr>
            <th>更新时间：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.maketime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
            <th></th>
            <td style="text-align: left"></td>
        </tr>
	</table>
</div>