<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:100px;width: 12%;"/>
			<col style="min-width:120px;width: 13%;"/>
			<col style="min-width:120px;width: 15%;"/>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 10%;"/>			
		</colgroup>
		<thead>
			<tr>
				<th>全国唯一识别码</th>
				<th>机构名称</th>
				<th>机构地址</th>
                <th>登记号</th>
                <th>电话</th>
				<th>邮编</th>
				<th>法人姓名</th>
				<th>申请日期</th>
				<th>批准日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="organ" items="${organList}" varStatus="status">
				<tr>
					<td><ehr:tip>${organ.nationalOrganCode}</ehr:tip></td> 
                    <td><ehr:tip>${organ.organName}</ehr:tip></td>
                    <td><ehr:tip>${organ.address}</ehr:tip></td>
                    <td><ehr:tip>${organ.registCode}</ehr:tip></td>
                    <td><ehr:tip>${organ.tel}</ehr:tip></td>
                    <td><ehr:tip>${organ.postCode}</ehr:tip></td>
                    <td><ehr:tip>${organ.artificialPerson}</ehr:tip></td>
                    <td><%-- <ehr:tip><fmt:formatDate value="${organ.EXPIRY_DT}" pattern="yyyy/MM/dd"/></ehr:tip> --%></td>
                    <td><ehr:tip><fmt:formatDate value="${organ.startDate}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                    <td>
                    	<a href="javascript:void(0)" onclick="configSearch.detailSearch('${organ.organCode}','${organ.organName}')" class="person-link-btn">查看</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr><ehr:pagination action="configSearch.search" /></tr>
	</table>
</div>