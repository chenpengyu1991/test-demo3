<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/waterIodine/monitorInfoEdit.js"></script>
<div id="infoEditFormDiv">
<div id="top"></div>
<div class="toolbar">
	<a href="javascript:void(0)" id="back"><b class="fanhui">返回</b></a>
</div>
<form id="infoEditForm">
	<div class="postcontent contentfixed">
		<i class="popno">农村水碘监测情况登记</i>
		<div class="postdiv">
			<fieldset>
				<legend>基本信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width:70px; width: 15%;"/>
						<col style="min-width:100px; width: 16%;"/>
						<col style="min-width:70px; width: 15%;"/>
						<col style="min-width:100px; width: 18%;"/>
	                    <col style="min-width:70px; width: 17%;"/>
	                    <col style="min-width:183px; width: 18%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>监测点编号</th>
						<td>${monitor.monitorId}</td>
						<th>水厂名称</th>
						<td>${monitor.factoryName}</td>
						<th>建厂时间</th>
						<td><fmt:formatDate value="${monitor.factoryConstructionTime}" pattern="yyyy/MM/dd"/></td>
					</tr>
					<tr>
                        <th>水厂类型</th>
                        <td><ehr:dic dicmeta="FS10265" code="${monitor.monitorType}" /></td>
                        <th>水厂地址</th>
						<td colspan="3">河南省永城市<ehr:dic dicmeta="FS990001" code="${monitor.gbCode}" />
							<ehr:dic dicmeta="FS990001" code="${monitor.villageCode}" /></td>
					</tr>
					<tr>
                        <th>监测类型</th>
                        <td><ehr:dic dicmeta="FS10264" code="${monitor.factoryType}" /></td>
                        <th>自检能力</th>
						<td><ehr:dic dicmeta="PH00002" code="${monitor.selfCheckingAbility}" /></td>
						<th>消毒情况</th>
						<td><ehr:dic dicmeta="PH00002" code="${monitor.disinfectSituation}" /></td>
					</tr>
					<tr>
						<th>水源类型</th>
						<td><ehr:dic dicmeta="FS10268" code="${monitor.waterSourceType}" /></td>
						<th>井深</th>
						<td>${monitor.wellDepth}米</td>
						<th><label class="required">水处理方式</label></th>
						<td><ehr:dic dicmeta="FS10269" code="${monitor.waterProcessType}" /></td>
					</tr>
					<tr>
						<th>供水规模</th>
						<td>${monitor.waterSupplyScale}万吨/天</td>
						<th>覆盖范围</th>
						<td>${monitor.coverageArea}</td>
						<th>覆盖人口</th>
						<td>${monitor.coveragePopulation}万</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>水碘监测</legend>
				<div class="repeattable">
				<table>
					<tbody>
					<tr>
						<td style="text-align:center;" colspan="4">枯水期</td>
						<td style="text-align:center;" colspan="4">丰水期</td>
					</tr>
					<tr>
						<th style="text-align:center;" colspan="2">出厂水</th>
						<th style="text-align:center;" colspan="2">末梢水</th>
						<th style="text-align:center;" colspan="2">出厂水</th>
						<th style="text-align:center;" colspan="2">末梢水</th>
					</tr>
					<tr>
						<td style="text-align:center;">监测水样数</td>
						<td style="text-align:center;">水碘含量(μg/L)</td>
						<td style="text-align:center;">监测水样数</td>
						<td style="text-align:center;">水碘含量(μg/L)</td>
						<td style="text-align:center;">监测水样数</td>
						<td style="text-align:center;">水碘含量(μg/L)</td>
						<td style="text-align:center;">监测水样数</td>
						<td style="text-align:center;">水碘含量(μg/L)</td>
					</tr>
					<tr>
						<td>${monitor.dryFinishedSamples}</td>
						<td>${monitor.dryFinishedIodine}</td>
						<td>${monitor.dryTipSamples}</td>
						<td>${monitor.dryTipIodine}</td>
						<td>${monitor.wetFinishedSamples}</td>
						<td>${monitor.wetFinishedIodine}</td>
						<td>${monitor.wetTipSamples}</td>
						<td>${monitor.wetTipIodine}</td>
					</tr>
					</tbody>
				</table>
				</div>
			</fieldset>
			<fieldset>
				<legend>调查记录</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width:70px; width: 15%;"/>
						<col style="min-width:100px; width: 18%;"/>
						<col style="min-width:70px; width: 15%;"/>
						<col style="min-width:100px; width: 18%;"/>
	                    <col style="min-width:70px; width: 17%;"/>
	                    <col style="min-width:183px; width: 16%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>调查人</th>
						<td>${monitor.investigator}</td>
						<th>调查单位</th>
						<td>${monitor.investigateUnit}</td>
						<th>调查时间</th>
						<td><fmt:formatDate value="${monitor.investigateTime}" pattern="yyyy/MM/dd"/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</form>
</div>