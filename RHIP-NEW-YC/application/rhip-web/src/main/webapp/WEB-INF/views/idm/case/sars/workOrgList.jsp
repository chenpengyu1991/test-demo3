<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--工作单位或主要活动场所联系人--%>
<div class="toolbarsublist">
    <a href="javascript:void(0)" id="addWorkOrg" onclick="sarsCase.popWorkOrg()"><b class="xinz">添加</b></a>
    <a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('2012')"><b class="import">导入</b></a>
</div>
<div  class="repeattable">

<table id="workOrgTable">
	<colgroup>
        <%--不要超过520px--%>
		<col style="width:100px;"/>
		<col style="width:150px;"/>
		<col style="width:70px;"/>
		<col style="width:130px;"/>
		<col style="width:60px;"/>
	</colgroup>	
	<thead>
		<tr>
			<th class="centerth">单位名称</th>
			<th class="centerth">地址及联系电话</th>
			<th class="centerth">主要联系人</th>
			<th class="centerth">接触者名单</th>
			<th class="centerth">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="workOrg" items="${caseDto.idmListEfcList}" varStatus="status">
			<c:if test="${workOrg.flag=='7'}">
				<tr>
					<td field="flag" style="display:none;"><ehr:tip>${workOrg.flag}</ehr:tip></td>
					<td field="unitAddr"><ehr:tip>${workOrg.unitAddr}</ehr:tip></td>
					<td field="tel"><ehr:tip>${workOrg.tel}</ehr:tip></td>
					<td field="linkman"><ehr:tip>${workOrg.linkman}</ehr:tip></td>
					<td field="contactName"><ehr:tip>${workOrg.contactName}</ehr:tip></td>
					<td class="btnsublist" field="btn">
						<a href="javascript:void(0)" onclick='sarsCase.editTr(this,7)'>修改</a>				
						<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)" >删除</a>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table>
</div>


