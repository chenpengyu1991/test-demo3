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
			<col style="min-width:100px;width: 10%;"/>
			<col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
			<col style="min-width:100px;width: 9%;"/>
			<col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>

		</colgroup>
		<thead>
			<tr>
				<th>医疗机构</th>
                <th>库位</th>
				<th>耗材名称</th>
				<th>管理分类</th>
				<th>规格</th>
				<th>单位</th>
				<th>生产厂家</th>
				<th>零售价格</th>
				<th>注册证号</th>
				<th>失效日期</th>
				<th>报损原因</th>
				<th>报损日期</th>
				<th>报损人</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="breakage" items="${breakages}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${breakage.ORGAN_CODE}"/></ehr:tip></td>
                    <td><ehr:tip>${breakage.STORAGE_LOCATION}</ehr:tip></td>
                    <td><ehr:tip>${breakage.GENERIC_NAME}</ehr:tip></td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00016" code="${breakage.MANAGE_TYPE_CODE_GB}"/></ehr:tip></td>
                    <td><ehr:tip>${breakage.SPECIFICATIONS}</ehr:tip></td>
                    <td><ehr:tip>${breakage.PACKAGING}</ehr:tip></td>
                    <td><ehr:tip>${breakage.FAC_NAME}</ehr:tip></td>
                    <td><tags:numberLabel value="${breakage.RETAIL_PRICE}" fractionDigits="2"/></td>
                    <td><ehr:tip>${breakage.REGISTER_NO}</ehr:tip></td>
                    <td><ehr:tip><fmt:formatDate value="${breakage.EXPIRY_DT}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00014" code="${breakage.BREAKAGE_REASON}"/></ehr:tip></td>
                    <td><ehr:tip><fmt:formatDate value="${breakage.BREAKAGE_DT}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                    <td><ehr:tip>${breakage.OPERATOR_NAME}</ehr:tip></td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="breakageSearch.search" colspan="13"/>
		</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="breakageSearch.search" />
		</tr>
	</table> --%>
</div>