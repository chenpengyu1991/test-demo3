<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<script type="text/javascript">
</script>

<div>
	<div style="padding-left: 15px; padding-right: 15px; width: auto;">
		<table class="formtable">
			<tr>
				<th>年度</th>
				<td>${areaYear}年</td>
			</tr>
			<tr>
				<th>地区编码</th>
				<td>${dicItem.itemCode}</td>
			</tr>
			<tr>
				<th>地区名称</th>
				<td>${dicItem.itemName}</td>
			</tr>
		</table>
	</div>
</div>
