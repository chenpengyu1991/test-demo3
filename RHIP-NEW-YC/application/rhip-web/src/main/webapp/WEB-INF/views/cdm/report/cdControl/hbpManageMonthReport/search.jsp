<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div id="list_view">
	<div class="section">
		<div class="toolbar">
		          <%-- <a href="javascript:void(0)" id="cdm-hbpManageMonthReport-export"><b class="export">导出</b></a> --%>
		          <a href="javascript:void(0)" id="cdm-hbpManageMonthReport-export"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
		 </div> 
		<div class="searchbox searchSection x-admin-sm">	
			<form id="hbpManageMonthReportForm" name="" action="" method="post">
				<table id="hiddeSearch">
					<colgroup>
                        <col style="width: 8%;">
                        <col style="width: 10.5%;">
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
					   			<%-- <tags:dateInput date="${currentDate}" style="width:176px;" id="chooseMonth" name="month" pattern="yyyy/MM"></tags:dateInput> --%>
					   			<input type="text" class="layui-input x-admin-sm-date" style="width:80px;padding-left: 0px;" placeholder="选择月份" name="month" id="chooseMonth" value="<fmt:formatDate value='${currentDate}' pattern='yyyy/MM'/>" />
					   		</td>	                  
					<ehr:authorize ifAnyGranted="11,01">
							<td class="coltext">管理机构</td>
							<td colspan="3">
								<ehr:dic-town-centre-station  centreName="centreCode" stationName="stationCode" townName="gbCode" width="130px;" cssClass="x-layui-input"/>
							</td>
					</ehr:authorize>
					
					<ehr:authorize ifAnyGranted="03">
							<td class="coltext">管理机构</td>
							<td colspan="2">
									<ehr:dic-org-list  name="stationCode"  width="130px;" cssClass="x-layui-input"></ehr:dic-org-list>
							</td>
							<td></td>
					</ehr:authorize>
					   		<td>
					   			<%-- <input id="hmmr_searchButton" type="button" class="button search_btn" value="查询" /> --%>
					   			<button class="layui-btn layui-btn-sm" id="hmmr_searchButton"><i class="layui-icon">&#xe615;</i>查询</button>
					   		</td>
					   </tr>
					</tbody>
				</table>
				<table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span id = "cdControlhiddeSearch" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			</form>
		</div>
		<div id="hbpManageMonthReport_result"></div>
	</div>
</div>

<script type="text/javascript">
  
  layui.use('laydate', function() {
      var laydate = layui.laydate;
      
     laydate.render({
        elem: '#chooseMonth' 
     	   ,type: 'month'
     	   ,format:'yyyy/MM'
     	   ,max:0
      });

  
});
</script>