<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<tr>
	<th><label for="bpExamFlag">血压检测标志</label></th>
	<td><ehr:dic-radio dicmeta="DMD00027" name="bpExamFlag"  value="${strtum.bpExamFlag}"></ehr:dic-radio>
	<span style="display:${strtum.bpExamFlag !='1'?'none':'inline' }" id="bpExamSbpDbpSpan">
	<tag:numberInput style="width:75px" id="sbp" name="sbp" value="${strtum.sbp}" reg="{'required':true,'min':0,'max':9999}" />~
	<tag:numberInput 	id="dbp" style="width:75px" name="dbp" value="${strtum.dbp}" reg="{'required':true,'min':0,'max':9999}" 	/>mmHg
	</span></td>
</tr>
<tr>
	<th><label for="fpg">血糖检测</label></th>
	<td>
		<ehr:dic-radio dicmeta="DMD00027" name="bloodGlucoseFalg"  value="${strtum.bloodGlucoseFalg}"></ehr:dic-radio>
		<table style="display:${strtum.bloodGlucoseFalg !='1'?'none':'inline' }" id="bloodGlucoseSpan">
			<colgroup>
			<col style="width:190px;">
			</colgroup>
			<tr>
				<th>空腹血糖值  &nbsp;</th>
				<td><tag:numberInput id="fpg" style="width:50px" point="point" name="fpg" value="${strtum.fpg}" reg="{'max':999.99,'scale':2}"/>mmol/L
				</td>
			</tr>
			<tr>
				<th>餐后2小时血糖值  &nbsp;</th>
				<td>
				<tag:numberInput id="gluValue" style="width:50px" point="point" name="gluValue" value="${strtum.gluValue}" reg="{'max':999.99,'scale':2}" />mmol/L
				</td>
			</tr>
			<tr>
				<th>糖化血红蛋白值  &nbsp;</th>
				<td>
				<tag:numberInput  id="hgb" style="width:50px"   point="point"  name="hgb" reg="{'min':0,'max':999.99,'scale':2}" value="${strtum.hgb}"/>%
			</tr>
		</table>
	</td>
</tr>
<tr>
	<th><label for="fat">血脂检测</label></th>
	<td>
		<ehr:dic-radio dicmeta="DMD00027" name="bloodFat"  value="${strtum.bloodFat}"/>
		<table style="display:${strtum.bloodFat !='1'?'none':'inline' }" id="bloodFatSpan">
			<tr>
				<th><label for="tc">总胆固醇值(mmol／L)</label></th>
				<td><tag:numberInput point="point" id="tc" name="tc" value="${strtum.tc}" reg="{'max':999.99}"/></td>
			</tr>
			<tr>
				<th><label for="triglycerideValue">甘油三酯值(mmol/L)</label></th>
				<td><tag:numberInput point="point" id="triglycerideValue" name="triglycerideValue" value="${strtum.triglycerideValue}" reg="{'max':99.9}"/></td>
			</tr>
			<tr>
				<th><label for="ldlcDetectValue">血清低密度脂蛋白胆固醇检测值(mmol/L)</label></th>
				<td><tag:numberInput point="point" id="ldlcDetectValue" name="ldlcDetectValue" value="${strtum.ldlcDetectValue}" reg="{'max':999.99}"/></td>
			</tr>
			<tr>
				<th><label for="hdlcDetectValue">血清高密度脂蛋自胆固醇检测值(mmol/L)</label></th>
				<td><tag:numberInput point="point" id="hdlcDetectValue" name="hdlcDetectValue" value="${strtum.hdlcDetectValue}" reg="{'max':999.99}"/></td>
			</tr>
		</table>
	</td>
</tr>
