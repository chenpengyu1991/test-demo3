<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<tr>
	<th><label for="fat">血脂检测</label></th>
	<td>
		<table>
			<tr>
				<td colspan="2"><ehr:dic-radio dicmeta="DMD00027" name="bloodFat"  value="${bloodFat}"></ehr:dic-radio>
			</tr>
			<tr>
				<th><label for="tc">总胆固醇值(mmol／L)</label></th>
				<td><input id="tc" name="tc" value="${tc}" reg="{'max':999.99}"></input></td>
			</tr>
			<tr>
				<th><label for="triglycerideValue">甘油三酯值(mmol/L)</label></th>
				<td><input id="triglycerideValue" name="triglycerideValue" value="${triglycerideValue}" reg="{'max':99.9}"></input></td>
			</tr>
			<tr>
				<th><label for="ldlcDetectValue">血清低密度脂蛋白胆固醇检测值(mmol/L)</label></th>
				<td><input id="ldlcDetectValue" name="ldlcDetectValue" value="${ldlcDetectValue}" reg="{'max':999.99}"></input></td>
			</tr>
			<tr>
				<th><label for="ldlcDetectValue">血清低密度脂蛋白胆固醇检测值(mmol/L)</label></th>
				<td><input id="ldlcDetectValue" name="ldlcDetectValue" value="${ldlcDetectValue}" reg="{'max':999.99}"></input></td>
			</tr>
			<tr>
				<th><label for="hdlcDetectValue">血清高密度脂蛋自胆固醇检测值(mmol/L)</label></th>
				<td><input id="hdlcDetectValue" name="hdlcDetectValue" value="${hdlcDetectValue}" reg="{'max':999.99}"></input></td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<th><label for="height">身高(cm)</label></th>
	<td><input id="height" name="height" value="${height}" reg="{'max':9999.9}"></input></td>
</tr>
<tr>
	<th><label for="bodyWeight">体重(kg)</label></th>
	<td><input id="bodyWeight" name="bodyWeight" value="${bodyWeight}" reg="{'max':9999.9}"></input></td>
</tr>
<tr>
	<th><label for="waostline">腰围(cm)</label></th>
	<td><input id="waostline" name="waostline" value="${waostline}" reg="{'max':9999.9}"></input></td>
</tr>