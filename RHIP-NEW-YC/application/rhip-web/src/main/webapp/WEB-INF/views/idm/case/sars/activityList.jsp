<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--发病前一周内逐日活动情况--%>

<div class="toolbarsublist">
    <a href="javascript:void(0)" id="addEsActivity" ><b class="xinz">添加</b></a>
</div>
<div  class="repeattable">
<table id="activityTable">
	<colgroup>
        <%--不要超过520px--%>
		<col style="width:80px;"/>
		<col style="width:130px;"/>
        <col style="width:130px;"/>
		<col style="width:100px;"/>
		<col style="width:80px;"/>
	</colgroup>	
	<thead>
		<tr>
	        <th class="centerth">日期</th>
	        <th class="centerth">活动内容</th>
	        <th class="centerth">活动地点</th>
	        <th class="centerth" title="接触人员（有无接触发热等可疑病人）">接触人员</th>
	        <th class="centerth">操作</th>	        
		</tr>
	</thead>
	<tbody>
		<c:forEach var="es" items="${caseDto.idmListEsActivity}" varStatus="status">
			<tr>
				<td field="flag" style="display:none;"><ehr:tip>${es.flag}</ehr:tip></td>
				<td field="activityDt"><ehr:tip><fmt:formatDate value="${es.activityDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
				<td field="activityContent"><ehr:tip>${es.activityContent}</ehr:tip></td>
				<td field="activityAddr"><ehr:tip>${es.activityAddr}</ehr:tip></td>
				<td field="contactName"><ehr:tip>${es.contactName}</ehr:tip></td>
				<td class="btnsublist" field="btn">
					<a href="javascript:void(0)" onclick='sarsCase.editTr(this,1)'>修改</a>				
					<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)" >删除</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<span>注：每一项活动内容或活动地点单独填写一项</span>
</div>


