<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<table class="posttable">
		<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
		<tr>
			<th><label>糖尿病类型</label></th>
			<td><ehr:dic dicmeta="DMD00007" code="${brwDiseaseInfo.diType}" /></td>
			<th><label>确诊医院</label></th>
			<td><ehr:org code="${brwDiseaseInfo.diDiagnosedOrganCode}"/></td>
		</tr>
		<tr>
			<th><label>确诊时间</label></th>
			<td><fmt:formatDate value='${brwDiseaseInfo.diDiagnosedDate}' pattern='yyyy/MM/dd'/></td>
			<th><label>确诊方式</label></th>
			<td><ehr:dic dicmeta="DMD00010" code="${brwDiseaseInfo.diDiagnosedWay}" /></td>
		</tr>
	</table>
<div class = "postcontent">
<div class="postdiv">
<fieldset>
	<legend>确诊时并发症情况</legend>
		<table class="posttable">
		<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
		<tr>
			<th><label for="diComHbpFlag">高血压</label></th>
			<td><ehr:dic dicmeta="FS10238"  code="${brwDiseaseInfo.diComHbpFlag}" /></td>
			<th><label for="diComDiFootFlag">糖尿病足</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diComDiFootFlag}" /></td>
		</tr>
		<tr>
			<th><label for="diComNeuropathyFlag">神经病变</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diComNeuropathyFlag}" /></td>
			<th><label for="diComStrokeFlag">脑卒中</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diComStrokeFlag}" /></td>
		</tr>
		<tr>
			<th><label for="diComRetyFlag">视网膜病变</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diComRetyFlag}" /></td>
			<th><label for="diComKidneyFlag">糖尿病肾病</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diComKidneyFlag}" /></td>
		</tr>
		<tr>
			<th><label for="diComHbcFlag">高血脂</label></th>
			<td colspan="3"><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diComHbcFlag}" /></td>
		</tr>
		<tr>
			<th><label for="diComFpg">既往空腹血糖</label></th>
			<td><c:out value="${brwDiseaseInfo.diComFpg}" />mmol/L</td>
			<th><label  for="diComHgb">既往糖化血红蛋白</label></th>
			<td><c:out value="${brwDiseaseInfo.diComHgb}"/>%</td>
		</tr>
		<tr>
			<th><label for="diComSmokingFlag">吸烟</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diComSmokingFlag}" /></td>
			<th><label for="diComSmokingDailyNum">吸烟每日数量</label></th>
			<td><c:out value="${brwDiseaseInfo.diComSmokingDailyNum}" /> 支</td>
		</tr>
		<tr>
			<th><label for="diComDrinkingFlag">饮酒</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diComDrinkingFlag}" /></td>
			<th><label for="diComDrinkingdailyNum">饮酒每日数量</label></th>
			<td><c:out value="${brwDiseaseInfo.diComDrinkingdailyNum}" /> 两</td>
		</tr>
	</table>
</fieldset>
<fieldset>
	<legend>糖尿病目前并发症情况</legend>
		<table class="posttable">
		<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 20%;min-width:150px;" />
			<col style="width: 20%;min-width:150px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
		<tr>
			<td>并发症</td>
			<td>有无</td>
			<td>诊断时间</td>
			<td>治疗方式</td>
		</tr>
		<tr>
			<th>冠心病</th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diCcomCoronaryFlag}" /></td>
			<c:if test="${brwDiseaseInfo.diCcomCoronaryFlag eq '2'}">
				<td><fmt:formatDate value="${brwDiseaseInfo.diCcomCoronaryDisDate}"  pattern='yyyy/MM/dd'/></td>
				<td><c:out value="${brwDiseaseInfo.diCcomCoronaryTreatment}" ></c:out></td>
			</c:if>
		</tr>
		<tr>
			<th>高血压</th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diCcomHbpFlag}" /></td>
			<c:if test="${brwDiseaseInfo.diCcomHbpFlag eq '2'}">
				<td><fmt:formatDate value='${brwDiseaseInfo.diCcomHbpDisDate}' pattern='yyyy/MM/dd'/></td>
				<td><c:out value="${brwDiseaseInfo.diCcomHbpTreatment}" /></td>
			</c:if>
		</tr>
		<tr>
			<th><label for="diCcomHbcFlag">高血脂</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diCcomHbcFlag}" /></td>
			<c:if test="${brwDiseaseInfo.diCcomHbcFlag eq '2'}">
				<td><fmt:formatDate value="${brwDiseaseInfo.diCcomHbcDisDate}" pattern='yyyy/MM/dd'/></td>
				<td><c:out value="${brwDiseaseInfo.diCcomHbcTreatment}" /></td>
			</c:if>
			
		</tr>
		<tr>
			<th><label for="diCcomRetyFlag">视网膜病变</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diCcomRetyFlag}" /></td>
			<c:if test="${brwDiseaseInfo.diCcomRetyFlag eq '2'}">
				<td><fmt:formatDate value="${brwDiseaseInfo.diCcomRetyDisDate}" pattern='yyyy/MM/dd' /></td>
				<td><c:out value="${brwDiseaseInfo.diCcomRetypTreatment}"/></td>
			</c:if>
		</tr>
		<tr>
			<th><label for="diCcomNerveFlag">周围神经病变</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diCcomNerveFlag}" /></td>
			<c:if test="${brwDiseaseInfo.diCcomNerveFlag eq '2'}">
				<td><fmt:formatDate value="${brwDiseaseInfo.diCcomNerveDisDate}" pattern='yyyy/MM/dd' /></td>
				<td><c:out value="${brwDiseaseInfo.diCcomNerveTreatment}" /></td>
			</c:if>
		</tr>
		<tr>
			<th><label for="diCcomKidneyFlag">肾病</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diCcomKidneyFlag}" /></td>
			<c:if test="${brwDiseaseInfo.diCcomKidneyFlag eq '2'}">
				<td><fmt:formatDate value="${brwDiseaseInfo.diCcomKidneyDisDate}" pattern='yyyy/MM/dd' /></td>
				<td><c:out value="${brwDiseaseInfo.diCcomKidneyTreatment}" /></td>
			</c:if>
			
		</tr>
		<tr>
			<th><label for="diCcomFootFlag">足部病变</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diCcomFootFlag}" /></td>
			<c:if test="${brwDiseaseInfo.diCcomFootFlag eq '2'}">
				<td><fmt:formatDate value="${brwDiseaseInfo.diCcomFootDisDate}" pattern='yyyy/MM/dd' /></td>
				<td><c:out value="${brwDiseaseInfo.diCcomFootTreatment}" /></td>
			</c:if>
			
		</tr>
		<tr>
			<th><label for="diCcomStrokeFlag">脑卒中</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diCcomStrokeFlag}" /></td>
			<c:if test="${brwDiseaseInfo.diCcomStrokeFlag eq '2'}">
				<td><fmt:formatDate value="${brwDiseaseInfo.diCcomStrokeDisDate}" pattern='yyyy/MM/dd' /></td>
				<td><c:out value="${brwDiseaseInfo.diCcomStrokeTreatment}" /></td>
			</c:if>
			
		</tr>
	</table>
</fieldset>
<fieldset>
	<legend>近期治疗情况</legend>
		<table class="posttable">
		<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 20%;min-width:150px;" />
			<col style="width: 20%;min-width:150px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
		<tr>
			<th><label for="diRtDietControlFlag">饮食控制</label></th>
			<td colspan="3"><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diRtDietControlFlag}" ></ehr:dic></td>
		</tr>
		<tr>
			<th><label for="diRtQuitSmokingFlag">戒烟</label></th>
			<td colspan="3"><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diRtQuitSmokingFlag}" /></td>
		<tr>
			<th><label for="diRtLimitDrinkingFlag">限酒</label></th>
			<td colspan="3"><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diRtLimitDrinkingFlag}" /></td>
		</tr>
		<tr>
			<th><label for="diRtPhyActivityFlag">体力活动</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diRtPhyActivityFlag}" /></td>
			<td>每周<c:out value="${brwDiseaseInfo.diRtPhyActivityWeekCount}" />次
			</td>
			<td>每次<c:out value="${brwDiseaseInfo.diRtPhyActivityTime}" />分钟
			</td>
		</tr>
		<tr>
			<th><label for="diRtHypDrugsFlag">口服降糖药</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diRtHypDrugsFlag}" /></td>
			<td>每日<c:out value="${brwDiseaseInfo.diRtHypDrugsDailyCount}" />次
			</td>
			<td>每次<c:out value="${brwDiseaseInfo.diRtHypDrugsperDose}" />mg
			</td>
		</tr>
		<tr>
			<th><label for="diRtInsulinFlag">胰岛素</label></th>
			<td><ehr:dic dicmeta="FS10238" code="${brwDiseaseInfo.diRtInsulinFlag}" /></td>
			<td>每日<c:out value="${brwDiseaseInfo.diRtInsulinDailyCount}" />次
			</td>
			<td>每次<c:out value="${brwDiseaseInfo.diRtInsulinPerDose}"/>单位
			</td>
		</tr>
		</table>
	</fieldset>
</div>
</div>