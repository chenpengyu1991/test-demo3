<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table>
		<colgroup>
          <col style="min-width:150px;width: 18%;"/>
			<col style="min-width:150px;width: 15%;"/>
	        <col style="min-width:80px;width: 15%;"/>
			<col style="min-width:80px;width: 15%;"/>
	        <col style="min-width:80px;width: 15%;"/>
	        <col style="min-width:80px;width: 15%;"/>
	         <col style="min-width:80px;width: 7%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>医疗机构</th>
				<th>门诊号</th>
				<th>姓名</th>
				<th>身份证号</th>
				<th>就诊科室</th>
				<th>就诊时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="outpatientList" items="${outpatientInfoList}" varStatus="status">
				<tr>
					<td style="text-align: center"><ehr:tip>${outpatientList.clinicOrganName}</ehr:tip></td>
					<td style="text-align: center"><ehr:tip>${outpatientList.outpatientNo}</ehr:tip></td>
					<td style="text-align: center"><ehr:tip>${outpatientList.clinicPeopleName}</ehr:tip></td>
					<td style="text-align: center"><ehr:tip>${outpatientList.idcard}</ehr:tip></td>
					<td style="text-align: center"><ehr:tip>${outpatientList.medicalRoomName}</ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value='${outpatientList.clinicDate}' pattern='yyyy/MM/dd'/></ehr:tip></td>
					<td class="centertd">
					    <a title="查看门诊信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" onclick="emrSearch.outpatientDetail('${outpatientList.ehrId}','${outpatientList.personId}')"><i class="layui-icon">&#xe615;</i>查看</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<table>
		<tr>
			<ehr:pagination action="emrSearch.emrSearch"/>
		</tr>
	</table>
</div>