<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:140px;width: 20%;"/>
	        <col style="min-width:120px;width: 15%;"/>
			<col style="min-width:140px;width: 20%;"/>
	        <col style="min-width:120px;width: 15%;"/>
	        <col style="min-width:120px;width: 15%;"/>
	        <col style="min-width:120px;width: 15%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>医疗机构</th>
                <th>退货单号</th>
				<th>供货单位</th>
				<th>退货日期</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="storageReturn" items="${storageReturns}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${storageReturn.ORGAN_CODE}"/></ehr:tip></td>
                    <td><ehr:tip>${storageReturn.BATCH_NO}</ehr:tip></td>
                    <td><ehr:tip>${storageReturn.SUPPLIER_UNIT_NAME}</ehr:tip></td>
                    <td><ehr:tip><fmt:formatDate value="${storageReturn.RETURN_DT}" pattern="yyyy/MM/dd" /></ehr:tip></td>
                    <td><ehr:tip>${storageReturn.COMMENTS}</ehr:tip></td>
                    <td>
                    	<a href="javascript:void(0)" onclick="storageReturnSearch.detailSearch('${storageReturn.BATCH_NO}')" class="person-link-btn">查看</a>
                    </td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="storageReturnSearch.search" colspan="6"/>
		</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="storageReturnSearch.search" />
		</tr>
	</table> --%>
</div>