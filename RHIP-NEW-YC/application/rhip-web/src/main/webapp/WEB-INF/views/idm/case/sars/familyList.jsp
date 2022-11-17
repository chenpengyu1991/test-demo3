<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--家庭、亲友--%>
<div class="toolbarsublist">
    <a href="javascript:void(0)" id="addFamily" onclick="sarsCase.popFamily()"><b class="xinz">添加</b></a>
    <a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('2011')"><b class="import">导入</b></a>
</div>
<div  class="repeattable">

<table id="familyTable">
	<colgroup>
        <%--不要超过520px--%>
		<col style="width:60px;"/>
		<col style="width:60px;"/>
        <col style="width:40px;"/>
        <col style="width:60px;"/>
		<col style="width:80px;"/>
		<col style="width:80px;"/>
		<col style="width:80px;"/>
		<col style="width:60px;"/>
	</colgroup>	
	<thead>
		<tr>
			<th class="centerth">接触者姓名</th>
			<th class="centerth">性别</th>
			<th class="centerth">年龄</th>
			<th class="centerth">关系</th>
			<th class="centerth">接触情况</th>
			<th class="centerth" title="住址（或工作单位）">住址(或工作单位)</th>
			<th class="centerth">电话号码</th>
			<th class="centerth">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="contact" items="${caseDto.idmListEfcList}" varStatus="status">
			<c:if test="${contact.flag=='6'}">
			<tr>
				<td field="flag" style="display:none;"><ehr:tip>${contact.flag}</ehr:tip></td>
				<td field="name"><ehr:tip>${contact.name}</ehr:tip></td>
				<td field="sexStr"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${contact.sex}"/></ehr:tip></td>
				<td field="sex" style="display:none;"><ehr:tip>${contact.sex}</ehr:tip></td>
				<td field="age"><ehr:tip>${contact.age}</ehr:tip></td>
				<td field="relation"><ehr:tip>${contact.relation}</ehr:tip></td>
				<td field="contactType"><ehr:tip>${contact.contactType}</ehr:tip></td>
				<td field="unitAddr"><ehr:tip>${contact.unitAddr}</ehr:tip></td>
				<td field="tel"><ehr:tip>${contact.tel}</ehr:tip></td>
				<td class="btnsublist" field="btn">
					<a href="javascript:void(0)" onclick='sarsCase.editTr(this,6)'>修改</a>				
					<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)" >删除</a>
				</td>
			</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table>
</div>


