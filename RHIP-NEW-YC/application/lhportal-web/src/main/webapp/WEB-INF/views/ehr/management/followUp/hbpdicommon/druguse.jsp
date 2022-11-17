<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset>
	<legend>用药情况</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width: 100px; width: 30%" />
			<col style="min-width: 150px; width: 70%" />
		</colgroup>
		<tr>
			<th>第一种用药名称</th>
			<td><c:out value="${drug.drugNameFirst}" /></td>
		</tr>
		<tr>
			<th><label  >第一种用药用法</label></th>
			<td>
				每日<c:out value="${drug.drugPerdayFirst}" />次 , 每次
				<c:out value="${drug.drugPertimeFirst}" />mg
			</td>
		</tr>
		
		<tr>
			<th>第二种用药名称</th>
			<td><c:out value="${drug.drugNameSecond}"/></td>
		</tr>
		<tr>
			<th>第二种用药用法</th>
			<td>
				每日<c:out value="${drug.drugPerdaySecond}" />次 , 每次
				<c:out value="${drug.drugPertimeSecond}" />mg
			</td>
		</tr>
		
		<tr>
			<th>第三种用药名称</th>
			<td><c:out value="${drug.drugNameThird}" /></td>
		</tr>
		<tr>
			<th>第三种用药用法</th>
			<td>
				每日<c:out value="${drug.drugPerdayThird}" />次 , 每次
				<c:out value="${drug.drugPertimeThird}" />mg
			</td>
		</tr>		
	</table>
</fieldset>