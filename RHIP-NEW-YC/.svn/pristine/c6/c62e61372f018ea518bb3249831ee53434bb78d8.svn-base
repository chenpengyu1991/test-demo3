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
                <th>出库单号</th>
				<th>出库方式</th>
				<th>出库日期</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="storageOut" items="${storageOuts}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${storageOut.organ_Code}"/></ehr:tip></td>
                    <td><ehr:tip>${storageOut.BATCH_NO}</ehr:tip></td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00007" code="${storageOut.DELIVERY_TYPE_CODE}"/></ehr:tip></td>
                    <td><ehr:tip><fmt:formatDate value="${storageOut.DELIVERY_DT}" pattern="yyyy/MM/dd" /></ehr:tip></td>
                    <td><ehr:tip>${storageOut.comments}</ehr:tip></td>
                    <td>
						<a style="color: #FFF;font-size: 12px;"class="layui-btn layui-btn-xs" onclick="storageOutSearch.detailSearch('${storageOut.batch_No}')"><i class="layui-icon">&#xe615;</i>查看</a>
                    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="storageOutSearch.search" />
		</tr>
	</table>
</div>