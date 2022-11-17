<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--密切接触者--%>

<div class="toolbarsublist">
	患者的密切接触者情况：<a href="javascript:void(0)" id="addContacts" onclick="dysenteryCase.popEfc()" ><b class="xinz">添加</b></a>
    <!-- <a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('2131')"><b class="import">导入</b></a>   -->   
</div>
<div  class="repeattable">
<table id="efcTable">
	<colgroup>
        <%--不要超过520px--%>
		<col style="width:60px;"/>
		<col style="width:40px;"/>
        <col style="width:40px;"/>
		<col style="width:40px;"/>
		<col style="width:80px;"/>
		<col style="width:40px;"/>
		<col style="width:60px;"/>
        <col style="width:60px;"/>
		<col style="width:100px;"/>
		<col style="width:60px;"/>
	</colgroup>	
	<thead>
		<tr>
			<th class="centerth">姓名</th>
			<th class="centerth">性别</th>
			<th class="centerth">年龄</th>
			<th class="centerth">关系</th>
			<th class="centerth">单位或住址</th>
			<th class="centerth">接触方式</th>
			<th class="centerth">是否发病</th>
			<th class="centerth">发病日期</th>
			<th class="centerth">实验室检查</th>
			<th class="centerth">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="contact" items="${caseDto.idmListEfcList}" varStatus="status">
			<tr>
				<td field="name" title="${contact.name}"><ehr:tip>${contact.name}</ehr:tip></td>
				<td field="sexStr"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${contact.sex}"/></ehr:tip></td>
				<td field="sex" style="display:none;"><ehr:tip>${contact.sex}</ehr:tip></td>
				<td field="age"><ehr:tip>${contact.age}</ehr:tip></td>
				<td field="relationStr"><ehr:tip><ehr:dic dicmeta="IDM00018" code="${contact.relation}" /></ehr:tip></td>
				<td field="relation"  style="display:none;"><ehr:tip>${contact.relation}</ehr:tip></td>
				<td field="unitAddr" title="${contact.unitAddr}"><ehr:tip>${contact.unitAddr}</ehr:tip></td>
				<td field="contactTypeStr"><ehr:tip><ehr:dic dicmeta="IDM00033" code="${contact.contactType}" /></ehr:tip></td>
				<td field="contactType"  style="display:none;"><ehr:tip>${contact.contactType}</ehr:tip></td>
				<td field="attackStr"><ehr:tip><ehr:dic dicmeta="PH00002" code="${contact.attack}" /></ehr:tip></td>
				<td field="attack" style="display:none;"><ehr:tip>${contact.attack}</ehr:tip></td>
				<td field="attackDt" ><ehr:tip><fmt:formatDate value="${contact.attackDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
				<td field="labExamination" ><ehr:tip>${contact.labExamination}</ehr:tip></td>
				<td class="btnsublist" field="btn">
					<a href="javascript:void(0)" onclick='dysenteryCase.editConTr(this)'>修改</a>				
					<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)" >删除</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>


