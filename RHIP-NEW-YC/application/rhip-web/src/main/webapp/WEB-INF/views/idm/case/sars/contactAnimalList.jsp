<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--发病前两周内接触动物--%>
<span>若是，请填写下表</span>
<div class="toolbarsublist">
    <a href="javascript:void(0)" id="addEsAnimal" ><b class="xinz">添加</b></a>
</div>
<div  class="repeattable">

<table id="animalTable">
	<colgroup>
        <%--不要超过520px--%>
		<col style="width:60px;"/>
		<col style="width:80px;"/>
        <col style="width:80px;"/>
		<col style="width:40px;"/>
		<col style="width:40px;"/>
		<col style="width:40px;"/>
        <col style="width:40px;"/>
		<col style="width:80px;"/>
		<col style="width:60px;"/>
	</colgroup>	
	<thead>
		<tr>
			<th class="centerth" colspan="3">接触动物情况</th>	
			<th class="centerth" colspan="5">接触方式</th>	
			<th class="centerth" style="vertical-align:middle;" rowspan="2">操作</th>	
		</tr>
		<tr>
			<th class="centerth">时间</th>
			<th class="centerth">地点</th>
			<th class="centerth">动物名称</th>
			<th class="centerth">销售</th>
			<th class="centerth">屠宰</th>
			<th class="centerth">烹饪</th>
			<th class="centerth">吃</th>
			<th class="centerth">其他</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="es" items="${caseDto.idmListEsAnimal}" varStatus="status">
			<tr>
				<td field="flag" style="display:none;">${es.flag}</td>
				<td field="contactBeginDt"><ehr:tip><fmt:formatDate value="${es.contactBeginDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
				<td field="contactAnimalAddr"><ehr:tip>${es.contactAnimalAddr}</ehr:tip></td>
				<td field="contactAnimalName"><ehr:tip>${es.contactAnimalName}</ehr:tip></td>
				<td field="contactAnimalSell" style="display:none;"><ehr:tip>${es.contactAnimalSell}</ehr:tip></td>
				<td field="contactAnimal" style="text-align:center;">
					<c:forEach var="type" items="${es.contactAnimalType}" varStatus="status1">
						<c:if test="${type == '1'}">√</c:if>
					</c:forEach>
				</td>
				<td field="contactAnimal" style="text-align:center;">
					<c:forEach var="type" items="${es.contactAnimalType}" varStatus="status2">
						<c:if test="${type == '2'}">√</c:if>
					</c:forEach>					
				</td>
				<td field="contactAnimal" style="text-align:center;">
					<c:forEach var="type" items="${es.contactAnimalType}" varStatus="status3">
						<c:if test="${type == '3'}">√</c:if>
					</c:forEach>
				</td>
				<td field="contactAnimal" style="text-align:center;">
					<c:forEach var="type" items="${es.contactAnimalType}" varStatus="status4">
						<c:if test="${type == '4'}">√</c:if>
					</c:forEach>
				</td>
				<td field="contactAnimalOther">
					<c:forEach var="type" items="${es.contactAnimalType}" varStatus="status5">
						<c:if test="${type == '99'}"><ehr:tip>${fn:trim(es.contactAnimalOther)}</ehr:tip></c:if>
					</c:forEach>				
				</td>
				<td class="btnsublist" field="btn">
					<a href="javascript:void(0)" onclick='sarsCase.editTr(this,2)'>修改</a>				
					<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)" >删除</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>


