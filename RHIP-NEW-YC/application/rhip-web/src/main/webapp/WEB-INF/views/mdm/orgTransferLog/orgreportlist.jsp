<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable">
	<table id="serviceTable">
		<colgroup>
	        <col style="min-width:200px;width: 20%;"/>
			<col style="min-width:150px;width: 20%;"/>
	        <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
	        <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
			    <th>姓名</th>
				<th>身份证号码</th>
				<th>疾病名称</th>
                <th>迁出机构</th>
				<th>迁入机构</th>
				<th>操作者</th>
				<th>迁移时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="reportList" items="${reportList}" varStatus="status">
				<tr>
				    <td style="text-align:center">${reportList.name}</td>
				    <td style="text-align:center">${reportList.idcard}</td>
					<td><tags:textWithTip value=" ${reportList.disType eq '1' ? '高血压':''} ${reportList.disType eq '2' ? '糖尿病':''} ${reportList.disType eq '5' ? '肿瘤':''}  ${reportList.disType eq '4' ? '冠心病':''} ${reportList.disType eq '3' ? '脑卒中':''}" /></td>
				<td><ehr:tip><ehr:org code="${reportList.createOrganCode}"/></ehr:tip></td>
                    <td><ehr:tip><ehr:org code="${reportList.currentOrganCode}"/></ehr:tip></td>
                    <td style="text-align:center">${reportList.operator}</td>
                    <td style="text-align:center">
                    <fmt:formatDate value='${reportList.recordChangeTime}' pattern='yyyy/MM/dd'/>
                    <td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="orgtransferLogSearch.search" />
		</tr>
	</table>
</div>