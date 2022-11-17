<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<ehr:authorize ifAnyGranted="11,01">
	<c:set var="isMBK" value="${true}" />
</ehr:authorize>
<colgroup>
	<col style="width: 8%;">
		<col style="width: 16.5%;">
	<col style="width: 8%;">
	<col style="width: 32.5%;">
	<col style="width: 8%;">
	<col style="width: 16.5%;">
	<col style="width: 8%;">
	<col style="width: 16.5%;">
	<col style="width: 8%;">
	<col style="width: 6.5%;">
</colgroup>
<tbody>
	<tr>
		<td class="coltext">季度</td>
		<td class="colinput">
		<%-- <tags:dateInput date="${currentDate}" style="width:40px;" name="year" pattern="yyyy"></tags:dateInput> --%>
		<input type="text" class="layui-input x-admin-sm-date" style="width:40px;padding-left: 0px;" placeholder="选择年份" name="year" id="cdSeasonYearId" value="<fmt:formatDate value='${currentDate}' pattern='yyyy'/>" />
		<select style="width:100px" name="season" class="x-layui-input">
			<option value="1">第一季度</option>
			<option value="2" >第二季度</option>
			<option value="3" >第三季度</option>
			<option value="4">第四季度</option>
		</select>
		</td>
		
		<c:if test="${isMBK eq true}">
			<td class="coltext">上报机构</td>
			<td class="colinput" >
				<ehr:dic-town-centre-station width="130px;" centreName="organCode" townName="gbCode" cssClass="x-layui-input"/>
			</td>
		</c:if>
		<td class="colinput" colspan="2"><input type="radio" checked="checked" name="timeType" value="1" />按报卡日期 <input type="radio" name="timeType"
			value="2"
		/>按诊断日期</td>
		
		<td class="colinput" colspan="2"><input class="hide" />
		<%-- <input id="cdm-year-report-cdm-genger-search" type="button" class="button search_btn" value="查询" /> --%>
		<button class="layui-btn layui-btn-sm" id="cdm-season-statistics-search"><i class="layui-icon">&#xe615;</i>查询</button>
		</td>
	</tr>
</tbody>

<script type="text/javascript">
  
  layui.use('laydate', function() {
      var laydate = layui.laydate;
      
     laydate.render({
        elem: '#cdSeasonYearId' 
     	   ,type: 'year'
     	   ,max:0
      });

  
});
</script>