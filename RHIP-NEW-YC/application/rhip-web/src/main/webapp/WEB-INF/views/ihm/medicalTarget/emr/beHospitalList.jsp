<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 25%;"/>
			<col style="min-width:150px;width: 15%;"/>
	        <col style="min-width:80px;width: 20%;"/>
			<col style="min-width:80px;width: 15%;"/>
			<col style="min-width:80px;width: 15%;"/>
	        <col style="min-width:80px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>医疗机构</th>			
				<th>姓名</th>
				<th>身份证号</th>
				<th>住院号</th>
				<th>入院日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="inpatientInfo" items="${inpatientInfoList}" varStatus="status">
				<tr>
					<td class="centertd"><ehr:tip><ehr:org code="${inpatientInfo.referralHospitalCode}"/></ehr:tip></td>				
					<td class="centertd"><ehr:tip>${inpatientInfo.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${inpatientInfo.idcard}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${inpatientInfo.admissionNo}</ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value='${inpatientInfo.inhosDate}' pattern='yyyy/MM/dd'/></ehr:tip></td>
					<td class="centertd">
						<a title="查看入院记录" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" onclick="emrSearch.beHospitalDetail('${inpatientInfo.id}')"><i class="layui-icon">&#xe615;</i>查看</a>
				    </td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="emrSearch.emrSearch" colspan="6"/>
			</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="emrSearch.emrSearch"/>
		</tr>
	</table> --%>
</div>