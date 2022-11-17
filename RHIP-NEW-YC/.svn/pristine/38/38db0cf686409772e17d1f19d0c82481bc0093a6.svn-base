<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--密切接触者--%>
<div class="toolbarsublist">
	<a href="javascript:void(0)" id="addContacts" onclick="scarlatinaCase.popEfc()"><b class="xinz">添加</b></a>
    <a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('220')"><b class="import">导入</b></a>	
</div>
<div  class="repeattable">

<table id="efcTable">
	<colgroup>
		<col style="width:8%;"/>
		<col style="width:8%;"/>
        <col style="width:8%;"/>
		<col style="width:15%;"/>
		<col style="width:21%;"/>
		<col style="width:15%;"/>
        <col style="width:15%;"/>
		<col style="width:10%;"/>					
	</colgroup>	
	<thead>
		<tr>
			<th class="centerth">姓名</th>
			<th class="centerth">性别</th>
			<th class="centerth">年龄</th>
			<th class="centerth">关系</th>
			<th class="centerth">住址</th>
			<th class="centerth">接触方式</th>
			<th class="centerth">发病情况</th>
			<th class="centerth">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="contact" items="${caseDto.idmListEfcList}" varStatus="status">
			<tr>
				<td field="name"><ehr:tip>${contact.name}</ehr:tip></td>
				<td field="sexStr"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${contact.sex}"/></ehr:tip></td>
				<td field="sex" style="display:none;"><ehr:tip>${contact.sex}</ehr:tip></td>
				<td field="age"><ehr:tip>${contact.age}</ehr:tip></td>
				<td field="relation"><ehr:tip>${contact.relation}</ehr:tip></td>
				<td field="unitAddr"><ehr:tip>${contact.unitAddr}</ehr:tip></td>
				<td field="contactType"><ehr:tip>${contact.contactType}</ehr:tip></td>
				<td field="attackCondition"><ehr:tip>${contact.attackCondition}</ehr:tip></td>
				<td class="btnsublist" field="btn">
					<a href="javascript:void(0)" onclick='scarlatinaCase.editConTr(this)'>修改</a>				
					<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)" >删除</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>


