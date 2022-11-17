<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--发病后至隔离治疗前逐日活动情况--%>
<div class="toolbarsublist">
    <a href="javascript:void(0)" id="addEsLeave" ><b class="xinz">添加</b></a>
</div>
<div  class="repeattable">

<table id="leaveTable">
	<colgroup>
        <%--不要超过520px--%>
		<col style="width:60px;"/>
		<col style="width:120px;"/>
        <col style="width:120px;"/>
		<col style="width:100px;"/>
		<col style="width:60px;"/>
	</colgroup>	
	<thead>
		<tr>
			<th class="centerth">日期</th>
			<th class="centerth">活动内容</th>
			<th class="centerth">活动地点</th>
			<th class="centerth">接触人员</th>
			<th class="centerth">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="leave" items="${caseDto.idmListEsLeave}" varStatus="status">
			<tr>
				<td field="flag" style="display:none;"><ehr:tip>${leave.flag}</ehr:tip></td>
				<td field="activityDt"><ehr:tip><fmt:formatDate value="${leave.activityDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
				<td field="activityContent"><ehr:tip>${leave.activityContent}</ehr:tip></td>
				<td field="activityAddr"><ehr:tip>${leave.activityAddr}</ehr:tip></td>
				<td field="contactName"><ehr:tip>${leave.contactName}</ehr:tip></td>
				<td class="btnsublist" field="btn">
					<a href="javascript:void(0)" onclick='sarsCase.editTr(this,3)'>修改</a>				
					<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)" >删除</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>


