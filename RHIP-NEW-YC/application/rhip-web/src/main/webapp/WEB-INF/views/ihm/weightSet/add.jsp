<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	require(['views/ihm/weightSet/add'],function(weightSetAdd){
		weightSetAdd.load();
	});
</script>
<div>
<div class="toolbar">
	<a href="javascript:void(0)" id="backId"><b class="fanhui">返回</b></a>
	<a href="javascript:void(0)" id="saveId"><b class="baocun">保存</b></a>
</div>
<form id="editFormWeight" class="postcontent">
	<div class="postdiv">
		<i class="popno">权重设置</i>
		<input type="hidden" name="id" value="${rpWeightSet.id}"/>
		<fieldset>
			<legend>转诊基本信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
				</colgroup>
				<tbody>
				<tr>
					<th><label class="required">选择机构</label></th>
					<td colspan="3">
						<ehr:dic-town-centre-station centreId="centerCodeId" townId="gbCode" stationId="organCodeId" 
							centreName="centerCode" townName="gbCode" stationName="organCode"
							 centreValue="${rpWeightSet.centerCode}" townValue="${rpWeightSet.gbCode}" stationValue="${rpWeightSet.organCode}"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">权重类型</label></th>
					<td>
						<ehr:dic-radio name="rpType" dicmeta="FS990011" value="${rpWeightSet.rpType}" code="1,2"
						onchange="toggleOther('rpType','unitNameTb',2)" reg='{"required":"true"}'/>
					</td>
				</tr>
				<tr>
					<th><label class="required">权重日期</label></th>
					<td>
						<tag:dateInput id="rpBeginDate" nullToToday="true" name="rpBeginDate" pattern="yyyy/MM/dd"
				    	 reg='{"required":"true","compare":["rpEndDate","le","权重开始日期不能大于权重结束日期"]}' date="${caseDto.attackCondition.pathogenesisDate}" style="width: 45%"/>
				    	 ~~
				    	 <tag:dateInput id="rpEndDate" nullToToday="true" name="rpEndDate" pattern="yyyy/MM/dd"
				     reg='{"required":"true","compare":["rpBeginDate","ge","权重结束日期不能小于权重开始日期"]}' date="${caseDto.attackCondition.firstVisitDate}" style="width: 45%"/>
					</td>
					<td>
						<input type="button" value="查询" id="weightSetSearchChildId" class="search_btn"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">指标</label></th>
					<td colspan="3">
						<ehr:dic-list name="weightIndex" dicmeta="FS990012" value="${rpWeightSet.weightIndex}" reg='{"required":"true"}'/>，
						<span id="unitNameTb" style="display: none">
							完成度开始值：<input type="text" name="weightDatumBegin" value="${rpWeightSet.weightDatumBegin}" style="width: 150px" reg='{"required":"true","maxlength":5}'/>
							结束值：<input type="text" name="weightDatumEnd" value="${rpWeightSet.weightDatumEnd}" style="width: 150px" reg='{"required":"true","maxlength":5}'/>
						</span>
						代表<input type="text" name="weightValue" value="${rpWeightSet.weightValue}" style="width: 150px"  reg='{"required":"true","maxlength":5}'/>分
					</td>
				</tr>
				<tr>
					<th></th>
					<td colspan="3">注：包干型。开始值最低请设置0，如无上限结束值请设置99999。</td>
				</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
</form>
<div id="top_all_weight" style="padding: 0px 10px 30px;">
	<fieldset>
			<legend>查询结果</legend>
			<div id="childListDiv" style="min-height: 20px; padding: 5px;"></div>
		</fieldset>
</div>
</div>
