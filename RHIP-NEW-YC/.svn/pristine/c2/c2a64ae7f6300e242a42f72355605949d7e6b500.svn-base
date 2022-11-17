<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
<table class="layui-table x-admin-sm-table-list-middle">
	<thead>
	<tr>
		<th width="8%">药物级别</th>
		<th width="8%">申报编码</th>
		<th width="8%">通用名</th>
		<th width="5%">类别一级</th>
		<th width="5%">类别二级</th>
		<th width="6%">类别三级</th>
		<th width="10%">商品名</th>
		<th width="5%">剂型</th>
		<th width="5%">规格</th>
		<th width="11%">生产企业</th>
		<th width="6%">状态</th>
		<th width="23%">操作</th>
	</tr>
	</thead>
	<c:forEach items="${medicineList}" var="medicine" varStatus="status">
		<tr>
			<td class="centertd"><ehr:dic dicmeta="FS10242" code="${medicine.levelCode}" /></td>
			<td><a href="javascript:void(0);" onclick="medicineSearch.viewMedicine('${medicine.medicineCode}')">${medicine.medicineCode}</a></td>
			<td title="${medicine.commonName}">${medicine.commonName}</td>
			<td title="${medicine.categoryNameOne}">${medicine.categoryNameOne}</td>
			<td title="${medicine.categoryNameTwo}">${medicine.categoryNameTwo}</td>
			<td title="${medicine.categoryNameThree}">${medicine.categoryNameThree}</td>
			<td title="${medicine.productName}">${medicine.productName}</td>
			<td title="${medicine.dosage}">${medicine.dosage}</td>
			<td title="${medicine.specification}">${medicine.specification}</td>
			<td title="${medicine.manufactory}">${medicine.manufactory}</td>
			<td class="centertd">
				<a href="javascript:void(0);" onclick="medicineSearch.changeStatus(this,'${medicine.medicineCode}',${medicine.status})">
					<c:if test="${medicine.status eq -1}">作废</c:if>
					<c:if test="${medicine.status eq 1}">有效</c:if>
				</a>
			</td>
			<td class="centertd">
				<%-- <a href="javascript:void(0);" onclick="medicineSearch.editMedicine('${medicine.medicineCode}')">修改</a>&nbsp; --%>
				<a href="javascript:void(0);" onclick="medicineSearch.editMedicine('${medicine.medicineCode}')" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
				<%-- <a href="javascript:void(0);" onclick="medicineSearch.deleteMedicine('${medicine.medicineCode}')">删除</a>&nbsp; --%>
				<a href="javascript:void(0);" onclick="medicineSearch.deleteMedicine('${medicine.medicineCode}')" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;" title="删除"><i class="layui-icon">&#xe640;</i>刪除</a>&nbsp;
				<%-- <a href="javascript:void(0);" onclick="medicineSearch.showMedicineLogs('${medicine.medicineCode}')">变化跟踪</a> --%>
				<a href="javascript:void(0);" onclick="medicineSearch.showMedicineLogs('${medicine.medicineCode}')" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" title="变化跟踪"><i class="layui-icon">&#xe60e;</i>跟踪</a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<ehr:pagination action="medicineSearch.search" colspan="12"/>
	</tr>
</table>
<%-- <table>
	<tr>
		<ehr:pagination action="medicineSearch.search" />
	</tr>
</table> --%>
<input type="hidden" id="indexPage" value="${indexPage}" />
</div>