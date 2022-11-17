<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/ehr-tag" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="${pageContext.request.contextPath}/js/views/pam/organ/popChart.js" type="text/javascript"></script>
<input type="hidden" id="monthData">
<input type="hidden" id="yearData">
<div class="searchbox">
	<input type="hidden" id="compare_month_data" value="">
	<input type="hidden" id="compare_year_data" value="">
	<input type="hidden" id="rangeType" value="${rangeType}">
	<table>
		<colgroup>
			<col style="min-width:120px;width: 15%;"/>
	        <col style="min-width:400px;width: 85%;"/>
		</colgroup>
		<tr>
			<td class="coltext">统计类型:</td>
			<td>
				<input class="radioGroup" onclick="popChart.refresh()" id="chartType1" name="chartType" value="1" type="radio"  CHECKED="checked">
				<label for="chartType1">同比</label>
				<!-- 按年统计的时候没有环比 -->
				    <input class="radioGroup" onclick="popChart.refresh()" id="chartType2" name="chartType" value="2" type="radio" >
				    <label for="chartType2">环比</label>	
	
			</td>
		</tr>
		<tr>
			<td class="coltext">指标:</td>
			<td>
				<input type="radio" name="staticItem" id="checkall" value="-1" class="checkboxGroup" checked="checked" onclick="popChart.refresh()"/><label for="checkall">全部</label>
				<input type="radio" name="staticItem" id="staticItem01" value="0" class="checkboxGroup" onclick="popChart.refresh()"/><label for="staticItem01">人均门急诊人次数</label>
				<input type="radio" name="staticItem" id="staticItem02" value="1" class="checkboxGroup" onclick="popChart.refresh()"/><label for="staticItem02">人均出院病人床日数</label>
				<input type="radio" name="staticItem" id="staticItem03" value="2" class="checkboxGroup" onclick="popChart.refresh()"/><label for="staticItem03">门急诊次均费用</label>
				<input type="radio" name="staticItem" id="staticItem04" value="3" class="checkboxGroup" onclick="popChart.refresh()"/><label for="staticItem04">出院病人次均费用</label>
				<input type="radio" name="staticItem" id="staticItem05" value="4" class="checkboxGroup" onclick="popChart.refresh()"/><label for="staticItem05">药占比</label>
				<input type="radio" name="staticItem" id="staticItem06" value="5" class="checkboxGroup" onclick="popChart.refresh()"/><label for="staticItem06">门急诊点滴处方比例</label>			
				<input type="radio" name="staticItem" id="staticItem07" value="6" class="checkboxGroup" onclick="popChart.refresh()"/><label for="staticItem07">平均处方费用</label>
			</td>
		</tr>			
	</table>
</div>
<div id="pop-chart-con" style="width: 800px;height: 400px"></div>
