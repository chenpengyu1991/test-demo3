<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/flyList.js" type="text/javascript"></script>
<div class="repeattable" style="${displayList}">
	<table>
		<colgroup>
			<col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:80px;width: 8%;"/>
			<col style="min-width:40px;width: 4%;"/>
	        <col style="min-width:40px;width: 4%;"/>	
	        <col style="min-width:40px;width: 4%;"/>	
	        <col style="min-width:40px;width: 4%;"/>	
	        <col style="min-width:40px;width: 4%;"/>
	        <col style="min-width:40px;width: 4%;"/>
	        <col style="min-width:40px;width: 4%;"/>	
	        <col style="min-width:40px;width: 4%;"/>	
	        <col style="min-width:40px;width: 4%;"/>	
	        <col style="min-width:40px;width: 4%;"/>
	        <col style="min-width:40px;width: 4%;"/>
	        <col style="min-width:40px;width: 4%;"/>	
	        <col style="min-width:40px;width: 4%;"/>	
	        <col style="min-width:40px;width: 4%;"/>	
	        <col style="min-width:40px;width: 4%;"/>
	        <col style="min-width:40px;width: 4%;"/>
	        <col style="min-width:40px;width: 4%;"/>	
	        <col style="min-width:40px;width: 4%;"/>	
	        <col style="min-width:80px;width: 4%;"/>	
	        <col style="min-width:100px;width: 8%;"/>			
		</colgroup>	
		<thead>
			<tr>
				<th style="text-align: center">环境类型</th>
				<th style="text-align: center">地点</th>
				<th style="text-align: center">家蝇</th>	
				<th style="text-align: center">市蝇</th>	
				<th style="text-align: center">丝光绿蝇</th>	
				<th style="text-align: center">铜绿蝇</th>
				<th style="text-align: center">亮绿蝇</th>
				<th style="text-align: center">大头金蝇</th>
				<th style="text-align: center">伏蝇</th>
				<th style="text-align: center">新陆原伏蝇</th>
				<th style="text-align: center">巨尾阿丽蝇</th>
				<th style="text-align: center">红头丽蝇</th>
				<th style="text-align: center">厩腐蝇</th>
				<th style="text-align: center">夏厕蝇</th>
				<th style="text-align: center">元厕蝇</th>
				<th style="text-align: center">棕尾别麻蝇</th>
				<th style="text-align: center">其它</th>
				<th style="text-align: center">合计</th>
				<th style="text-align: center">蝇笼数</th>
				<th style="text-align: center">密度(只/笼)</th>
				<th style="text-align: center">备注</th>
				<c:if test="${type == 'edit'}"><th style="text-align: center">操作</th></c:if>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="fly" items="${flyList.list}" varStatus="status">
				<tr>
					<td title='<ehr:dic dicmeta="DMBC00007" code="${fly.environment}"/>' class="centertd">
						<ehr:dic dicmeta="DMBC00007" code="${fly.environment}"/>
					</td>
					<td title="${fly.place}">
						${fly.place}
					</td>
					<td title="${fly.houseFly}">${fly.houseFly}</td>
					<td title="${fly.muscaSorbens}">${fly.muscaSorbens}</td>
					<td title="${fly.lucilliaSericata}">${fly.lucilliaSericata}</td>
					<td title="${fly.luciliaCuprina}">${fly.luciliaCuprina}</td>
					<td title="${fly.luciliaIllustris}">${fly.luciliaIllustris}</td>
					<td title="${fly.chrysomyiaMegacephala}">${fly.chrysomyiaMegacephala}</td>
					<td title="${fly.phormiaRegina}">${fly.phormiaRegina}</td>
					<td title="${fly.protophormiaTerraenovae}">${fly.protophormiaTerraenovae}</td>
					<td title="${fly.aldrichinaGrahami}">${fly.aldrichinaGrahami}</td>
					<td title="${fly.calliphoraVicina}">${fly.calliphoraVicina}</td>
					<td title="${fly.muscinaStabulans}">${fly.muscinaStabulans}</td>
					<td title="${fly.fanniaCanicularis}">${fly.fanniaCanicularis}</td>
					<td title="${fly.fanniaPrisca}">${fly.fanniaPrisca}</td>
					<td title="${fly.boettcheriscaPeregrina}">${fly.boettcheriscaPeregrina}</td>
					<td title="${fly.other}">${fly.other}</td>
					<td title="${fly.total}">${fly.total}</td>
					<td title="${fly.cageCount}">${fly.cageCount}</td>
					<td title="${fly.density}">${fly.density}</td>
					<td title="${fly.remarks}">${fly.remarks}</td>
					<c:if test="${type == 'edit'}"><td style="text-align:center">
						
					    <a href="#this" onclick="flyMonitorAdd.initFlyEdit('${fly.id}')">修改</a>
					    <a href="#this" onclick="flyMonitorAdd.del('${fly.id}')">删除</a>
					    
					</td></c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="flyList.search" />
		</tr>
	</table>
</div>