<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/treatmentList.js" type="text/javascript"></script>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:150px;width: 25%;"/>
	        <col style="min-width:80px;width: 15%;"/>
			<col style="min-width:40px;width: 15%;"/>	
	        <col style="min-width:40px;width: 15%;"/>
	        <col style="min-width:100px;width: 15%;"/>		
	        <col style="min-width:100px;width: 15%;"/>			
		</colgroup>	
		<thead>
			<tr>
				<th style="text-align: center">处理时间</th>
				<th style="text-align: center">污水处理量</th>
				<th style="text-align: center">消毒剂投加量</th>		
				<th style="text-align: center">余氯值</th>	
				<th style="text-align: center">处理人</th>
				<c:if test="${type == 'edit'}"><th style="text-align: center">操作</th>	</c:if>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="treatment" items="${treatmentList.list}" varStatus="status">
				<tr>
					<td title='<fmt:formatDate value="${treatment.treatmentDate}" pattern="yyyy-MM-dd HH:mm:ss" />' class="centertd">
						<fmt:formatDate value="${treatment.treatmentDate}" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td title="${treatment.treatmentQuantity}">
						${treatment.treatmentQuantity}
					</td>
					<td title="${treatment.dosingQuantity}">${treatment.dosingQuantity}</td>
					<td title="${treatment.residualChlorineVal}">${treatment.residualChlorineVal}</td>
					<td title="${treatment.assigner}">${treatment.assigner}</td>
					<c:if test="${type == 'edit'}"><td style="text-align:center">
						
					    <a href="#this" onclick="sewageTreatmentAdd.initTreatmentEdit('${treatment.id}')">修改</a>
					    <a href="#this" onclick="sewageTreatmentAdd.del('${treatment.id}')">删除</a>
					    
					</td></c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="treatmentList.search" />
		</tr>
	</table>
</div>