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
	<a href="javascript:void(0)" id="save"><b class="baocun">保存</b></a>
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
						<td><input type="text" name="monitorId" value="${monitor.monitorId}"  style="width: 120px" reg="{'maxlength':50}"/>
								<input type="hidden" name="id" value="${monitor.id}"  /></td>
						<th><label class="required">水厂名称</label></th>
						<td><input type="text" name="factoryName" value="${monitor.factoryName}" style="width: 200px" reg='{"required":"true", "maxlength":"20"}' /></td>
						<th><label class="required">建厂时间</label></th>
						<td><tag:dateInput onlypast="true" name="factoryConstructionTime" pattern="yyyy/MM/dd" date="${monitor.factoryConstructionTime}" style="width:75px;" reg='{"required":"true"}'/></td>
					</tr>
					<tr>
                        <th><label class="required">水厂类型</label></th>
                        <td><ehr:dic-list name="monitorType" dicmeta="FS10265" value="${monitor.monitorType}"  reg="{'required':'true'}" /></td>
                        <th><label class="required">水厂地址</label></th>
						<td colspan="3">河南省永城市
                            <%-- <ehr:dic-town-village townValue="${monitor.gbCode}" townName="gbCode" 
                                                  villageValue="${monitor.villageCode}"  villageName="villageCode" reg='{"required":"true"}' /> --%>
							<ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" 
														 townId="patown_address"  streetName="villageCode"
														 townName="gbCode"  streetValue="${monitor.villageCode}"
														 townValue="${monitor.gbCode}"  width="150px;" reg='{"required":"true"}'/>
						
						</td>
					</tr>
					<tr>
                        <th><label class="required">监测类型</label></th>
                        <td><ehr:dic-list name="factoryType" dicmeta="FS10264" value="${monitor.factoryType}" reg="{'required':'true'}"/></td>
                        <th><label class="required">自检能力</label></th>
						<td><ehr:dic-radio name="selfCheckingAbility" dicmeta="PH00002" value="${monitor.selfCheckingAbility}" code="1,2" reg="{'required':'true'}" /></td>
						<th><label class="required">消毒情况</label></th>
						<td><ehr:dic-radio name="disinfectSituation" dicmeta="PH00002" value="${monitor.disinfectSituation}" code="1,2" reg="{'required':'true'}" /></td>
					</tr>
					<tr>
						<th><label class="required">水源类型</label></th>
						<td><ehr:dic-list name="waterSourceType" dicmeta="FS10268" value="${monitor.waterSourceType}" reg="{'required':'true'}" /></td>
						<th>井深(米)</th>
						<td><tag:numberInput name="wellDepth" value="${monitor.wellDepth}" reg="{'max':99999}"/></td>
						<th><label class="required">水处理方式</label></th>
						<td><ehr:dic-list name="waterProcessType" dicmeta="FS10269" value="${monitor.waterProcessType}" reg="{'required':'true'}" /></td>
					</tr>
					<tr>
						<th><label class="required">供水规模</label></th>
						<td><tag:numberInput name="waterSupplyScale" point="point" value="${monitor.waterSupplyScale}" style="width: 80px"  reg="{'required':'true', 'scale':2, 'max':99999.99}"/>万吨/天</td>
						<th><label class="required">覆盖范围</label></th>
						<td><input type="text"name="coverageArea" value="${monitor.coverageArea}" style="width: 200px" reg='{"required":"true", "maxlength":"50"}' /></td>
						<th><label class="required">覆盖人口</label></th>
						<td><tag:numberInput name="coveragePopulation" value="${monitor.coveragePopulation}" point="point"  reg="{'required':'true', 'max':9999999.99}"/>万</td>
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
						<td><tag:numberInput name="dryFinishedSamples" value="${monitor.dryFinishedSamples}" reg="{'max':99999}"/></td>
						<td><tag:numberInput name="dryFinishedIodine" point="point" value="${monitor.dryFinishedIodine}"  reg="{'max':999.99}"/></td>
						<td><tag:numberInput name="dryTipSamples" value="${monitor.dryTipSamples}" reg="{'max':99999}"/></td>
						<td><tag:numberInput name="dryTipIodine" point="point" value="${monitor.dryTipIodine}"  reg="{'max':999.99}"/></td>
						<td><tag:numberInput name="wetFinishedSamples" value="${monitor.wetFinishedSamples}" reg="{'max':99999}"/></td>
						<td><tag:numberInput name="wetFinishedIodine" point="point" value="${monitor.wetFinishedIodine}"  reg="{'max':999.99}"/></td>
						<td><tag:numberInput name="wetTipSamples" value="${monitor.wetTipSamples}" reg="{'max':99999}"/></td>
						<td><tag:numberInput name="wetTipIodine" point="point" value="${monitor.wetTipIodine}"  reg="{'max':999.99}"/></td>
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
						<th><label class="required">调查人</label></th>
						<td><input type="text"name="investigator" value="${monitor.investigator}" style="width: 200px" reg='{"required":"true", "maxlength":"20"}' /></td>
						<th><label class="required">调查单位</label></th>
						<td><input type="text" name="investigateUnit" value="${monitor.investigateUnit}" style="width: 200px" reg='{"required":"true", "maxlength":"50"}' /></td>
						<th><label class="required">调查时间</label></th>
						<td><tag:dateInput onlypast="true" name="investigateTime" pattern="yyyy/MM/dd" date="${monitor.investigateTime}" style="width:75px;" reg='{"required":"true"}'/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</form>
</div>