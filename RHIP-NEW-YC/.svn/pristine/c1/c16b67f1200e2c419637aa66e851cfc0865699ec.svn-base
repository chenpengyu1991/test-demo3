<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/mosquitoesList.js" type="text/javascript"></script>
<div class="repeattable" style="${displayList}">
	<table>
		<colgroup>
			<col style="min-width:50px;width: 7%;"/>
	        <col style="min-width:60px;width: 7%;"/>
			<col style="min-width:60px;width: 7%;"/>
	        <col style="min-width:60px;width: 7%;"/>	
	        <col style="min-width:60px;width: 7%;"/>	
	        <col style="min-width:60px;width: 7%;"/>	
	        <col style="min-width:60px;width: 7%;"/>
	        <col style="min-width:60px;width: 7%;"/>	
	        <col style="min-width:60px;width: 7%;"/>	
	        
	        <col style="min-width:60px;width: 7%;"/>
	        <col style="min-width:60px;width: 7%;"/>
	        <col style="min-width:60px;width: 8%;"/>
	        <col style="min-width:100px;width: 15%;"/>		
		</colgroup>	
		<thead>
			<tr>
				<th style="text-align: center">地点（户名）</th>
				<th style="text-align: center">淡色（致倦）库蚊</th>
				<th style="text-align: center">三带喙库蚊</th>
				<th style="text-align: center">白纹伊蚊</th>	
				<th style="text-align: center">埃及伊蚊</th>	
				<th style="text-align: center">中华按蚊</th>	
				<th style="text-align: center">嗜人按蚊</th>
				<th style="text-align: center">大劣按蚊</th>
				
				<th style="text-align: center">微小按蚊</th>
				<th style="text-align: center">其它</th>
				<th style="text-align: center">合计</th>
				<th style="text-align: center">备注</th>
				<c:if test="${type == 'edit'}"><th style="text-align: center">操作</th></c:if>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mosquitoes" items="${mosquitoesList.list}" varStatus="status">
				<tr>
					<td title="${mosquitoes.place}">
						${mosquitoes.place}
					</td>
					<td title="${mosquitoes.culexPi}">
						${mosquitoes.culexPi}
					</td>
					<td title="${mosquitoes.culexTr}">
						${mosquitoes.culexTr}
					</td>
					<td title="${mosquitoes.aedesAl}">
						${mosquitoes.aedesAl}
					</td>
					<td title="${mosquitoes.aedesAe}">${mosquitoes.aedesAe}</td>
					<td title="${mosquitoes.anS}">${mosquitoes.anS}</td>
					<td title="${mosquitoes.anA}">${mosquitoes.anA}</td>
					<td title="${mosquitoes.anD}">${mosquitoes.anD}</td>
					<td title="${mosquitoes.anM}">${mosquitoes.anM}</td>
					<td title="${mosquitoes.other}">${mosquitoes.other}</td>
					<td title="${mosquitoes.total}">${mosquitoes.total}</td>
					<td title="${mosquitoes.remarks}">${mosquitoes.remarks}</td>
					<c:if test="${type == 'edit'}"><td style="text-align:center">
						
					    <a href="#this" onclick="mosquitoesMonitorAdd.initMosquitoesEdit('${mosquitoes.id}')">修改</a>
					    <a href="#this" onclick="mosquitoesMonitorAdd.del('${mosquitoes.id}')">删除</a>
					    
					</td></c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="mosquitoesList.search" />
		</tr>
	</table>
</div>