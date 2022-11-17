<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--消毒情况--%>
<div class="toolbarsublist">
    <a href="javascript:void(0)" id="addDisinfect" ><b class="xinz">添加</b></a>
</div>
<div class="repeattable">
	<table id="disinfectTable" >
		<colgroup>
			<col style="width:60px;"/>
			<col style="width:100px;"/>
	        <col style="width:60px;"/>
			<col style="width:60px;"/>
			<col style="width:80px;"/>
			<col style="width:100px;"/>
	        <col style="width:60px;"/>
		</colgroup>		
		<thead>
			<tr>
				<th class="centerth">对象</th>
				<th class="centerth">消毒药物</th>
				<th class="centerth">药物浓度</th>
				<th class="centerth">数 量</th>
				<th class="centerth">消毒时间</th>
				<th class="centerth">消毒方式</th>
				<th class="centerth">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="disinfect" items="${caseDto.idmDisinfectList}" varStatus="status">
			 	<tr>
					<td field="objectStr"><ehr:tip><ehr:dic dicmeta='IDM00209' code='${disinfect.object}'/></ehr:tip></td>
					<td field="object" style="display:none;"><ehr:tip>${disinfect.object}</ehr:tip></td>
					<td field="sterilizeDrug"><ehr:tip>${disinfect.sterilizeDrug}</ehr:tip></td>
					<td field="drugConcentration"><ehr:tip>${disinfect.drugConcentration}</ehr:tip></td>
					<td field="drugNum"><ehr:tip>${disinfect.drugNum}</ehr:tip></td>
					<td field="attackDt"><ehr:tip><fmt:formatDate value="${disinfect.attackDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
					<td field="sterilizeType"><ehr:tip>${disinfect.sterilizeType}</ehr:tip></td>
					<td class="btnsublist" field="btn">
						<a href="javascript:void(0)" onclick='dysenteryCase.editDisTr(this)'>修改</a>
						<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)" >删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


