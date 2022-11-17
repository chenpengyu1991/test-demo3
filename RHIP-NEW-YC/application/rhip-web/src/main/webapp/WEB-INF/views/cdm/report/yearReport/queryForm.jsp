<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<table  id="searchTable">
					<colgroup>
						<col style="min-width:70px; width: 10%;">
						<col style="min-width:100px; width: 23%;">
						<col style="min-width:70px; width: 10%;">
						<col style="min-width:100px; width: 23%;">
						<col style="min-width:70px; width: 10%;">
						<col style="min-width:183px; width: 23%;">
					</colgroup>
	<tbody>
		<tr>
			<td class="coltext">年份</td>
			<td class="colinput">
				<tag:dateInput date="${currentDate }" style="width:120px;" name="currentYear" pattern="yyyy"></tag:dateInput>
			</td>
			<td class="colinput" colspan="2">
				<input type="radio" name="rangeType" value="1"/>按报卡日期
				<input type="radio" name="rangeType" value="2"/>按诊断日期
			</td>
			<td  colspan="2">
				<input type="button" class="button search_btn" value="查询" />
			</td>
		</tr>
	</tbody>
</table>
