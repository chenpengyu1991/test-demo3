<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:150px;width: 12%;"/>
			<col style="min-width:80px;width: 10%;"/>
	        <col style="min-width:120px;width: 15%;"/>
	        <col style="min-width:80px;width: 10%;"/>
	        <%--<col style="min-width:80px;width: 10%;"/>--%>
	        <%--<col style="min-width:80px;width: 10%;"/>	--%>
	        <col style="min-width:80px;width: 10%;"/>	
	        <col style="min-width:80px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>医疗机构</th>
                <th>入库单号</th>
				<th>入库方式</th>
                <th>供货单位</th>
				<th>入库日期</th>
				<%--<th>购入方式</th>--%>
				<%--<th>发票号码</th>--%>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="storageIn" items="${storageIns}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${storageIn.organ_Code}"/></ehr:tip></td>
                    <td><ehr:tip>${storageIn.batch_No}</ehr:tip></td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00001" code="${storageIn.storage_Type_Code}"/></ehr:tip></td>
                    <td><ehr:tip>${storageIn.supplier_Unit_Name}</ehr:tip></td>  
                    <td><ehr:tip><fmt:formatDate value="${storageIn.storage_Dt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
                    <%--<td><ehr:tip>${storageIn.purchase_Type_Name}</ehr:tip></td>--%>
                    <%--<td><ehr:tip>${storageIn.invoice_Num}</ehr:tip></td>--%>
                    <td><ehr:tip>${storageIn.comments}</ehr:tip></td>
                    <td>
						<a style="color: #FFF;font-size: 12px;"class="layui-btn layui-btn-xs" onclick="storageInSearch.detailSearch('${storageIn.batch_No}')"><i class="layui-icon">&#xe615;</i>查看</a>
                    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="storageInSearch.search" />
		</tr>
	</table>
</div>