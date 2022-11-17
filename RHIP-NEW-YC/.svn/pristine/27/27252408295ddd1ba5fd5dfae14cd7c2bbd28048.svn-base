<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<ehr:authorize ifAnyGranted="0107,01">
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
		<td class="coltext">月份</td>
		<td class="colinput">
		<%-- <tags:dateInput date="${currentDate}" style="width:120px;" name="yearMonth" pattern="yyyy/MM"></tags:dateInput> --%>
		<input type="text" class="layui-input x-admin-sm-date" style="width:80px;padding-left: 0px;" placeholder="选择月份" name="yearMonth" id="tumorYearMonthId" value="<fmt:formatDate value='${currentDate}' pattern='yyyy/MM'/>" />
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
		<button class="layui-btn layui-btn-sm" id="tumor-month-statistics-search"><i class="layui-icon">&#xe615;</i>查询</button>
		</td>
	</tr>
</tbody>

<script type="text/javascript">
  
  layui.use('laydate', function() {
      var laydate = layui.laydate;
      
     laydate.render({
        elem: '#tumorYearMonthId' 
     	   ,type: 'month'
     	   ,format:'yyyy/MM'
     	   ,max:0
      });

  
});
</script>