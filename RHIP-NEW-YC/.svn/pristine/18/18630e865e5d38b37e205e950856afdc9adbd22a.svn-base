<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
<i class="popno">
	儿童接种禁忌信息<br/>
</i>
<fieldset>
<legend>1、基本信息</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width:80px;width:25%;"/>
	        <col style="min-width:80px;width:25%;"/>
			<col style="min-width:80px;width:25%;"/>
	        <col style="min-width:80px;width:25%"/>
		</colgroup>
		<tr>
		    <th>姓名：</th>
			<td style="text-align: left">${obj.name}</td>
			<th>身份证件号码：</th>
			<td style="text-align: left">${obj.idcard}</td>
		</tr>
		<tr>
		    <th>父亲姓名：</th>
			<td style="text-align: left">${obj.father_name}</td>
			<th>父亲身份证件号码：</th>
			<td style="text-align: left">${obj.father_idcard}</td>
		</tr>
		<tr>
		    <th>母亲姓名：</th>
			<td style="text-align: left">${obj.mother_name}</td>
			<th>母亲身份证件号码：</th>
			<td style="text-align: left">${obj.mother_idcard}</td>
		</tr>
		<tr>
		    <th>受接种者编号：</th>
			<td style="text-align: left">${obj.vaccination_code}</td>
			<th>&nbsp;</th>
			<td style="text-align: left">&nbsp;</td>
		</tr>
	</table>
</fieldset>
<fieldset>
<legend>2、禁忌信息</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width:80px;width:25%;"/>
	        <col style="min-width:80px;width:25%;"/>
			<col style="min-width:80px;width:25%;"/>
	        <col style="min-width:80px;width:25%"/>
		</colgroup>
		<tr>
		    <th>禁忌症名称：</th>
			<td style="text-align: left"><c:choose><c:when test="${obj.TABU_NAME ne 'null'}">${obj.TABU_NAME}</c:when></c:choose></td>
			<th>预防接种机构名称：</th>
			<td style="text-align: left">${obj.VACCINATION_ORGANNAME}</td>
		</tr>
	</table>
</fieldset>
</div>