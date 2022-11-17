<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/infectDetailList.js" type="text/javascript"/>
<input type="hidden" id="id" value="${monitor.id}"/>
<input type="hidden" id="operation" value="${operation}"/>
<c:if test="${operation eq 'edit'}">
	<div id="detailToolbar" class="toolbar" style="${displayDetailList}">
		<a href="javascript:void(0)" id="addDetail"><b class="xinz">新增</b></a>
	</div>
</c:if>
<div class="repeattable" style="${displayDetailList}">
	<table>
		<colgroup>
			<col style="width: 10%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 8%"/>
			<col style="width: 12%"/>
		</colgroup>
		<thead>
		<tr>
			<th style="text-align: center" rowspan="2">科室</th>
			<th style="text-align: center" rowspan="2">抽查病例数</th>
			<th style="text-align: center" colspan="13">感染部位及例数</th>
			<th style="text-align: center" rowspan="2">感染率(%)</th>
			<th style="text-align: center" rowspan="2">操作</th>
		</tr>
		<tr>
			<th style="text-align: center">呼吸系统</th>
			<th style="text-align: center">心血管系统</th>
			<th style="text-align: center">泌尿系统</th>
			<th style="text-align: center">消化系统和腹部</th>
			<th style="text-align: center">血液系统</th>
			<th style="text-align: center">中枢神经系统</th>
			<th style="text-align: center">皮肤与软组织</th>
			<th style="text-align: center">生殖道</th>
			<th style="text-align: center">手术部位</th>
			<th style="text-align: center">口腔</th>
			<th style="text-align: center">骨和关节</th>
			<th style="text-align: center">其他部位</th>
			<th style="text-align: center">合计</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="detail" items="${detailList}" varStatus="status">
			<tr>
				<td><ehr:tip value="${detail.deptName}"/></td>
				<td>${detail.spotCheckNum}</td>
				<td>${detail.breathingSys}</td>
				<td>${detail.cardiovascularSys}</td>
				<td>${detail.urinarySys}</td>
				<td>${detail.digestiveSysAbdomen}</td>
				<td>${detail.bloodSys}</td>
				<td>${detail.cns}</td>
				<td>${detail.skinSofttisstle}</td>
				<td>${detail.rti}</td>
				<td>${detail.ssi}</td>
				<td>${detail.oral}</td>
				<td>${detail.boneJoint}</td>
				<td>${detail.otherParts}</td>
				<td>${detail.total}</td>
				<td>${detail.infectionRate}</td>
				<td style="text-align: center">
					<a href="javascript:void(0)" onclick="infectDetailList.editOrView('${detail.id}', '${detail.monitorId}', 'view')">查看</a>
					<c:if test="${operation eq 'edit'}">
						<a href="javascript:void(0)" onclick="infectDetailList.editOrView('${detail.id}', '${detail.monitorId}', 'edit')">修改</a>
						<a href="javascript:void(0)" onclick="infectDetailList.del(this, '${detail.id}','${detail.monitorId}')">删除</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<table id="pagination">
		<tr>
			<ehr:pagination action="infectMonitorAdd.searchDetail" />
		</tr>
	</table>
</div>
<div><input type="hidden" id="idxPage" value="${idxPage}"/></div>