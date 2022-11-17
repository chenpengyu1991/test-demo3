<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
    <div class="toolbarsublist">
        <a href="javascript:void(0)" id="addEfcList" onclick="plagueCase.popEfc()"><b class="xinz">添加</b></a>
       	<a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('101')"><b class="import">导入</b></a>
    </div>
	<table id="efcTable">
		<colgroup>
			<col style="width: 15%" />
			<col style="width: 15%" />
			<col style="width: 15%" />
			<col style="width: 25%" />
			<col style="width: 15%" />
			<col style="width: 15%" />
		</colgroup>
		<thead>
			<tr>
				<th class="centerth">姓名</th>
				<th class="centerth">性别</th>
				<th class="centerth">年龄</th>
				<th class="centerth">住址</th>
				<th class="centerth">接触方式</th>
				<th class="centerth">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="patients" items="${caseDto.idmListEfcList}"	varStatus="status">
				<tr>
					<td field="name"><ehr:tip>${patients.name}</ehr:tip></td>
					<td field="sexStr"><ehr:tip>${patients.sexStr}</ehr:tip></td>
	                <td field="sex" style="display: none;"><ehr:tip>${patients.sex}</ehr:tip></td>
					<td field="age"><ehr:tip>${patients.age}</ehr:tip></td>
					<td field="unitAddr"><ehr:tip>${patients.unitAddr}</ehr:tip></td>
					<td field="contactType"><ehr:tip>${patients.contactType}</ehr:tip></td>
					<td class="btnsublist" field="btn">
		                <a href="javascript:void(0)" onclick="plagueCase.editTr(this, 'efcList')">修改</a>&nbsp;
		                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>