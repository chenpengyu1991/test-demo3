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
			<col style="min-width:80px;width: 8%;"/>
	        <%-- <col style="min-width:80px;width: 8%;"/> --%>
			<col style="min-width:120px;width: 10%;"/>
	        <col style="min-width:100px;width: 9%;"/>
			<col style="min-width:100px;width: 9%;"/>
			<col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
			<col style="min-width:100px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
	        <%-- <col style="min-width:140px;width: 10%;"/> --%>
	        <col style="min-width:80px;width: 8%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>医疗机构</th>
                <th>耗材名称</th>
				<!-- <th>管理分类</th> -->
				<th>规格</th>
				<th>单位</th>
				<th>生产厂家</th>
				<th>库存数量</th>
				<th>购入价</th>
				<th>零售价</th>
				<th>购入金额</th>
				<!-- <th>注册证号</th> -->
				<th>失效日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="store" items="${stores}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${store.ORGAN_CODE}"/></ehr:tip></td>
                    <td><ehr:tip>${store.GENERIC_NAME}</ehr:tip></td>
                    <%-- <td><ehr:tip>${store.MANAGE_TYPE_NAME}</ehr:tip></td> --%>
                    <td><ehr:tip>${store.SPECIFICATIONS}</ehr:tip></td>
                    <td><ehr:tip>${store.PACKAGING}</ehr:tip></td>
                    <td><ehr:tip>${store.FAC_NAME}</ehr:tip></td>
                    <td><tags:numberLabel value="${store.STORAGE_NUM}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${store.STORAGE_PRICE}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${store.RETAIL_PRICE}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${store.STORAGE_AMOUNT}" fractionDigits="2"/></td>
                    <%-- <td><ehr:tip>${store.REGISTER_NO}</ehr:tip></td> --%>
                    <td><ehr:tip><fmt:formatDate value="${store.EXPIRY_DT}" pattern="yyyy/MM/dd"/></ehr:tip></td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="storageSearch.search" colspan="10"/>
		</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="storageSearch.search" />
		</tr>
	</table> --%>
</div>