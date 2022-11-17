<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--密切接触者--%>
<div class="toolbarsublist">
	<a href="javascript:void(0)" id="addEfcList" onclick="typhusCase.popEfc()"><b class="xinz">添加</b></a>
	<a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('306')"><b class="import">导入</b></a>	
</div>
<div class="repeattable">
	<table id="efcTable">
    	<thead>
            <tr>
				<th class="centerth" style="width: 10%">姓名</th>
				<th class="centerth" style="width: 5%">性别</th>
				<th class="centerth" style="width: 5%">年龄</th>
				<th class="centerth" style="width: 26%">住址</th>
				<th class="centerth" style="width: 12%">预防接种日期</th>
				<th class="centerth" style="width: 12%">灭虱日期</th>
				<th class="centerth" style="width: 20%">接触方式</th>
				<th class="centerth" style="min-width:120px; width: 10%">操作</th>
			</tr>
        </thead>
        <c:forEach var="patients" items="${caseDto.idmListEfcList}" varStatus="status">
	    	<tr>
	        	<td field="name"><ehr:tip>${patients.name}</ehr:tip></td>
	          	<td field="sexStr"><ehr:tip>${patients.sexStr}</ehr:tip></td>
	          	<td field="sex" style="display:none;"><ehr:tip>${patients.sex}</ehr:tip></td>
	          	<td field="age"><ehr:tip>${patients.age}</ehr:tip></td>
	          	<td field="unitAddr"><ehr:tip>${patients.unitAddr}</ehr:tip></td>
	          	<td class="centertd" field="vaccineDt"><ehr:tip><fmt:formatDate pattern='yyyy/MM/dd' value='${patients.vaccineDt}'/></ehr:tip></td>
	          	<td class="centertd" field="delousingDt"><ehr:tip><fmt:formatDate pattern='yyyy/MM/dd' value='${patients.delousingDt}'/></ehr:tip></td>
	          	<td field="contactType"><ehr:tip>${patients.contactType}</ehr:tip></td>
	          	<td class="btnsublist centertd" field="btn">
	            	<a href="javascript:void(0)" onclick="typhusCase.editTr(this, 'efcList')">修改</a>&nbsp;
	              	<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
	          	</td>
	      	</tr>
  		</c:forEach>
	</table>
</div>


