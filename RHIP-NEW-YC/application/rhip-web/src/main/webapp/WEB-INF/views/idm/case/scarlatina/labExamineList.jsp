<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--实验室检查--%>
<div class="toolbarsublist">
	<a href="javascript:void(0)"  id="addLabExamine"><b class="xinz">添加</b></a>
</div>
<div  class="repeattable">

<table id="leTable">
	<colgroup>
		<col style="width:20%;"/>
		<col style="width:25%;"/>
        <col style="width:45%;"/>
		<col style="width:10%;"/>					
	</colgroup>	
	<thead>
		<tr>
			<th class="centerth">项目</th>
			<th class="centerth">送检日期</th>
			<th class="centerth">结果</th>
			<th class="centerth">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="leList" items="${caseDto.idmListLeList}" varStatus="status">
			<tr>
				<td field="other"><ehr:tip>${leList.other}</ehr:tip></td>
				<td field="checkFt"><ehr:tip><fmt:formatDate value="${leList.checkFt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
				<td field="checkResult"><ehr:tip>${leList.checkResult}</ehr:tip></td>
				<td class="btnsublist" field="btn">
					<a href="javascript:void(0)" onclick='scarlatinaCase.editLabTr(this)'>修改</a>				
					<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)" >删除</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>


