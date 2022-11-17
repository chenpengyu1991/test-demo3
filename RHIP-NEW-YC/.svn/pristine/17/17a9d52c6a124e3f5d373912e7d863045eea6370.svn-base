<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--就诊情况--%>

<div class="toolbarsublist">
    <a href="javascript:void(0)" id="addAc" ><b class="xinz">添加</b></a>
</div>
<div  class="repeattable">
<table id="acTable">
	<colgroup>
        <%--不要超过520px--%>
		<col style="width:80px;"/>
		<col style="width:140px;"/>
        <col style="width:120px;"/>
		<col style="width:100px;"/>
		<col style="width:80px;"/>
	</colgroup>	
	<thead>
		<tr>
	        <th class="centerth">就诊日期</th>
	        <th class="centerth">就诊医院和科室</th>
	        <th class="centerth">诊断病名</th>
	        <th class="centerth">接诊治疗医护人员</th>
	        <th class="centerth">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="ac" items="${caseDto.idmListAcList}" varStatus="status">
			<tr>
				<td field="treatmentDt"><ehr:tip><fmt:formatDate value="${ac.treatmentDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
				<td field="treatmentDepartments"><ehr:tip>${ac.treatmentDepartments}</ehr:tip></td>
				<td field="diagnosisName"><ehr:tip>${ac.diagnosisName}</ehr:tip></td>
				<td field="medicalWorkers"><ehr:tip>${ac.medicalWorkers}</ehr:tip></td>
				<td class="btnsublist" field="btn">
					<a href="javascript:void(0)" onclick='sarsCase.editTr(this,4)'>修改</a>				
					<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)" >删除</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>


