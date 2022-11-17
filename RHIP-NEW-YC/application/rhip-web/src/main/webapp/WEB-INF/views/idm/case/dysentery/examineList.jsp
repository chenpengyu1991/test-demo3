<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--检验结果--%>
<div class="toolbarsublist">
    （请将检验结果填写于下表）<a href="javascript:void(0)" id="addExamine" ><b class="xinz">添加</b></a>
</div>
<div class="repeattable">
	<table id="leTable" >
		<colgroup>
			<col style="width:13%;"/>
			<col style="width:10%;"/>
	        <col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
	        <col style="width:10%;"/>
	        <col style="width:60px;"/>
		</colgroup>		
		<thead>
			<tr>
				<th rowspan="2" class="centerth">日期</th>
				<th colspan="6" class="centerth">镜      检      培      养</th>
				<th rowspan="2" class="centerth">操作</th>
			</tr>
			<tr>
				<th class="centerth">红细胞</th>
				<th class="centerth">白细胞</th>
				<th class="centerth">志贺</th>
				<th class="centerth">福氏</th>
				<th class="centerth">鲍氏</th>
				<th class="centerth">宋内</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="examine" items="${caseDto.idmListLeList}" varStatus="status">
			 	<tr>
					<td field="leDt"><ehr:tip><fmt:formatDate value="${examine.leDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
					<td field="redBloodCell"><ehr:tip>${examine.redBloodCell}</ehr:tip></td>
					<td field="whiteBloodCell"><ehr:tip>${examine.whiteBloodCell}</ehr:tip></td>
					<td field="shigella"><ehr:tip>${examine.shigella}</ehr:tip></td>
					<td field="freund"><ehr:tip>${examine.freund}</ehr:tip></td>
					<td field="powell"><ehr:tip>${examine.powell}</ehr:tip></td>
					<td field="sonnei"><ehr:tip>${examine.sonnei}</ehr:tip></td>
					<td class="btnsublist" field="btn">
						<a href="javascript:void(0)" onclick='dysenteryCase.editLeTr(this)'>修改</a>
						<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)" >删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


