<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<colgroup>
	<col style="width: 8%;">
	<col style="width: 16.5%;">
	<col style="width: 8%;">
	<col style="width: 16.5%;">
	<col style="width: 8%;">
	<col style="width: 16.5%;">
	<col style="width: 8%;">
	<col style="width: 16.5%;">
	<col style="width: 8%;">
	<col style="width: 16.5%;">
</colgroup>
<tbody>
	<tr>
		<td class="coltext">年份</td>
		<td class="colinput"><tags:dateInput date="${currentDate}" style="width:120px;" name="year" pattern="yyyy"></tags:dateInput></td>
		<td class="colinput" colspan="2"><input type="radio" checked="checked" name="timeType" value="1" />按报卡日期 <input type="radio" name="timeType"
			value="2"
		/>按诊断日期</td>
		<td class="coltext" colspan="2"></td>
		<td class="colinput" colspan="2"><input class="hide" />
		<%-- <input id="cdm-year-report-cdm-genger-search" type="button" class="button search_btn" value="查询" /> --%>
		<button class="layui-btn layui-btn-sm" id="cdm-year-report-cdm-genger-search"><i class="layui-icon">&#xe615;</i>查询</button>
		</td>
	</tr>
</tbody>