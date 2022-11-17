<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:140px;width: 15%;"/>
			<col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:100px;width: 10%;"/>
	        <%-- <col style="min-width:100px;width: 10%;"/> --%>
	        <col style="min-width:100px;width: 10%;"/>
	        <%-- <col style="min-width:100px;width: 10%;"/> --%>
	        <col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:120px;width: 15%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>医疗机构</th>
                <th>入库单号</th>
				<th>入库方式</th>
				<th>供货单位</th>
				<!-- <th>发票号码</th> -->
				<th>采购日期</th>
				<!-- <th>购入方式</th> -->
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="consumableIn" items="${consumableIns}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${consumableIn.ORGAN_CODE}"/></ehr:tip></td>
                    <td><ehr:tip>${consumableIn.BATCH_NO}</ehr:tip></td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00001" code="${consumableIn.STORAGE_TYPE_CODE}"/></ehr:tip></td>
                    <td><ehr:tip>${consumableIn.SUPPLIER_UNIT_NAME}</ehr:tip></td> 
                    <%-- <td><ehr:tip>${consumableIn.INVOICE_NUM}</ehr:tip></td> --%>                 
                    <td><ehr:tip><fmt:formatDate value="${consumableIn.STORAGE_DT}" pattern="yyyy/MM/dd" /></ehr:tip></td>
                    <%-- <td><ehr:tip>${consumableIn.PURCHASE_TYPE_NAME}</ehr:tip></td> --%>
                    <td><ehr:tip>${consumableIn.COMMENTS}</ehr:tip></td>
                    <td>
						<a style="color: #FFF;font-size: 12px;"class="layui-btn layui-btn-xs" onclick="consumableInSearch.detailSearch('${consumableIn.BATCH_NO}')"><i class="layui-icon">&#xe615;</i>查看</a>
                    </td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="consumableInSearch.search" colspan="7"/>
		    </tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="consumableInSearch.search" />
		</tr>
	</table> --%>
</div>