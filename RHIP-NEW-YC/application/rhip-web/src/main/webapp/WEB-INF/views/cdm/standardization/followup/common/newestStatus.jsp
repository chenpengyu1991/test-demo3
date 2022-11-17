<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset class="layui-elem-field">
	<legend>最新健康状况</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width: 100px; width: 30%" />
			<col style="min-width: 150px; width: 70%" />
		</colgroup>
		<tr>
			<th><label for="positiveSigns">体格检查阳性体征</label></th>
			<td><input type="text" id="positiveSigns" name="positiveSigns" value="${strtum.positiveSigns}" reg="{'maxlength':300}"></input></td>
		</tr>
		<tr>
			<th><label for="assay">化验</label></th>
			<td><input  type="text"  id="assay" name="assay" value="${strtum.assay}" reg="{'maxlength':300}"></input></td>
		</tr>
		<tr>
			<th><label for="ecg">心电图</label></th>
			<td><input  type="text"  id="ecg" name="ecg" value="${strtum.ecg}" reg="{'maxlength':300}"></input></td>
		</tr>
		<tr>
			<th><label for="specialExam">特殊检查</label></th>
			<td><input  type="text"  id="specialExam" name="specialExam" value="${strtum.specialExam}" reg="{'maxlength':300}"></input></td>
		</tr>
		<tr>
			<th><label for="otherStatus">其他状况</label></th>
			<td><input  type="text" id="otherStatus" name="otherStatus" value="${strtum.otherStatus}" reg="{'maxlength':300}"></input></td>
		</tr>
	</table>
</fieldset>
