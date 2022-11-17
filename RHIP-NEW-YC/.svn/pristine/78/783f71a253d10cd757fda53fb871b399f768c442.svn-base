<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/disinfectionRsList.js" type="text/javascript"></script>
<div class="repeattable" style="${displayList}">
	<table>
		<colgroup>
			<col style="min-width:60px;width: 12%;"/>
	        <col style="min-width:40px;width: 6%;"/>
	        <col style="min-width:40px;width: 3%;"/>
	        <col style="min-width:40px;width: 3%;"/>	
	        <col style="min-width:40px;width: 3%;"/>
	        <col style="min-width:100px;width: 3%;"/>
	        <col style="min-width:40px;width: 3%;"/>	
	        <col style="min-width:40px;width: 3%;"/>
	        <col style="min-width:100px;width: 3%;"/>
	        <col style="min-width:40px;width: 3%;"/>	
	        <col style="min-width:40px;width: 3%;"/>
	        <col style="min-width:100px;width: 3%;"/>
			<col style="min-width:40px;width: 3%;"/>	
	        <col style="min-width:40px;width: 3%;"/>
	        <col style="min-width:40px;width: 3%;"/>
	        <col style="min-width:40px;width: 3%;"/>	
	        <col style="min-width:40px;width: 3%;"/>
	        <col style="min-width:100px;width: 3%;"/>
	        <col style="min-width:40px;width: 3%;"/>	
	        <col style="min-width:40px;width: 3%;"/>
	        <col style="min-width:100px;width: 3%;"/>
	        <col style="min-width:40px;width: 3%;"/>	
	        <col style="min-width:40px;width: 3%;"/>
	        <col style="min-width:40px;width: 3%;"/>		
	        <col style="min-width:40px;width: 6%;"/>
	        <col style="min-width:100px;width: 10%;"/>			
		</colgroup>	
		<thead>
			<tr>
				<th style="text-align: center" rowspan="2">科室</th>
				<th style="text-align: center" rowspan="2">合格率%</th>
				<th style="text-align: center" colspan="5">无菌试验</th>
				<th style="text-align: center" colspan="5">乙肝表面抗原</th>		
				<th style="text-align: center" colspan="2">细菌总数</th>	
				<th style="text-align: center" colspan="2">金黄色葡萄球菌</th>
				<th style="text-align: center" colspan="2">大肠杆菌</th>
				<th style="text-align: center" colspan="3">空气细菌</th>
				<th style="text-align: center" colspan="3">压力蒸汽灭菌</th>
				<th style="text-align: center" rowspan="2">合   计</th>
				<c:if test="${type == 'edit'}"><th style="text-align: center" rowspan="2">操作</th></c:if>				
			</tr>
			<tr>
				<th style="text-align: center">针尖</th>
				<th style="text-align: center">注射器</th>
				<th style="text-align: center">纱布</th>
				<th style="text-align: center">刀片</th>		
				<th style="text-align: center">器械保存液</th>	
				<th style="text-align: center">口腔表</th>
				<th style="text-align: center">刮宫器</th>
				<th style="text-align: center">牙钳</th>
				<th style="text-align: center">牙钻</th>
				<th style="text-align: center">内窥镜</th>
				<th style="text-align: center">手</th>
				<th style="text-align: center">操作面台</th>
				<th style="text-align: center">手</th>
				<th style="text-align: center">操作面台</th>
				<th style="text-align: center">手</th>
				<th style="text-align: center">操作面台</th>
				
				<th style="text-align: center">手术室</th>
				<th style="text-align: center">产房</th>
				<th style="text-align: center">监护室</th>
				
				<th style="text-align: center">指示胶带</th>
				<th style="text-align: center">化学指示卡</th>
				<th style="text-align: center">生物指示菌片</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="disinfectionRs" items="${disinfectionRsList.list}" varStatus="status">
				<tr>
					<td title="${disinfectionRs.deptName}" rowspan="3">${disinfectionRs.deptName}</td>
					<td >采样数</td>
					<td title="${disinfectionRs.pinpointTotal}">${disinfectionRs.pinpointTotal}</td>
					<td title="${disinfectionRs.syringeTotal}">${disinfectionRs.syringeTotal}</td>
					<td title="${disinfectionRs.gauzeTotal}">${disinfectionRs.gauzeTotal}</td>
					<td title="${disinfectionRs.bladeTotal}">${disinfectionRs.bladeTotal}</td>					
					<td title="${disinfectionRs.eqPreSolutionTotal}">${disinfectionRs.eqPreSolutionTotal}</td>
					<td title="${disinfectionRs.mouthTotal}">${disinfectionRs.mouthTotal}</td>
					<td title="${disinfectionRs.cureInstTotal}">${disinfectionRs.cureInstTotal}</td>
					<td title="${disinfectionRs.forcepsTotal}">${disinfectionRs.forcepsTotal}</td>
					<td title="${disinfectionRs.engineBitTotal}">${disinfectionRs.engineBitTotal}</td>
					<td title="${disinfectionRs.endoscopeTotal}">${disinfectionRs.endoscopeTotal}</td>
					<td title="${disinfectionRs.hdGermTotal}">${disinfectionRs.hdGermTotal}</td>
					<td title="${disinfectionRs.tlGermTotal}">${disinfectionRs.tlGermTotal}</td>
					<td title="${disinfectionRs.hdMrsaTotal}">${disinfectionRs.hdMrsaTotal}</td>
					<td title="${disinfectionRs.tlMrsaTotal}">${disinfectionRs.tlMrsaTotal}</td>
					<td title="${disinfectionRs.hdColicinTotal}">${disinfectionRs.hdColicinTotal}</td>
					<td title="${disinfectionRs.tlColicinTotal}">${disinfectionRs.tlColicinTotal}</td>
						<td title="${disinfectionRs.orBacteriaTotal}">${disinfectionRs.orBacteriaTotal}</td>
					<td title="${disinfectionRs.drBacteriaTotal}">${disinfectionRs.drBacteriaTotal}</td>
					<td title="${disinfectionRs.icuBacteriaTotal}">${disinfectionRs.icuBacteriaTotal}</td>
					<td title="${disinfectionRs.itpssTotal}">${disinfectionRs.itpssTotal}</td>
					<td title="${disinfectionRs.cicpssTotal}">${disinfectionRs.cicpssTotal}</td>
					<td title="${disinfectionRs.bibpssTotal}">${disinfectionRs.bibpssTotal}</td>
					<td title="${disinfectionRs.total}">${disinfectionRs.total}</td>
					<c:if test="${type == 'edit'}"><td style="text-align:center" rowspan="3">
						
					    <a href="#this" onclick="disinfectionMonitorAdd.initDisinfectionRsEdit('${disinfectionRs.id}')">修改</a>
					    <a href="#this" onclick="disinfectionMonitorAdd.del('${disinfectionRs.id}')">删除</a>
					    
					</td></c:if>
				</tr>
				<tr>
					<td >合格数</td>
					<td title="${disinfectionRs.pinpointAceptNum}">${disinfectionRs.pinpointAceptNum}</td>
					<td title="${disinfectionRs.syringeAceptNum}">${disinfectionRs.syringeAceptNum}</td>
					<td title="${disinfectionRs.gauzeAceptNum}">${disinfectionRs.gauzeAceptNum}</td>
					<td title="${disinfectionRs.bladeAceptNum}">${disinfectionRs.bladeAceptNum}</td>
					<td title="${disinfectionRs.eqPreSolutionAceptNum}">${disinfectionRs.eqPreSolutionAceptNum}</td>
					<td title="${disinfectionRs.mouthAceptNum}">${disinfectionRs.mouthAceptNum}</td>
					<td title="${disinfectionRs.cureInstAceptNum}">${disinfectionRs.cureInstAceptNum}</td>
					<td title="${disinfectionRs.forcepsAceptNum}">${disinfectionRs.forcepsAceptNum}</td>
					<td title="${disinfectionRs.engineBitAceptNum}">${disinfectionRs.engineBitAceptNum}</td>
					<td title="${disinfectionRs.endoscopeAceptNum}">${disinfectionRs.endoscopeAceptNum}</td>
					<td title="${disinfectionRs.hdGermAceptNum}">${disinfectionRs.hdGermAceptNum}</td>
					<td title="${disinfectionRs.tlGermAceptNum}">${disinfectionRs.tlGermAceptNum}</td>
					<td title="${disinfectionRs.hdMrsaAceptNum}">${disinfectionRs.hdMrsaAceptNum}</td>
					<td title="${disinfectionRs.tlMrsaAceptNum}">${disinfectionRs.tlMrsaAceptNum}</td>
					<td title="${disinfectionRs.hdColicinAceptNum}">${disinfectionRs.hdColicinAceptNum}</td>
					<td title="${disinfectionRs.tlColicinAceptNum}">${disinfectionRs.tlColicinAceptNum}</td>
						<td title="${disinfectionRs.orBacteriaAceptNum}">${disinfectionRs.orBacteriaAceptNum}</td>
					<td title="${disinfectionRs.drBacteriaAceptNum}">${disinfectionRs.drBacteriaAceptNum}</td>
					<td title="${disinfectionRs.icuBacteriaAceptNum}">${disinfectionRs.icuBacteriaAceptNum}</td>
					<td title="${disinfectionRs.itpssAceptNum}">${disinfectionRs.itpssAceptNum}</td>
					<td title="${disinfectionRs.cicpssAceptNum}">${disinfectionRs.cicpssAceptNum}</td>
					<td title="${disinfectionRs.bibpssAceptNum}">${disinfectionRs.bibpssAceptNum}</td>
					<td title="${disinfectionRs.aceptNum}">${disinfectionRs.aceptNum}</td>
				</tr>
				<tr>
					<td >合格率</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.pinpointAceptNum/disinfectionRs.pinpointTotal*100}" maxFractionDigits="0" /> ">
					<fmt:formatNumber type="number" value="${disinfectionRs.pinpointAceptNum/disinfectionRs.pinpointTotal*100}" maxFractionDigits="0" />  
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.syringeAceptNum/disinfectionRs.syringeTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.syringeAceptNum/disinfectionRs.syringeTotal*100}" maxFractionDigits="0" /> 
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.gauzeAceptNum/disinfectionRs.gauzeTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.gauzeAceptNum/disinfectionRs.gauzeTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.bladeAceptNum/disinfectionRs.bladeTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.bladeAceptNum/disinfectionRs.bladeTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.eqPreSolutionAceptNum/disinfectionRs.eqPreSolutionTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.eqPreSolutionAceptNum/disinfectionRs.eqPreSolutionTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.mouthAceptNum/disinfectionRs.mouthTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.mouthAceptNum/disinfectionRs.mouthTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.cureInstAceptNum/disinfectionRs.cureInstTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.cureInstAceptNum/disinfectionRs.cureInstTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.forcepsAceptNum/disinfectionRs.forcepsTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.forcepsAceptNum/disinfectionRs.forcepsTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.engineBitAceptNum/disinfectionRs.engineBitTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.engineBitAceptNum/disinfectionRs.engineBitTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.endoscopeAceptNum/disinfectionRs.endoscopeTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.endoscopeAceptNum/disinfectionRs.endoscopeTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.hdGermAceptNum/disinfectionRs.hdGermTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.hdGermAceptNum/disinfectionRs.hdGermTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.tlGermAceptNum/disinfectionRs.tlGermTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.tlGermAceptNum/disinfectionRs.tlGermTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.hdMrsaAceptNum/disinfectionRs.hdMrsaTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.hdMrsaAceptNum/disinfectionRs.hdMrsaTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.tlMrsaAceptNum/disinfectionRs.tlMrsaTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.tlMrsaAceptNum/disinfectionRs.tlMrsaTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.hdColicinAceptNum/disinfectionRs.hdColicinTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.hdColicinAceptNum/disinfectionRs.hdColicinTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.tlColicinAceptNum/disinfectionRs.tlColicinTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.tlColicinAceptNum/disinfectionRs.tlColicinTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.orBacteriaAceptNum/disinfectionRs.orBacteriaTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.orBacteriaAceptNum/disinfectionRs.orBacteriaTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.drBacteriaAceptNum/disinfectionRs.drBacteriaTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.drBacteriaAceptNum/disinfectionRs.drBacteriaTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.icuBacteriaAceptNum/disinfectionRs.icuBacteriaTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.icuBacteriaAceptNum/disinfectionRs.icuBacteriaTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.itpssAceptNum/disinfectionRs.itpssTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.itpssAceptNum/disinfectionRs.itpssTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.cicpssAceptNum/disinfectionRs.cicpssTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.cicpssAceptNum/disinfectionRs.cicpssTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.bibpssAceptNum/disinfectionRs.bibpssTotal*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.bibpssAceptNum/disinfectionRs.bibpssTotal*100}" maxFractionDigits="0" />
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionRs.aceptNum/disinfectionRs.total*100}" maxFractionDigits="0" />">
						<fmt:formatNumber type="number" value="${disinfectionRs.aceptNum/disinfectionRs.total*100}" maxFractionDigits="0" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="disinfectionRsList.search" />
		</tr>
	</table>
</div>