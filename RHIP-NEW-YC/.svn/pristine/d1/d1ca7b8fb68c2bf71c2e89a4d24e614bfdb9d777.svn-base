<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/roachList.js" type="text/javascript"></script>
<div class="repeattable" style="${displayList}">
	<table>
		<colgroup>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:40px;width: 5%;"/>
	        <col style="min-width:20px;width: 3%;"/>
			<col style="min-width:20px;width: 3%;"/>
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>
	        <col style="min-width:20px;width: 3%;"/>
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>
			<col style="min-width:20px;width: 3%;"/>
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>
	        <col style="min-width:20px;width: 3%;"/>
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>	
	        <col style="min-width:20px;width: 3%;"/>
	        <col style="min-width:80px;width: 9%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th style="text-align: center" rowspan="2">布放场所</th>
				<th style="text-align: center" rowspan="2">数据名称</th>
				<th style="text-align: center" colspan="3">德国小蠊</th>
				<th style="text-align: center" colspan="3">美洲大蠊</th>	
				<th style="text-align: center" colspan="3">澳洲大蠊</th>	
				<th style="text-align: center" colspan="3">黑胸大蠊</th>	
				<th style="text-align: center" colspan="3">褐斑大蠊</th>
				<th style="text-align: center" colspan="3">日本大蠊</th>
				<th style="text-align: center" colspan="3">其他</th>
				<th style="text-align: center" colspan="3">合计</th>
				<th style="text-align: center" rowspan="2">备注</th>
				<c:if test="${type == 'edit'}"><th style="text-align: center" rowspan="2">操作</th></c:if>				
			</tr>
			<tr>
				<th style="text-align: center" >若</th>
				<th style="text-align: center" >雌</th>
				<th style="text-align: center" >雄</th>
				<th style="text-align: center" >若</th>
				<th style="text-align: center" >雌</th>
				<th style="text-align: center" >雄</th>
				<th style="text-align: center" >若</th>
				<th style="text-align: center" >雌</th>
				<th style="text-align: center" >雄</th>
				<th style="text-align: center" >若</th>
				<th style="text-align: center" >雌</th>
				<th style="text-align: center" >雄</th>
				<th style="text-align: center" >若</th>
				<th style="text-align: center" >雌</th>
				<th style="text-align: center" >雄</th>
				<th style="text-align: center" >若</th>
				<th style="text-align: center" >雌</th>
				<th style="text-align: center" >雄</th>
				<th style="text-align: center" >若</th>
				<th style="text-align: center" >雌</th>
				<th style="text-align: center" >雄</th>
				<th style="text-align: center" >若</th>
				<th style="text-align: center" >雌</th>
				<th style="text-align: center" >雄</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="roach" items="${roachList.list}" varStatus="status">
				<tr>
					<td title="${roach.place}" rowspan="3">
						${roach.place}
					</td>
					<td>数量</td>
					<td title="${roach.blaGermanicaN}">${roach.blaGermanicaN}</td>
					<td title="${roach.blaGermanicaF}">${roach.blaGermanicaF}</td>
					<td title="${roach.blaGermanicaM}">${roach.blaGermanicaM}</td>
					<td title="${roach.perAmericanaN}">${roach.perAmericanaN}</td>
					<td title="${roach.perAmericanaF}">${roach.perAmericanaF}</td>
					<td title="${roach.perAmericanaM}">${roach.perAmericanaM}</td>
					<td title="${roach.perAustralasiaeN}">${roach.perAustralasiaeN}</td>
					<td title="${roach.perAustralasiaeF}">${roach.perAustralasiaeF}</td>
					<td title="${roach.perAustralasiaeM}">${roach.perAustralasiaeM}</td>
					<td title="${roach.perFuliginosaN}">${roach.perFuliginosaN}</td>
					<td title="${roach.perFuliginosaF}">${roach.perFuliginosaF}</td>
					<td title="${roach.perFuliginosaM}">${roach.perFuliginosaM}</td>
					<td title="${roach.perBrunneaBurmeisterN}">${roach.perBrunneaBurmeisterN}</td>
					<td title="${roach.perBrunneaBurmeisterF}">${roach.perBrunneaBurmeisterF}</td>
					<td title="${roach.perBrunneaBurmeisterM}">${roach.perBrunneaBurmeisterM}</td>
					<td title="${roach.perJaponicaN}">${roach.perJaponicaN}</td>
					<td title="${roach.perJaponicaF}">${roach.perJaponicaF}</td>
					<td title="${roach.perJaponicaM}">${roach.perJaponicaM}</td>
					<td title="${roach.otherN}">${roach.otherN}</td>
					<td title="${roach.otherF}">${roach.otherF}</td>
					<td title="${roach.otherM}">${roach.otherM}</td>
					<td title="${roach.totalN}">${roach.totalN}</td>
					<td title="${roach.totalF}">${roach.totalF}</td>
					<td title="${roach.totalM}">${roach.totalM}</td>
					<td title="${roach.remarks}" rowspan="3">${roach.remarks}</td>
					<c:if test="${type == 'edit'}"><td style="text-align:center" rowspan="3">
						
					    <a href="#this" onclick="roachMonitorAdd.initRoachEdit('${roach.id}')">修改</a>
					    <a href="#this" onclick="roachMonitorAdd.del('${roach.id}')">删除</a>
					    
					</td></c:if>
				</tr>
				<tr>
					<td>密度</td>
					<td title="${roach.blaGerDensityN}">${roach.blaGerDensityN}</td>
					<td title="${roach.blaGerDensityF}">${roach.blaGerDensityF}</td>
					<td title="${roach.blaGerDensityM}">${roach.blaGerDensityM}</td>
					<td title="${roach.perAmeDensityN}">${roach.perAmeDensityN}</td>
					<td title="${roach.perAmeDensityF}">${roach.perAmeDensityF}</td>
					<td title="${roach.perAmeDensityM}">${roach.perAmeDensityM}</td>
					<td title="${roach.perAusDensityN}">${roach.perAusDensityN}</td>
					<td title="${roach.perAusDensityF}">${roach.perAusDensityF}</td>
					<td title="${roach.perAusDensityM}">${roach.perAusDensityM}</td>
					<td title="${roach.perFulDensityN}">${roach.perFulDensityN}</td>
					<td title="${roach.perFulDensityF}">${roach.perFulDensityF}</td>
					<td title="${roach.perFulDensityM}">${roach.perFulDensityM}</td>
					<td title="${roach.perBruDensityN}">${roach.perBruDensityN}</td>
					<td title="${roach.perBruDensityF}">${roach.perBruDensityF}</td>
					<td title="${roach.perBruDensityM}">${roach.perBruDensityM}</td>
					<td title="${roach.perJapDensityN}">${roach.perJapDensityN}</td>
					<td title="${roach.perJapDensityF}">${roach.perJapDensityF}</td>
					<td title="${roach.perJapDensityM}">${roach.perJapDensityM}</td>
					<td title="${roach.otherDensityN}">${roach.otherDensityN}</td>
					<td title="${roach.otherDensityF}">${roach.otherDensityF}</td>
					<td title="${roach.otherDensityM}">${roach.otherDensityM}</td>
					<td title="${roach.totalN}">${roach.totalDensityN}</td>
					<td title="${roach.totalF}">${roach.totalDensityF}</td>
					<td title="${roach.totalM}">${roach.totalDensityM}</td>
				</tr>
				<tr>
					<td>侵害率</td>
					<td title="${roach.blaGerDgRateN}">${roach.blaGerDgRateN}</td>
					<td title="${roach.blaGerDgRateF}">${roach.blaGerDgRateF}</td>
					<td title="${roach.blaGerDgRateM}">${roach.blaGerDgRateM}</td>
					<td title="${roach.perAmeDgRateN}">${roach.perAmeDgRateN}</td>
					<td title="${roach.perAmeDgRateF}">${roach.perAmeDgRateF}</td>
					<td title="${roach.perAmeDgRateM}">${roach.perAmeDgRateM}</td>
					<td title="${roach.perAusDgRateN}">${roach.perAusDgRateN}</td>
					<td title="${roach.perAusDgRateF}">${roach.perAusDgRateF}</td>
					<td title="${roach.perAusDgRateM}">${roach.perAusDgRateM}</td>
					<td title="${roach.perFulDgRateN}">${roach.perFulDgRateN}</td>
					<td title="${roach.perFulDgRateF}">${roach.perFulDgRateF}</td>
					<td title="${roach.perFulDgRateM}">${roach.perFulDgRateM}</td>
					<td title="${roach.perBruDgRateN}">${roach.perBruDgRateN}</td>
					<td title="${roach.perBruDgRateF}">${roach.perBruDgRateF}</td>
					<td title="${roach.perBruDgRateM}">${roach.perBruDgRateM}</td>
					<td title="${roach.perJapDgRateN}">${roach.perJapDgRateN}</td>
					<td title="${roach.perJapDgRateF}">${roach.perJapDgRateF}</td>
					<td title="${roach.perJapDgRateM}">${roach.perJapDgRateM}</td>
					<td title="${roach.otherDgRateN}">${roach.otherDgRateN}</td>
					<td title="${roach.otherDgRateF}">${roach.otherDgRateF}</td>
					<td title="${roach.otherDgRateM}">${roach.otherDgRateM}</td>
					<td title="${roach.totalN}">${roach.totalDgRateN}</td>
					<td title="${roach.totalF}">${roach.totalDgRateF}</td>
					<td title="${roach.totalM}">${roach.totalDgRateM}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="roachList.search" />
		</tr>
	</table>
</div>