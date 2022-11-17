<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--患者接触者--%>
<div class="toolbarsublist">
	<a href="javascript:void(0)" id="addEsList" onclick="varicellaCase.popEs()" ><b class="xinz">添加</b></a>
</div>
<div class="repeattable">
	<table id="esTable">
    	<thead>
        	<tr>
            	<th class="centerth" style="width: 8%">患者姓名</th>
                <th class="centerth" style="width: 5%">性别</th>
                <th class="centerth" style="width: 5%">年龄</th>
                <th class="centerth" style="width: 10%">与患者关系</th>
                <th class="centerth">发病情况</th>
                <th class="centerth" style="width: 80px;">操作</th>
            </tr>
		</thead>
		<c:forEach var="patients" items="${caseDto.idmListEsList}" varStatus="status">
			<tr>
				<td field="name"><ehr:tip>${patients.name}</ehr:tip></td>
				<td field="sexStr"><ehr:tip>${patients.sexStr}</ehr:tip></td>
				<td field="sex" style="display:none;" title="${patients.sex}">${patients.sex}</td>
				<td field="age"><ehr:tip>${patients.age}</ehr:tip></td>
				<td field="relation"><ehr:tip>${patients.relation}</ehr:tip></td>
				<td field="attackCondition"  title="${patients.attackCondition}"><ehr:tip>${patients.attackCondition}</ehr:tip></td>
				<td class="btnsublist" field="btn">
				    <a href="javascript:void(0)" onclick="varicellaCase.editTr(this, 'esList')">修改</a>&nbsp;
				    <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>


