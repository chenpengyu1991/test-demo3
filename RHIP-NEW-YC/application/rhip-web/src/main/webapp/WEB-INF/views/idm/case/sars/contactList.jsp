<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--发病前2周内是否接触过非典病人或/和疑似非典患者--%>
<span>若是，请填写下表</span>
<div class="toolbarsublist">
    <a href="javascript:void(0)" id="addContacts" ><b class="xinz">添加</b></a>
</div>
<div  class="repeattable">

<table id="contactTable">
	<colgroup>
        <%--不要超过520px--%>
		<col style="width:60px;"/>
		<col style="width:60px;"/>
        <col style="width:90px;"/>
		<col style="width:50px;"/>
		<col style="width:50px;"/>
		<col style="width:50px;"/>
        <col style="width:50px;"/>
		<col style="width:50px;"/>
		<col style="width:60px;"/>
	</colgroup>	
	<thead>
		<tr>
			<th class="centerth">患者姓名</th>
			<th class="centerth">发病时间</th>
			<th class="centerth">临床诊断</th>
			<th class="centerth">与患者关系</th>
			<th class="centerth">最后接触时间</th>
			<th class="centerth">接触方式</th>
			<th class="centerth">接触频率</th>
			<th class="centerth">接触地点</th>
			<th class="centerth">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="contact" items="${caseDto.idmListEsContact}" varStatus="status">
			<tr id = '${status.count}'>
				<td field="flag" style="display:none;"><ehr:tip>${contact.flag}</ehr:tip></td>
				<td field="name"><ehr:tip>${contact.name}</ehr:tip></td>
				<td field="attackDt"><ehr:tip><fmt:formatDate value="${contact.attackDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
				<td field="clinicalDiagnosis"><ehr:tip>${contact.clinicalDiagnosis}</ehr:tip></td>
				<td field="relationStr"><ehr:tip><ehr:dic dicmeta="IDM00112" code="${contact.relation}" /></ehr:tip></td>
				<td field="relation" style="display:none;"><ehr:tip>${contact.relation}</ehr:tip></td>
				<td field="condactDtLast"><ehr:tip><fmt:formatDate value="${contact.condactDtLast}" pattern="yyyy/MM/dd" /></ehr:tip></td>
				<td field="contactTypeStr"><ehr:tip><ehr:dic dicmeta="IDM00113" code="${contact.contactType}" /></ehr:tip></td>
				<td field="contactType" style="display:none;"><ehr:tip>${contact.contactType}</ehr:tip></td>
				<td field="contactRateStr"><ehr:tip><ehr:dic dicmeta="IDM00035" code="${contact.contactRate}" /></ehr:tip></td>
				<td field="contactRate" style="display:none;"><ehr:tip>${contact.contactRate}</ehr:tip></td>
				<td field="contactAddrStr"><ehr:tip><ehr:dic dicmeta="IDM00114" code="${contact.contactAddr}" /></ehr:tip></td>
				<td field="contactAddr" style="display:none;"><ehr:tip>${contact.contactAddr}</ehr:tip></td>
				<td class="btnsublist" field="btn">
					<a href="javascript:void(0)" onclick='sarsCase.editTr(this,5)'>修改</a>				
					<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)" >删除</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>


